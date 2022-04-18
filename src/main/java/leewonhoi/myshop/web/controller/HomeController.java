package leewonhoi.myshop.web.controller;

import leewonhoi.myshop.domain.Member;
import leewonhoi.myshop.web.argumentResolver.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(@Login Member loginMember, Model model) {

        log.info("loginMember={}", loginMember);
        // 세션 정보 없음 (로그인 x)
        if (loginMember == null) {
            return "home";
        }

        // 세션 정보 있음 (로그인 된 상태)
        model.addAttribute("member", loginMember);
        return "loginHome";
    }


}
