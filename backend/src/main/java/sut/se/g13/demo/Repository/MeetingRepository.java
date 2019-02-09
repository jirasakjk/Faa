package sut.se.g13.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g13.demo.entity.Meeting;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}
