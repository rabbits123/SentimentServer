package sentiment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sentiment.json.type.JsonTypeGeneral;
import sentiment.model.FeedbackSentence;

@Service
public class JsonTypeGeneralService {
	
	public JsonTypeGeneral calculateJsonTypeGeneral(List<FeedbackSentence> feedbackSentences) {
		JsonTypeGeneral jsonType = new JsonTypeGeneral();
		for(FeedbackSentence feedbackSentence: feedbackSentences) {
			int sentLabel = feedbackSentence.getSentimentlabel();
			int topicLabel = feedbackSentence.getTopiclabel();

			switch (topicLabel) {
			case 0:
				jsonType.setNumLec();
				switch (sentLabel) {
				case 0:
					jsonType.setNumNeg();
					jsonType.setLecNeg();
					break;
				case 1:
					jsonType.setNumNeu();
					jsonType.setLecNeu();
					break;
				case 2:
					jsonType.setNumPos();
					jsonType.setLecPos();
					break;
				}
				break;
			case 1:
				jsonType.setNumCur();
				System.out.println(jsonType.getNumCur());
				switch (sentLabel) {
				case 0:
					jsonType.setNumNeg();
					jsonType.setCurNeg();
					break;
				case 1:
					jsonType.setNumNeu();
					jsonType.setCurNeu();
					break;
				case 2:
					jsonType.setNumPos();
					jsonType.setCurPos();
					break;
				}
				break;
			case 2:
				jsonType.setNumfac();
				switch (sentLabel) {
				case 0:
					jsonType.setNumNeg();
					jsonType.setFacNeg();
					break;
				case 1: 
					jsonType.setNumNeu();
					jsonType.setFacNeu();
					break;
				case 2:
					jsonType.setNumPos();
					jsonType.setFacPos();
					break;
				}
				break;
			case 3:
				jsonType.setNumOth();
				switch (sentLabel) {
				case 0:
					jsonType.setNumNeg();
					jsonType.setOthNeg();
					break;
				case 1: 
					jsonType.setNumNeu();
					jsonType.setOthNeu();
					break;
				case 2:
					jsonType.setNumPos();
					jsonType.setOthPos();
					break;
				}
				break;
			}

		}
		return jsonType;
	}

}
