package com.boransolution;

import java.util.Scanner;

/***
 * test
 *
 * @author : xy
 *
 * @date : 2021/8/12
 **/
public class Test {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n  = sc.nextInt();
//        for(int i =0;i<n;i++){
//            String str = sc.nextLine();
//            String[] a = str.split("\\.");
//            int year = Integer.parseInt(a[0]);
//            if(year%4==0&&year%100!=0||year%400==0){
//                System.out.println("Case "+ i+ ": Yes");
//            }else{
//                System.out.println("Case "+ i +": No");
//            }
//        }
//
//    }
//
//    public static String calculate(String s) {
//        String res = null;
//        String[] t = s.split("\\.");
//        int temp = Integer.parseInt(t[0]);
//        if ((temp % 4 == 0 && temp % 100 != 0) || (temp % 400 == 0)) {
//            res = "YES";
//        } else {
//            res = "NO";
//        }
//        return res;
//    }
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            String[] temp = str.split("\\.");
            int year = Integer.parseInt(temp[0]);
            boolean isRun = helper(year);
            if (isRun == true) {
                System.out.println("Case " + i + ":Yes");
            } else {
                System.out.println("Case " + i + ":No");
            }
        }
    }

    public static boolean helper(int n) {
        return (n % 4 == 0 && n % 100 != 0) || n % 100 == 0;
    }
}