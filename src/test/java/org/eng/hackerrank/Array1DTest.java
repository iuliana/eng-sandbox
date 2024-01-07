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
import java.util.Arrays;

import static java.lang.System.out;
import static org.eng.hackerrank.Array1D.canWin;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static java.lang.System.out;

/**
 * Created by iuliana on 05/01/2024
 */
public class Array1DTest {

    @Test
    void test00() throws IOException {
        testTheThing("arr-00");
    }

    @Test
    void test01() throws IOException {
        testTheThing("arr-01");
    }

    @Test
    void test02() throws IOException {
        testTheThing("arr-02");
    }

    @Test
    void test03() throws IOException {
        testTheThing("arr-03");
    }

    @Test
    void test04() throws IOException {
        testTheThing("arr-04");
    }

    void testTheThing(String filename) throws IOException {
        var gameFcts = new ArrayList<GameFct>();

        var in = InReader.lines(STR."\{filename}.in", this.getClass()).toList();
        var n = Integer.parseInt(in.getFirst());
        for (int i = 1; n > 0; i = i+2) {
            var gd = Arrays.stream(in.get(i).split(" ")).map(Integer::parseInt).toList();

            var g = in.get(i+1).split(" ");
            if (g.length != gd.getFirst()) {
                throw  new IllegalArgumentException("Invalid input");
            }
            var game = new int[gd.getFirst()];
            for (int j = 0; j < gd.getFirst(); j++) {
                game[j] = Integer.parseInt(g[j]);
            }
            gameFcts.add(new GameFct(gd.getLast(), game));
            n--;
        }
        //---

        var oo = InReader.linesAsList(STR."\{filename}.out", this.getClass());
        for (int i = 0; i < gameFcts.size(); i++) {
            var r = canWin(gameFcts.get(i).leap(), gameFcts.get(i).game());
            if (!oo.get(i).equals(r)) {
                out.println(gameFcts.get(i));
                out.println(STR."[\{i}] -> expected: \{oo.get(i)}, actual: \{r}");
            }
        }

        /*out.println(gameFcts);
        var sb = new StringBuilder();
        gameFcts.stream().map(g -> canWin(g.leap(), g.game())).forEach(r -> sb.append(STR."\{r}\n") );
        sb.setLength(sb.length() - 1);

        var out = InReader.text(STR."\{filename}.out", this.getClass());
        assertEquals(out, sb.toString());*/
    }

}
