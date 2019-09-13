package HUAWEI;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[]left,right;//代表两手牌
        String[]line;
        String nextLine;//表示输入的牌
        String outString;//表示最大的那手牌
        while(sc.hasNext()){
            nextLine=sc.nextLine();
            //输入的手牌中，有对王就是对王最大
            if(nextLine.contains("joker JOKER")){
                outString="joker JOKER";
            }else {
                //拆分，先拆分成左右，再拆分成单排
                line=nextLine.split("-");
                left=line[0].split(" ");
                right=line[1].split(" ");
                //length为4表示为炸弹
                if(left.length==4&&right.length!=4){
                    outString=line[0];//左边的手牌大
                }else if(right.length==4&&left.length!=4){
                    outString=line[1];//右边的手牌大
                }else if(right.length==left.length){
                    //牌数相同的情况下，比较最小的牌的大小
                    if(count(left[0])>count(right[0])){
                        outString=line[0];
                    }else {
                        outString=line[1];
                    }
                }else {
                    outString="ERROR";
                }
            }
            System.out.println(outString);
        }
    }
    private static int count(String str) {
        return "345678910JQKA2".indexOf(str);
    }
}
