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

import java.io.*;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by iuliana on 10/12/2023
 */
public class BasicConversion {

    /**
     * <a href="https://www.hackerrank.com/challenges/java-int-to-string/problem?isFullScreen=true">Java Int to String</a>
     * @throws IOException
     */
    public static void intToString() throws IOException {
        try(var bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine().strip());
            if (N < -100 || N > 100) {
                throw new IllegalArgumentException("N outside permitted interval!");
            }
            try {
                Integer.toString(N);
                out.println("Good job");
            } catch (Exception e) {
                out.println("Wrong answer");
            }
        }
    }


// -----------------------------------------------------------------------------------------------------------------------

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    /**
     * @return string: the day of the week in capital letters
     */
    public static String findDayUsingCalendar(int month, int day, int year)  {
        var zdt = new GregorianCalendar(year,month -1,day).toZonedDateTime() ;
        return zdt.getDayOfWeek().name();
    }

    /**
     * @return string: the day of the week in capital letters
     */
    public static String findDay(int month, int day, int year)  {
        var  date = LocalDate.of(year, month, day);
        return  date.getDayOfWeek().name();
    }

    /**
     * <a href="https://www.hackerrank.com/challenges/java-date-and-time/problem?isFullScreen=true">Java Date and Time</a>
     */
    public static void printDay() throws IOException {
        try( var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             var bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int month = Integer.parseInt(firstMultipleInput[0]);
            int day = Integer.parseInt(firstMultipleInput[1]);
            int year = Integer.parseInt(firstMultipleInput[2]);

            if (year <=2000  || year >= 3000) {
                throw new IllegalArgumentException("Year is outside interval!");
            }

            String res = findDay(month, day, year);

            bufferedWriter.write(res);
            bufferedWriter.newLine();
        }
    }

    /**
     * <a href="https://www.hackerrank.com/challenges/java-currency-formatter/problem?isFullScreen=true">Java Currency Formatter</a>
     */
    public static void currencyFormatter(){
        try(var scan = new Scanner(System.in)) {
            var payment = scan.nextDouble();
            out.print(format(payment));
        }
    }

    public static String format(Double payment) {
        var s = "";
        if (payment >= 0 && payment <= Math.pow(10, 9)) {
          return STR."""
                US: \{NumberFormat.getCurrencyInstance(Locale.US).format(payment)}
                India: \{NumberFormat.getCurrencyInstance(Locale.of("en", "IN")).format(payment)}
                China: \{NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment)}
                France: \{NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment)}""" ;
        }
        return s;
    }

// -----------------------------------------------------------------------------------------------------------------------

    public static void main(String... args) throws IOException {
        if(args.length > 0) {
            if(args[0].equals("1")) {
                intToString();
            } else {
                printDay();
            }
        } else {
            currencyFormatter();
        }
    }
}
