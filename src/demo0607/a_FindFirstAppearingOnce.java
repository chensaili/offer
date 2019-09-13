package demo0607;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class a_FindFirstAppearingOnce {
    public static void main(String[] args) {

    }
    static char[]cn=new char[256];//数组存储每个字符出现的次数
    static StringBuffer sb=new StringBuffer();
    public static void insert(char ch){
        cn[ch]++;
        sb.append(ch+" ");
    }

    public static char findFirstAppearingOnce(){
        char[]t=sb.toString().toCharArray();
        for(int i=0;i<t.length;i++){
            if(cn[t[i]]==1){
                return t[i];
            }
        }
        return '#';
    }
}
