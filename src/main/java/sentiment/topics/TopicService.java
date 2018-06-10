package sentiment.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//business service : singleton place to get data (model ?)
@Service 	
public class TopicService {
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("dsad", "spring", "dsadsa"),
			new Topic("dsad", "spring", "dsadsa"),
			new Topic("dsad", "spring", "dsadsa")));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		for(Topic tp : topics) {
			if(tp.getId().equals(id)) {
				return tp;
			}
		}
		return null;
	}
	
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
}
