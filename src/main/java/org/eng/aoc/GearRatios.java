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

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import static java.lang.System.out;

/**
 * Created by iuliana on 14/12/2023
 *
 * <a href="https://adventofcode.com/2023/day/3">Day Three</a>
 */
public class GearRatios {

    public static final List<Character> SYMBOLS = List.of('*', '+', '-', '%', '/', '@', '=', '&', '$', '#');
    record IndexedNumber(int number, List<Integer> indexes) {}
    record Tuple(Integer sum, List<IndexedNumber> indexedNos) {}

    public static Tuple horizontalParseAndAdd(String line){
        var result = new ArrayList<IndexedNumber>();
        var sum = new AtomicInteger(0);
        var number =  new StringBuilder();
        var indexes =  new ArrayList<Integer>();
        IntStream.range(0, line.length()).forEach(i -> {
            if(line.charAt(i) == '.' ||  SYMBOLS.contains(line.charAt(i))) {
                //out.print(line.charAt(i));
                if (!number.isEmpty() && !indexes.isEmpty()) {
                    var in = new IndexedNumber(Integer.parseInt(number.toString()), List.copyOf(indexes));
                    if (SYMBOLS.contains(line.charAt(i)) || ( i-number.length()-1 >=0 && SYMBOLS.contains(line.charAt(i-number.length()-1)))){
                        sum.addAndGet(Integer.parseInt(number.toString()));
                    } else {
                        result.add(in);
                    }
                    number.setLength(0);
                    indexes.clear();
                }
            } else if (Character.isDigit(line.charAt(i))) {
                number.append(line.charAt(i));
                indexes.add(i);
            }
        });
        return new Tuple(sum.get(), result);
    }

    public static Tuple diagonalParseAndAdd(List<IndexedNumber> previousOut, String currentLine) {
        var sum = new AtomicInteger(0);

        for(ListIterator<IndexedNumber> li = previousOut.listIterator(); li.hasNext(); ) {
            var in = li.next();
            if (in.indexes.getFirst() - 1 >= 0 && currentLine.charAt(in.indexes.getFirst() -1) != '.') {
                sum.addAndGet(in.number);
                out.println(STR."\t \{currentLine.charAt(in.indexes.getFirst() -1)} adds \{in.number}");
                li.remove();
            } else if (in.indexes.getLast() + 1 < currentLine.length() && currentLine.charAt(in.indexes.getLast() + 1) != '.') {
                sum.addAndGet(in.number);
                out.println(STR."\t \{currentLine.charAt(in.indexes.getLast() + 1)} adds \{in.number}");
                li.remove();
            } else {
                for (var idx : in.indexes) {
                    if (currentLine.charAt(idx) != '.') {
                        sum.addAndGet(in.number);
                        out.println(STR."\t \{currentLine.charAt(idx)} adds \{in.number}");
                        li.remove();
                        break;
                    }
                }
            }
        }
        return new Tuple( sum.get(), previousOut);
    }

    public static Integer parseLine(String previous, String current, String  next) {
        var currentSum = horizontalParseAndAdd(current);
        var sum = currentSum.sum();

        List<IndexedNumber> indexedNumbers = currentSum.indexedNos();
        //out.println("H: " + indexedNumbers.size() + ": " + indexedNumbers);
        if (previous != null && !previous.isEmpty()) {
            var prevSum = diagonalParseAndAdd(indexedNumbers, previous);
            sum += prevSum.sum();
            indexedNumbers = prevSum.indexedNos();
            //out.println("P: " + indexedNumbers.size() + ": " + indexedNumbers);
        }

        if (next != null && !next.isEmpty()) {
            var nextSum = diagonalParseAndAdd(indexedNumbers, next);
            sum += nextSum.sum();
            out.println("N: " + nextSum.indexedNos .size() + ": " + nextSum.indexedNos);
        }
        out.println("------");        return sum;

    }

}
