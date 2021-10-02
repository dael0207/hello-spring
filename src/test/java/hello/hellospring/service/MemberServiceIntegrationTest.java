package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.Memberrepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //테스트를 실행하면 트랜젝션을 먼저 실행하고 여기에 세이브포인트?ㅋㅋ를 만들고 테스트가 끝나면 이 지점으로 롤백함
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired Memberrepository memberRepository;


    @Test
    void 회원가입() {
        //given 뭔가가 주어졌을때
        Member member = new Member();
        member.setName("hello");

        //when 이거를 실행했을 때
        Long saveId = memberService.join(member);

        //then 이게 나와야 함
        Member findmember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findmember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        //()->~~~~람다 로직을 돌릴때(join) IllegalS.class 예외가 터져야 함
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


    }

}