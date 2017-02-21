package com.bank.mathCounting;

import com.bank.mathCounting.MatchCounter;

import java.io.File;
import java.util.Scanner;

public class MatchCounterTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory:");
        String directory = in.nextLine();
        System.out.print("Enter keyword:");
        String keyword = in.nextLine();

        MatchCounter matchCounter = new MatchCounter(new File(directory), keyword);
        System.out.println(matchCounter.find() + " matching files.");
    }
}