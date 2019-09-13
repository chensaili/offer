package suanfa.demo.LeetCode;

import java.util.Scanner;
/*
给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
    'A' : Absent，缺勤
    'L' : Late，迟到
    'P' : Present，到场
如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
你需要根据这个学生的出勤记录判断他是否会被奖赏。
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int[]arr=new int[3];
            String input=sc.nextLine();
            for(int i=0;i<input.length();i++){
                if(input.charAt(i)==('A')){
                    arr[0]++;
                }
            }
            if(arr[0]>1||input.contains("LLL")){
                System.out.println("false");
            }else {
                System.out.println("true");
            }
        }
    }
}
