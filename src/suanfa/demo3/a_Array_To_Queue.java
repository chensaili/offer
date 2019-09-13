package suanfa.demo3;

/**
 * 用数组结构实现大小固定的队列
 */
public class a_Array_To_Queue {
    public static void main(String[] args) {
        ArrayToQueue array=new ArrayToQueue(4);
        array.push(1);
        array.push(4);
        array.push(3);
        array.push(4);
        System.out.println(array.poll());
        System.out.println(array.poll());
        array.push(2);
        System.out.println(array.poll());
        System.out.println(array.poll());
        System.out.println(array.poll());
    }
    public static class ArrayToQueue{
        private Integer[]arr;
        private int size;
        private int first;//用来表示取出的数的索引
        private int last;//用来表示放入的数的索引
        //构造方法
        public ArrayToQueue(int initsize){
            if(initsize<0) {
                throw new IllegalArgumentException("the size is Illegal");
            }
            arr=new Integer[initsize];
            size = 0;
            first = 0;
            last = 0;
        }
        //从数组的最前面取出数据
        public int poll(){
            if(size==0){
                //如果数组里面没有元素，那么抛出异常
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            size--;
            int temp=first;
            int res=arr[temp];
            first=first==arr.length-1?0:first+1;
            return res;
        }
        //把数据放入数组的最后面
        public void push(int num){
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last]=num;
            //判断当前的last值是不是等于数组的长度减一
            //如果是，那么就把last设为0；否则为数组的下一个值
            last=last==arr.length-1?0:last+1;
        }
    }
}
