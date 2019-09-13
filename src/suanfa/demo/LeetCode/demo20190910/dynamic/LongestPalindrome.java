package suanfa.demo.LeetCode.demo20190910.dynamic;
//5。给定一个字符串 s，找到 s 中最长的回文子串。
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("caba"));
    }
    //中心扩展法
    public static String longestPalindrome(String s) {
        if(s==null||s.length()<1){
            return null;
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int len1=isPalindrome(s,i,i);
            int len2=isPalindrome(s,i,i+1);
            int len=Math.max(len1,len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    //获取回文的长度
    public static int isPalindrome(String s,int left,int right){
        while(left>=0&&right<s.length()
                &&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
