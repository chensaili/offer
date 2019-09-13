package HUAWEI;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test1{
    public static void main(String[] args) {
        int[]initscore={1,2,3,4,5};
        int count=1;
        while(count<=7){
            int num=5;
            Scanner sc1=new Scanner(System.in);
            String operation=sc1.next();
            if(operation.equals("Q")){
                Scanner sc2=new Scanner(System.in);
                String start=sc2.next();
                int start_int=Integer.parseInt(start);
                Scanner sc3=new Scanner(System.in);
                String end=sc3.next();
                int end_int=Integer.parseInt(end);
                if(start_int<end_int&&end_int<num){
                    int res=getHighestScore(num,initscore,start_int,end_int);
                    count++;
                    System.out.println(res);
                }
            }else if(operation.equals("C")){
                Scanner sc4=new Scanner(System.in);
                String index =sc4.next();
                int index_int=Integer.parseInt(index);

                Scanner sc5=new Scanner(System.in);
                String change =sc4.next();
                int change_int=Integer.parseInt(change);
                if(index_int<initscore.length){
                    updateScore(num,initscore,index_int,change_int);
                    count++;
                }
            }else if(operation.equals("end")){
                System.out.println("退出");
                break;
            }else {
                System.out.println("不是命令请求，请重新输入");
            }
        }
    }
    //查询最高分
    public static int getHighestScore(int num,int[]initscore,int start,int end){
        int result=0;
        //num学生数量，count操作数量，initscore初试分数
        for(int i=start;i<=end;i++){
            if(initscore[i-1]>result){
                result=initscore[i-1];
            }
        }
        return result;
    }
    //更新分数
    public static void updateScore(int num,int[]initscore,int index,int change) {
        initscore[index-1]=change;
        System.out.println(change);
        System.out.println("更新完成");
    }
}
