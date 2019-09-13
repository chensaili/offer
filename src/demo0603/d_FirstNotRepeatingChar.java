package demo0603;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class d_FirstNotRepeatingChar {
    public static void main(String[] args) {
        System.out.println(getNotRepeatingChar("aabbd12d1"));
    }
    public static int getNotRepeatingChar(String str){
        HashMap<Character,Integer>map=new HashMap<>();
        char[]chs=str.toCharArray();
        for(char ch:chs){
            if(map.get(ch)==null){
                map.put(ch,1);
            }else {
                map.put(ch,map.get(ch)+1);
            }
        }
        //遍历集合，找出值为1的键
        for(int i=0;i<chs.length;i++){
            if(map.get(chs[i])==1){
                return i;
            }
        }
        return -1;
    }
}
