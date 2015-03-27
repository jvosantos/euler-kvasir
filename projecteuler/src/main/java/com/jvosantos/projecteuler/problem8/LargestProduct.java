/*
 * Largest product in a series
 * Problem 8
 * 
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * 
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 */

package com.jvosantos.projecteuler.problem8;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestProduct {
    private String[] sequence;
    private BigInteger[] products;
    
    private Map<BigInteger, String> productToSequences;
    
    public LargestProduct(String number, int sequenceSize) {
        productToSequences = new HashMap<>();
        sequence = new String[number.length()-sequenceSize];
        
        for(int i = 0; i+sequenceSize < number.length(); i++) {
            sequence[i] = number.substring(i, i+sequenceSize);
        }
        
        products = new BigInteger[sequence.length];
        
        for(int i = 0; i < sequence.length; i++) {
            products[i] = BigInteger.ONE;
            for(int j = 0; j < sequence[i].length(); j++) {
                BigInteger operand = new BigInteger(Character.toString(sequence[i].charAt(j)));
                if(operand.equals(BigInteger.ZERO)) {
                    products[i] = BigInteger.ZERO;
                    break;
                }
                products[i] = products[i].multiply(operand);
            }
            productToSequences.put(products[i], sequence[i]);
        }
        
        Arrays.sort(products);
    }
    
    public BigInteger getLargestProduct() {
        return products[products.length-1];
    }
    
    public String getSequenceOfLargestProduct() {
        return productToSequences.get(getLargestProduct());
    }
    
    public static void main(String[] args) {
        String number = "73167176531330624919225119674426574742355349194934" +
                        "96983520312774506326239578318016984801869478851843" +
                        "85861560789112949495459501737958331952853208805511" +
                        "12540698747158523863050715693290963295227443043557" +
                        "66896648950445244523161731856403098711121722383113" +
                        "62229893423380308135336276614282806444486645238749" +
                        "30358907296290491560440772390713810515859307960866" +
                        "70172427121883998797908792274921901699720888093776" +
                        "65727333001053367881220235421809751254540594752243" +
                        "52584907711670556013604839586446706324415722155397" +
                        "53697817977846174064955149290862569321978468622482" +
                        "83972241375657056057490261407972968652414535100474" +
                        "82166370484403199890008895243450658541227588666881" +
                        "16427171479924442928230863465674813919123162824586" +
                        "17866458359124566529476545682848912883142607690042" +
                        "24219022671055626321111109370544217506941658960408" +
                        "07198403850962455444362981230987879927244284909188" +
                        "84580156166097919133875499200524063689912560717606" +
                        "05886116467109405077541002256983155200055935729725" +
                        "71636269561882670428252483600823257530420752963450";
        
        LargestProduct largestProduct = new LargestProduct(number, 13);
        System.out.println("Largest Product: " + largestProduct.getLargestProduct());
        System.out.println("Sequence of largest product: " + largestProduct.getSequenceOfLargestProduct());
    }
}