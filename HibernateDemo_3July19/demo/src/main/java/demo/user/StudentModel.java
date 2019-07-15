package demo.user;

public class StudentModel implements java.io.Serializable 
{
	private int id,marks;
	private String name,course;
	
	public StudentModel() {}
	public StudentModel(int a,int b,String c,String d)
	{
		id=a;
		marks=b;
		name=c;
		course=d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String toString()
	{
		return "ID : "+id+"\tNAME : "+name+"\tCOURSE : "+course+"\tMARKS : "+marks;
	}
}
