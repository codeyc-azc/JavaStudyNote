package yc.al.zuo.base;

import java.util.Arrays;
import java.util.Random;

/**
 * 基础班————快速排序
 * @author code_yc
 * @version 1.0
 * @date 2020/4/23 10:21
 */
public class Class1_Code5_QuickSort {

    // 快速排序
    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        process(arr,0,arr.length - 1);
    }

    // 排序l到r处的元素
    private static void process(int[] arr, int l, int r) {
        if(l >= r) return;
        // 从数组中随机取一个值
        int mid = arr[l + (int)Math.random() * (r - l + 1)];
        // 快排找到左右边界
        int[] p = partion(arr,l,r,mid);
        // 继续对子数组进行排序
        process(arr, l, p[0]);
        process(arr,p[1],r);
    }

    private static int[] partion(int[] arr, int l, int r, int mid) {
        int less = l - 1;
        int more = r + 1;
        while(l < more){
            if(arr[l] < mid){
                swap(arr,l++,++less);
            }else if(arr[l] > mid){
                swap(arr,l,--more);
            }else{
                l++;
            }
        }
        return new int[]{less, more};
    }

    // 交换两个元素的位置
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ++++++++++++++++++++++++++++++++++++++++
    //                对数器
    // ++++++++++++++++++++++++++++++++++++++++
    // 官方排序方法
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // 获取随机测试数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // 复制一个数组
    public static int[] copyArray(int[] arr){
        if(arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 测试两个数组是否相等
    public static boolean isEquals(int[] arr1, int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) return false;
        if(arr1 == null && arr2 == null) return true;
        if(arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //测试打印数组
    public static void printArray(int[] arr) {
        if(arr == null) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    //测试主方法
    public static void main(String[] args) {
        int testTime = 500000;  //测试次数
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize,maxValue);  //生成随机数组
            int[] arr1 = copyArray(arr);   //复制数组
            quickSort(arr);
            comparator(arr1);
            if(!isEquals(arr,arr1)){
                System.out.println("手撸：" + arr);
                System.out.println("标准：" + arr1);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking Fucked");
    }

}
