package org.example.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    // 执行handler之前调用的拦截方法
    // 例如： 编码格式设置、登录保护、权限处理

    /**
     * filter => dofilter
     * @param request  请求对象
     * @param response  相应对象
     * @param handler 就是我们调用方法的对象
     * @return true 放行  false 拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor.preHandle");
        return true;
    }

    // hander之后触发的方法，没有链接
    // 只有preHandle 返回true才会触发
    /**
     *
     * @param request   请求
     * @param response  相应
     * @param handler   处理方法
     * @param modelAndView   返回的视图和共享域
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle");
    }


    /**
     * 整体处理完毕
     * @param request
     * @param response
     * @param handler
     * @param ex   如果handler报错了 异常对象 ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
    }
}
