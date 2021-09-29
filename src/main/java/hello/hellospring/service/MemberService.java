package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.Memberrepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final Memberrepository memberRepository;

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
