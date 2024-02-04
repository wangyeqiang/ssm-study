package org.example.share;


import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("share")
@ResponseBody
public class ShareController {

    @Autowired
    private ServletContext servletContext;

    public void data(HttpServletRequest request, HttpSession session){

    }



    // spring mvc提供的方式 ： request提供了几个(了解)
}
