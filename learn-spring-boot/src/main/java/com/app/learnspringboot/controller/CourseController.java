package com.app.learnspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.learnspringboot.pojo.Course;

@RestController
public class CourseController {

	@GetMapping("/cources")
	public List<Course> retriveAllCourse(){
		System.out.println("in cour controller");
		return Arrays.asList(new Course(0, "Learn AWS", "Avinah"),
				new Course(1, "Learn React", "Avinash"));
	}
}
