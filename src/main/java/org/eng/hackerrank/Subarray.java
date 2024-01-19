/*
Freeware License, some rights reserved

Copyright (c) 2024 Iuliana Cosmina

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
package org.eng.hackerrank;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by iuliana on 16/01/2024
 * <a href="https://www.hackerrank.com/challenges/java-negative-subarray/problem">Java Subarray</a>
 */
public class Subarray {
    public static void main(String... args) {
        try(var in = new Scanner(System.in)){
            var n = Integer.parseInt(in.nextLine());
            if(n < 1 || n > 100) {
                throw new IllegalArgumentException("Unsuitable no. of items!");
            }
            var a = new int[n];
            for (var i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if(a[i] < - 10_000 || a[i] > 10_000) {
                    throw new IllegalArgumentException("Unsuitable array element!");
                }
            }
            out.print(getNegCnt(a));
        }

    }
    
    public static int getNegCnt(int[] a) {
        var cnt =0;
        for (var n = 1; n <= a.length; n++) {
            //out.println(" arr len: " + n);
            for (var i = 0; i < a.length; i++) {
                var s = 0;
                //out.println(i + " - " + ( i + n -1));
                var max =  i+n;
                for (var j = i; j < max && max <= a.length; j++) {
                    s += a[j];
                }
                if (s < 0) {
                    ++cnt;
                    //out.println("sum = " + s);
                }
            }
            //out.println(" -----");
        }
        return cnt;
    }
}

