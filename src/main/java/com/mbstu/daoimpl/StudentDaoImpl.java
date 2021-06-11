package com.mbstu.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mbstu.dao.StudentDao;
import com.mbstu.entity.Student;
import com.mbstu.utils.JpaUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void save(Student student) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
	}

	@Override
	public Student findById(int id) {
		EntityManager em = JpaUtils.getEntityManager();
		Student student = em.find(Student.class, id);
		return student;
	}

	@Override
	public void update(Student student) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Student student) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		student = em.find(Student.class, student.getId());
		em.remove(student);
		em.getTransaction().commit();
	}

	@Override
	public List<Student> getAll() {
		EntityManager em = JpaUtils.getEntityManager();
		String query = "SELECT s FROM Student s";
		List<Student> students = em.createQuery(query).getResultList();
		return students;
	}

}
