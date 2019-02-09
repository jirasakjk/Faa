package sut.se.g13.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.ApplicationRunner;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g13.demo.Repository.CategoryRepository;
import sut.se.g13.demo.Repository.MeetingRepository;
import sut.se.g13.demo.Repository.PersonnelRepository;
import sut.se.g13.demo.Repository.StatusmeetRepository;
import sut.se.g13.demo.entity.Category;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	ApplicationRunner init(CategoryRepository categoryRepository, MeetingRepository meetingRepository, PersonnelRepository personnelRepository, StatusmeetRepository statusmeetRepository){
		return args -> {

			Category cy = new Category();
			Category cy1 = new Category();
			Category cy2 = new Category();
			Category cy3 = new Category();
			cy.setCatename("Hello Word");
			cy1.setCatename("ggggggggggggggggggggggggggggg");
			cy2.setCatename("DDDDDDDDDDDDDDDDDDDDDDD");
			cy3.setCatename("Hello Word");
			categoryRepository.save(cy);
			categoryRepository.save(cy1);
			categoryRepository.save(cy2);
			categoryRepository.save(cy3);
			categoryRepository.findAll().forEach(System.out::println);
		};
	}

}

