package exceptionsHandling_customized;

import java.util.Scanner;
import exceptionsHandling_customized.EmployeeNotFoundException;

public class TestEmployee {

	public static void main(String[] args) throws EmployeeNotFoundException {

		Employee emp[] = new Employee[5];
		emp[0] = new Employee(1, "abc", 1000);
		emp[1] = new Employee(2, "pqr", 2000);
		emp[1] = new Employee(3, "xyz", 3000);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter EMP number - ");
		int a = sc.nextInt();

		for (int i = 0; i < emp.length; i++) {
			if (emp[i].empid == a) {
				System.out.println("Employee Informaton: " + emp[i].empid);
				System.out.println(emp[i].empid);
				System.out.println(emp[i].name);
				System.out.println(emp[i].basicSal);
				break;
			} else {
				throw new EmployeeNotFoundException("Employee does not exits");
			}
		}
	}
}
