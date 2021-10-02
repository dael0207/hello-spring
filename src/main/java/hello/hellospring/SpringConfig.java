package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.Memberrepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*
    새로 만든 고대의 JDBC리포로 바꾸고 연결된거 들어가보면
    데이터 소스를 받아야함 근데 스프링에서 제공해줌 그게 이 아래코드
     */
    //@Autowired DataSource dataSource; 이렇게 그냥 연결 받을 수도 있음
    //근데 아래걸로 함

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberrepository());
    }

    @Bean
    public Memberrepository memberrepository() {
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
