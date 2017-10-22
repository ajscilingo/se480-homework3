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

public class TestPrimeNumberCachedThreadPool {

	
	private static Executor scheduler;
	@Test
	public void testPrimeNumberLoopWith32TasksThreadPool() {
		
		scheduler = Executors.newCachedThreadPool();
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 32; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), scheduler)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, scheduler)
				.thenAcceptAsync( (Long result) -> System.out.println(result), scheduler));
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
		
		scheduler = Executors.newCachedThreadPool();
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 1000; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), scheduler)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, scheduler)
				.thenAcceptAsync( (Long result) -> System.out.println(result), scheduler));
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
		
		scheduler = Executors.newCachedThreadPool();
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 2048; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), scheduler)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, scheduler)
				.thenAcceptAsync( (Long result) -> System.out.println(result), scheduler));
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
		
		scheduler = Executors.newCachedThreadPool();
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 3072; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), scheduler)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, scheduler)
				.thenAcceptAsync( (Long result) -> System.out.println(result), scheduler));
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
		
		scheduler = Executors.newCachedThreadPool();
		
		List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();
		for(int i = 0; i < 4096; ++i) {
			final int n = i;
			futures.add(CompletableFuture.supplyAsync( () -> PrimeNumberTask.calculateNthPrimeNumber(n), scheduler)
				.thenApplyAsync( (Long result) -> {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					return result; }, scheduler)
				.thenAcceptAsync( (Long result) -> System.out.println(result), scheduler));
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