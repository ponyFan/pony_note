package com.pony.ctrl;

import com.pony.common.BaseResponse;
import com.pony.common.http.HttpClient;
import freemarker.template.utility.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private HttpClient httpClient;

    @RequestMapping("/redirectTest")
    @ResponseBody
    public BaseResponse redirect(){
        return httpClient.defaultPost("/test/list", null, BaseResponse.class);
    }


    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("value", "哈哈");
        return "/test/redirecTest";
    }

    @RequestMapping("/modal")
    public String modal(){
        return "/test/testmodal";
    }

}
