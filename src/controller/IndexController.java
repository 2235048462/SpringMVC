package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.springframework.web.servlet.mvc.Controller; //mav01,mav02

@Controller // 注解,表示该类是一个控制器
public class IndexController /*implements Controller*/ {

    // 控制类IndexController实现接口Controller,提供方法handleRequest处理请求
    @RequestMapping("/hello") // 注解,表示路径/hello会映射到该方法上
    public ModelAndView handleRequest ( HttpServletRequest request, HttpServletResponse response ) {

        // SpringMVC通过ModelAndView对象把模型和视图结合在一起
        // ModelAndView mav01 = new ModelAndView ( "index.jsp" );
        // ModelAndView mav02 = new ModelAndView ( "hello" ); //视图定位
        ModelAndView mav03 = new ModelAndView ( "hello" ); // 注解方式

        // mav01.addObject ( "message", "Hello Spring MVC......" );
        // mav02.addObject ( "helloMessage", "视图定位..." );
        mav03.addObject ( "helloMessage", "注解方式..." );

        return mav03;
    }

    /* 路径跳转具有传递性,但传递中的路径不能是已经存在的路径,即不能由/hello跳转到/addProduct. */
    @RequestMapping("/jump") // 注解,映射/jump到jump()方法
    public ModelAndView jump () {
        ModelAndView mav04 = new ModelAndView ( "redirect:/hello1" ); // 表示客户端跳转
        return mav04;
    }

    @RequestMapping("/hello1")
    public ModelAndView hello () {
        ModelAndView mav05 = new ModelAndView ( "redirect:/addProduct.jsp" ); // /hello路径跳转到/addProduct
        return mav05;
    }

    @RequestMapping("/check")
    public ModelAndView check ( HttpSession session ) {
        Integer i = (Integer) session.getAttribute ( "count" );
        if (i == null) {
            i = 0;
        }
        i++;
        session.setAttribute ( "count", i );
        ModelAndView mav06 = new ModelAndView ( "check" );
        return mav06;
    }

    /* 访问/clear后,session的count=0,且客户端跳转到/check */
    @RequestMapping("/clear")
    public ModelAndView clear ( HttpSession session ) {
        session.setAttribute ( "count", -1 ); // session的count=0.
        ModelAndView mav07 = new ModelAndView ( "redirect:/check" );
        return mav07;
    }
}
