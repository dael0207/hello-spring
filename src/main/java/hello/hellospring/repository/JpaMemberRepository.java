package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class JpaMemberRepository implements Memberrepository{

    public final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    //method자동생성 atl +  enter
    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    /*
    아래 코드에서 id를 제외하고 name과 all은 ql문을 작성했다
    그 이유는 pk기반이 아닌 것들은 그냥 해야된대 모르겠어 찾아보고 수정해야지
     */
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        /*List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
        위에 코드를 ctrl + art + n 하면 아래 코드로 합쳐줌
        */
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
