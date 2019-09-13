package HUAWEI;

import java.util.Scanner;

/**
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
 * 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
 * 答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，
 * 这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * 分析可以得出：当手上有两个空瓶子的时候可以喝到一个汽水，并且不剩于空瓶子
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//空瓶子
            int count=0;//喝到的次数
            if(n>0){
                while(n>1){
                    count+=n/3;
                    n=n/3+n%3;//空瓶子
                    if(n==2){
                        n++;//因为可以向老板借瓶子
                    }
                }
                System.out.println(count);
            }
        }
        sc.close();
    }
}
