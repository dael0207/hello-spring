package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {
	//

	public static void main(String[] args) {
		/*메인 메소드를 실행하면 SpringApplication.run 해가지고
		안에 클래스를 실행함 annotation은 이때 도와주는듯
		스프링부트는 톰캣 내장*/
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
