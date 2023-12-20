package org.eng.hackerrank;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by iuliana on 19/12/2023
 * <a href="https://www.hackerrank.com/challenges/valid-username-checker/problem">Valid Username Checker</a>
 */

class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
}

public class ValidUsernameChecker {

    public static void main(String... args) {
        try(var scan = new Scanner(System.in)){
            int n = Integer.parseInt(scan.nextLine());
            if (n < 1 || n > 100) {
                throw  new IllegalArgumentException("Unsuitable number of items");
            }
            var sb = new StringBuilder();
            while (n-- > 0) {
                String userName = scan.nextLine();
                sb.append(STR."\{matches(userName)}\n");
                //  sb.append(matches(userName) + "\n");
            }
            sb.setLength(sb.length() - 1);
            out.println(sb);
        }
    }

    public static String matches(String userName){
        return userName.matches(UsernameValidator.regularExpression)? "Valid" : "Invalid";
    }
}
