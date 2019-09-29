package com.dsa.algo;

//import java.util.Arrays;

import java.util.*;

public class Test1 {

    private final String[] ones = {"", "one"};
    public static void main(String args[]) {

        int max1 = Integer.MAX_VALUE;
        System.out.println(max1);


        Integer[] arr = new Integer[]{1,8,4,4,0,5};
        Integer maxResult = getMax(arr, 3);
       // Integer minResult = getMin(arr, 2);
       // String str = getArray(arr);
        //System.out.println(str.toCharArray());

    }
    public static String getArray(Integer[] arr)
    {
        Arrays.asList(arr);
        Map testMap = new HashMap();
        testMap.put(1,"2");

        Set abc = testMap.entrySet();

        System.out.println(" testMap.keySet() " + testMap.keySet());;
        System.out.println(abc);
        return Arrays.toString(arr);
    }

    private static int getMax(Integer[] input, int k)
    {
        List<Integer> list = Arrays.asList(input);
        Collections.sort(list);//, Collections.reverseOrder());
      //  Set<Integer> set = new TreeSet<Integer>(list);

       // list = new ArrayList<Integer>(set);
        int value = (list.size() - 1) - k;
        System.out.println("List: " + list.toString());
        System.out.println(k + "th Max Value : "+list.get(value));
        return list.get(value);
    }

    private static int getMin(Integer[] input, int k)
    {
        List<Integer> list = Arrays.asList(input);
        Collections.sort(list, Collections.reverseOrder());
        //  Set<Integer> set = new TreeSet<Integer>(list);

        // list = new ArrayList<Integer>(set);
        int value = (list.size() - 1) - k;
        System.out.println("Min List: " + list.toString());
        System.out.println(k + "th Min Value : "+list.get(value));
        return list.get(value);
    }
}


