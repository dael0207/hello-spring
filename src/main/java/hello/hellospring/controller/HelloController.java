package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
