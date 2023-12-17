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
package org.eng.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;

/**
 * Created by iuliana on 16/12/2023
 *
 * <a href="https://www.hackerrank.com/challenges/simple-addition-varargs/problem?isFullScreen=true">Simple Addition Varargs</a>
 */

class Add {

    public void add(int... n) {
        if(n.length == 0) {
            throw new NumberFormatException("No terms to add.");
        } else if (n.length == 1) {
            throw new NumberFormatException("Not enough terms to add.");
        } else {
            var sum = 0;
            for (int i = 0; i < n.length; i++) {
                out.print(n[i]);
                if (i < n.length -1) {
                    out.print("+");
                }
                sum +=n[i];
            }
            out.println(STR."=\{sum}");
        }
    }
}
public class VarArgsProblem {

    public static void main(String... args) throws Exception {
        try(var br=new BufferedReader(new InputStreamReader(System.in))) {
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            int n6=Integer.parseInt(br.readLine());

            Add ob=new Add();
            ob.add(n1,n2);
            ob.add(n1,n2,n3);
            ob.add(n1,n2,n3,n4,n5);
            ob.add(n1,n2,n3,n4,n5,n6);

            // WTF is this ?
            Method[] methods=Add.class.getDeclaredMethods();

            Set<String> set=new HashSet<>();
            boolean overload=false;

            for(int i=0;i<methods.length;i++) {
                if(set.contains(methods[i].getName())) {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());
            }
            if(overload) {
                throw new Exception("Overloading not allowed");
            }
            // wtf ? ....
        }
    }
}
