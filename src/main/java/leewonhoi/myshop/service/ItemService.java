package leewonhoi.myshop.service;

import leewonhoi.myshop.domain.item.Book;
import leewonhoi.myshop.domain.item.Item;
import leewonhoi.myshop.web.controller.form.BookUpdateForm;
import leewonhoi.myshop.web.exception.NotFoundItem;
import leewonhoi.myshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    @Transactional
    public Item updateItem(Long itemId, BookUpdateForm bookUpdateForm) {
        Item findItem = itemRepository.findItem(itemId).orElseThrow(() -> new NotFoundItem("아이템이 존재하지 않습니다."));

        if (findItem instanceof Book) {
            Book book = (Book) findItem;
            book.updateItem(bookUpdateForm);
            book.updateBook(bookUpdateForm);

            return book;
        }

        return findItem;
    }

    public Item findItem(Long itemId) {
        return itemRepository.findItem(itemId).orElseThrow(() -> new NotFoundItem("아이템이 존재하지 않습니다."));
    }

    public List<Item> findAllItem() {
        return itemRepository.findAllItem();
    }


}
