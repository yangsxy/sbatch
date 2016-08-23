package cn.yuan.thread;

public class ThreadTest {
	public static void main(String[] args) {
		ExecutorHelper.excution(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
