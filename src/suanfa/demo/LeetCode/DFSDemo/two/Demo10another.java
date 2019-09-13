package suanfa.demo.LeetCode.DFSDemo.two;
//回溯算法
// 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
//例如:a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
// 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
public class Demo10another {
    public static void main(String[] args) {
        char[]matrix={'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[]str={'b','c' ,'c','e','d'};
        System.out.println(hasPath(matrix,3,4,str));
    }
    public static boolean hasPath(char[]matrix,int rows,int cols,char[]str){
        boolean[]booleans=new boolean[matrix.length];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isHas(matrix,rows,cols,i,j,str,0,booleans)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isHas(char[]matrix,int rows,int cols,int curR,int curC,
                                char[]str,int k,boolean[]booleans){
        int index=curR*cols+curC;
        if(curC<0||curR>=rows||curR<0||curC>=cols||matrix[index]!=str[k]||booleans[index]==true) {
            return false;
        }
        if(k==str.length-1){
            return true;
        }
        booleans[index]=true;
        if(isHas(matrix,rows,cols,curR+1,curC,str,k+1,booleans)||
                isHas(matrix,rows,cols,curR-1,curC,str,k+1,booleans)||
                isHas(matrix,rows,cols,curR,curC+1,str,k+1,booleans)||
                isHas(matrix,rows,cols,curR,curC-1,str,k+1,booleans)) {
            return true;
        }
        // 我们要还原一下标志位数组index处的标志位，进入下一轮的判断
        booleans[index]=false;
        return false;
    }
}
