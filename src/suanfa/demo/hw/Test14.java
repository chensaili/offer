package suanfa.demo.hw;

import java.util.Scanner;

public class Test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[]arr=new int[26];
            String str=sc.nextLine();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                int index=(int)(ch-'a');
                arr[index]++;
            }
            int min=Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=0&&arr[i]<min){
                    min=arr[i];
                }
            }
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                int n = (int)(c - 'a');
                if(arr[n] != min) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
