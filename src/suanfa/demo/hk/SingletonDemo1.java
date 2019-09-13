package suanfa.demo.hk;
//饿汉
public class SingletonDemo1 {
    private static SingletonDemo1 instance=new SingletonDemo1();
    private SingletonDemo1(){

    }
    public static SingletonDemo1 getInstance(){
        return instance;
    }
}
