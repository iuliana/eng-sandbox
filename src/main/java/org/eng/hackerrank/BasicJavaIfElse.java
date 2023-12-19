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
package org.eng.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;

/**
 * Created by iuliana on 09/12/2023
 *
 * <a href="https://www.hackerrank.com/challenges/java-if-else/problem">Java If-Else</a>
 */
public class BasicJavaIfElse {

    public static String getType(int N) {
        var type = "Weird";
        if( N <0 || N > 100) {
            throw new IllegalArgumentException("N outside interval!");
        }

        if (N % 2 != 0) {
            return type;
        }

        if (N>=2 && N<= 5) {
            return STR."Not \{type}";
        } else  if (N>=6 && N<= 20) {
            return type;
        } else {
            return STR."Not \{type}";
        }
    }

    public static void main(String... args) throws IOException {
        try(var bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            var N = Integer.parseInt(bufferedReader.readLine().strip());
            out.println(getType(N));
        }
    }
}
