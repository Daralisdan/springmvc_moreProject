package com.daralisdan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	/**
	 * @RequestMapping 表示用哪个URL来对应
	 * 
	 * 为了访问某个URL能得到这个hello
	 * 访问/hello之后能自动找到HelloController下的方法处理
	 */
	@RequestMapping({ "/hello", "/" }) 
	
	public String hello(@RequestParam ("username") String username,Model model) {  
		System.out.println("hello");
		model.addAttribute("username",username);
		System.out.println(username);
		return "hello"; 
		//返回一个视图，直接返回一个hello（"hello"是逻辑视图的名称）现在需要pu创建一个hello.jsp文件
	}
	@RequestMapping({"/welcome"})
	public String welcome() {
		return "welcome";
	}
}
