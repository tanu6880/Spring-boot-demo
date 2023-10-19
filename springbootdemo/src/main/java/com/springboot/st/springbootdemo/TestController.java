package com.springboot.st.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
    @RequestMapping("/admin")
    public String firstHndler()
    {
        return "just for testing";
    }
    @RequestMapping("/")
    public String print()
    {
        return "contact";
    }

}
