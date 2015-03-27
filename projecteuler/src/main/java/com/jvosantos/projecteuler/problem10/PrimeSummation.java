/*
 * Summation of primes
 * Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */
 

package com.jvosantos.projecteuler.problem10;

import java.util.Arrays;

public class PrimeSummation {
    private final boolean[] primes; 

    public PrimeSummation(int n) {
        primes = new boolean[n];
        initPrimeTable();
    }

    public boolean isPrime(int n) {
        return primes[n];
    }
    
    private void initPrimeTable() {
        Arrays.fill(primes,true);        // assume all numbers are prime.
        primes[0]=primes[1]=false;       // 0 and 1 are not prime.
        for (int i=2;i<primes.length;i++) {
            //if the number is prime, go through all its multiples mark as not prime false.
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int threshold = 2_000_000;
        PrimeSummation primes = new PrimeSummation(threshold);
        
        long sum = 0;
        for(int i = 0; i < threshold; i++) {
            if(primes.isPrime(i)) {
                sum += i;
            }
        }
        System.out.println("Sum of primes below " + threshold + ": " + sum);
    }
}