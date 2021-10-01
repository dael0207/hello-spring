package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements Memberrepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override //save니까 저장할 곳이 필요하다 그래서 위에 Map만든것
    /* Member save는 setId로 Id세팅하고 시퀀스에 값을 더한걸 id로 함
    store로 만든 id를 저장함
    그리고member값 반환
     */
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    //store한것 꺼내오는거

    public Optional<Member> findById(Long id) {
        //return store.get(id); 옛날 방식인데 널값이 들어올 수도 있으니까
        //Optional.ofNullable()안에 넣어서 감싸줌
        return Optional.ofNullable(store.get(id));
    }

    @Override//필터를 돌려서 맵을 다돈다 findany로 하나라도 있으면 반환 없으면 optional로 감싸서 반환
    //루프가 뭔감?
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
