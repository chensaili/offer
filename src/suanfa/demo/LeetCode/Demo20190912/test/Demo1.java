package suanfa.demo.LeetCode.Demo20190912.test;

public class Demo1 {
    private int x,y,z;
    public void d(){
        x=1;
        y=2;
        z=y-x;
    }
    public void display(){
        System.out.println("z="+z);
    }

    public static void main(String[] args) {
        Demo1 d=new Demo1();
        d.display();
    }
}
