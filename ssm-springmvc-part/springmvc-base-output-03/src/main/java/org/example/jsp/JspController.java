package org.example.jsp;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {

    /**
     * TODO: 快速查找视图
     *    1。 方法的返回值是字符串类型
     *    2。 确保不能添加@RequestBody ，这个是直接返回字符串给浏览器，不找视图，也不走视图解析器
     *    3。 通过返回值 写对应中间视图名称即可
     * @return
     */
    @GetMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("data","hello");
        System.out.println("JspController.index");
        return "index";
    }

    // 转发 只能是项目下的资源

    /**
     * 1。 方法的返回值写成字符串
     * 2。 不能添加@ResponseBody注解
     * 3。 在返回的字符串前添加forwar: / 转发地址
     * @return
     */
    @GetMapping("forward")
    public String forward(){
        return "forward:/jsp/index"; //  forward 表示转发的意思
    }


    /**
     * 重定向
     * 1. 方法返回值写成字符串形式
     * 2。 不能添加@ResponseBody注解
     * 3。 在返回字符串前添加注解 redirect: /重定向地址
     * @return
     */

    /**
     * 路径细节：【不使用spingmvc request response】
     *     转发是项目下的资源跳转，路径，项目下的地址 /jsp/index 忽略 applicationContext
     *     重定向可以是项目下的资源，也可以是项目外的资源  重定向属于二次请求路径：项目下的地址 全地址： /springmvc/jsp/index 不忽略 applicationContext
     *
     * 使用springmvc路径方法：
     * "forward:路径 ｜ redirect: 路径 " 重定向资源的地址 也不需要写项目的根路径！  /jsp/index
     * 转发和重定向的地址都一样 ！ springmvc/jsp/index  -> springmvc/springmvc/jsp/index
     *
     * @return
     */
    //
    @GetMapping("redirect")
    public String redirect(){
        System.out.println("JspController.redirect");
        return "redirect:/jsp/index";
    }


    @GetMapping("redirect/baidu")
    public String redirectBaidu(){
        System.out.println("JspController.baidu");
        return "redirect:http://www.baidu.com";
    }


}
