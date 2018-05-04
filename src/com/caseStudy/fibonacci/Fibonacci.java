package com.caseStudy.fibonacci;

public class Fibonacci {

    public static void main(String args[]){
        System.out.println("Fibo with dynamic programming:"+ fiboWithDynamicProgramming(6));
        System.out.println("Fibo with recurssion:"+ fiboWithRecurssion(6));

    }
    public static int fiboWithDynamicProgramming(int n){
        int f[]= new int[n+2];
        int i;
        f[0] = 0;
        f[1] = 1;
        for(i=2; i<= n; i++){
            f[i] = f[i-1]+ f[i-2];
        }
        return f[n];
    }
    public static int fiboWithRecurssion(int n){

        if(n<= 1){
            return n;
        }
        return fiboWithRecurssion(n-1) + fiboWithRecurssion(n-2);
    }
}
