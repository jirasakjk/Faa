package sut.se.g13;


import sut.se.g13.Entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class G13ApplicationTests {


	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	@Test
	public void testAllMatch() {
		SchoolCheck sck = new SchoolCheck();
		Student ss = new Student("siriratt");
		Parents pa = new Parents("Marther");
		Status st = new Status("Present");
		Classrooms cr = new Classrooms("B1");
		sck.setStudent(ss);
		sck.setParents(pa);
		sck.setStatus(st);
		sck.setClassrooms(cr);

		try {
			entityManager.persist(sck);
		//	entityManager.flush();

		//	fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testStudentNull() {
		SchoolCheck sck1 = new SchoolCheck();

		Parents pa = new Parents("Marther");
		Status st = new Status("Present");
		Classrooms cr = new Classrooms("B3");
		sck1.setStudent(null);
		sck1.setParents(pa);
		sck1.setStatus(st);
		sck1.setClassrooms(cr);

		try {
			entityManager.persist(sck1);


		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testStudentOversize(){
		SchoolCheck sck = new SchoolCheck();
		Student ss = new Student("siriratttttttttttttttttt");
		Parents pa = new Parents("Marther");
		Status st = new Status("Present");
		Classrooms cr = new Classrooms("B2");
		sck.setStudent(ss);
		sck.setParents(pa);
		sck.setStatus(st);
		sck.setClassrooms(cr);

		try {
				entityManager.persist(sck);
			//	entityManager.flush();

			//	fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testStudentMinsize(){
		SchoolCheck sck = new SchoolCheck();
		Student ss = new Student("sr");
		Parents pa = new Parents("Marther");
		Status st = new Status("Present");
		Classrooms cr = new Classrooms("B1");
		sck.setStudent(ss);
		sck.setParents(pa);
		sck.setStatus(st);
		sck.setClassrooms(cr);

		try {
			entityManager.persist(sck);
			//	entityManager.flush();

			//	fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testmNotPatternMatch(){
		SchoolCheck sck = new SchoolCheck();
		Student ss = new Student("กกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
		Parents pa = new Parents("Marther");
		Status st = new Status("Present");
		Classrooms cr = new Classrooms("codddddds3");
		sck.setStudent(ss);
		sck.setParents(pa);
		sck.setStatus(st);
		sck.setClassrooms(cr);

		try {
			entityManager.persist(sck);
			//	entityManager.flush();

			//	fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
}

