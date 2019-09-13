package suanfa.demo1;

/**
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 */
public class b_Convert {
    public static void main(String[] args) {
        int m=100;
        int n=8;
        System.out.println(convert(m,n));
    }
    public static String convert(int m,int n){
        String s="";
        String str="0123456789ABCDEF";
        char[]table=str.toCharArray();
        if(m<0) {
            m=-m;
        }
        if(m==0) {
            return "0";
        }
        while(m>0) {
            s=table[m%n]+s;
            m=m/n;
        }
        return s;
    }
}
