import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyFixedSizeThreadPool implements Executor {

	private ConcurrentLinkedQueue<Runnable> runnables;
	
	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub

	}

	private class MyFixedSizedThreadPoolThread extends Thread {
		
		private AtomicBoolean execute;
		private ConcurrentLinkedQueue<Runnable> runnables;
		
		public MyFixedSizedThreadPoolThread(String name, 
				AtomicBoolean execute, ConcurrentLinkedQueue<Runnable> runnables) {
			super(name);
			this.execute = execute;
			this.runnables = runnables;
		}
		
		@Override
		public void run() {
			
			try {
				while(execute.get() || !runnables.isEmpty()) {
					Runnable runnable;
					
					while((runnable = runnables.poll()) != null) {
						runnable.run();
					}
					Thread.sleep(1);
				}
			} catch (RuntimeException | InterruptedException e) {
				
			}
		}
		
		
		
	}
}
