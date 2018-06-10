package sentiment.json.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "jsonTypeDepartment"})
public class ChartElement {
	private int semester;
	private JsonTypeDepartment jsonTypeDepartment = new JsonTypeDepartment();
	private List<Double> listRatio = new ArrayList<>();
	
	public ChartElement(int semester, JsonTypeDepartment jsonTypeDepartment) {
		this.semester = semester;
		this.jsonTypeDepartment = jsonTypeDepartment;
	}
	
	public ChartElement() {
		
	}
	
	public void caculateRatio() {
		int total = jsonTypeDepartment.getNegative() + jsonTypeDepartment.getPositive() + jsonTypeDepartment.getNeutral();
		this.listRatio.add((double)jsonTypeDepartment.getNegative() / total);
		this.listRatio.add((double)jsonTypeDepartment.getNeutral() / total);
		this.listRatio.add((double)jsonTypeDepartment.getPositive() / total);
	}
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public JsonTypeDepartment getListPercent() {
		return jsonTypeDepartment;
	}
	public void setListPercent(JsonTypeDepartment listPercent) {
		this.jsonTypeDepartment = listPercent;
	}

	public JsonTypeDepartment getJsonTypeDepartment() {
		return jsonTypeDepartment;
	}

	public void setJsonTypeDepartment(JsonTypeDepartment jsonTypeDepartment) {
		this.jsonTypeDepartment = jsonTypeDepartment;
	}

	public List<Double> getListRatio() {
		return listRatio;
	}

	public void setListRatio(List<Double> listRatio) {
		this.listRatio = listRatio;
	}
	
	
	
	
}
