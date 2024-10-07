
package org.eng;

import org.eng.utilities.InReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TrebuchetTwoDay1 {
    
   static Map<String, String> DIGITS =  new HashMap<>() {{
       //put("zero", "0");
       put( "one", "1");
       put("two", "2");
       put("three", "3");
       put( "four", "4");
       put( "five", "5");
       put( "six", "6");
       put(  "seven", "7");
       put(  "eight", "8");
       put("nine", "9");
   }};


   public static Integer getDigits(String input) {
       String first ="";
       String last ="";

       if (Character.isDigit(input.charAt(0))) {
           first = input.charAt(0) + "";
       } else {
           first = findDigitFromStart(input);
       }

       if (Character.isDigit(input.charAt(input.length() - 1))) {
           last = input.charAt(input.length() - 1) + "";
       } else {
           last = findDigitFromEnd(input);
       }

       if (first.isBlank() && !last.isBlank()) {
           first = last;
       }
       if (last.isBlank() && !first.isBlank()) {
           last = first;
       }

       System.out.println(input +  ": " + first + last);
       return Integer.parseInt(first + last);
   }


    public static String getDigit(String input) {
        String threeDigits =  3 <= input.length() ? DIGITS.get(input.substring(0, 3)) : "";
        String fourDigits =   4 <= input.length() ? DIGITS.get(input.substring(0, 4)) : "";
        String fiveDigits =  5 <= input.length() ?  DIGITS.get(input.substring(0, 5)) : "";

        if(threeDigits != null && !threeDigits.isBlank()) {
            return input.substring(0, 3);
        }
        if(fourDigits!= null && !fourDigits.isBlank()) {
            return input.substring(0, 4);
        }
        if(fiveDigits!= null && !fiveDigits.isBlank()) {
            return input.substring(0, 5);
        }
        return "";
    }

    public static String findDigitFromEnd(String input) {
        for (int i = input.length()-3; i > 0; i--) {
            var sl = input.substring(i);
            var digit = getDigit(sl);
            if (!digit.isBlank()) {
                return DIGITS.get(digit);
            } else {
                for (int j = input.length()-1; j >= i; j--) {
                    if (Character.isDigit(input.charAt(j))){
                        return input.charAt(j) + "";
                    }
                }
            }
        }
        return "";
    }

    public static String findDigitFromStart(String input) {
        for (int i = 0; i < input.length() -1; i++) {
            var sl = input.substring(i);
            var digit = getDigit(sl);
            if (!digit.isBlank()) {
                return DIGITS.get(digit);
            } else {
                for (int j = i; j < i + 4; j++) {
                    if (Character.isDigit(input.charAt(j))){
                        return input.charAt(j) + "";
                    }
                }
            }
        }
        return "";
    }

    public static Integer computeWithEntry(Stream<String> entry) throws IOException {
       return  entry
               .map(TrebuchetTwoDay1::getDigits)
               .reduce(Integer::sum).orElse(-1);
    }


    public static void main(String... args) throws IOException {
       var trebuchet = new TrebuchetTwoDay1();
        System.out.println(trebuchet.sum);
    }

    Integer sum;

    TrebuchetTwoDay1() throws IOException {
        sum = InReader.lines("input.txt", this.getClass())
                .map(TrebuchetTwoDay1::getDigits)
                .reduce(Integer::sum).orElse(Integer.MIN_VALUE);
    }
}
