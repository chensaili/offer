package suanfa.demo20190725;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 将整数字符串转换为整数值
 * 如果str符合日常书写的整数形式，并且属于32位整数的范围，那就返回str对应的整数值，否则返回
 */
public class a_Convert {
    public static void main(String[] args) {

    }
    public static int convert(String str){
        if(str.equals("")||str==null){
            return 0;
        }
        char[]chars=str.toCharArray();
        if(!isValid(chars)){
            return 0;
        }
        boolean posi=chars[0]=='-'?false:true;//用来记录是正数还是负数
        //关键就是接下来如何判断的字符串代表的数字是否已经溢出，即超出32位
        //有两种情况会出现溢出，记当前字符所代表的负数形式为cur
        //1.如果res在加上cur之前，res已经小于minq，那么加上cur之后一定会溢出
        //2.如果res在加上cur之前，res等于minq，且发现cur小于minr，那么加上cur之后一定溢出
        int  minq=Integer.MIN_VALUE/10;
        int minr=Integer.MIN_VALUE%10;
        int res=0;
        int cur=0;
        //正数从索引0开始遍历，负数从索引1开始遍历
        for(int i=posi?0:1;i<chars.length;i++){
            cur='0'-chars[i];//cur表示当前字符的负数形式
            //两种溢出的情况
            if ((res < minq) ||(res==minq&&cur<minr)){
                return 0;
            }
            res=res*10+cur;
        }
        //-2147483648 2147483647
        if(posi&&res==Integer.MIN_VALUE){
            return 0;
        }
        return posi?-res:res;
    }
    //判断str是否符合日常的书写形式
    public static boolean isValid(char[] chars){
        //排除str以字母开头的情况
        if(chars[0]!='-'&&(chars[0]<'0'||chars[0]>'9')){
            return false;
        }
        //排除str的-或者-0情况
        if(chars[0]=='-'&&(chars.length==1||chars[1]=='0')){
            return false;
        }
        //排除str的类似012的情况
        if(chars[0]=='0'&&chars.length>1){
            return false;
        }
        //排除str中包含字母的情况
        for(int i=0;i<chars.length;i++){
            if(chars[i]<'0'||chars[i]>'9'){
                return false;
            }
        }
        return true;
    }
}
