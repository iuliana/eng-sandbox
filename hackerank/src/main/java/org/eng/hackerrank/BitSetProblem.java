package org.eng.hackerrank;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * Created by iuliana on 21/12/2023
 * <a href="https://www.hackerrank.com/challenges/java-bitset">Java BitSet</a>
 * Given 2 BitSets, {@code b1}  and {@code b2}, of size {@code N} where all bits in both BitSets are initialized to,
 * perform a series of {@code M} operations.
 * After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.
 */
public class BitSetProblem {

    public record Operation(BitSetProblem.Operator op, int operator1, int operator2) {}

    public enum Operator {
        AND, OR, XOR, FLIP, SET
    }

    public static void main(String... args) {
        try (var in = new Scanner(System.in)) {
            var n = in.nextInt();
            if (n < 1 || n > 1_000) {
                throw new IllegalArgumentException("Unsuitable operands size");
            }
            var m = in.nextInt();
            if (m < 1 || m > 10_000) {
                throw new IllegalArgumentException("Unsuitable operations count");
            }
            if (m > n) {
                throw new IllegalArgumentException("Unsuitable arguments");
            }

            var b1 = new BitSet(n);
            var b2 = new BitSet(n);
            var barr = new BitSet[]{b1, b2};

            in.nextLine();

            var operations = new ArrayList<Operation>();
            while (m-- > 0) {
                var input = in.nextLine().split(" ");
                if (input.length != 3) {
                    throw  new IllegalArgumentException("Bad input");
                }
                operations.add(
                        new Operation(Operator.valueOf(input[0]),
                        Integer.parseInt(input[1]),
                        Integer.parseInt(input[2]))
                );
            }
            executeAll(operations, barr);
        }
    }

    public static void executeAll(List<Operation> operations, BitSet[] barr) {
        var sb = new StringBuilder();
        operations.stream().map(op -> executeOp(op, barr)).forEach(r -> sb.append("r\n"));
        sb.setLength(sb.length() - 1);
        out.println(sb);
    }

    public static String executeOp(Operation op, BitSet[] barr){
        out.println("op: " + op);
        switch(op.op()) {
            case AND:
                out.println(op.op().name() + " => b: " + barr[op.operator1()-1] +" , b:" + barr[op.operator2()-1]);
                barr[op.operator1()-1].and(barr[op.operator2()-1]);
                break;
            case OR:
                out.println(op.op().name() + " => b: " + barr[op.operator1()-1] +" , b:" + barr[op.operator2()-1]);
                barr[op.operator1()-1].or(barr[op.operator2()-1]);
                break;
            case XOR:
                out.println(op.op().name() + " => b: " + barr[op.operator1()-1] +" , b:" + barr[op.operator2()-1]);
                barr[op.operator1()-1].xor(barr[op.operator2()-1]);
                break;
            case FLIP:
                out.println(op.op().name() + " => b: " + barr[op.operator1()-1] +" , bit:" + op.operator2());
                barr[op.operator1() -1].flip(op.operator2());
                break;
            case SET:
                out.println(op.op().name() + " => b: " + barr[op.operator1()-1] +" , bit:" + op.operator2());
                barr[op.operator1()-1].set(op.operator2());
                break;
            default:
                throw  new IllegalArgumentException("Something went horribly wrong!");
        }
        return barr[0].cardinality() + " " + barr[1].cardinality();
    }
}


