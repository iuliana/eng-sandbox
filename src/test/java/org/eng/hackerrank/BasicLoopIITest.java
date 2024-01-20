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

import org.eng.AppTest;
import org.eng.InReader;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.eng.hackerrank.simple.BasicLoopII.COMPUTE;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by iuliana on 09/12/2023
 *
 */
public class BasicLoopIITest {
    private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

    @Test
    void testSampleZero() throws IOException {
        testTheThing("basic-loop-00");
    }

    @Test
    void testSampleOne() throws IOException {
        testTheThing("basic-loop-01");
    }

    void testTheThing(String filename) throws IOException {

        List<String> result = new ArrayList<>();

        try(BufferedReader br = InReader.getReader(STR."\{filename}.in", this.getClass())) {
            var inputCount = 0;
            String line;
            while ( (line = br.readLine()) != null) {
                inputCount = inputCount +1;
                if(inputCount == 1 ) {
                   var linesNo = Integer.parseInt(line.strip());
                   if(linesNo < 0 || linesNo > 500) {
                       throw new IllegalArgumentException("Too many lines!");
                   }
                } else {
                    result.add(COMPUTE.apply(line));
                }
            }
        }

        out.println("-------------------------");

        var output  = InReader.lines(STR."\{filename}.out", this.getClass()).toList();

        var check = true;
        for (int i = 0; i < output.size(); i++) {
            out.println(STR."\{output.get(i)}<>\{result.get(i)}");
            check &= output.get(i).endsWith(result.get(i));
        }
        assertTrue(check);
    }


}
