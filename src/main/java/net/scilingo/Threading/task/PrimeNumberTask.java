package net.scilingo.Threading.task;

public class PrimeNumberTask {
	
	public static Long calculateNthPrimeNumber(final int n) {
		Long number;
		int count = 0;

		for(number = 2L; count < n; number++) {
			if(isPrimeNumber(number)) {
				count++;
			}
		}
	
		number = number -1L;
		return number;
	}
	
	private static boolean isPrimeNumber(Long n) {
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	
	
}
