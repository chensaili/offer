package suanfa.demo3;
/**
 * 用数组结构实现大小固定的栈
 */
public class b_Array_To_Stack {
    public static void main(String[] args) {
        //设置栈的大小为4
        ArrayToStack array=new ArrayToStack(4);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
    }
    public static class ArrayToStack{
        private int[]arr;
        private int index;
        //构造方法
        public ArrayToStack(int initsize) {
            if(initsize<0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr=new int[initsize];
            index=0;
        }
        //从栈中取出数据
        public int pop(){
            if(index==0){
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--index];
        }
        //将数据放入栈
        public void push(int num){
            if(index==arr.length){
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[index++]=num;
        }
    }
}
