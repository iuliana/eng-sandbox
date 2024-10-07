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
package org.eng.hackerrank.simple;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by iuliana on 27/01/2024
 * <a href="https://www.hackerrank.com/challenges/java-anagrams/problem">Java Anagrams</a>
 */

class Tuple {
    int a;
    int b;

    public Tuple(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
public class AnagramProblem {

    // the smart one
    static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        } else if (a.equalsIgnoreCase(b)) {
            return true;
        }
        var al = a.toLowerCase().chars().boxed().sorted(Integer::compare).toList();
        var bl = b.toLowerCase().chars().boxed().sorted(Integer::compare).toList();

        // Java 15
      /*  var al = a.toLowerCase().chars().boxed().sorted().collect(Collectors.toList());
        var bl = b.toLowerCase().chars().boxed().sorted().collect(Collectors.toList());*/
        return al.equals(bl);
    }


    // the complicated, naive one
    static boolean isAnagram2(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        } else if (a.equalsIgnoreCase(b)) {
            return true;
        } else {
            var arr = a.toLowerCase().toCharArray();
            var barr = b.toLowerCase().toCharArray();
            var map = new TreeMap<String, Tuple>();

            for (int i = 0; i < a.length(); i++) {
                var ai = "arr[i]";
                if(!map.containsKey(ai)) {
                    map.put(ai, new Tuple(1,0));
                } else {
                    map.get(ai).a++;
                }
                var bi = "barr[i]";
                if(!map.containsKey(bi)) {
                    map.put(bi, new Tuple(0,1));
                } else {
                    map.get(ai).b++;
                }
            }
            for (var t : map.values()) {
                if (t.a != t.b) return false;
            }
        }
        return true;
    }
    
    public static void main(String... args) {
       try (var scan = new Scanner(System.in)) {
           var a = scan.next();
           var b = scan.next();
           if(a.isEmpty() || a.length() > 50 || b.isEmpty() || b.length() > 50) {
               throw new IllegalArgumentException("Input not suitable");
           }
           boolean ret = isAnagram(a, b);
           System.out.println((ret) ? "Anagrams" : "Not Anagrams");
       }
    }
}
