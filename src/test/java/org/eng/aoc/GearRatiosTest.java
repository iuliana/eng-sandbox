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
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by iuliana on 14/12/2023
 */
public class GearRatiosTest {

    @Test
    void testLineParsing() throws IOException {
        var res = GearRatios.horizontalParseAndAdd("467..114..");
        System.out.println(res);
        var out = List.of( new GearRatios.IndexedNumber(467, List.of(0,1,2)), new GearRatios.IndexedNumber(114, List.of(5,6, 7)));
        System.out.println(out);
        assertEquals(out, res.indexedNos());
        assertEquals(0, res.sum());
    }

    @Test
    void testLineTwoParsing() throws IOException {
        var res = GearRatios.horizontalParseAndAdd("617*......");
        System.out.println(res);
        assertTrue(res.indexedNos().isEmpty());
        assertEquals(617, res.sum());
    }

    @Test
    void testEmptyLineParsing() throws IOException {
        var res = GearRatios.horizontalParseAndAdd("...*......");
        assertTrue(res.indexedNos().isEmpty());
        assertEquals(0, res.sum());
    }

    @Test
    void testBigLineParsing() throws IOException {
        var res = GearRatios.horizontalParseAndAdd("..............318....107...........*793.....361...............................*................372.......*.....*509......765.203....737.....");
        System.out.println(res);
        var out = List.of( new GearRatios.IndexedNumber(318, List.of(14, 15, 16)),
                new GearRatios.IndexedNumber(107, List.of(21, 22, 23)),
                //new GearRatios.IndexedNumber(793, List.of(36, 37, 38)),
                new GearRatios.IndexedNumber(361, List.of(44, 45, 46)),
                new GearRatios.IndexedNumber(372, List.of(95, 96, 97)),
                //new GearRatios.IndexedNumber(509, List.of(112, 113, 114)),
                new GearRatios.IndexedNumber(765, List.of(121, 122, 123)),
                new GearRatios.IndexedNumber(203, List.of(125, 126, 127)),
                new GearRatios.IndexedNumber(737, List.of(132, 133, 134)));
        System.out.println(out);
        assertEquals(out, res.indexedNos());
        assertEquals(1302, res.sum());
    }


    @Test
    void testSampleZero() throws IOException {
        testTheThing("engine-00");
    }

    @Test // TODO answer is too low
    void testSampleOne() throws IOException {
        testTheThing("engine-01");
    }

    @Test
    void testSampleTwo() throws IOException {
        testTheThing("engine-02");
    }

    @Test
    void getAllSymbols() throws IOException {
        Set<Character> symbols = new HashSet<>();
        try(BufferedReader br = InReader.getReader("engine-01.in", this.getClass())) {
            String line;
            while ( (line = br.readLine()) != null) {
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length ; i++) {
                    symbols.add(chars[i]);
                }
            }
        }
        System.out.println(symbols);
    }

    void testTheThing(String filename) throws IOException {
        var sum = 0;
        try(BufferedReader br = InReader.getReader(STR."\{filename}.in", this.getClass())) {
            String currentLine;
            String previousLine = "";
            String nextLine = "";

            boolean first = true;

            do {
                if (first) {
                    currentLine = br.readLine();
                    first = false;
                } else {
                    currentLine = nextLine;
                }
                nextLine = br.readLine();
                sum += GearRatios.parseLine(previousLine, currentLine, nextLine);
                previousLine = currentLine;
            } while (nextLine != null);
        }

        var output  = Integer.parseInt(InReader.lines(STR."\{filename}.out", this.getClass()).toList().getFirst());
        assertEquals(output, sum);
    }

}
