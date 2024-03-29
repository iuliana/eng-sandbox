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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import static java.lang.System.out;

/**
 * Created by iuliana on 08/02/2024
 * <a href="https://www.hackerrank.com/challenges/java-primality-test/problem">Java Primality Test</a>
 * TODO
 */
public class Primality {

    public static void main(String... args) throws IOException {
        try( var bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = bufferedReader.readLine();
            if(n.isEmpty() || n.length() > 100) {
                throw new IllegalArgumentException("Unsuitable argument");
            }
            out.print(isPrime(n) ? "prime" : "not prime");
        }
    }

    public static boolean isPrime(String n) {
        if(n.equals("0") || n.equals("1"))
            return false;
        var bi = new BigInteger(n);
        return bi.isProbablePrime(1);
    }
}
