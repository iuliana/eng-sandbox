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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 * Created by iuliana on 07/02/2024
 *
 * <a href="https://www.hackerrank.com/challenges/tag-content-extractor/problem">Tag Content Extractor</a>
 */
public class TagContentExtractor {
    public static void main(String... args) {
        try (var in = new Scanner(System.in)) {
            var n = in.nextInt();
            if(n<1 || n> 100) {
                throw new IllegalArgumentException("Unsuitable no. of lines");
            }
            in.nextLine(); // to switch to next line
            var lines = new ArrayList<String>();
            var total = 0;
            for (int i = 0; i < n; i++) {
                var line = in.nextLine();
                if(line.length() > 10_000) {
                    throw new IllegalArgumentException("Unsuitable no. of characters");
                }
                total += line.length();
                if(total > 1_000_000) {
                    throw new IllegalArgumentException("Unsuitable total no. of characters");
                }
                lines.add(line);
            }
            out.print(processLines(lines));
        }
    }

    // my opinion is that this is a more suitable HTML/XML tag regex, but oh well.
    //public static final Pattern tags = Pattern.compile("<([a-zA-Z 0-9]+?)>([^<]+)</\\1>");
    public static final Pattern tags = Pattern.compile("<(.+?)>([^<]+)</\\1>");

    public static String processLines(List<String> input){
        var sb = new StringBuilder();
        for (var line: input) {
            var m = tags.matcher(line);
            var found = false;
            while(m.find()) {
                sb.append(m.group(2)).append("\n");
                found = true;
            }
            if(!found) {
                sb.append("None").append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
