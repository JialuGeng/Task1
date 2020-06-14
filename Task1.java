package com.codewithJialu.marlabs.task1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    /**
     Write a Java Program to reverse a string without using String inbuilt
     function reverse.
     */
    public static char[] reverse() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a String: ");
        String s = scanner.nextLine();


        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (left <= right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        return ch;
    }

    /**
     Write a Java Program to count the number of words in a string using
     HashMap.
     */
    public static void countWords(String words) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] strings = words.split(" ");

        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
        }

        System.out.println(map);
    }

    /**
     Write a Java Program to iterate HashMap using While and advance for loop.
     */
    public static void iterateHash() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Grace");
        map.put(2, "Jialu");
        map.put(3, "Siqi");
        map.put(4, "Toby");
        map.put(5, "Wen");
        map.put(6, "Chao-Ting");

//        int i = 1;
//        while (!map.isEmpty()) {
//            System.out.println(map.get(i));
//            map.remove(i);
//            i++;
//
//        }

//        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, String> pair = iterator.next();
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }

        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     Write a Java Program to find whether a string or number is palindrome
     or not. 125. Valid Palindrome
     */
    public static boolean palindrome(String s) {
        if (s == null || s.length() == 0) return true;

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    /**
     Write a Java Program to iterate ArrayList using for-loop, while-loop,
     and advance for-loop.
     */
    public static void iterateArray() {
        List<String> list = new ArrayList<>();
        list.add("Grace");
        list.add("Jialu");
        list.add("Siqi");
        list.add("Angular");
        list.add("React");
        list.add("Java");
        list.add("Python");

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

//        int i = 0;
//        while (i < list.size()) {
//            System.out.println(list.get(i));
//            i++;
//        }
    }

    /**
     Write a Java Program to find the duplicate characters in a string.
     */
    public static List<Character> duplicate(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {

            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    /**
     Write a Java Program to find the second highest number in an array.
     */
    public static int secondHigh() {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(10);
        list.add(20);
        list.add(400);
        list.add(80);
        list.add(200);

        Collections.sort(list);

        return list.get(list.size() - 2);
    }

    /**
     Write a Java Program to remove all white spaces from a string without
     using replace.
     */
    public static String removeWhiteSpace(String s) {
        if (s == null || s.length() == 0) return s;

        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != ' ') {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    /**
     How to find Missing Integers in Given Array of Numbers with
     Duplicates in JAVA.
     */
    public static void Missing() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 6, 8, 9};
        int[] find = new int[array.length + 1];

        for (int i: array) {
            find[i] = 1;
        }
        for (int i = 0; i < find.length; i++) {
            if (find[i] == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     Write a Java Program to Find the Most Repeated Word in Text File
     */

    public static String repeated() throws Exception{

        File file = new File("task.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println("This");
        printWriter.println("is");
        printWriter.println("first");
        printWriter.println("in");
        printWriter.println("Marlabs");
        printWriter.print("first");

        printWriter.close();

        BufferedReader reader = new BufferedReader(new FileReader("task.txt"));
        String line = null;

        HashMap<String, Integer> map = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            map.put(line, map.getOrDefault(line, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        String s = "";

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                s = entry.getKey();
            }

        }
        return s;
    }

    public static void main(String[] args) throws Exception{
        //System.out.println(reverse());
        //countWords("words happy word happy happy happy words words word words");
        //iterateHash();
        //System.out.println(palindrome("absasba"));
        //iterateArray();
        //System.out.println(duplicate("bfbssanvkjsqj"));
        //System.out.println(secondHigh());
        //System.out.println(removeWhiteSpace("hfds falkjf saf"));
        //Missing();
        System.out.println(repeated());
    }
}
