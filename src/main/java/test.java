/**
 * Project name(项目名称)：算法_Median_of_Two_Sorted_Arrays
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/13
 * Time(创建时间)： 14:33
 * Version(版本): 1.0
 * Description(描述)： 已知两个有序数组，找到两个数组合并后的中位数。
 * 解法一
 * 先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
 * 时间复杂度：遍历全部数组，O（m + n）
 * 空间复杂度：开辟了一个数组，保存合并后的两个数组，O（m + n）
 */

public class test
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0)
        {
            if (n % 2 == 0)
            {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            }
            else
            {

                return nums2[n / 2];
            }
        }
        if (n == 0)
        {
            if (m % 2 == 0)
            {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            }
            else
            {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n))
        {
            if (i == m)
            {
                while (j != n)
                {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n)
            {
                while (i != m)
                {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j])
            {
                nums[count++] = nums1[i++];
            }
            else
            {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0)
        {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        }
        else
        {
            return nums[count / 2];
        }
    }

    public static void main(String[] args)
    {
        test t = new test();
        System.out.println("已知两个有序数组，找到两个数组合并后的中位数");
        System.out.println("解法一\n" +
                "先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数");

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
