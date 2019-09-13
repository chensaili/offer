package demo0324;
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 * 二叉搜索树：左子树上的节点值都小于根节点，右子树上的值都大于根节点
 */
public class d_VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int[]array){
        if(array==null||array.length==0){
            return false;
        }
        return isPost(array,0,array.length-1);
    }
    public static boolean isPost(int[]array,int start,int end){
        if(start==end){
            return true;
        }
        //找到比根节点小的那部分和比根节点大的那部分
        //设置两个变量
        //关键点
        int less=-1;//表示比根节点小的那部分最后一个元素的位置
        int more=end;//比根节点大的那部分第一个元素的位置
        for(int i=start;i<end;i++){
            if(array[i]<array[end]){
                less=i;
            }else {
                //找到比根节点大的那部分的开始位置
                //关键点
                more=more==end?i:more;
            }
        }
        if(less==-1||more==end){
            //表示只有左子树或者只有右子树
            return isPost(array,start,end-1);
        }
        //表示两个部分必须首尾相接
        if(less!=more-1){
            return false;
        }
        return isPost(array,start,less)&&isPost(array,more,end-1);
    }
}
