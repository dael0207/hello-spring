package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //메서드가 끝날때마다 아래의 afterEach가 실행됨
    public void afterEach() {
        repository.clearStore();
        //MemoryMemberRepository여기에 만듬
    }

    @Test
    public void save(){//new에서 한거랑 db에서 꺼낸거랑 똑같으면 ㅇㅋ
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = " + (result == member));
        //계속 글자로 볼 수 없으니까 Assertions를 사용
        //junit Assertions.assertEquals(member, result ); 기대값으로 하는거
        // 아래꺼는 같은 Assertions이지만 junit아님
        //member는 값을 가져온 result와 똑같다
        assertThat(member).isEqualTo(result);
        //알트 엔터로 위에 스태틱으로 Assertions만듬
    }

    @Test//이름으로 찾는거 테스트
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
