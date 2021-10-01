package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.Memberrepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
@Controller, @Service, @Repository와 같은 어노테이션은
컨테이너에 등록해주고
@Autowired는 등록된걸 서로 연결 지어줌
 */

//@Service //이걸 쓰면 이 아래 5~6줄을 스프링이 엥? 서비스네 이러고
//컨테이너에 MemberService를 등록해줌
//@Component라고 해도 되는데 @Service안에 컴포넌트도 있음
public class MemberService {

    private final Memberrepository memberRepository;

    //@Autowired
    public MemberService(Memberrepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /*회원가입
     */
    public Long join(Member member){
        //이름이 같은 중복회원이 있으면 안된다
        //findbyname을 해 그 결과는 optional memeber니까
        // 바로 optional member. ifPre
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /*Optional<Member> result = memberrepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
         */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /*
    전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public  Optional<Member> findOne(Long memberId) {
        return  memberRepository.findById(memberId);
    }
}
