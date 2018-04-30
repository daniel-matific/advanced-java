package mmn15.exercise1;

public class Main {

	public static void main(String[] args) {
        IntegerPool<Integer> integerPool = new IntegerPool<>(10, 2);
        final int FIRST = 0;
        System.out.println(integerPool.testSum());
        while(integerPool.size() > 1) {
        	integerPool.waitForThread();
            new Thread(new Sum(integerPool)).start();
        }
        integerPool.waitForAll();
        System.out.println("Sum is: " + integerPool.get(FIRST));
	}

}
