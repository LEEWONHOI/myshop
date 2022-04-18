package leewonhoi.myshop.service;

import leewonhoi.myshop.domain.Member;
import leewonhoi.myshop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceIntegrateTest {

    @Autowired
    MemberService memberService;


    @Test
    public void 회원가입() {
        // given
        Member memberA = new Member("memberA", "1234", null);
        Member memberB = new Member("memberB", "1234", null);

        // when
        Long savedMemberIdA = memberService.join(memberA);
        Long savedMemberIdB = memberService.join(memberB);

        Member findMemberByIdA = memberService.findById(savedMemberIdA);
        Member findMemberByIdB = memberService.findById(savedMemberIdB);

        Member findMemberByNameA = memberService.findByName(findMemberByIdA.getName());
        Member findMemberByNameB = memberService.findByName(findMemberByIdB.getName());

        // then
        assertThat(findMemberByIdA.getName()).isEqualTo(findMemberByNameA.getName());
        assertThat(findMemberByIdB.getName()).isEqualTo(findMemberByNameB.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member = new Member("memberA", "1234", null);
        Member sameMember = new Member("memberA", "1234", null);

        // when
        Long savedMember = memberService.join(member);
        // then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(sameMember)
        );
    }

    @Test
    void 전체회원조회(){
        // given
        Member memberA = new Member("memberA", "1234", null);
        Member memberB = new Member("memberB", "1234", null);

        // when
        memberService.join(memberA);
        memberService.join(memberB);

        List<Member> result = memberService.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);

    }


}