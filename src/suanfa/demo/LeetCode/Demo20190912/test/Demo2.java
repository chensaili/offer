package suanfa.demo.LeetCode.Demo20190912.test;

public class Demo2  extends Thread{
    String name;
    Demo2(){
    }
    Demo2(String name){
        this.name=name;
    }
    public String getThreadName(){
        return name;
    }
    public void execute(){
        Demo2 d1=new Demo2("one");
        d1.start();
        Demo2 d2=new Demo2("two");
        d2.start();
    }
    public void start(){
        for(int i=0;i<10;i++){
            System.out.println(this.getThreadName()+i);
        }
        /*try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }*/
    }
    public static void main(String[] args) {
        Demo2 d=new Demo2("one");
        Demo2 d1=new Demo2("two");
        d.start();
        d1.start();
    }
}
