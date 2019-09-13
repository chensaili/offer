package suanfa.demo.LeetCode.Demo20190912;


import java.util.HashSet;
import java.util.Set;

//771
public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        char[]chs=J.toCharArray();
        char[]strs=S.toCharArray();
        Set<Character> set=new HashSet<>();
        for(char ch:chs){
            set.add(ch);
        }
        int sum=0;
        for(char str:strs){
            if(set.contains(str)){
                sum++;
            }
        }
        return sum;
    }
}
