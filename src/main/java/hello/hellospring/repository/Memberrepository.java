package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//interface
public interface Memberrepository {
    Member save(Member member);
    //Optional은 null값을 감싸서 반환하는 방법
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
