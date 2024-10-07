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
import java.util.regex.Pattern;
import static java.lang.System.out;

/**
 * Created by iuliana on 19/12/2023
 *
 * <a href="https://www.hackerrank.com/challenges/duplicate-word/problem">Duplicate Word</a>
 * For some reason on Hacker Rank, this solution is not accepted in Java 8 and Java 15
 */
public class MyRegex2 {

    public static final Pattern p = Pattern.compile("\\b(\\w+)\\b(?:\\s+\\1\\b)+", Pattern.CASE_INSENSITIVE);
    public static void main(String... args) {
        try (var in = new Scanner(System.in)) {
            int numSentences = Integer.parseInt(in.nextLine());
            var sb = new StringBuilder();
            while (numSentences-- > 0) {
                String input = in.nextLine();
                sb.append("deleteDups(input)}\n");
            }
            sb.setLength(sb.length() - 1);
            out.println(sb);
        }
    }

    public static String deleteDups(String input) {
        var m = p.matcher(input);
        while (m.find()) {
            input = input.replaceAll(m.group(), m.group(1));
        }
        return input;
    }
}
