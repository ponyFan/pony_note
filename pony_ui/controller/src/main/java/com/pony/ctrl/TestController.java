package com.pony.ctrl;

import com.pony.common.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zelei.fan on 2017/5/19.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/list")
    public String getList(Model model){
        model.addAttribute("value", "hahahahha");
        return "/redirectTest";
    }

    @RequestMapping("/redirectTest")
    @ResponseBody
    public BaseResponse redirect(String value){
        return new BaseResponse(200, "ok", value);
    }

}
