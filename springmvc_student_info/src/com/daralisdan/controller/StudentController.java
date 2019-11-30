package com.daralisdan.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.dararlisdan.controller.model.Student;

@Controller
@RequestMapping("/rest")
public class StudentController {
	private List<Student> slist = new ArrayList<Student>(); // 存入学生数据

	public StudentController() {
		// TODO Auto-generated constructor stub
		Student s1 = new Student("001", "二狗子", "20岁", "男");
		Student s2 = new Student("002", "张三", "15岁", "女");
		Student s3 = new Student("003", "李四", "25岁", "男");
		Student s4 = new Student("004", "王五", "30岁", "男");
		slist.add(s1);
		slist.add(s2);
		slist.add(s3);
		slist.add(s4);
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, params = "json")
	@ResponseBody
	public Object getAll() {
		System.out.println("GET:All");
		return slist;
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getOne/{sid}", method = RequestMethod.GET, params = "json")
	public Object getOne(@PathVariable("sid") String id) {
		System.out.println("GET:" + id);
		List<Student> select = new ArrayList<Student>();
		for (Student s : slist) {
			if (s.getSid().equals(id)) {
				select.add(s);
			}
		}
		return select;
	}

	/**
	 * 添加
	 * 
	 * @param student
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.GET, params = "json")
	public Object add(@RequestBody Student student) {
		System.out.println("add:" + student.getSid());
		slist.add(student);
		return slist;
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @param student
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update/{sid}", method = RequestMethod.GET, params = "json")
	public Object update(@PathVariable("sid") String id, @RequestBody Student student) {
		System.out.println("update:" + id);
		List<Student> updatelist = new ArrayList<Student>();
		for (Student s : slist) {
			if (s.getSid().equals(id)) {
				student.setSid(s.getSid());
				updatelist.add(s);
			}

		}
		slist.removeAll(updatelist);
		slist.add(student);
		return slist;
	}

	/**
	 * 删除所有
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/clear", method = RequestMethod.GET, params = "json")
	public Object clear() {
		System.out.println("Delete:All");
		slist.clear();
		return slist;
	}
/**
 * 删除一个
 * @param id
 * @return
 */
	@ResponseBody
	@RequestMapping(value = "/delete/{sid}", method = RequestMethod.GET, params = "json")
	public Object delete(@PathVariable("sid") String id) {
		System.out.println("Delete:" + id);
		List<Student> removelist = new ArrayList<Student>();
		for (Student s : slist) {
			if (s.getSid().equals(id)) {
				removelist.add(s);
			}
		}
		slist.removeAll(removelist);
		return slist;
	}

}
