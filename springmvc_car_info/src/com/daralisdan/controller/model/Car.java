package com.daralisdan.controller.model;
/**
 * 实体类
 * @author Administrator
 *
 */
public class Car {
	private String type;
	private String color;
	private String wheels;
	private String people;

	public Car() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWheels() {
		return wheels;
	}

	public void setWheels(String wheels) {
		this.wheels = wheels;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public Car(String type, String color, String wheels, String people) {
		this.type = type;
		this.color = color;
		this.wheels = wheels;
		this.people = people;
	}

}