package com.app.learnspringboot.pojo;

public class Course {
	
	private int id;
	private String name;
	private String trainer;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Course(int id, String name, String trainer) {
		super();
		this.id = id;
		this.name = name;
		this.trainer = trainer;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", trainer=" + trainer + "]";
	}
	
	
	

}
