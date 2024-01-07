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

import java.util.*;

import static java.lang.System.out;

/**
 * Created by iuliana on 05/01/2024
 <a href="https://www.hackerrank.com/challenges/java-1d-array/problem">Java 1D Array (Part 2)</a>
 TODO - this does not work, more algorithms knowledge is necessary, or the problem is stated wrong
 */
public class Array1D {
    public static void main(String... args) {
        try(var scan = new Scanner(System.in)){
            int q = scan.nextInt();
            if (q< 1 || q>5000) {
                throw new IllegalArgumentException("Unsuitable value for 'q'");
            }
            while (q-- > 0) {
                int n = scan.nextInt();
                if (n< 2 || n>100) {
                    throw new IllegalArgumentException("Unsuitable value for 'n'");
                }
                int leap = scan.nextInt();
                if (leap< 0 || leap>100) {
                    throw new IllegalArgumentException("Unsuitable value for 'leap'");
                }
                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }
                if (game[0] != 0) {
                    throw new IllegalArgumentException("Unsuitable value for 'game[0]'");
                }

                out.println((canWin(leap, game)));
            }
        }
    }

    public static String canWin(int leap, int[] game){
        var res = false;
        var max =  game.length -(leap ==0 ? 2 : leap +1);
        if (leap +1 == game.length)
            max =  game.length - leap +1 ;
        for (int i = 0; i < max ; i++) {
            res =  canLeap(i, leap, game, new HashSet<>());
            if (res) return "YES";

        }
       return "NO";
    }

    private static boolean canLeap(int i, int leap, int[] game, Set<Integer> processed) {
        if (i == game.length-1 || i + leap >= game.length) {
            return true;
        } else {
            if (!processed.add(i)) return false; // if already there we are in a loop
            if(leap != 0 && game[i+leap] == 0) {
                return canLeap(i + leap, leap, game,processed);
            } else {
                if(game[i+1] == 0) { // add failed leap attempt for this index
                    return canLeap(i + 1, leap, game,processed);
                } else {
                    if(i > 0 && game[i-1] == 0) {
                        return canLeap(i - 1, leap, game,processed);
                    } else return false;
                }
            }
        }
    }
}

record GameFct(int leap, int[] game){

    @Override
    public String toString() {
        return STR."leap=\{leap}, size=\{game.length} , game=\{Arrays.toString(game)}";
    }
}
