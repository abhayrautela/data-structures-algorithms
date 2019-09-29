package com.dsa.algo;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2,2};
        Set listSet = new HashSet<>(Arrays.asList(test));
        List newlist = new ArrayList<>(listSet);
        System.out.println(newlist.size());
    }

    public static void main1(String args[]) {
        int[] test = new int[]{1, 2,2};
        //    test[0]=15;
        //   test[1]=10;

        int[] test12;
        //test12 = new test12[5];
        String[] a = new String[3];
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        //char[] newArray = new char[];
        String temp = "HelloWorld";
        char[] arr = new char[]{'H', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};
        char[] newArray = temp.toCharArray();

        Set abc = new HashSet();
        List list = new ArrayList();
        //   ArrayUtils.

        Scanner sc = new Scanner(System.in);
        System.out.println("Username ?? : ");
        System.out.println("Username ?? : " + sc.nextLine());

        //Collections.sort(Arrays.asList(test), Collections.reverseOrder());
        //System.out.println("List  : " + Integer ((Arrays.asList(test)).get(0)));
        Set<Integer> listSet = new HashSet(Arrays.asList(test));

        List newlist = new ArrayList(listSet);
        System.out.println("newList  : " + newlist.toArray().toString());
        System.out.println("Array Sorted  : " + Arrays.toString(test));

        for (int j=0;j<newlist.size();j++)
        {
            System.out.println("newList  : " + newlist.get(j).toString());
        }
        for (char i : newArray) {
            if (abc.contains(i)) {
                //System.out.println("Duplicate  : " +);
            } else {
                abc.add(i);
            }
            if (charCountMap.containsKey(i)) {
                charCountMap.put(i, charCountMap.get(i) + 1);
            } else {
                charCountMap.put(i, 1);
            }

        }

        Set<Character> charArray = charCountMap.keySet();
        for (char c : charArray) {
            if (charCountMap.get(c) > 1) {
                System.out.println("Duplicate character  : " + c + " + no of times : " + charCountMap.get(c));
            } else {
                System.out.println("character  : " + c + " + no of times : " + charCountMap.get(c));
            }
        }




/*        String reverse="";
        for (int i=arr.length-1;i>=0;i--) {
            reverse = reverse + arr[i];
            System.out.println("String reversed " + "I : " + reverse);
        }
        System.out.println("String reversed " + reverse);
        System.out.println("Before sorting " + Arrays.toString(test));
        //Arrays.sort(test, 0, test.length,Collections.reverseOrder());
        System.out.println("After sorting " + Arrays.toString(test));
        System.out.println("Search Result " + Arrays.binarySearch(test, 15));
    }
*/
    }
}
