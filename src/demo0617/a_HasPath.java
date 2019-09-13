package demo0617;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3*4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class a_HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        //标志位，初始化为false，false表示没有走过，true表示该位置已经走过
        boolean[]booleans=new boolean[matrix.length];
        if(matrix.length<=0||rows<0||cols<0||str.length<0){
            return false;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //找到字符串的一个字符在矩阵中的位置
                if(isHas(matrix,rows,cols,i,j,str,0,booleans)) {
                    return true;
                }
            }
        }
        //遍历完整个矩阵都没有找到相应的路径，那么返回false
        return false;
    }
    public static boolean isHas(char[] matrix, int rows, int cols, int curx, int cury, char[] str,int k,boolean[]booleans) {
        /**
         * k表示走过的长度
         * bool用来存储boolean值，false表示该位置还没走过，true表示该位置已经走过，不能再走
         */
        //根据当前行和当前列确定该元素在一维数组中的索引
        int index=curx*cols+cury;
        //确定终止条件。判断当前行和当前列是否处于矩阵中，判断当前位置是否已经走过
        //越界；当前找到的矩阵值不等于数组对应位置的值；已经走过
        if(curx<0||curx>=rows||cury<0||cury>=cols||matrix[index]!=str[k]||booleans[index]) {
            return false;
        }
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(k==str.length-1) {
            return true;
        }
        //要走的第一个位置置为true，表示已经走过了
        booleans[index]=true;
        //递归不断地寻找周围四个格子是否符合条件
        // 只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子
        // 直到k到达末尾或者不满足递归条件就停止。
        if(isHas(matrix,rows,cols,curx+1,cury,str,k+1,booleans)||
                isHas(matrix,rows,cols,curx-1,cury,str,k+1,booleans)||
                isHas(matrix,rows,cols,curx,cury+1,str,k+1,booleans)||
                isHas(matrix,rows,cols,curx,cury-1,str,k+1,booleans)) {
            return true;
        }
        //走到这一步，说明本次是不成功的
        // 我们要还原一下标志位数组index处的标志位，进入下一轮的判断
        booleans[index]=false;
        return false;
    }
}
