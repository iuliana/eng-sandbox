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
package org.eng.aoc;

import static java.lang.System.out;

/**
 * Created by iuliana on 09/12/2023
 * <a href="https://adventofcode.com/2023/day/1">Day One</a>
 */
public class NumericCypher {

    public static int decode(String l) {
        if(l.length() == 1 ) {
            out.println(STR."\{l}: \{l + l}");
            return Character.isDigit(l.charAt(0))? Integer.parseInt(l+l) : 0;
        } else {
            return decodeDeep(l);
        }
    }

    public static String findDigitFromStart(String l) {
        var first = new StringBuilder();
        for (int i = 0; i < l.length()-1; i++) {
            if(first.toString().isBlank() && Character.isDigit(l.charAt(i))) {
                first.append(l.charAt(i));
                break;
            }
        }
        return first.toString();
    }

    public static String findDigitFromEnd(String l) {
        var last = new StringBuilder();

        for (int i = l.length()-1; i > 0; i--) {
            if(last.toString().isBlank() && Character.isDigit(l.charAt(i))) {
                last.append(l.charAt(i));
                break;
            }
        }
        return last.toString();
    }

    public static int decodeDeep(String l) {
        var first = findDigitFromStart(l);
        var last = findDigitFromEnd(l);

        if (first.isBlank() && last.isBlank()) {
            out.println(STR."\{l}: 0");
            return 0;
        }

        if (first.isBlank() && !last.isBlank()) {
            first = last;
        }

        if (last.isBlank() && !first.isBlank()) {
            last = first;
        }

        out.println(STR."\{l}: \{first + last}");
        return Integer.parseInt(first+ last);
    }
}
