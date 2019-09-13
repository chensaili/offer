package suanfa.demo.hk;

public class Test1 {
    public int add(int a,int b){
        try {
            return a+b;
        }catch (Exception e){
            System.out.println("catch语句块");
        }finally {
            System.out.println("finall语句块");
        }
        return 0;
    }

    public static void main(String[] args) {
        Test1 test1=new Test1();

        System.out.println("和是："+test1.add(9,34));
    }
}
