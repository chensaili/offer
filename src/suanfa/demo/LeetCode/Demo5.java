package suanfa.demo.LeetCode;

import java.util.Stack;

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 */
public class Demo5 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("aeed","aaed"));
    }
    public static boolean isLongPressedName(String name, String typed) {
        int j=0;
        for(char ch:name.toCharArray()){
            if(j==typed.length()){
                return false;
            }
            if(typed.charAt(j)!=ch){
                if(j==0||typed.charAt(j-1)!=typed.charAt(j)){
                    return false;
                }
                char cur=typed.charAt(j);
                while(j<typed.length()&&typed.charAt(j)==cur){
                    j++;
                }
                if(j==typed.length()||typed.charAt(j)!=ch){
                    return false;
                }
            }
            j++;
        }
        return true;
    }
}
