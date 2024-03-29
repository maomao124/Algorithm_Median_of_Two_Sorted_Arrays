/**
 * Project name(项目名称)：算法_Median_of_Two_Sorted_Arrays
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/13
 * Time(创建时间)： 19:19
 * Version(版本): 1.0
 * Description(描述)：解法二
 * 首先是怎么将奇数和偶数的情况合并一下。
 * 用 len 表示合并后数组的长度，如果是奇数，我们需要知道第 （len + 1）/ 2 个数就可以了，如果遍历的话需要遍历 int ( len / 2 ) + 1 次。
 * 如果是偶数，我们需要知道第 len / 2 和 len / 2 + 1 个数，也是需要遍历 len / 2 + 1 次。所以遍历的话，奇数和偶数都是 len / 2 + 1 次。
 * 返回中位数的话，奇数需要最后一次遍历的结果就可以了，偶数需要最后一次和上一次遍历的结果。所以我们用两个变量 left 和 right ，
 * right 保存当前循环的结果，在每次循环前将 right 的值赋给 left 。这样在最后一次循环的时候，left 将得到 right 的值，
 * 也就是上一次循环的结果，接下来 right 更新为最后一次的结果。
 * 循环中该怎么写，什么时候 A 数组后移，什么时候 B 数组后移。用 aStart 和 bStart 分别表示当前指向 A 数组和 B 数组的位置。
 * 如果 aStart 还没有到最后并且此时 A 位置的数字小于 B 位置的数组，那么就可以后移了。也就是aStart  ＜  m  &&   A[aStart] < B[bStart]
 * 但如果 B 数组此刻已经没有数字了，继续取数字B [ bStart ]，则会越界，所以判断下 bStart 是否大于数组长度了，
 * 这样 || 后边的就不会执行了，也就不会导致错误了，所以增加为 aStart  ＜  m  && ( bStart >= n || A [ aStart ] < B [ bStart ] ) 。
 * 时间复杂度：遍历 len/2 + 1 次，len = m + n ，所以时间复杂度依旧是 O（m + n）。
 * 空间复杂度：我们申请了常数个变量，也就是 m，n，len，left，right，aStart，bStart 以及 i 。
 * 总共 8 个变量，所以空间复杂度是 O（1）。
 */

public class test1
{
    public double findMedianSortedArrays(int[] A, int[] B)
    {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++)
        {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart]))
            {
                right = A[aStart++];
            }
            else
            {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
        {
            return (left + right) / 2.0;
        }
        else
        {
            return right;
        }
    }

    public static void main(String[] args)
    {
        test1 t = new test1();
        System.out.println("解法二");
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
