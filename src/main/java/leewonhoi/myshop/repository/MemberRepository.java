package leewonhoi.myshop.repository;

import leewonhoi.myshop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Optional<Member> findById(Long memberId) {
        return Optional.of(em.find(Member.class, memberId));
    }


    public Optional<Member> findByName(String name) {
        List<Member> findMemberList = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        if (!findMemberList.isEmpty()) {
            return Optional.of(findMemberList.get(0));
        }
        return Optional.empty();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

}
