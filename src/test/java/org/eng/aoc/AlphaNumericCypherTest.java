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

import org.eng.InReader;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by iuliana on 10/12/2023
 */
public class AlphaNumericCypherTest {
    @Test
    void testSampleZero() throws IOException {
        testTheThing("aoc-00");
    }

    @Test
    void testSampleOne() throws IOException {
        testTheThing("aoc-01-2");
    }

    @Test
    void testSampleTwo() throws IOException {
        testTheThing("aoc-02");
    }

    @Test
    void testSampleThree() throws IOException {
        testTheThing("aoc-03");
    }

    @Test
    void testSampleFour() throws IOException {
        testTheThing("aoc-04");
    }

    @Test
    void testSampleFive() throws IOException {
        testTheThing("aoc-05");
    }

    @Test
    void testSampleOfficial() throws IOException {
        testTheThing("aoc-99-2");
    }

    void testTheThing(String filename) throws IOException {
        var sum = 0;
        try(BufferedReader br = InReader.getReader(STR."\{filename}.in", this.getClass())) {
            String line;
            while ( (line = br.readLine()) != null) {
                sum += AlphaNumericCypher.decode(line);
            }
        }

        var output  = InReader.line(STR."\{filename}.out", this.getClass());
        assertEquals(output, sum);
    }
}
