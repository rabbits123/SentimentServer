package sentiment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sentiment.model.FeedbackSentence;

public interface FeedbackSentenceRepository extends JpaRepository<FeedbackSentence, Long>{
	
}
