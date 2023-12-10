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

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by iuliana on 09/12/2023
 * <a href="https://www.hackerrank.com/challenges/java-static-initializer-block/problem?isFullScreen=true">Java Static Initializer</a>
 */
public class BasicStaticInitializer {

    static int B;
    static int H;

    static {
        try (var sc = new Scanner(System.in)) {
            B = sc.nextInt();
            if (B < -100 || B > 100) {
                throw new IllegalArgumentException("B outside permitted interval");
            }
            sc.nextLine();
            H = sc.nextInt();
            if (H < -100 || H > 100) {
                throw new IllegalArgumentException("H outside permitted interval");
            }
        }
    }

    public static void main(String... args) {
        if (B <= 0 || H <= 0) {
            out.println("java.lang.Exception: Breadth and height must be positive");
            return;
        }
        out.println( B*H );
    }
}
