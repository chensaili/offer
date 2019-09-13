package demo0526;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class a_VerifySquenceOfBST {
    public static void main(String[] args) {
        int[]array={2,1,3,6,5,7,4};
        System.out.println(verifySquenceOfBST(array));
    }
    public static boolean verifySquenceOfBST(int[]array){
        //数组长度为0
        if(array.length==0||array==null){
            return false;
        }
        return isPost(array,0,array.length-1);
    }
    public static boolean isPost(int[]array,int start ,int end){
        //数组只有一个元素
        if(start==end){
            return true;
        }
        //找到数组中比根节点小的那部分和比根节点大的那部分
        int less=-1;//表示比根节点小的那部分最后一个元素的位置
        int more=end;//比根节点大的那部分第一个元素的位置
        for(int i=start;i<end;i++){
            if(array[i]<array[end]){
                less=i;
            }else {
                //要找出比根节点大的那部分的第一个元素的位置
                more=more==end?i:more;
            }
        }
        //还要考虑只有左子树或者只有右子树的情况
        if(less==-1||more==end){
            return isPost(array,start,end-1);
        }
        //表示两个部分必须首尾相接
        if(less!=more-1){
            return false;
        }
        //比根节点大和小的两部分都要满足上面的规则，所以对两部分进行递归
        return isPost(array,start,less)&&isPost(array,more,end-1);
    }
}
