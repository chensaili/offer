package demo0223;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer buffer=new StringBuffer();
        buffer.append("we");
        buffer.append(" ");
        buffer.append("are");
        buffer.append(" ");
        buffer.append("happy");
        System.out.println(replaceSpace(buffer));
    }
    public static String replaceSpace(StringBuffer str){
        if(str==null){
            return null;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==' '){
                str.replace(i,i+1,"%20");
            }
        }
        //将StringBuffer类的str转换为String类型，toString()
        return str.toString();
    }
}
