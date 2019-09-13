package suanfa.demo.LeetCode.DFSDemo.two;

public class Demo10 {
    public static void main(String[] args) {
        char[][]matrix={{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        char[]str={'b','c' ,'c','e','d'};
        System.out.println(hasPath(matrix,str));
    }
    public static boolean hasPath(char[][]matrix,char[]str){
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean[][]booleans=new boolean[rows][cols];
        if(str.length<0){
            return false;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                if(isHas(matrix,rows,cols,i,j,str,0,booleans)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isHas(char[][]matrix,int rows,int cols,int curR,int curC,
                                char[]str,int step,boolean[][]booleans){
        if(curC<0||curR>=rows||curR<0||curC>=cols||matrix[curR][curC]!=str[step]||booleans[curR][curC]) {
            return false;
        }
        if(step==str.length-1){
            return true;
        }
        booleans[curR][curC]=true;

        if(isHas(matrix,rows,cols,curR+1,curC,str,step+1,booleans)||
                isHas(matrix,rows,cols,curR-1,curC,str,step+1,booleans)||
                isHas(matrix,rows,cols,curR,curC+1,str,step+1,booleans)||
                isHas(matrix,rows,cols,curR,curC-1,str,step+1,booleans)) {
            return true;
        }
        booleans[curR][curC]=false;
        return false;
    }
}
