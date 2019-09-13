package suanfa.demo.hk;

public class Test3 {
    public static void main(String[] args) {
        String str1="hello";
        String str2="hel"+new String("lo");
        System.out.println(str1==str2);//false

        String str3="hel";
        String str4="lo";
        String str5=str3+"lo";
        String str6=str3+str4;
        System.out.println(str1==("hel"+"lo"));//true
        System.out.println(str1==str5);//false
        System.out.println(str1==str6);//false

        String str7=new String("hello");
        System.out.println(str1==str7);//false
        System.out.println(str2==str7);//false
        //System.err.println(str1==str2);
    }
}
