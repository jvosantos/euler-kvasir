package com.jvosantos.projecteuler.utils;

import java.util.Arrays;

public class PrimeFinder {
    private final boolean[] primes; 

    public PrimeFinder(int n) {
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
}
