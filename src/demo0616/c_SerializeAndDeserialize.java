package demo0616;

/**
 * 序列化和反序列化二叉树
 */
public class c_SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n2.right=n4;
        System.out.println(Serialize(root));
    }
    public static String Serialize(TreeNode root){
        StringBuilder str=new StringBuilder();
        //使用先序遍历完成序列化
        preOrder(root,str);
        return str.toString();
    }
    public static void preOrder(TreeNode root, StringBuilder str){
        //递归结束的边界条件
        if(root==null){
            //在序列化时，对于为null的结点也需要遍历并将其对应为”#!”
            str.append("#,");
            return;
        }
        //先遍历根结点
        str.append(root.val+",");
        //遍历左子树
        preOrder(root.left,str);
        //遍历右子树
        preOrder(root.right,str);
    }

    /**
     * 反序列化（不是很理解）
     * @param str
     * @return
     */
    public static TreeNode deserialize(String str) {
        if(str==null||str.length()<=0){
            return null;
        }
        //将字符串按照","拆分为数组
        String[]s=str.split(",");
        TreeNode root=deserialize2(s);
        return root;
    }
    //关键：设计一个成员变量index用于在每次递归调用时能够使用不同的字符串来建立根结点
    static int i=0;
    public static TreeNode deserialize2(String[] str) {
        if(str[i].equals("#")) {
            i++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(str[i]));
        i++;
        root.left=deserialize2(str);
        root.right=deserialize2(str);
        return root;
    }
}
