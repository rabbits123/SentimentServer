package sentiment.json.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "jsonTypeDepartment"})
public class ChartElement {
	private int semester;
	private JsonType jsonType = new JsonType();
	private List<Double> listRatio = new ArrayList<>();
	
	public ChartElement(int semester, JsonType jsonType) {
		this.semester = semester;
		this.jsonType = jsonType;
	}
	
	public ChartElement() {
		
	}
	
	public void caculateRatio() {
		int total = jsonType.getNegative() + jsonType.getPositive() + jsonType.getNeutral();
		this.listRatio.add((double)jsonType.getNegative() / total);
		this.listRatio.add((double)jsonType.getNeutral() / total);
		this.listRatio.add((double)jsonType.getPositive() / total);
	}
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public JsonType getListPercent() {
		return jsonType;
	}
	public void setListPercent(JsonType listPercent) {
		this.jsonType = listPercent;
	}

	public JsonType getJsonTypeDepartment() {
		return jsonType;
	}

	public void setJsonTypeDepartment(JsonType jsonTypeDepartment) {
		this.jsonType = jsonTypeDepartment;
	}

	public List<Double> getListRatio() {
		return listRatio;
	}

	public void setListRatio(List<Double> listRatio) {
		this.listRatio = listRatio;
	}
	
	
	
	
}
