package suanfa.demo.hk;

public class Test2 {
    static int i= 0;
    public static int aMethod(){
        i++;
        return i;
    }
    public static void main (String args[ ]) {
        Test2 test = new Test2();
        Test2.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}
