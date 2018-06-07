package mmn15.exercise1;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("serial")
public class IntegerPool<I> extends LinkedList<Integer> {
	
	private int maxThreads, activeThreads;
    private Lock lock;
    private Condition condition;
	private static final int MAX_NUMBER = 100;
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public IntegerPool(int n, int m) {
        maxThreads = m;
        activeThreads = 0;
        lock = new ReentrantLock();
        condition = lock.newCondition();
		for(; n > 0; n--) {
			add(randomNumbers.nextInt(MAX_NUMBER + 1));
		}
	}
	
    public void waitForThread()
    {
        lock.lock();
        while(activeThreads == maxThreads)
            try{
                condition.await();
            }
            catch(InterruptedException e){}
        activeThreads++;
        lock.unlock();
    }
    
    public void finished()
    {
    	lock.lock();
        activeThreads--;
        condition.signalAll();
        lock.unlock();
    }
	
    public void waitForAll()
    {
    	lock.lock();
        while(activeThreads > 0) {
            try {
            	condition.await();
            }
            catch(InterruptedException e){}
        }
        lock.unlock();
    }
    
    public int testSum() {
    	int count = 0;
    	for(int i = 0; i < size(); i++) {
    		count += get(i);
    	}
    	return count;
    }

}
