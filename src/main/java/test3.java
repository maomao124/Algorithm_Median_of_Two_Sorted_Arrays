/**
 * Project name(项目名称)：算法_Median_of_Two_Sorted_Arrays
 * Package(包名): PACKAGE_NAME
 * Class(类名): test3
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/13
 * Time(创建时间)： 20:01
 * Version(版本): 1.0
 * Description(描述)： 解法四
 * 将 i 的左边和 j 的左边组合成「左半部分」，将 i 的右边和 j 的右边组合成「右半部分」。
 * 当 A 数组和 B 数组的总长度是偶数时，如果我们能够保证
 * * 左半部分的长度等于右半部分
 * i + j = m - i  + n - j  , 也就是 j = ( m + n ) / 2 - i
 * 左半部分最大的值小于等于右半部分最小的值 max ( A [ i - 1 ] , B [ j - 1 ]）） <=  min ( A [ i ] , B [ j ]））
 * 那么，中位数就可以表示如下
 * （左半部分最大值 + 右半部分最小值 ）/ 2 。
 * （max ( A [ i - 1 ] , B [  j  - 1 ]）+ min ( A [ i ] , B [ j ]）） /  2
 * 当 A 数组和 B 数组的总长度是奇数时，如果我们能够保证
 * 左半部分的长度比右半部分大 1
 * i + j = m - i  + n - j  + 1也就是 j = ( m + n + 1) / 2 - i
 * 左半部分最大的值小于等于右半部分最小的值 max (  A [ i - 1 ] , B [ j - 1 ]）） <=  min ( A [ i ] , B [ j ]））
 * 那么，中位数就是
 * 左半部分最大值，也就是左半部比右半部分多出的那一个数。
 * max ( A [ i - 1 ] , B [  j - 1 ]）
 */

public class test3
{
    public double findMedianSortedArrays(int[] A, int[] B)
    {
        int m = A.length;
        int n = B.length;
        if (m > n)
        {
            return findMedianSortedArrays(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax)
        {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j - 1] > A[i])
            { // i 需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && A[i - 1] > B[j])
            { // i 需要减小
                iMax = i - 1;
            }
            else
            { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0)
                {
                    maxLeft = B[j - 1];
                }
                else if (j == 0)
                {
                    maxLeft = A[i - 1];
                }
                else
                {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1)
                {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m)
                {
                    minRight = B[j];
                }
                else if (j == n)
                {
                    minRight = A[i];
                }
                else
                {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

    public static void main(String[] args)
    {
        test3 t = new test3();
        System.out.println("解法四");
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums2 = {5, 6, 7, 8, 9, 10, 11, 12};
        System.out.print("nums1");
        System.out.print(":");
        for (int i = 0; i < nums1.length - 1; i++)
        {
            System.out.print(nums1[i]);
            System.out.print(" ");
        }
        System.out.println(nums1[nums1.length - 1]);
        System.out.print("nums2");
        System.out.print(":");
        for (int i = 0; i < nums2.length - 1; i++)
        {
            System.out.print(nums2[i]);
            System.out.print(" ");
        }
        System.out.println(nums2[nums2.length - 1]);
        System.out.print("结果：");
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        System.out.println(t.findMedianSortedArrays(nums1, nums2));
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
