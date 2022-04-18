package leewonhoi.myshop.web.controller;

import leewonhoi.myshop.domain.Address;
import leewonhoi.myshop.domain.Member;
import leewonhoi.myshop.service.MemberService;
import leewonhoi.myshop.web.controller.form.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model, @RequestParam(defaultValue = "/") String redirectUrl) {
        model.addAttribute("memberForm", new MemberForm());
        model.addAttribute("redirectUrl", redirectUrl);
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid @ModelAttribute("memberForm") MemberForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = new Member(form.getName(), form.getPassword(), address);
        try {
            memberService.join(member);
        } catch (IllegalStateException e) {
            // 중복된 이름 에러
            bindingResult.reject("sameName", "동일한 아이디가 존재합니다. 다른 아이디를 입력해주세요.");
            return "members/createMemberForm";
        }


        return "redirect:/";
    }

    @GetMapping("/members")
    public String memberList(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
