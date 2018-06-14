package sentiment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sentiment.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
	List<Subject> findBySubjectName(String subjectName);
	
	List<Subject> findBySubjectCode(String subjectCode);
	//@Modifying
	//@Query(value = "insert into subject (SubjectCode, SubjectName) VALUES (?1, ?2)", nativeQuery = true)
	//@Query("insert into Subject (SubjectCode,SubjectName) select :SubjectCode,:SubjectName from Subject")
    //public int modifyingQueryInsertSubject(@Param("SubjectCode")String SubjectCode, @Param("SubjectName")String SubjectName);

}
