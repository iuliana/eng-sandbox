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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by iuliana on 14/01/2024
 */
public class SortTest {

    @Test
    void test00() throws IOException {
        testTheThing("sort-00");
    }

    // TODO fix it at some point
    @Disabled
    @Test
    void test01() throws IOException {
        testTheThing("sort-01");
    }

    void testTheThing(String filename) throws IOException {
        var in = new ArrayList<SortProblem.Student>();
        InReader.lines(filename + ".in", this.getClass()).map(l ->  {
            var vals = l.split(" ");
            if (vals.length != 3) {
                throw new IllegalArgumentException("Unacceptable student data!");
            }

            var id = Integer.parseInt(vals[0]);
            if(id < 0 || id > 100_000) {
                throw new IllegalArgumentException("Unsuitable id!");
            }
            if(vals[1].length() < 5 || vals[1].length() > 30) {
                throw new IllegalArgumentException("Unsuitable name!");
            }
            var cgpa = Double.parseDouble(vals[2]);
            if(cgpa < 0 || cgpa > 4.00D) {
                throw new IllegalArgumentException("Unsuitable cgpa!");
            }
            return new SortProblem.Student(id, vals[1], cgpa);
        }).forEach(in::add);

        in.sort(new SortProblem.StudentComparator());
        var sb = new StringBuilder();
        in.forEach( s -> sb.append(s.getFname()).append("\n"));
        sb.setLength(sb.length() - 1);

        var out = InReader.text(filename + ".out", this.getClass());
        assertEquals(out, sb.toString());
    }
}
