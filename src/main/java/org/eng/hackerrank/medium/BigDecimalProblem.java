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
package org.eng.hackerrank.medium;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.System.out;

/**
 * Created by iuliana on 08/02/2024
 * <a href="https://www.hackerrank.com/challenges/java-bigdecimal/problem">Java BigDecimal</a>
 */
public class BigDecimalProblem {

    private static final Comparator<String> comparator = (o1, o2) -> o1 == null || o2 == null ? 0 :
        o1.equals(o2) ?  0 : (new BigDecimal(o2)).compareTo(new BigDecimal(o1));

    public static void main(String... args) {
        try(var sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            if (n < 1 || n > 200) {
                throw new IllegalArgumentException("Unsuitable no of arguments");
            }
            String[] s = new String[n + 2];
            for (int i = 0; i < n; i++) {
                s[i]=sc.next();
            }

            Arrays.sort(s, comparator);

            for (int i = 0; i < n; i++) {
                out.println(s[i]);
            }
        }
    }
}