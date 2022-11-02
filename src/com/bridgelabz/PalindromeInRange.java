package com.bridgelabz;

import java.util.Scanner;

public class PalindromeInRange {
    static boolean checkPrime(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                count = 1;
                break;
            }
        }
        return count == 0 ? true : false;
    }

    static boolean checkPalindrome(int num) {
        int temp = num;
        int reverse_number = 0;
        while (num != 0) {
            int rem = num % 10;
            reverse_number = reverse_number * 10 + rem;
            num /= 10;
        }
        if (temp == reverse_number) {
            return true;
        } else {
            return false;
        }
    }

    static void primeAndPalinromeInRange(int startValue, int endValue) {
        int count = 0;
        for (int i = startValue; i <= endValue; i++) {
            if (i == 1 || i == 0) {
                System.out.println(i + " is neither prime nor non-prime number. ");
            } else {
                if (checkPalindrome(i) && checkPrime(i)) {
                    System.out.println(i);
                    count++;
                }
            }
        }
        System.out.println("Both palindrome and prime numbers in range (" + startValue + "," + endValue + ") are total : " + count);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Number 1 : ");
        int num1 = s.nextInt();
        System.out.print("Number 2 : ");
        int num2 = s.nextInt();
        primeAndPalinromeInRange(num1, num2);


    }
}
