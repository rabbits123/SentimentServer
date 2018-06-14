package sentiment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sentiment.model.Department;
import sentiment.model.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long>{
	List<Lecturer> findByLecturerName(String lecturerName);
}
