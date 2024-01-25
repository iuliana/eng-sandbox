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

import static java.lang.System.out;

/**
 * Created by iuliana on 21/01/2024
 *
 <a href="https://www.hackerrank.com/challenges/java-substring/problem">Java Substring</a>
 */
public class BasicStringPlay {
    public static void main(String... args) {
        try (var in = new Scanner(System.in)) {
            var s = in.next();
            if(s.isEmpty() || s.length()> 100 || !s.matches("[a-zA-Z]*")) {
                throw new IllegalArgumentException("Unsuitable string input");
            }
            int start = in.nextInt();
            int end = in.nextInt();
            if( start < 0 || start > end || end > s.length()) {
                throw new IllegalArgumentException("Unsuitable index input");
            }
            out.print(s.substring(start,end));
        }
    }
}
