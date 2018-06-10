package sentiment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.model.FeedbackSentence;
import sentiment.repositories.FeedbackSentenceRepository;

@Service
public class DepartmentChartService {

	@Autowired
	private FeedbackSentenceRepository feedbackSentenceRepository;

	@Autowired
	private DepartmentPercentService departmentPercentService;

	public List<ChartElement> getChart(String departmentID) {
		List<ChartElement> chartList = new ArrayList<>();

		ArrayList<Integer> listSemester = departmentPercentService.getListSemester();

		for (int semester : listSemester) {
			ChartElement chart = new ChartElement();
			chart.setListPercent(departmentPercentService.getPercent(departmentID, semester));
			chart.setSemester(semester);
			chart.caculateRatio();
			chartList.add(chart);
		}
		return chartList;
	}

}
