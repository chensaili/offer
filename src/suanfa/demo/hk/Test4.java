package suanfa.demo.hk;

public class Test4 {
    static int x = 1;
    static int test(){
        try {
            return x++;
        } finally {
            ++x;
        }
    }
    public static void main(String[ ] args){
        Test4.test();//2
        System.out.println(Test4.x);//3
    }
}
