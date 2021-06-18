package itDepartment;

public interface IStudent extends ILessons{
	
	double cumulativeSuccessGrade();
	void setStdNo(int stdNo);
	void setStdName(String stdName);
	void setStdSirName(String stdSirName);
	void setStdDepartment(String stdDepartment);
}
