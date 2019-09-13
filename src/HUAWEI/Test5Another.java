package HUAWEI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Test5的题目不用TreeSet
public class Test5Another {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int cnt=in.nextInt();
            int[] beforeRanNum=new int[cnt];
            for (int i = 0; i < cnt; i++) {
                beforeRanNum[i]=in.nextInt();
            }
            List<Integer>ranList=new ArrayList<Integer>();
            for (int i = 0; i < cnt; i++) {
                ranList.add(beforeRanNum[i]);
            }
            int temp=0;
            for (int i = 0; i < ranList.size(); i++) {
                for (int j = i+1; j < ranList.size(); j++) {
                    if(ranList.get(i)==ranList.get(j)){//去重复
                        ranList.remove(j);
                        j--;//每移除一个size会减一，若出现相邻的相同的点，会出现漏点的情况，所以安全起见，要减一
                    }
                    else if(ranList.get(i)>ranList.get(j)){//排序
                        temp=ranList.get(i);
                        ranList.set(i, ranList.get(j));
                        ranList.set(j, temp);
                    }
                }
            }
            for(int i=0;i<ranList.size();i++){
                System.out.println(ranList.get(i));
            }
        }
        in.close();
    }
}