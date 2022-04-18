package leewonhoi.myshop.service;

import leewonhoi.myshop.domain.Member;
import leewonhoi.myshop.repository.MemberRepository;
import leewonhoi.myshop.web.exception.NotFoundMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * 로그인 기능
     */
    @Transactional
    public Member login(String memberId, String password) {
        return memberRepository.findByName(memberId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }


}
