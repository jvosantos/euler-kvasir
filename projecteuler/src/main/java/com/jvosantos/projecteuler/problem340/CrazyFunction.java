/*
 * Crazy Function
 * Problem 340
 * For fixed integers a, b, c, define the crazy function F(n) as follows:
 * F(n) = n - c for all n > b 
 * F(n) = F(a + F(a + F(a + F(a + n)))) for all n ≤ b.
 * 
 * Also, define S(a, b, c) = Sum from n=0 to b of F(n).
 * 
 * For example, if a = 50, b = 2000 and c = 40, then F(0) = 3240 and F(2000) = 2040.
 * Also, S(50, 2000, 40) = 5204240.
 * 
 * Find the last 9 digits of S(21^7, 7^21, 12^7).
 */
package com.jvosantos.projecteuler.problem340;

public class CrazyFunction {

    public static void main(String[] args) {
        
    }
}