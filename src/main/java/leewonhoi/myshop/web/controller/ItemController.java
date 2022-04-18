package leewonhoi.myshop.web.controller;

import leewonhoi.myshop.domain.item.Book;
import leewonhoi.myshop.domain.item.Item;
import leewonhoi.myshop.service.ItemService;
import leewonhoi.myshop.web.controller.form.BookCreateForm;
import leewonhoi.myshop.web.controller.form.BookUpdateForm;
import leewonhoi.myshop.web.exception.NotFoundItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    /**
     * 상품 추가 폼
     */
    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookCreateForm());
        return "items/createItemForm";
    }

    /**
     * Book 상품 추가
     */
    @PostMapping("/items/new")
    public String create(
            @Validated @ModelAttribute("form") BookCreateForm form,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {

        // 필드 오류
        if (bindingResult.hasErrors()) {
            log.info("bindingResult={}", bindingResult);
            return "items/createItemForm";
        }

        // 성공 로직
        Book book = new Book();
        book.initItem(form.getName(), form.getPrice(), form.getStockQuantity());
        book.initBook(form.getAuthor(), form.getIsbn());

        itemService.saveItem(book);

        redirectAttributes.addAttribute("itemId", book.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/items";
    }

    /**
     * 상품 목록보기
     */
    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findAllItem();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    /**
     * 상품 수정 폼
     */
    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable Long itemId, Model model) {

        Item item = itemService.findItem(itemId);

        if (item instanceof Book) {
            Book book = (Book) item;

            BookUpdateForm bookUpdateForm = new BookUpdateForm();
            log.info("bookUpdateForm id={}", book.getId());
            bookUpdateForm.setId(book.getId());
            bookUpdateForm.setName(book.getName());
            bookUpdateForm.setPrice(book.getPrice());
            bookUpdateForm.setStockQuantity(book.getStockQuantity());

            bookUpdateForm.setAuthor(book.getAuthor());
            bookUpdateForm.setIsbn(book.getIsbn());

            model.addAttribute("form", bookUpdateForm);
        }
        return "items/updateItemForm";
    }

    /**
     * 상품 수정
     */
    @PostMapping("items/{itemId}/edit")
    public String updateItem(
            @PathVariable Long itemId,
            @Validated @ModelAttribute("form") BookUpdateForm form,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors()) {
            return "items/updateItemForm";
        }
        try {
            itemService.updateItem(itemId, form);
        } catch (NotFoundItem e) {
            // 가정) 동시성 이슈로 다른 사용자가 업데이트할 아이템을 삭제했을 때 발생됨
            bindingResult.reject("notFoundItem", "존재하지 않는 아이템입니다.");
            return "items/updateItemForm";
        }

        redirectAttributes.addAttribute("itemId", form.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/items";
    }



}
