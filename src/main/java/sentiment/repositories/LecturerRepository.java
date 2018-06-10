package sentiment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sentiment.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Long>{

}
