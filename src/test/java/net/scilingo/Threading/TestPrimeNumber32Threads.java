package net.scilingo.Threading;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import net.scilingo.Threading.task.PrimeNumberTask;

public class TestPrimeNumber32Threads {

	
	private static Executor sleeper;
	private static Executor printer;
	private static Executor primer;

	@Test
	public void testPrimeNumberLoopWith32TasksThreadPool() {
		
		primer = Executors.newFixedThreadPool(32);
		sleeper = Executors.newFixedThreadPool(32);
		printer = Executors.newFixedThreadPool(32);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 32; ++i) {
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
	public void testPrimeNumberLoopWith1024TasksThreadPool() {
		
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
	public void testPrimeNumberLoopWith2048TasksThreadPool() {
		
		primer = Executors.newFixedThreadPool(32);
		sleeper = Executors.newFixedThreadPool(32);
		printer = Executors.newFixedThreadPool(32);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 2048; ++i) {
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
	public void testPrimeNumberLoopWith3072TasksThreadPool() {
		
		primer = Executors.newFixedThreadPool(32);
		sleeper = Executors.newFixedThreadPool(32);
		printer = Executors.newFixedThreadPool(32);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 3072; ++i) {
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
	public void testPrimeNumberLoopWith4096TasksThreadPool() {
		
		primer = Executors.newFixedThreadPool(32);
		sleeper = Executors.newFixedThreadPool(32);
		printer = Executors.newFixedThreadPool(32);
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 4096; ++i) {
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
}