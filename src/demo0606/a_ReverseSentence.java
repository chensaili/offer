package demo0606;


/**
 * 翻转单词顺序列，例如，“I am a student.”翻转后是“student. a am I”
 */
public class a_ReverseSentence {
    public static void main(String[] args) {

    }
    public static String reverseSentence(String str){
        if(str==null||str.length()==0){
            return str;
        }
        char[]chars=str.toCharArray();
        //反转整个字符串
        char[]strChar=reverseChar(chars,0,chars.length-1);
        int start=0;
        int end=0;
        int i=0;
        while(i<str.length()){
            while(i<str.length()&&strChar[i]==' '){
                i++;
            }
            //记录单词第一个字符的位置
            end=start=i;
            //如果遇到空格就跳过
            while (i<str.length()&&strChar[i]!=' '){
                i++;
                end++;
            }
            //翻转部分字符串
            reverseChar(chars,start,end-1);
        }
        return new String(strChar);
    }
    public static char[] reverseChar(char[]chars,int start,int end){
        if(chars.length==0){
            return chars;
        }
        while(start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
        return chars;
    }
}
