package demo0603;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class a_NumberOf1Between1AndN {
    public static void main(String[] args) {
        System.out.println(countDigitOne(3142));
    }
    public static int countDigitOne(int n) {
        int ones = 0;
        for (int m = 1; m <= n; m *= 10) {
            //将数字按照10的整数倍分为高低位，高位为a，低位为b
            int a = n/m;
            int b = n%m;
            //当高位的最后一位等于1时，需要考虑特殊情况
            ones += (a + 8) / 10 * m + (a % 10 == 1?1:0) * (b + 1);
        }
        return ones;
    }
}
