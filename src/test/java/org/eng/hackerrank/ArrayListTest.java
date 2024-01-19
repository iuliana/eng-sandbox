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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by iuliana on 19/01/2024
 *
 * <a href="https://www.hackerrank.com/challenges/java-arraylist/problem">Java Arraylist</a>
 */
public class ArrayListTest {

    @Test
    void test00() throws IOException {
        testTheThing("array-00");
    }

    @Test
    void test01() throws IOException {
        testTheThing("array-01");
    }

    void testTheThing(String filename) throws IOException {
        var sb = new StringBuilder();
        var in = InReader.lines(STR."\{filename}.in", this.getClass()).toList();
        var idx = 0;

        var n = Integer.parseInt(in.get(idx++));
        if(n < 1 || n > 20_000) {
            throw new IllegalArgumentException("Unsuitable no. of items!");
        }
        List<List<Integer>> arrays = new ArrayList<>();

        var totalInts = 0;
        for (var i = 0; i < n; i++) {
            var line = in.get(idx++).replaceAll("\\s+$", "").split(" ");
            if (totalInts > 100_000) {
                throw new IllegalArgumentException("Too many integers!");
            }
            totalInts += line.length-1;
            var d = Integer.parseInt(line[0]);
            if(d < 0 || d > 50_000) {
                throw new IllegalArgumentException("Unsuitable no. of items on line!");
            }
            var list = new ArrayList<Integer>();
            for (int j = 1; j < d+1; j++) {
                list.add(Integer.parseInt(line[j]));
            }
            arrays.add(list);
        }
        var q = Integer.parseInt(in.get(idx++));
        if(q < 1 || q > 1_000) {
            throw new IllegalArgumentException("Unsuitable no. of queries!");
        }
        for (int i = 0; i < q; i++) {
            var line = in.get(idx++).replaceAll("\\s+$", "").split(" ");
            if (line.length != 2) {
                throw new IllegalArgumentException("Unsuitable no. of query members!");
            }
            var x = Integer.parseInt(line[0]) - 1; // xth line
            var y = Integer.parseInt(line[1]) - 1; // yth element
            if (x < 0 || x >= n) {
                //throw new IllegalArgumentException("Unsuitable x value!");
                //out.println("ERROR!");
                sb.append("ERROR!\n");
            }
            var list = arrays.get(x);
            if (y < 0 || y >= list.size()) {
                sb.append("ERROR!\n");
            } else {
                sb.append(STR."\{list.get(y)}\n");
            }
        }
        sb.setLength(sb.length() - 1);

        var out = InReader.text(STR."\{filename}.out", this.getClass());
        assertEquals(out, sb.toString());
    }
}
