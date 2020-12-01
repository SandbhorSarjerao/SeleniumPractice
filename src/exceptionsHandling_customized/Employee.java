package exceptionsHandling_customized;

public class Employee {
	int empid;
	String name;
	float basicSal;
	
	public Employee(int id, String nm, int bsal) {
		empid=id;
		name = nm;
		basicSal=bsal;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(float basicSal) {
		this.basicSal = basicSal;
	}
}
