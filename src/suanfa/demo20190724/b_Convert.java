package suanfa.demo20190724;

/**
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 */
public class b_Convert {
    public static void main(String[] args) {

    }
    public static String convert(int m,int n){
        if(m<0){
            m=-m;
        }
        if(m==0){
            return "0";
        }
        //关键点1
        String str="0123456789ABCDEF";
        String s="";
        char[]table=str.toCharArray();
        while(m>0){
            //关键点2
            s=table[m%n]+s;
            m=m/n;
        }
        return s;
    }
}
