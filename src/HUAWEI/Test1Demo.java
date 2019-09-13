package HUAWEI;

import java.util.Scanner;

public class Test1Demo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//学生的数目
            int m=sc.nextInt();//操作的数目
            sc.nextLine();
            int[]arr=new int[n];//创建一个数组用来存放成绩
            //往数组里面添加成绩
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();//输入成绩
            }
            sc.nextLine();
            for(int i=0;i<m;i++){
                String[]line=sc.nextLine().split(" ");
                int a=Integer.parseInt(line[1])-1;
                int b=Integer.parseInt(line[2])-1;
                switch (line[0]){
                    case "Q":
                        int max=0;
                        for(int j=Math.min(a,b);j<=Math.max(a,b);j++){
                            max=Math.max(max,arr[j]);
                        }
                        System.out.println(max);
                        break;
                    case "U":
                        arr[a]=b+1;
                        break;
                }
            }
        }
        sc.close();
    }
}
