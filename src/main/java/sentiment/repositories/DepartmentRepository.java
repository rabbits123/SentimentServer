package sentiment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sentiment.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	List<Department> findByDepartmentName(String departmentName);
//	@Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
//	List<Department> retrieveByName(@Param("name") String name);
}
