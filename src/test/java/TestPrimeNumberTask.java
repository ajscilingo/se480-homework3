import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestPrimeNumberTask {

	private static Executor executor;
	private static Executor sleeper;
	private static Executor printer;
	private static Executor primer;

	
	@BeforeClass
	public static void setUpClass() {
		executor = Executors.newFixedThreadPool(1);
	}
	
	@Test
	public void testSychronousNonThreaded() {
		
		for(int i=0; i<1000; ++i) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(PrimeNumberTask.calculateNthPrimeNumber(i));
		}
	}
	
	@Test
	public void testPrimeNumberLoopWithSize1ThreadPool() {
		
		primer = Executors.newFixedThreadPool(1);
		sleeper = Executors.newFixedThreadPool(1);
		printer = Executors.newFixedThreadPool(1);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), primer)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, sleeper)
				.thenAcceptAsync( (Long result) -> System.out.println(result), printer));
		}
		
		for(CompletableFuture<Void> future: futures) {
			try {
				future.get();
				assertTrue(future.isDone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}		
	
	@Test
	public void testPrimeNumberLoopWithSize2ThreadPool() {
		
		primer = Executors.newFixedThreadPool(2);
		sleeper = Executors.newFixedThreadPool(2);
		printer = Executors.newFixedThreadPool(2);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), primer)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, sleeper)
				.thenAcceptAsync( (Long result) -> System.out.println(result), printer));
		}
		
		for(CompletableFuture<Void> future: futures) {
			try {
				future.get();
				assertTrue(future.isDone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}		
	
	@Test
	public void testPrimeNumberLoopWithSize4ThreadPool() {
		
		primer = Executors.newFixedThreadPool(4);
		sleeper = Executors.newFixedThreadPool(4);
		printer = Executors.newFixedThreadPool(4);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), primer)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, sleeper)
				.thenAcceptAsync( (Long result) -> System.out.println(result), printer));
		}
		
		for(CompletableFuture<Void> future: futures) {
			try {
				future.get();
				assertTrue(future.isDone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}		
	
	
	@Test
	public void testPrimeNumberLoopWithSize8ThreadPool() {
		
		primer = Executors.newFixedThreadPool(8);
		sleeper = Executors.newFixedThreadPool(8);
		printer = Executors.newFixedThreadPool(8);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), primer)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, sleeper)
				.thenAcceptAsync( (Long result) -> System.out.println(result), printer));
		}
		
		for(CompletableFuture<Void> future: futures) {
			try {
				future.get();
				assertTrue(future.isDone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}		
	
	
	@Test
	public void testPrimeNumberLoopWithSize16ThreadPool() {
		
		primer = Executors.newFixedThreadPool(16);
		sleeper = Executors.newFixedThreadPool(16);
		printer = Executors.newFixedThreadPool(16);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), primer)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, sleeper)
				.thenAcceptAsync( (Long result) -> System.out.println(result), printer));
		}
		
		for(CompletableFuture<Void> future: futures) {
			try {
				future.get();
				assertTrue(future.isDone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}		
	
	@Test
	public void testPrimeNumberLoopWithSize32ThreadPool() {
		
		primer = Executors.newFixedThreadPool(32);
		sleeper = Executors.newFixedThreadPool(32);
		printer = Executors.newFixedThreadPool(32);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), primer)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, sleeper)
				.thenAcceptAsync( (Long result) -> System.out.println(result), printer));
		}
		
		for(CompletableFuture<Void> future: futures) {
			try {
				future.get();
				assertTrue(future.isDone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}		
	
	@Test
	public void testNewCachedThreadPool() {
		
		primer = Executors.newCachedThreadPool();
		sleeper = Executors.newCachedThreadPool();
		printer = Executors.newCachedThreadPool();
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), primer)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, sleeper)
				.thenAcceptAsync( (Long result) -> System.out.println(result), printer));
		}
		
		for(CompletableFuture<Void> future: futures) {
			try {
				future.get();
				assertTrue(future.isDone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testForkJoinPoolCommonPool() {
		
		primer = ForkJoinPool.commonPool();
		sleeper = ForkJoinPool.commonPool();
		printer = ForkJoinPool.commonPool();
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), primer)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, sleeper)
				.thenAcceptAsync( (Long result) -> System.out.println(result), printer));
		}
		
		for(CompletableFuture<Void> future: futures) {
			try {
				future.get();
				assertTrue(future.isDone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void testPrimeNumber1() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(1), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(2L));
	}
	
	
	@Test
	public void testPrimeNumber2() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(2), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(3L));
	}
	
	@Test
	public void testPrimeNumber3() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(3), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(5L));
	}
	
	@Test
	public void testPrimeNumber4() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(4), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(7L));
	}
	
	@Test
	public void testPrimeNumber5() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(5), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(11L));
		
	}
	
	@Test
	public void testPrimeNumber6() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(6), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(13L));
	}
	
	@Test
	public void testPrimeNumber7() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(7), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(17L));
	}
	
	@Test
	public void testPrimeNumber8() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(8), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(19L));
	}
	
	@Test
	public void testPrimeNumber9() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(9), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(23L));
	}
	
	@Test
	public void testPrimeNumber10() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(10), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(29L));
	}
	
	@Test
	public void testPrimeNumber11() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(11), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(31L));
	}
	
	@Test
	public void testPrimeNumber12() {

		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(12), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(37L));
	}
	
	@Test
	public void testPrimeNumber100() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(100), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(541L));
	}
	
	@Test 
	public void testPrimeNumber500() {
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(500), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(3571L));
	}
	
	public void testPrimeNumber1000() {
		
		Long result = 0L;
		
		CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(1000), executor);
		try {
			result = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(completableFuture.isDone());
		assertTrue(result.equals(7919L));
	}

}
