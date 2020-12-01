package exceptionsHandling_customized;

public class EmployeeNotFoundException extends Exception {
	String message;

	EmployeeNotFoundException(String str) {
		message = str;
	}

	public String toString() {
		return ("Custom Exception Occurred : " + message);
	}
}
