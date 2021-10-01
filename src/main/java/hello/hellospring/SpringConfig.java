package hello.hellospring;

import hello.hellospring.repository.Memberrepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberrepository());
    }

    @Bean
    public Memberrepository memberrepository() {
        return new MemoryMemberRepository();
    }
}
