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

import org.eng.InReader;
import org.eng.aoc.CubeConundrum;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;
import static org.eng.aoc.CubeConundrum.TOTAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by iuliana on 13/12/2023
 *
 * @version TODO
 */
public class CubeConundrumTest {

    @Test
    void testSampleZero() throws IOException {
        testTheThing("cube-00");
    }

    @Test
    void testOtherSampleZero() throws IOException {
        testTheOtherThing("cube-00");
    }

    @Test
    void testSampleOne() throws IOException {
        testTheThing("cube-01");
    }

    @Test
    void testOtherSampleOne() throws IOException {
        testTheOtherThing("cube-01");
    }


    void testTheThing(String filename) throws IOException {
        int sum = 0;
        try(BufferedReader br = InReader.getReader(STR."\{filename}.in", this.getClass())) {
            String line;
            while ( (line = br.readLine()) != null) {
                    var g =  CubeConundrum.parseGame(line);
                    if(g != null) {
                        AtomicInteger counter = new AtomicInteger(0);
                        g.handful().stream().filter(h -> h.red() <= TOTAL.red() && h.green() <= TOTAL.green() && h.blue() <= TOTAL.blue())
                                .forEach(_ -> counter.incrementAndGet());
                        if(counter.get() ==  g.handful().size()) {
                            sum += g.id();
                            //out.println(STR."\t Adding game: \{g}");
                        }
                    }
                }
            }
        out.println(STR."sum= \{sum}");
        var output  = Integer.parseInt(InReader.lines(STR."\{filename}.out", this.getClass()).toList().getFirst());
        assertEquals(output, sum);
    }

    void testTheOtherThing(String filename) throws IOException {
        int sum = 0;
        try(BufferedReader br = InReader.getReader(STR."\{filename}.in", this.getClass())) {
            String line;
            while ( (line = br.readLine()) != null) {
                var g =  CubeConundrum.parseGame(line);
                if(g != null) {
                    List<Integer> red = new ArrayList<>();
                    List<Integer> green = new ArrayList<>();
                    List<Integer> blue = new ArrayList<>();
                    g.handful().forEach(h -> {
                        red.add(h.red());
                        green.add(h.green());
                        blue.add(h.blue());
                    });
                    var few = red.stream().max(Integer::compare).orElse(0)
                            * green.stream().max(Integer::compare).orElse(0)
                            * blue.stream().max(Integer::compare).orElse(0);
                    //out.println(STR."\{g.id()} = \{few}");
                    sum += few;
                }
            }
        }
        out.println(STR."sum= \{sum}");
        var output  = Integer.parseInt(InReader.lines(STR."\{filename}-2.out", this.getClass()).toList().getFirst());
        assertEquals(output, sum);
    }
}
