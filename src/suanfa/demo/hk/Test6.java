package suanfa.demo.hk;

import java.util.concurrent.Semaphore;

public class Test6 {
    public static void main(String[ ] args){
        Semaphore semaphore = new Semaphore(2);
        new Thread(()-> {
            try {
                if (semaphore.tryAcquire(3)) {
                    System.out.print(1);
                }
                else {
                    System.out.print(2);
                }
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }).start();
        new Thread(()-> {
            try {
                Thread.sleep(200);
                if (semaphore.tryAcquire()) {
                    System.out.print(3);
                } else {
                    System.out.print(4);
                }

            } catch (InterruptedException e) {

            }
        }).start();
    }
}