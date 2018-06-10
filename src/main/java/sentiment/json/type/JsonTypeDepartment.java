package sentiment.json.type;

import java.util.ArrayList;
import java.util.List;

public class JsonTypeDepartment {
	private int positive =0;
	private int neutral =0;
	private int negative=0;
	
	public JsonTypeDepartment(int positive, int neutral, int negative) {
		this.positive = positive;
		this.neutral = neutral;
		this.negative = negative;
	}
	
	public JsonTypeDepartment() {
		
	}
	public int getPositive() {
		return positive;
	}
	public void setPositive() {
		this.positive += 1;
	}
	public int getNeutral() {
		return neutral;
	}
	public void setNeutral() {
		this.neutral += 1;
	}
	public int getNegative() {
		return negative;
	}
	public void setNegative() {
		this.negative += 1;
	}
}
