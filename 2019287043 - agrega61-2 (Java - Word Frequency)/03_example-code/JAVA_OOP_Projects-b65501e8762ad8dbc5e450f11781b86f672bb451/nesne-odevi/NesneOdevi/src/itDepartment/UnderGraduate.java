package itDepartment;

import java.util.*;

public class UnderGraduate implements IStudent {

	protected int stdNo;
	protected String stdName;
	protected String stdSirName;
	protected String stdDepartment;
	private String stdSchool="Dokuz Eylul University";
	protected List<String> lessonNo=new ArrayList<String>();
	protected List<String> lessonName=new ArrayList<String>();
	protected List<Integer> lessonEcts=new ArrayList<Integer>();
	protected List<Double> examGrade=new ArrayList<Double>();
	
	public String getLessonNo(int no) {
		return lessonNo.get(no);
	}
	public void setLessonNo(String lessonNo) {
		this.lessonNo.add(lessonNo);
	}
	public String getLessonName(int no) {
		return lessonName.get(no);
	}
	public void setLessonName(String lessonName) {
		this.lessonName.add(lessonName);
	}
	public Integer getLessonEcts(int no) {
		return lessonEcts.get(no);
	}
	public void setLessonEcts(Integer lessonEcts) {
		this.lessonEcts.add(lessonEcts);
	}
	public Double getExamGrade(int no) {
		return examGrade.get(no);
	}
	public void setExamGrade(Double examGrade) {
		this.examGrade.add(examGrade);
	}

	public int getStdNo() {
		return stdNo;
	}
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdSirName() {
		return stdSirName;
	}
	public void setStdSirName(String stdSirName) {
		this.stdSirName = stdSirName;
	}
	public String getStdDepartment() {
		return stdDepartment;
	}
	public void setStdDepartment(String stdDepartment) {
		this.stdDepartment = stdDepartment;
	}

	@Override
	public double cumulativeSuccessGrade() {
		double numerator=0,denumerator=0;
		int i=0,ects;
		for (double grade: examGrade)
		{
			ects=lessonEcts.get(i);
			numerator+=grade*ects;
			denumerator+=ects;
			i++;
		}
		return numerator/denumerator;
	}
	@Override
	public void addLesson(String lessonNo,String lessonName,int lessonEcts,double examGrade) {
		// TODO Adding lessons to a specific student
		setLessonNo(lessonNo);
		setLessonName(lessonName);
		setLessonEcts(lessonEcts);
		setExamGrade(examGrade);
	}
	@Override
	public String toString() {
		return "UnderGraduate [stdNo=" + stdNo + ", stdName=" + stdName + ", stdSirName=" + stdSirName
				+ ", stdDepartment=" + stdDepartment + ", stdSchool=" + stdSchool + ", lessonNo=" + lessonNo
				+ ", lessonName=" + lessonName + ", lessonEcts=" + lessonEcts + ", examGrade=" + examGrade + "]";
	}


}
