package sut.se.g13.Controller;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.g13.Entity.*;
import sut.se.g13.Repository.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SchoolcheckController {
    @Autowired private ClassroomsRepository classroomsRepository;
    @Autowired private ParentsRepository parentsRepository;
    @Autowired private SchoolCheckRepository schoolCheckRepository;
    @Autowired private StatusRepository statusRepository;
    @Autowired private StudentRepository studentRepository;

    @GetMapping(path = "/Classrooms")
    public Collection<Classrooms> classrooms() {
        return classroomsRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Parents")
    public Collection<Parents> parents() {
        return parentsRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Status")
    public Collection<Status> status() {
        return statusRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Students")
    public Collection<Student> student() {
        return studentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/SchoolCh")
    public Collection<SchoolCheck> schoolchecks() { return schoolCheckRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/schoolcheck/{student}/{classroom}/{date}/{status}/{parent}")
    public SchoolCheck schoolck(@PathVariable Long student,@PathVariable Long classroom,@PathVariable Date date,@PathVariable Long status,@PathVariable Long parent){
        Student stu = studentRepository.findById(student).get();
        Classrooms clas = classroomsRepository.findById(classroom).get();
        Status sta = statusRepository.findById(status).get();
        Parents pa = parentsRepository.findById(parent).get();
        SchoolCheck schoolchecks = new SchoolCheck();
        schoolchecks.setStudent(stu);
        schoolchecks.setClassrooms(clas);
        schoolchecks.setStatus(sta);
        schoolchecks.setDatecome(date);
        schoolchecks.setParents(pa);
        schoolCheckRepository.save(schoolchecks);
        return schoolchecks;
    }

}

