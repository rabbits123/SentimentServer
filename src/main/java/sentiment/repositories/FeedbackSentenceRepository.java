package sentiment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sentiment.model.FeedbackSentence;
@Repository
public interface FeedbackSentenceRepository extends JpaRepository<FeedbackSentence, Long>{
	
}
