package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloDispatcher {

    @RequestMapping("/hello")
    public String hello(){

        return "hello";
    }

    /**
     * RequestParam获取参数
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/success")
    public String success(@RequestParam("username")String username,
                          @RequestParam("password")String password){

        System.out.println(username);
        System.out.println(password);

        return "success";
    }

    /**
     * 使标签name和参数名字相同，获取参数
     * @param username
     * @param password
     * @param verifycode
     * @return
     */
    @RequestMapping(value = {"/mvcsuccess"},
            method = {RequestMethod.POST},
            params = {"username", "password", "verifycode"})
    public String mvcsuccess(String username, String password, String  verifycode){

        System.out.println(username);
        System.out.println(password);
        System.out.println(verifycode);

        return "success";
    }

    @RequestMapping("/testModelAndView/{id}")
    public ModelAndView testModelAndView(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView();

        mv.addObject("mv" , "Hello ModelAndView");
        mv.addObject("mv1" , "this is a demo");
        mv.addObject("id" , id);

        mv.setViewName("success");
        return mv;
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String testDelete(String username){

        System.out.println("userId : " + username);

        return "success";
    }
}
