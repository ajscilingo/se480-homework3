/**
 * MyThreadPoolBatchProcessor
 * 
 * Similar to the Fixed Sized Thread Pool
 * This Thread Pool takes into account a
 * more "SEDA" like apporach
 * The number of threads available are lower
 * but the number of task that are processed at one time 
 * is more.
 * 
 * Number of Threads are based on Available Processors 
 * which can vary per machine
 * 
 * Sources:
 * 1) https://caffinc.github.io/2016/03/simple-threadpool/
 * 2) http://fasterjava.blogspot.com/2014/09/writing-non-blocking-executor.html 
 * 
 */


package net.scilingo.Threading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyThreadPoolBatchProcessor implements Executor {
	
	private final ConcurrentLinkedQueue<ConcurrentLinkedQueue<Runnable>> taskQueue;
	private final Thread[] threads;
	private volatile AtomicBoolean execute;
	private static final int threadPoolSize = Runtime.getRuntime().availableProcessors();
	private ConcurrentLinkedQueue<Runnable> runnables = new ConcurrentLinkedQueue<Runnable>();
	
	public MyThreadPoolBatchProcessor() {
		this.taskQueue = new ConcurrentLinkedQueue<ConcurrentLinkedQueue<Runnable>>();
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
		//batch in groups of 10
		if(runnables.size() <= 10)
			runnables.add(command);
		else {
			taskQueue.add(runnables);
			runnables.clear();
			runnables.add(command);
		}
		
	}
	
	private class WorkerThread extends Thread {
		
		WorkerThread(){
			super("MyFixedSizedThreadPool - WorkerThread");
		}
		
		@Override
		public void run() {
			
			try {
				while(execute.get() || !taskQueue.isEmpty()) {
					ConcurrentLinkedQueue<Runnable> runnables;
					
					while((runnables = taskQueue.poll()) != null) {
						Iterator<Runnable> itr = runnables.iterator();
						while(itr.hasNext()) {
							itr.next().run();
						}
					}
					Thread.sleep(1);
				}
			} catch (RuntimeException | InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}

}
