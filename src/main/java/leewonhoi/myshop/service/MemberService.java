package leewonhoi.myshop.service;

import leewonhoi.myshop.domain.Member;
import leewonhoi.myshop.web.exception.NotFoundMember;
import leewonhoi.myshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * @return memberId
     */

    @Transactional
    public Long join(Member member) {
        // 중복 회원 검증
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }



    /**
     * 회원조회 (id)
     * @return member
     */
    public Member findById(Long memberId)  throws NotFoundMember {
        return memberRepository.findById(memberId).orElseThrow( () -> new NotFoundMember("회원을 조회하지 못했습니다."));
    }

    /**
     * 회원조회 (name)
     * @return member
     */
    public Member findByName(String name) throws NotFoundMember {
        return memberRepository.findByName(name).orElseThrow( () -> new NotFoundMember("회원을 조회하지 못했습니다."));
    }

    /**
     * 전체 회원조회
     * @return List<Member>
     */
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    private void validateDuplicateMember(Member member) throws IllegalStateException {
        boolean hasMember = memberRepository.findByName(member.getName()).isEmpty();

        if (!hasMember) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

}
