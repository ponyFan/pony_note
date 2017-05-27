package com.pony.ctrl;

import com.pony.common.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by zelei.fan on 2017/5/19.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/list")
    public String getList(Model model, RedirectAttributes attributes){
        model.addAttribute("value", "hahahahha");
        attributes.addAttribute("value", "ggggggggggg");
        return "redirect:/test/redirectTest1";
    }

    @RequestMapping("/redirectTest")
    @ResponseBody
    public BaseResponse redirect(String value){
        return new BaseResponse(200, "ok", value);
    }

    @RequestMapping("/redirectTest1")
    public String redirect1(){
        return "/aa";
    }
}
