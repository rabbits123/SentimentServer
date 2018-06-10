package sentiment.json.type;

public class JsontypeFeedback {
	private String feedback;
	private int sentLabel;

	public JsontypeFeedback(String feedback, int sentLabel) {
		super();
		this.feedback = feedback;
		this.sentLabel = sentLabel;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getSentLabel() {
		return sentLabel;
	}

	public void setSentLabel(int sentLabel) {
		this.sentLabel = sentLabel;
	}


}
