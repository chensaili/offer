package demo0516fuxi;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class b_ReplaceSpace {
    public static void main(String[] args) {
        String input="We Are Happy";
        System.out.println(replace(input));
    }
    public static String replace(String input){
        String[] inputStr=input.split(" ");
        StringBuilder output=new StringBuilder();
        for(int i=0;i<inputStr.length-1;i++){
            output.append(inputStr[i]+"%20");
        }
        output.append(inputStr[inputStr.length-1]);
        return output.toString();
    }
}
