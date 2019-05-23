package com.company;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Task {
    Scanner scan = new Scanner(System.in);
    int arrayLength, sumOfElements, position = 0, zeroCounter = 0;
    int[] intArray, firstAnsNum, secondAnsNum;
    Set <Integer> set = new TreeSet<>();
    Set <Integer> check = new TreeSet<>();
    public void read(){
        String[] strArray = scan.nextLine().split(" ");
        arrayLength = strArray.length;
        intArray = new int[arrayLength];
        firstAnsNum = new int[arrayLength];
        secondAnsNum = new int[arrayLength];
        for(int i=0; i<arrayLength; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
            if (intArray[i] == 0) zeroCounter++;
        }
        sumOfElements = scan.nextInt();
    }
    public void operation(){
        for (int i=0; i<arrayLength; i++){
            if (set.contains(sumOfElements-intArray[i]) && (intArray[i] == sumOfElements-intArray[i])){
                firstAnsNum[position] = secondAnsNum[position] = intArray[i];
                position++;
                set.remove(intArray[i]);
                continue;
            }
            set.add(intArray[i]);
            if (set.contains(sumOfElements-intArray[i]) && (intArray[i] != sumOfElements-intArray[i])){
                set.remove(intArray[i]);
                set.remove(sumOfElements-intArray[i]);
                firstAnsNum[position] = intArray[i];
                secondAnsNum[position] = sumOfElements-intArray[i];
                position++;
            }
        }
    }
    public void output(){
        try {
            for (int i=0; i<arrayLength; i++){
                if (firstAnsNum[i] == 0 && secondAnsNum[i] == 0 && sumOfElements == 0 && (zeroCounter < 2) && !check.contains(0)){
                    check.add(0);
                    continue;
                }
                if (!check.contains(firstAnsNum[i]) && !check.contains(secondAnsNum[i]) && (firstAnsNum[i] + secondAnsNum[i] == sumOfElements)){
                    System.out.println(firstAnsNum[i] + " " + secondAnsNum[i]);
                    check.add(firstAnsNum[i]);
                    check.add(secondAnsNum[i]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
    public void initialize(){
        read();
        operation();
        output();
    }
}
