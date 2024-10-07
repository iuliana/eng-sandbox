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
package org.eng;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iuliana on 09/12/2023
 * <a href="https://adventofcode.com/2023/day/1">Day One</a>
 */
public class AlphaNumericCypher {

    static Map<String, String> DIGITS =  new HashMap<>() {{
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
    }};

    public static int decode(String l) {
        if (l.length() == 1) {
            //out.println("l: " + l + l);
            return Character.isDigit(l.charAt(0)) ? Integer.parseInt(l + l) : 0;
        } else if (DIGITS.containsKey(l)) {
            return Integer.parseInt(DIGITS.get(l) + DIGITS.get(l));
        } else {
            return decodeDeep(l);
        }
    }

    public static String getDigit(String input) {
        String threeDigits = 3 <= input.length() ? DIGITS.get(input.substring(0, 3)) : "";
        String fourDigits =  4 <= input.length() ? DIGITS.get(input.substring(0, 4)) : "";
        String fiveDigits =  5 <= input.length() ?  DIGITS.get(input.substring(0, 5)) : "";

        if(threeDigits != null && !threeDigits.isBlank()) {
            return input.substring(0, 3);
        }
        if(fourDigits!= null && !fourDigits.isBlank()) {
            return input.substring(0, 4);
        }
        if(fiveDigits!= null && !fiveDigits.isBlank()) {
            return input.substring(0, 5);
        }
        return "";
    }

    public static String findDigitFromStart(String l) {
        for (int i = 0; i < l.length()-1; i++) {
            var sl = l.substring(i);
            var digit = getDigit(sl);
            if (!digit.isBlank()) {
                return DIGITS.get(digit);
            } else {
                for (int j = i; j < i + 3; j++) {
                    if (Character.isDigit(l.charAt(j))){
                        return l.charAt(j) +"";
                    }
                }
            }

        }
        return "";
    }

    public static String findDigitFromEnd(String l) {
        for (int i = l.length()-3; i > 0; i--) {
            var sl = l.substring(i);
            var digit = getDigit(sl);
            if (!digit.isBlank()) {
                return DIGITS.get(digit);
            } else {
                for (int j = i + 2; j >= i ; j--) {
                    if (Character.isDigit(l.charAt(j))){
                        return l.charAt(j) +"";
                    }
                }
            }
        }
        return "";
    }

    public static int decodeDeep(String l) {
        var first = Character.isDigit(l.charAt(0)) ? l.charAt(0) + "" :  findDigitFromStart(l);
        var last = Character.isDigit(l.charAt(l.length() - 1)) ? l.charAt(l.length() - 1) + "" : findDigitFromEnd(l);

        if (first.isBlank() && last.isBlank()) {
            //out.println(l+": 0");
            return 0;
        }

        if (first.isBlank() && !last.isBlank()) {
            first = last;
        }

        if (last.isBlank() && !first.isBlank()) {
            last = first;
        }

        //out.println(first + last);
        return Integer.parseInt(first+ last);
    }
}
