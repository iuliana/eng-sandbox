package org.eng.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/java-2d-array/problem">Java 2D Array</a>
 */
public class Array2D {

    public static void main(String... args) throws IOException {
        var matrix = new int[6][6];
        try(var bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            IntStream.range(0, 6).forEach(i -> {
                try {
                    var vals = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                    for (int j = 0; j < vals.length; j++) {
                        matrix[i][j] = Integer.parseInt(vals[j]);
                        if (matrix[i][j] < -9 || matrix[i][j] > 9) {
                            throw new IllegalArgumentException("Unsuitable number!");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        //System.out.println(Arrays.deepToString(matrix));
        System.out.println(compute(matrix));
    }

    public static int compute(int[][] matrix) {
        var sum = Integer.MIN_VALUE;
        for (int i = 1; i <= matrix.length - 2 ; i++) {
            for (int j = 1; j <= matrix[i].length - 2; j++) {
                var s =   matrix[i-1][j-1] + matrix[i-1][j] + matrix[i-1][j+1]
                        + matrix[i][j]
                        +  matrix[i+1][j-1] + matrix[i+1][j] + matrix[i+1][j+1];
                if (s> sum) {
                    sum = s;
                }
            }
        }
        return sum;
    }
}
