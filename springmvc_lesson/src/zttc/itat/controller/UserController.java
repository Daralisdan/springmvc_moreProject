package zttc.itat.controller;

import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.ModelAndViewContainer;

import zttc.itat.controller.model.User;
import zttc.itat.controller.model.UserException;

@Controller
@RequestMapping("/user")
public class UserController {
	private Map<String, User> users = new HashMap<String, User>(); // 存数据，值

	public UserController() {
		// TODO Auto-generated constructor stub
		users.put("cxk", new User("cxk", "123", "蔡徐坤", "asas"));
		users.put("sdy", new User("sdy", "123", "宋冬野", "asas"));
		users.put("tt", new User("tt", "123", "天天", "asas"));
		users.put("yy", new User("yy", "123", "丫丫", "asas"));

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", users);
		return "user/list";
	}
	/**
	 * 添加用户 链接到add页面时是get请求，会访问这段代码 然后跳转到服务器端 add页面
	 * 
	 * @param username
	 * @return
	 */
	/*
	 * 两种方式都行
	 * 
	 * @RequestMapping(value = "/add", method = RequestMethod.GET) public String
	 * add(@ModelAttribute("user") User user) { return "user/add";
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		// 开启ModelDriven,绑定，创建一个新用户
		model.addAttribute(new User());
		return "user/add";
	}

	/**
	 * 再具体添加用户时，是post请求，就访问以下代码 然后跳转到客户端（redirect)users页面
	 * 
	 * @param user
	 * @return
	 * @Validated User 验证，User是验证的对象， BindingResult br验证的结果（一定要紧跟验证结果类
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated User useradd, BindingResult br) {
		/**
		 * 如果有错误就跳转到add视图
		 */
		if (br.hasErrors()) {
			return "user/add";

		}
		users.put(useradd.getUsername(), useradd);
		return "redirect:/user/users";
	}

	/**
	 * 显示详细列表
	 * 
	 * @param username
	 * @return value="{usernameShow}" 路径参数
	 */
	@RequestMapping(value = "/{usernameShow}", method = RequestMethod.GET)
	public String show(@PathVariable String usernameShow, Model model) {
		model.addAttribute(users.get(usernameShow));
		return "user/show";
	}
	@RequestMapping(value = "/{usernameShow}", method = RequestMethod.GET,params="json")
	@ResponseBody
	public User show(@PathVariable String usernameShow) {
		return users.get(usernameShow);
	}
	
	
	
	
	
	

	/**
	 * 修改用户
	 * 
	 * @param model
	 * @param usernameUpdate
	 * @return
	 */
	@RequestMapping(value = "/{usernameUpdate}/update", method = RequestMethod.GET)
	public String update(Model model, @PathVariable String usernameUpdate) {
		model.addAttribute(users.get(usernameUpdate));
		return "user/update";
	}

	@RequestMapping(value = "/{usernameUpdate}/update", method = RequestMethod.POST)
	public String update(@PathVariable String usernameUpdate, User user) {
		users.put(usernameUpdate, user);
		return "redirect:/user/users";
	}

	/**
	 * 删除
	 * 
	 * @param usernameDelete
	 * @return
	 */
	@RequestMapping(value = "/{usernameDelete}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable String usernameDelete) {
		users.remove(usernameDelete);
		return "redirect:/user/users";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		if (!users.containsKey(username)) {
			throw new UserException("用户名不存在");
		}
		User u=users.get(username);
		if (!u.getPassword().equals(password)) {
			throw new UserException("用户密码不正确");
		}
		session.setAttribute("loginUser", u);
		return "redirect:/user/users";
	}
}
