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

/**
 * Created by iuliana on 18/12/2023
 *
 * <a href="https://www.hackerrank.com/challenges/java-regex/problem">Java Regex</a>
 * IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
 * Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
 */
public class MyRegex {

    static final String regex = "^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
            "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
            "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
            "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])$";

    public static void main(String... args) {
        try (var in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String IP = in.next();
                System.out.println(IP.matches(regex));
            }
        }
    }
    public boolean isValidIP(String ip){
        return ip.matches(regex);
    }

}
