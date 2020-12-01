package exceptionsHandling;

public class Test2 {

	// Unreachable code Example
	public static void main(String[] args) {
		try {
			try {
			} finally {
				try {
					throw new IllegalStateException("ISE");
				} finally {
					throw new IllegalArgumentException("IAE");
				}
			//	throw new RuntimeException("RE");   // Unreachable code
			}
		} finally {
			System.out.println("Inside Finally");
		}
	}
}
