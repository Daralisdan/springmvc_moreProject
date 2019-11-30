package zttc.itat.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson {
	/**
	 * 
	 * @param   String username 是视图传值给Controller
	 * @param   Map<String,Object> context 是Controller传值给视图
	 * @return
	 */
//	@RequestMapping("/good")
//	public String good(String username,Map<String,Object> context) {
//		context.put("username", username); //传值给视图
//		System.out.println(username);
//		return "welcome";
//	}
	@RequestMapping("/good")
	public String good(String username,Model model) {
		model.addAttribute("username", username); //传值给视图
		System.out.println(username);
		return "welcome";
	}


} 
