package suanfa.demo.hw;
import java.util.*;
public class Test12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String input=sc.next();
            int[]category={0,0,0,0};//表示大写字母，小写字母，数字，其他符号
            if(input.length()<9||input==null){
                System.out.println("NG");
            }else {
                for(int i=0;i<input.length();i++){
                    char ch=input.charAt(i);
                    if(ch>='A'&&ch<='Z'){
                        category[0]=1;
                    }else if(ch>='a'&&ch<='z'){
                        category[1]=1;
                    }else if(ch>='0'&&ch<='9'){
                        category[2]=1;
                    }else {
                        category[3]=1;
                    }
                }
                if(category[0]+category[1]+category[2]+category[3]<3){
                    System.out.println("NG");
                }else {
                    //如果满足长度大于8，满足有三种及以上的字符种类，那么再判断是否有重复的地方
                    System.out.println(isRepetition(input));
                }
            }
        }
    }
    public static String isRepetition(String input){
        for(int i=0;i<input.length()-3;i++){
            String str1=input.substring(i,i+3);
            String str2=input.substring(i+3);
            if(str2.contains(str1)){
                return "NG";
            }
        }
        return "OK";
    }
}