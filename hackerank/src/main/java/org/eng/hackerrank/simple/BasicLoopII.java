/*
Freeware License, some rights reserved

Copyright (c) 2023 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package org.eng.hackerrank.simple;

import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.out;

/**
 * Created by iuliana on 09/12/2023

 * <a href="https://www.hackerrank.com/challenges/java-loops/problem">Java Loops II</a>
 */
public class BasicLoopII {

    public static Function<String,String> COMPUTE =  line -> {
        var terms = line.split(" ");
        if (terms.length > 3) {
            throw new IllegalArgumentException("Too many terms!");
        }
        var a = Integer.parseInt(terms[0].strip());
        var b = Integer.parseInt(terms[1].strip());
        var n = Integer.parseInt(terms[2].strip());

        if(a<0 || a>50) {
            throw new IllegalArgumentException("A: " + a + " outside interval!");
        }

        if(b<0 || b>50) {
            throw new IllegalArgumentException("B: " + b + " outside interval!");
        }

        if(n<1 || n>15) {
            throw new IllegalArgumentException("N: " + n + " outside interval!");
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n ; i++) {
            var res = a;
            for (int j = 0; j <=i ; j++){
                res += (int)(Math.pow(2, j)) * b;
            }
            out.append(i == n - 1 ? res : res + " ");
        }
      return out.toString();
    };

    public static void main(String... args) {
        Scanner sc=new Scanner(System.in);
        out.println("================================");
        int q = sc.nextInt();
        if(q < 0 || q > 500) {
            throw new IllegalArgumentException("Too many lines!");
        }
        sc.nextLine();

        for(int i=0;i<q;i++) {
            String line=sc.nextLine();
            out.println(COMPUTE.apply(line));
        }
       out.println("================================");
    }

}
