package cn.yuan.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorHelper {

	public static ExecutorHelper instance =new ExecutorHelper();
	private  ExecutorService executorService;
	
	
	private ExecutorHelper(){
		this.executorService = Executors.newScheduledThreadPool(5);
	}
	
	public static void excution(Runnable command){
		instance.executorService.submit(command);
	}
}
