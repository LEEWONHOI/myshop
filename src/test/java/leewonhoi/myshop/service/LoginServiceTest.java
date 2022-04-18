package leewonhoi.myshop.service;

import leewonhoi.myshop.domain.Address;
import leewonhoi.myshop.domain.Member;
import leewonhoi.myshop.web.exception.NotFoundMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LoginServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    LoginService loginService;


    @Test
    public void 로그인() throws Exception {
        // given
        Member member = new Member("memberA", "123", new Address("a", "b", "c"));
        memberService.join(member);

        // when
        Member rightMember = loginService.login("memberA", "123");
        Member wrongMember = loginService.login("memberA", "12");

        // then
        assertThat(rightMember.getName()).isEqualTo(member.getName());
        assertThat(rightMember.getPassword()).isEqualTo(member.getPassword());
        assertThat(wrongMember).isNull();

    }

}