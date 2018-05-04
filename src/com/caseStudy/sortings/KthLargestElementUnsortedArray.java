package com.caseStudy.sortings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargestElementUnsortedArray {

    public static void main(String args[]){

        Integer a[] = {4,6,2,12,8,7,9};
        List<Integer> list = Arrays.asList(a);
        int k=3;

        System.out.print("Kth Smallest element:");
        System.out.println(list.stream().sorted().distinct().limit(k).skip(k-1).collect(Collectors.toList()));

        System.out.print("Kth Largest element:");
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).distinct().limit(k).skip(k-1).collect(Collectors.toList()));

    }
}
