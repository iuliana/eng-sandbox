package org.eng.hackerrank;

import org.eng.utilities.InReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTest {

    @Test
    void test00() throws IOException {
        testTheThing("comparator-00");
    }

    void testTheThing(String filename) throws IOException {
        var lines = InReader.lines(filename + ".in", this.getClass()).toList();
        var n = Integer.parseInt(lines.getFirst());
        var player = new Player[n];
        var checker = new Checker();

        IntStream.range(1, n+1).forEach(i -> {
            var s = lines.get(i).split(" ");
            var name = s[0];
            var score = Integer.parseInt(s[1]);
            if(score < 0 || score> 1000) {
                throw new IllegalArgumentException("Unacceptable score!");
            }
            player[i-1] = new Player(name, score);
        });

        Arrays.sort(player, checker);

        var outLines = InReader.lines(filename + ".out", this.getClass()).toList();
        var out = new Player[n];
        IntStream.range(0, n).forEach(i -> {
            var s = outLines.get(i).split(" ");
            out[i] = new Player(s[0], Integer.parseInt(s[1]));
        });

        assertEquals(Arrays.toString(out), Arrays.toString(player));
    }
}
