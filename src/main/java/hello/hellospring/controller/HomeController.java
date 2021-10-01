package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")// localhost:8080/로 들어오면
    public String home() {
        return  "home"; //home이 나타남
    }
}
