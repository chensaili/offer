package dynamic;
import java.util.Scanner;
/**
 * https://www.cnblogs.com/Christal-R/p/Dynamic_programming.html
 * 动态规划的背包问题
 * 对于这个题目，解法不够完全符合题意，因为没有考虑到添加附件时，应该先添加附件对应的主件
 */
public class Demo3 {
    public static void main(String[] aStrings) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int total = scanner.nextInt(); // 总的钱数
            int num = scanner.nextInt(); // 希望购买物品的个数
            int[] price = new int[num + 1]; // 每个物品的价格
            int[] value = new int[num + 1]; // 每个物品的权重
            int[] check = new int[num + 1];// 是主件还是附件，0是主件，1是附件
            for (int i = 1; i <= num; i++) { // 读取输入数据
                price[i] = scanner.nextInt();
                value[i] = scanner.nextInt();
                check[i] = scanner.nextInt();
            }
            // 结果数组
            int[][] result = new int[num + 1][total + 1];// 行代表物品个数，列代表钱数
            for (int i = 1; i <= total; i++) {
                for (int j = 1; j <= num; j++) {
                    // 如果是附件
                    if (check[j] > 0) {
                        // 总的钱数比(当前物品+他的主件)所需要的钱多
                        if (i > price[j] + price[(check[j])]) {
                            //w代表的是加入附件后总的总值
                            int w = result[j - 1][i - price[j]] + value[j] * price[j];
                            //如果加入当前附件后的总值大于不加当前附件的总值，那么将其加入，否则不加
                            result[j][i] = w > result[j - 1][i] ? w : result[j - 1][i];
                        }
                    } else {
                        // 总钱数可以买主件
                        if (i >= price[j]) {
                            int w = result[j - 1][i - price[j]] + value[j] * price[j];
                            //如果加入当前主件后的总值大于不加当前主件的总值，那么将其加入，否则不加
                            result[j][i] = w > result[j - 1][i] ? w : result[j - 1][i];
                        }
                    }
                }
            }
            System.out.println(result[num][total]);
        }
        scanner.close();
    }
}
