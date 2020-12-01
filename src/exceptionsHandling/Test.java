package exceptionsHandling;

public class Test {
	
	// use of "throw" in finally block to throw new RuntimeException("RE");
	
	public static void main(String[] args) {
		try {
			try {
			} finally {
				try {
					throw new IllegalStateException("ISE");
				} finally {
					throw new IllegalArgumentException("IAE");
				}
			}
		} finally {
			throw new RuntimeException("RE");
		}
	}
}
