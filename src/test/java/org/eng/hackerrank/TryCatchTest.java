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
package org.eng.hackerrank;

import org.eng.InReader;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by iuliana on 05/01/2024
 */
public class TryCatchTest {

    @Test
    void test00() throws IOException {
        testTheThing("trycatch-00");
    }

    @Test
    void test01() throws IOException {
        testTheThing("trycatch-01");
    }

    @Test
    void test02() throws IOException {
        testTheThing("trycatch-02");
    }

    @Test
    void test03() throws IOException {
        testTheThing("trycatch-03");
    }

    @Test
    void test04() throws IOException {
        testTheThing("trycatch-04");
    }


    void testTheThing(String filename) throws IOException {
        var output  = InReader.lines(STR."\{filename}.out", this.getClass()).findFirst().orElse(null);

        try(BufferedReader br = InReader.getReader(STR."\{filename}.in", this.getClass())) {
            String xstr = br.readLine();
            String ystr =  br.readLine();
            int x;
            int y;
            String res = "";
            try {
                x = Integer.parseInt(xstr);
                y = Integer.parseInt(ystr);
                res = STR."\{x / y}";
            } catch (Exception e ){
                if (e instanceof  NumberFormatException) {
                    res = "java.util.InputMismatchException"; // because we are not using scanner here
                } else {
                    res = e.toString();
                }
            }
            assertEquals(output, res);
        }
    }
}
