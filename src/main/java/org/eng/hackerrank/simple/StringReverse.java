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
package org.eng.hackerrank.simple;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by iuliana on 25/01/2024
 <a href="https://www.hackerrank.com/challenges/java-string-reverse/problem">Java String Reverse</a>
 */
public class StringReverse {
    public static void main(String... args) {
        try(var sc=new Scanner(System.in)) {
            String a = sc.next();
            if (a.length() > 50 || !a.matches("[a-zA-Z]*")) {
                throw new IllegalArgumentException("Unsuitable entry");
            }
            var n = a.length()-1;
           /* var reverseArr = new char[a.length()];
            for (int i = 0; i <= n; i++) {
                reverseArr[n-i] = a.charAt(i);
            }
            var reverse = new String(reverseArr);
            System.out.println(a.equals(reverse) ? "Yes" : "No");*/

         /* var reverse = "";
            var stack = new Stack<Character>();
            a.chars().forEach(c -> stack.push((char) c));
            while(!stack.isEmpty()) {
                reverse =  reverse.concat(stack.pop().toString());
            }
            System.out.println(a.equals(reverse) ? "Yes" : "No");*/

           /* var reverse = new StringBuilder(a).reverse().toString();
            System.out.println(a.equals(reverse) ? "Yes" : "No");*/

            /* without creating additional objects */
            var i =0;
            var j = n;
            while( i <= j) {
                if (a.charAt(i) == a.charAt(j)) {
                    i++; j--;
                } else {
                    System.out.println("No");
                    return;
                }
             }
            System.out.println("Yes");
        }
    }
}
