package org.eng.hackerrank;

import org.eng.utilities.InReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.BitSet;

import static org.eng.hackerrank.BitSetProblem.executeOp;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitSetTest {

    @Test
    void sample() throws IOException {
        var ins = InReader.lines("bitset-00.in", this.getClass());
        var sb = new StringBuilder();
        var b1 = new BitSet(5);
        var b2 = new BitSet(5);
        var barr = new BitSet[]{b1, b2};

        ins.map(line -> line.split(" "))
                .map(input ->  new BitSetProblem.Operation(BitSetProblem.Operator.valueOf(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])))
                .map(op -> executeOp(op, barr))
                .forEach(r -> sb.append(r).append("\n"));

        sb.setLength(sb.length() - 1);

        var out = InReader.text("bitset-00.out", this.getClass());
        assertEquals(sb.toString(), out);
    }

    @Test
    void trickySample() throws IOException {
        var ins = InReader.lines("bitset-01.in", this.getClass());
        var sb = new StringBuilder();
        var b1 = new BitSet(10);
        var b2 = new BitSet(10);
        var barr = new BitSet[]{b1, b2};

        ins.map(line -> line.split(" "))
                .map(input ->  new BitSetProblem.Operation(BitSetProblem.Operator.valueOf(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])))
                .map(op -> executeOp(op, barr))
                .forEach(r -> sb.append(r).append("\n"));

        sb.setLength(sb.length() - 1);

        var out = InReader.text("bitset-01.out", this.getClass());
        assertEquals(sb.toString(), out);
    }
}
