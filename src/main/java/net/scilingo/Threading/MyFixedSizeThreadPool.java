/**
 * MyFixedSizedThreadPool
 * 
 * A simple implementation of a fixed size thread pool
 * Based off of the thread pool designs discussed 
 * at the following places:
 * 
 * Sources:
 * 1) https://caffinc.github.io/2016/03/simple-threadpool/
 * 2) http://fasterjava.blogspot.com/2014/09/writing-non-blocking-executor.html 
 * 
 */


package net.scilingo.Threading;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyFixedSizeThreadPool implements Executor {

	private final ConcurrentLinkedQueue<Runnable> taskQueue;
	private final Thread[] threads;
	private volatile AtomicBoolean execute;
	
	
	public MyFixedSizeThreadPool(int threadPoolSize) {
		this.taskQueue = new ConcurrentLinkedQueue<Runnable>();
		this.threads = new Thread[threadPoolSize];
		this.execute = new AtomicBoolean();
		this.execute.set(true);
		for(int i = 0; i < threadPoolSize; i++) {
			threads[i] = new WorkerThread();
			threads[i].start();
		}
	}
	
	@Override
	public void execute(Runnable command) {
		taskQueue.add(command);
	}

	private class WorkerThread extends Thread {
			
		
		WorkerThread(){
			super("MyFixedSizedThreadPool - WorkerThread");
		}
		
		@Override
		public void run() {
			
			try {
				while(execute.get() || !taskQueue.isEmpty()) {
					Runnable runnable;
					
					while((runnable = taskQueue.poll()) != null) {
						runnable.run();
					}
					Thread.sleep(1);
				}
			} catch (RuntimeException | InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
}
