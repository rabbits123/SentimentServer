package sentiment.json.type;

public class JsonTypeDepartmentFB {
	private String feedback;
	private int sentLabel;
	private int topLabel;
	
	public JsonTypeDepartmentFB(String feedback, int sentLabel, int topLabel) {
		this.feedback = feedback;
		this.sentLabel = sentLabel;
		this.topLabel = topLabel;
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
	public int getTopLabel() {
		return topLabel;
	}
	public void setTopLabel(int topLabel) {
		this.topLabel = topLabel;
	}
	
	
}
