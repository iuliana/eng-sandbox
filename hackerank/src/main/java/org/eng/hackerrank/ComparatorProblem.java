package org.eng.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * <a href="https://www.hackerrank.com/challenges/java-comparator/problem">Java Comparator</a>
 */
public class ComparatorProblem {

    public static void main(String... args) {
        try (var scan = new Scanner(System.in)){
            var n = scan.nextInt();

            var player = new Player[n];
            var checker = new Checker();

            IntStream.range(0, n).forEach(i -> {
                player[i] = new Player(scan.next(), scan.nextInt());
                if( player[i].score < 0 ||  player[i].score> 1000) {
                    throw new IllegalArgumentException("Unacceptable score!");
                }
            });

            Arrays.sort(player, checker);
            for (Player value : player) {
               out.println(value);
            }
        }
    }
}


class Player {
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int res = o2.score - o1.score;
        return  res ==0 ? o1.name.compareTo(o2.name) : res;
    }
}
