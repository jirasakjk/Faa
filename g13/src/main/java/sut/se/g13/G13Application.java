package sut.se.g13;

import org.apache.el.stream.Stream;
import sut.se.g13.Entity.*;
import sut.se.g13.Repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;



@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class G13Application {

	public static void main(String[] args) {
		SpringApplication.run(G13Application.class, args);
	}
	@Bean
	ApplicationRunner init(ClassroomsRepository classroomsRepository,ParentsRepository parentsRepository,SchoolCheckRepository schoolCheckRepository,StatusRepository statusRepository,StudentRepository studentRepository)
	{return args -> {
		Student stu = new Student();
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		Student stu4 = new Student();
		Student stu5 = new Student();
		stu.setStudent_name("Tanapon");
		stu1.setStudent_name("Sitthichai");
		stu2.setStudent_name("Somchai");
		stu3.setStudent_name("Nanti");
		stu4.setStudent_name("Jiraphat");
		stu5.setStudent_name("Thiti");
		studentRepository.save(stu);
		studentRepository.save(stu1);
		studentRepository.save(stu2);
		studentRepository.save(stu3);
		studentRepository.save(stu4);
		studentRepository.save(stu5);

		studentRepository.findAll().forEach(System.out::println);

		Status sta = new Status();
		Status sta1 = new Status();

		sta.setStstusname("Present");
		sta1.setStstusname("Absent");
		statusRepository.save(sta);
		statusRepository.save(sta1);

		statusRepository.findAll().forEach(System.out::println);

		Parents pa = new Parents();
		Parents pa1 = new Parents();
		pa.setName("Mather");
		pa1.setName("Father");
		parentsRepository.save(pa);
		parentsRepository.save(pa1);
		parentsRepository.findAll().forEach(System.out::println);

		Classrooms cl = new Classrooms();
		Classrooms cl1 = new Classrooms();
		Classrooms cl2 = new Classrooms();
		cl.setClassroom("อนุบาล1");
		cl1.setClassroom("อนุบาล2");
		cl2.setClassroom("อนุบาล3");
		classroomsRepository.save(cl);
		classroomsRepository.save(cl2);
		classroomsRepository.save(cl1);
		classroomsRepository.findAll().forEach(System.out::println);



	};
	}
}

