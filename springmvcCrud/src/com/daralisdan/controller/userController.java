package com.daralisdan.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.daralisdan.model.User;
import com.daralisdan.model.userException;

@Controller //申明这个类是一个处理器
//只要访问Controller，前面加个“/"才能访问 
@RequestMapping("/user") 
/*用来映射，当访问(DispatcherServlet)到这个路径时，就找到（映射到）这个bean下的这个方法，
然后交给(handlerMapping下的方法)适配器执行这个方法，然后这个方法就返回某个字符串,
然后就交给视图解析器（ViewResolver）获取一个真正的视图返回*/

public class userController {
	private Map<String, User> users = new HashMap<String, User>();

	public userController() {
		// TODO Auto-generated constructor stub
		users.put("sdy", new User("sdy", "123", "宋冬野", "asssss"));
		users.put("yy", new User("yy", "123", "丫丫", "asssss"));
		users.put("tt", new User("tt", "123", "天天", "asssss"));
	}

	/**
	 * 用户列表 传值到视图
	 * 
	 * @return
	 */
	// 访问 /user/users 就可以访问到这个方法，只有get请求的users才处理
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("users", users);
		return "user/list"; // 找jsp中user文件夹下的list
	}

	/**
	 * 用户添加
	 * 
	 * @return 链接到add页面时，是get请求，会访问这段代码
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		// 开启ModelDriven
		model.addAttribute(new User());
		return "user/add"; // 服务器端跳转
	}
	// 与上面的方法一样的，这种是把User
	// user中的user对象放到@ModelAttribute中，@ModelAttribute的key值就是"user"
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String add(@ModelAttribute("user") User user) {
//		return "user/add"; //服务器端跳转
//	}

	/**
	 * 
	 * @param user
	 * @return 在具体添加用户时，是post请求，访问以下代码
	 * @throws IOException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated User user, BindingResult br, @RequestParam("attach") MultipartFile[] attachs,
			HttpServletRequest req) throws IOException {
		/**
		 * 上传文件
		 */
		String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realpath);
		for (MultipartFile attach : attachs) {
			if (attach.isEmpty()) {
				continue; // 传多个文件时，如果某个文件为空时则跳过
			}
			File f = new File(realpath + "/" + attach.getOriginalFilename());
			FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
		}

		// 文件上传：System.out.println(attach.getName()+","+attach.getOriginalFilename()+","+attach.getContentType());
		users.put(user.getUsername(), user);
		return "redirect:/user/users"; // 客服端跳转

	}

	/**
	 * 显示视图
	 * 
	 * @param username
	 * @param model
	 * @return "{username}" 表示路径参数
	 * @PathVariable 表示路径中的一个值作为参数
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String show(@PathVariable String username, Model model) {
		model.addAttribute(users.get(username)); // 得到一个user对象，在视图中key 就为user
		return "user/show";
	}

	/**
	 * 返回json数据
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET, params = "json")
	@ResponseBody
	public String show(@PathVariable String username) {
		return "users.get(username)"; // 返回的是一个对象
	}

	/**
	 * 用户修改
	 * 
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
	public String update(@PathVariable String username, Model model) {
		model.addAttribute(users.get(username));
		return "user/update";
	}

	@RequestMapping(value = "/{username}/update", method = RequestMethod.POST)
	public String update(@PathVariable String username, @Validated User user, BindingResult br) {
		users.put(username, user);
		return "redirect:/user/users";
	}

	@RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable String username) {
		users.remove(username);
		return "redirect:/user/users";
	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		if (!users.containsKey(username)) {
			throw new userException("用户名不存在");
		}
		User u = users.get(username);
		if (!u.getPassword().equals(password)) {
			throw new userException("用户密码不正确");
		}
		session.setAttribute("loginUser", u);
		return "redirect:/user/users";
	}


	/**
	 * 局部异常处理（仅仅只是针对这个Controller）
	@ExceptionHandler(value = { userException.class })
	public String handlerException(userException e, HttpServletRequest req) {
		req.setAttribute("e", e);
		return "error";
	}
	 */

}
