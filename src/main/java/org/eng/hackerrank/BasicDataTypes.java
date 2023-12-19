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
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * Created by iuliana on 09/12/2023
 * <a href="https://www.hackerrank.com/challenges/java-datatypes/problem">Java DataTypes</a>
 */
public class BasicDataTypes {
    public static Predicate<Long> isByte = x -> x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE;
    public static Predicate<Long> isShort = x -> x >= Short.MIN_VALUE && x <= Short.MAX_VALUE;
    public static Predicate<Long> isInteger = x -> x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE;
    public static Predicate<Long> isLong = x -> x >= Long.MIN_VALUE && x <= Long.MAX_VALUE;

    public static void main(String... args) {
        try (var sc = new Scanner(System.in)) {
            var t = sc.nextInt();
            List<String> input = new ArrayList<>();
            sc.nextLine();
            IntStream.range(0, t).forEach(i -> input.add(sc.nextLine().strip()));

            input.forEach(line -> {
                try {
                    var x = Long.parseLong(line);
                    out.println(x + " can be fitted in:");
                    if (isByte.test(x)) out.println("* byte");
                    if (isShort.test(x)) out.println("* short");
                    if (isInteger.test(x)) out.println("* int");
                    if (isLong.test(x)) out.println("* long");
                } catch (Exception e) {
                    out.println(line + " can't be fitted anywhere.");
                }
            });
        }
    }
}
