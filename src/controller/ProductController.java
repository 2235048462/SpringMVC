package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Product;

@Controller
public class ProductController {

    @RequestMapping("/addProduct")
    // add方法的Product参数接收注入
    public ModelAndView add ( Product product ) throws Exception {
        ModelAndView mav = new ModelAndView ( "showProduct" );
        return mav;
    }
}
