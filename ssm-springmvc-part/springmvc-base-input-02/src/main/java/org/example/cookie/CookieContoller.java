package org.example.cookie;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping("cookie")
@ResponseBody
public class CookieContoller {


    @RequestMapping("data")
    public String data(@CookieValue(value = "cookieName") String value){
        System.out.println("value = " + value);
        return value;
    }

    @GetMapping("save")
    public String save(HttpServletResponse response){
        Cookie cookie = new Cookie("cookieName","root");
        response.addCookie(cookie);
        return "ok";

    }
}
