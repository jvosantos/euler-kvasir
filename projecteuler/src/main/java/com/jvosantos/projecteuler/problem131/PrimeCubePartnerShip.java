/*
 * Prime cube partnership
 * Problem 131
 * 
 * There are some prime values, p, for which there exists a positive integer, n,
 * such that the expression n3 + n2p is a perfect cube.
 * For example, when p = 19, 83 + 82×19 = 123.
 * 
 * What is perhaps most surprising is that for each prime with this property the
 * value of n is unique, and there are only four such primes below one-hundred.
 * 
 * How many primes below one million have this remarkable property?
 */
package com.jvosantos.projecteuler.problem131;

import com.jvosantos.projecteuler.utils.PrimeFinder;

public class PrimeCubePartnerShip {
    private static final int problemConstant = 1_000_000;
//    private static final int problemConstant = 100;
    
    public static void main(String[] args) {
        PrimeFinder primeFinder = new PrimeFinder(problemConstant);
        
        int sum = 0;
        for(int i = 0; i < problemConstant; i++) 
            if(primeFinder.isPrime(i))
                sum+=1;
        
        System.out.println("sum = " + sum);
        
        if(true)
            return;
        // For every prime below one million
        mainloop:
        for(int i = 0; i < problemConstant; i++) {
            // if the number is prime
            if(primeFinder.isPrime(i)) {
                // for every natural number below the prime
                for(int j = 1; j <= problemConstant; j++) {
                    double result = Math.cbrt(Math.pow(j, 3) + Math.pow(j, 2) * i);
                    if(Double.isInfinite(result)) {
                        System.out.println("Infinity found!!");
                        break mainloop;
                    }
                    if(result == Math.floor(result) && !Double.isInfinite(result)) {
                        System.out.println("" + j + "^3 + " + j + "^2 * " + i + " = " + result + "^3");
                        break;
                    }
                }
            }
        }
    }
}
