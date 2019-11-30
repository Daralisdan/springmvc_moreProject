package com.daralisdan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.activation.MimeType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daralisdan.controller.model.Car;

/**
 * 控制器类
 * 
 * @author Administrator
 * @controller 注解用于声明这个类是一个处理器类 @RequestMapping("/car")
 *             注解用于映射处理请求地址的路径，该路径是响应所有请求的方法的父路径
 */
@Controller
@RequestMapping("/car")
public class CarController {
	private List<Car> cars = new ArrayList<Car>();// 存储车辆数据

	public CarController() {
		// 初始化数据
		Car c1 = new Car("川A", "black", "4", "6");
		Car c2 = new Car("川R", "white", "3", "4");
		Car c3 = new Car("川A", "red", "2", "3");
		cars.add(c1); // 把数据存入到集合中
		cars.add(c2);
		cars.add(c3);
	}

	/**
	 * 查询所有信息，返回json数据
	 * 
	 * @return
	 * @RequestMapping 该注解用于映射路径地址， 访问该方法时需要父路径追加到在注解方法上的路径地址，get请求
	 * @ResponseBody 该注解返回一个json数据，（接收Controller的该方法返回的对象，
	 *               然后处理后写入到response对象的body中然后返回一个json数据给这个对象的参数）
	 *               该方法返回的数据直接写入到http响应的正文中，然后返回一个json数据
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, params = "json")
	@ResponseBody // 该注解返回一个json数据，该方法返回的数据直接写入到http响应的正文中，然后返回一个json
	public Object getAll() {
		System.out.println("GET:getAll");
		return cars;
	}

	/**
	 * 根据车轮数查询
	 * 
	 * @RequestMapping 注解 映射响应请求的路径，访问该方法需要父路径追加到该方法的注解上的路径地址，get请求
	 * @@ResponseBody 该注解返回一个json数据（接收Controller类的该方法返回的对象）
	 *                该方法访问的数据直接写入到http响应的正文中，然后返回一个json数据
	 * @PathVariable 注解 用于获取请求路径中动态参数，相当于一个占位符
	 * @param wheel
	 * @return
	 */
	@RequestMapping(value = "/getWheels/{wheels}", method = RequestMethod.GET, params = "json")
	@ResponseBody
	public Object getWheels(@PathVariable("wheels") String wheel) {
		System.out.println("GET:getWheels");
		List<Car> select = new ArrayList<Car>();
		for (Car c : cars) {
			if (c.getWheels().equals(wheel)) {
				select.add(c);
			}
		}
		return select;
	}

	/**
	 * 创建用户
	 * 
	 * @param model
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/add", method = RequestMethod.GET) public String
	 * add(Model model) { // 开启ModelDriven,创建一个新用户 model.addAttribute(new Car());
	 * return "car/add"; }
	 * 
	 * @RequestMapping(value = "/add",method=RequestMethod.POST)
	 * 
	 * @ResponseBody public Object caradd(Car caradd) { cars.add(caradd); return
	 * cars; }
	 */

	/**
	 * 第二种创建方法
	 */

	@RequestMapping(value = "/add", method = RequestMethod.GET, params = "json")
	@ResponseBody
	public Object add1(@RequestBody Car car) {
		System.out.println("add:" + car.getWheels());
		cars.add(car);
		return cars;
	}
	/*
	 * 修改用户
	 * 
	 * @RequestMapping(value = "/update", method = RequestMethod.GET) public String
	 * update(Model model, @PathVariable String wheel) {
	 * model.addAttribute("wheels", wheel); return "car/update"; }
	 * 
	 * @RequestMapping(value = "/updateCar/{wheels}", method = RequestMethod.POST,
	 * params = "json")
	 * 
	 * @ResponseBody public Object updateCar(@RequestBody Car
	 * carupdate, @PathVariable("wheels") String Wheel) { List<Car> update = new
	 * ArrayList<Car>(); update.add(carupdate); cars.removeAll(update);
	 * cars.add(carupdate); return cars; }
	 */

	/**
	 * 修改用户
	 */
	@ResponseBody
	@RequestMapping(value = "/update/{wheels}", method = RequestMethod.GET)
	public Object update(@PathVariable("wheels") String wheel, @RequestBody Car car) {
		System.out.println("updete:" + wheel);
		List<Car> update = new ArrayList<Car>();
		for (Car c : cars) {
			if (c.getWheels().equals(wheel)) {
				car.setWheels(c.getWheels());
				update.add(c);
			}
		}
		cars.removeAll(update);
		cars.add(car);
		return cars;
	}

	/**
	 * 删除所有
	 */
	@ResponseBody
	@RequestMapping(value = "/clearAll", method = RequestMethod.GET, params = "json")
	public Object clearAll() {
		System.out.println("clearAll:car");
		cars.clear();
		return cars;
	}

	/**
	 * 删除一个
	 */
	@ResponseBody
	@RequestMapping(value = "/clearOne/{wheels}", method = RequestMethod.GET, params = "json")
	public Object clearOne(@PathVariable("wheels") String wheel) {
		System.out.println("clear:" + wheel);
		List<Car> clear = new ArrayList<Car>();
		for (Car c : cars) {
			if (c.getWheels().equals(wheel)) {
				clear.add(c);
			}
		}
		cars.removeAll(clear);
		return cars;
	}
}
