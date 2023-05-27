	public interface Runnable {
	    public void run();
	}
	
	public class EventLoggingTask implements  Runnable{
	    private Logger logger
	      = LoggerFactory.getLogger(EventLoggingTask.class);
	
	    @Override
	    public void run() {
	        logger.info("Message");
	    }
	}
	
	public void executeTask() {
	    executorService = Executors.newSingleThreadExecutor();
	    Future future = executorService.submit(new EventLoggingTask());
	    executorService.shutdown();
	}
	
	public interface Callable<V> {
	    V call() throws Exception;
	}
	
	
	public class FactorialTask implements Callable<Integer> {
	    int number;
	
	    // standard constructors
	
	    public Integer call() throws InvalidParamaterException {
	        int fact = 1;
	        // ...
	        for(int count = number; count > 1; count--) {
	            fact = fact * count;
	        }
	
	        return fact;
	    }
	}
	
	@Test
	public void whenTaskSubmitted_ThenFutureResultObtained(){
	    FactorialTask task = new FactorialTask(5);
	    Future<Integer> future = executorService.submit(task);
	 
	    assertEquals(120, future.get().intValue());
	}
	
	// Exception Handling- Since the method signature does not have the “throws” clause specified, we don't have a way to propagate further checked exceptions.

	public class FactorialTask implements Callable<Integer> {
	    // ...
	    public Integer call() throws InvalidParamaterException {
	
	        if(number < 0) {
	            throw new InvalidParamaterException("Number should be positive");
	        }
	    // ...
	    }
	}
	
	@Test(expected = ExecutionException.class)
	public void whenException_ThenCallableThrowsIt() {
	 
	    FactorialCallableTask task = new FactorialCallableTask(-5);
	    Future<Integer> future = executorService.submit(task);
	    Integer result = future.get().intValue();
	}