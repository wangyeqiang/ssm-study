package org.example.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("user")
public class UserContronller {


    /**
     * @WebServlet (必须使用 / 开头）
     * @RequestMapping (不要必须/开头)
     *
     * 1。 精准地址 【1个 ｜ 多个】  /user/login | {"地址1","地址2"}
     * 2。 支持模糊地址  * 任意一层字符串｜ ** 任意一层任意字符串
     *         /user/*       /user/a /user/aaaa  /user/a/b 不行
     *         /user/**      /user/a/b/c 可以
     *  3. 类上和方法上添加request的区别
     *     类上是提取通用的访问地址
     *     方法上是具体的handler地址
     *      访问： 类地址 + 方法地址 即可
     *  4. 请求方式指定
     *      客户端 -> http(get | post | put | delete) -> ds -> handler
     *      默认情况：  @RequestMapping("login")  只要地址正确任何方式都可以访问
     *      指定请求方式:   @RequestMapping(value = "/register", method = {RequestMethod.GET , RequestMethod.POST} )
     *      不符合请求方式，前端会出现405异常
     *   5。 注解进阶
     *      get  @GetMapping  @RequestMapping(value = "login", method = RequestMethod.GET)  // get请求地址
     *      post  @PostMapping  @RequestMapping(value = "login", method = RequestMethod.POST)  // get请求地址
     *      put  @PutMapping  @RequestMapping(value = "login", method = RequestMethod.PUT)  // get请求地址
     *      delete  @DeleteMapping  @RequestMapping(value = "login", method = RequestMethod.DELETE)  // get请求地址
     *    这些注解只能使用在方法上
     * @return
     */


    @RequestMapping   //user
    @GetMapping // get请求地址
    public String index(){
        return null;
    }

    // handler -> handlerMapping 指定访问地址
    @RequestMapping(value = "login", method = RequestMethod.POST)  // 作用：注册地址，将Handler注册到handlerMapping
    @PostMapping
    public String login(){
        return null ;
    }


    @RequestMapping(value = "/register", method = {RequestMethod.GET , RequestMethod.POST} )
    public String register(){
        return null;
    }



}
