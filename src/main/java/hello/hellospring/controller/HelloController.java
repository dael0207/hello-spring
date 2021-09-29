package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ResponseBody;
=======
>>>>>>> origin/master

@Controller
public class HelloController {

    //웹에서 /hello로 들어오면 여기로 연결해줌 스프링은 그럼
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        //위에 헬로는 문자열
        return "hello";
        // /hello링크를 누르면 hello.html로 감 원리는 pfd보기
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
       model.addAttribute("name"/*키*/,name/*위에 네임과 같은것*/);
       return "hello-template";
    }
<<<<<<< HEAD

    //API 문자열로 올려주는방법
    @GetMapping("hello-string")
    @ResponseBody //http의 head와 body부 중 body부에 직접 넣어주겠다 응답한 내용을
    public String helloString(@RequestParam("name") String name) {
        return  "hello" + name; //"hello spring"
    }

    //API 데이터 넘기는 것
    //json방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello hellpApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return  hello;
    }

    static class Hello {
        private  String name;

        //꺼낼때
        public String getName() {
            return name;
        }

        //넣을때
       public  void setName(String name) {
            this.name = name;
        }
    }

=======
>>>>>>> origin/master
}
