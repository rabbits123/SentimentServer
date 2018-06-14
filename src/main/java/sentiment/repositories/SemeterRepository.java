package sentiment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sentiment.model.Semeter;

@Repository
public interface SemeterRepository extends JpaRepository<Semeter, Long>{
	List<Semeter> findBySemeterName(String semeterName);
}
