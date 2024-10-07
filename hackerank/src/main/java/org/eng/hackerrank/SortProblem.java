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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by iuliana on 14/01/2024
 * <a href="https://www.hackerrank.com/challenges/java-sort/problem">Java Sort</a>
 */
public class SortProblem {
    public static void main(String... args) {
        try(var in = new Scanner(System.in)){
            var testCases = Integer.parseInt(in.nextLine());
            if(testCases< 2 || testCases> 1000) {
                throw new IllegalArgumentException("Unsuitable no. of testcases!");
            }

            var studentList = new ArrayList<Student>();
            while(testCases>0){
                var id = in.nextInt();
                if(id < 0 || id > 100_000) {
                    throw new IllegalArgumentException("Unsuitable id!");
                }
                var fname = in.next();
                if(fname.length() < 5 || fname.length() > 30) {
                    throw new IllegalArgumentException("Unsuitable name!");
                }

                var cgpa = in.nextDouble();
                if(cgpa < 0 || cgpa > 4.00D) {
                    throw new IllegalArgumentException("Unsuitable cgpa!");
                }

                var st = new Student(id, fname, cgpa);
                studentList.add(st);

                testCases--;
            }

            studentList.sort(new StudentComparator());
            for(Student st: studentList){
                out.println(st.getFname());
            }
        }
    }

    static class Student{
        private int id;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }
    }

    static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            var res = Double.compare(o2.cgpa, o1.cgpa);
            if ( res == 0 ) {
                res = o1.fname.compareTo(o2.fname) ;
                return res == 0 ? o1.id - o2.id :  res;
            }
            return res;
        }
    }
}

