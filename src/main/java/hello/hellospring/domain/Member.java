package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY는 db가 id값을 자동으로 생성해 주는 것
    private Long id; //임의의 값 시스템이 저장하는 id

    //@Column(name = "username'") 만약 db에서 name을 name이라 안쓰고 username이라고 쓰면
    //자동으로 name과 username을 매칭해 주는 것
    private String name; //그냥 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
