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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * Created by iuliana on 09/12/2023
 * <a href="https://www.hackerrank.com/challenges/java-output-formatting/problem?isFullScreen=true">Java Output Formatting</a>
 */



public class BasicFormatting {
    record Entry(String a, int b){}
    public static void main(String... args) {
        List<Entry> entries = new ArrayList<>();

        try(var sc = new Scanner(System.in)) {
            IntStream.range(0, 3).forEach(_ -> {
                String line = sc.nextLine();
                var terms = line.split(" ");
                if (terms.length != 2) {
                    throw new IllegalArgumentException("Number of arguments mismatch!");
                }
                var str = terms[0];
                if (str.length() > 10) {
                    throw new IllegalArgumentException("String length too big!");
                }
                var no = Integer.parseInt(terms[1].strip());
                if (no < 0 || no > 999) {
                    throw new IllegalArgumentException("Number not in interval!");
                }
                entries.add(new Entry(str, no));
            });
        }

        out.println("================================");
        entries.forEach(r -> {
            out.printf("%-15s", r.a);
            out.printf("%03d%n", r.b);
            }
        );
        out.println("================================");
    }
}
