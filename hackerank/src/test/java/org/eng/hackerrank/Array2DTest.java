package org.eng.hackerrank;

import org.eng.utilities.InReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.eng.hackerrank.Array2D.compute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Array2DTest {

    @Test
    void test00() throws IOException {
       testTheThing("matrix-00");
    }
    @Test
    void test01() throws IOException {
        testTheThing("matrix-01");
    }

    @Test
    void test02() throws IOException {
        testTheThing("matrix-02");
    }

    @Test
    void test03() throws IOException {
        testTheThing("matrix-03");
    }

    void testTheThing(String filename) throws IOException {
        var in = InReader.matrix(filename + ".in", this.getClass());
        System.out.println(Arrays.deepToString(in));
        var out = InReader.text(filename + ".out", this.getClass());
        assertEquals(Integer.parseInt(out), compute(in));
    }
}
