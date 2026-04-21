package org.eng.hackerrank;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.System.out;

/**
 * Created by iuliana on 20/12/2023
 * <a href="https://www.hackerrank.com/challenges/java-dequeue/problem">Dequeue Problem</a>
 */
public class DequeueProblem {

    public static void main(String... args) {
        try (var in = new Scanner(System.in)){
            var dq = new ArrayDeque<Integer>();
            var n = in.nextInt();
            if (n < 1 || n > 100000) {
                throw  new IllegalArgumentException("Unsuitable array size");
            }
            var m = in.nextInt();
            if (m < 1 || m > 100000) {
                throw  new IllegalArgumentException("Unsuitable sub-array size");
            }
            if (m > n) {
                throw  new IllegalArgumentException("Unsuitable array sizes!");
            }

            int u =0;
            int idx = 0;
            var set = new TreeSet<>(); // Optimisation 1: TreeSet is more efficient than a HashSet because it is ordered,
            // faster to insert an element, faster to get one out

            for (int i = 0; i < n; i++, idx++) {
                var num = in.nextInt();
                if (num <0 || num > 10_000_000) {
                    throw  new IllegalArgumentException("Unsuitable array element!");
                }
                dq.add(num);
                set.add(num);
                if (idx == m -1) {
                    var sz = set.size();
                    if (sz > u) {
                        u = sz;
                        if (u == m) {
                            out.print(u); // Optimisation 2: Max no of different integers we can have in an array of size m
                            // so if we got the max value before we traversed all n element, we return, because clearly there no need
                            // it's not like we could have m+1 unique integers in a size m array
                            return;
                        }
                    }
                    var polled = dq.pollFirst();
                    if (!dq.contains(polled)) {
                        set.remove(polled);
                    }
                    idx = idx -1;
                }
            }
            out.print(u);
        }
    }
}
