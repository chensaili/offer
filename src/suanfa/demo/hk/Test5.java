package suanfa.demo.hk;

public class Test5 {
    public void cal(int a, int b) {
        System.out.print(1);
    }
    public void cal(int a, int b, int c) {
        System.out.print(2);
    }
    public void cal(int a, int... b) {
        System.out.print(3);
    }
    public static void main(String args[ ]) {
        Test5 t = new Test5();
        t.cal(1);
        t.cal(1, 1);
        t.cal(1, 1, 1);
        t.cal(1,1,1,1);//调用的是第三个cal方法
    }
}
