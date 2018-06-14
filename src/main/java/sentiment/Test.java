package sentiment;

import uit.sentiment.maxent.PredictSentence;

public class Test {
	public static void main(String []args) {
		PredictSentence pre = new PredictSentence("model/sentiment.model", "model/topic.model");
		System.out.println();
	}
}
