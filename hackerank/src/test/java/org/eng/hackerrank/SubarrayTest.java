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

import org.eng.utilities.InReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.eng.hackerrank.Subarray.getNegCnt;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by iuliana on 16/01/2024
 */
public class SubarrayTest {

    @Test
    void test00() throws IOException {
        testTheThing("subarray-00");
    }

    void testTheThing(String filename) throws IOException {
        var inList = Arrays.stream(InReader.text(filename + ".in", this.getClass()).split(" ")).map(
                Integer::parseInt
        ).toList();
        var a = new int[inList.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = inList.get(i);
        }

        var in = getNegCnt(a);

        var out = InReader.text(filename + ".out", this.getClass());
        assertEquals(Integer.parseInt(out), in);
    }
}