package com.ty.mapping.uni.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {

	public static void main(String[] args) {

		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Course course1 = entityManager.find(Course.class, 1);
		Course course2 = entityManager.find(Course.class, 2);

		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);

		Student student = new Student();
		student.setAge(30);
		student.setName("Imtiyaz");
		student.setCourses(courses);

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

		System.out.println("***** Done *****");

	}

}
