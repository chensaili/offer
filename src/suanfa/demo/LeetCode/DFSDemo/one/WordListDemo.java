package suanfa.demo.LeetCode.DFSDemo.one;


/**
 * 拉姆刚刚开始学习英文字母，并已经注意有趣的单词阵列。
 * 他想确定他是否能将最足单词排列在一个列表中，使得改列表中任何单词的首字母与其前面单词的尾字母相同。
 * 你能编写一个计算机程序来帮助拉姆吗？
 *
 * 类WordListOrder的方法canArrangesWords的输入应包含一个单词数组arr
 *
 * 如果列表中单词可按照要求的方式排列，返回1，否则，返回-1.在这种排列中，
 * 第一个单词的首字母和最后一个单词的尾字母可以为任意字母，不需要满足约束条件。
 */
//算法思路：对字符串数组进行全排列，得到一个排序时扫描字符数组检查是否符合条件
public class WordListDemo {
    public static void main(String[] args) {
        String[]strs=new String[]{"abc","cba","add"};
        canArrangesWords(strs,0,strs.length);
        System.out.println(flag);

    }
    public static boolean flag;
    public static void canArrangesWords(String[]strs, int start, int len){
        if(start==len-1){
            int i=1;
            for(i=1;i<len;i++){
                //如果前一个字符串的最后一个字母不等于后一个字符串的第一个字母
                if (strs[i - 1].charAt(strs[i - 1].length() - 1) != strs[i].charAt(0)) {
                    break;
                }
            }
            if(i==len){
                for(String str:strs){
                    System.out.println(str+" ");
                }
                System.out.println();
                flag=true;
            }
        }else {
            //进行全排列
            for(int i=start;i<len;i++){
                swap(strs,start,i);
                canArrangesWords(strs,start+1,len);
                swap(strs,start,i);
            }
        }
    }
    public static void swap(String[] arr,int i,int j){
        String temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
