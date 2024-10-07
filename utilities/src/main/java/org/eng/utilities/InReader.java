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
package org.eng.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by iuliana on 09/12/2023
 */
public class InReader {

    // this is actually the best way to read a file in Java
    public static Stream<String> lines(String fileName, Class c) throws IOException {
       return Files.lines(Path.of(c.getClassLoader().getResource(fileName).getPath()), StandardCharsets.UTF_8);
    }

    public static int[][] matrix(String fileName, Class c)throws IOException {
        var lines = lines(fileName, c).toList();
        var columns = lines.getFirst().replaceAll("\\s+$", "").split(" ").length;
        var rows = lines.size();
        var matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            var vals = lines.get(i).replaceAll("\\s+$", "").split(" ");
            for (int j = 0; j < vals.length; j++) {
                matrix[i][j] = Integer.parseInt(vals[j]);
                if (matrix[i][j] < -9 || matrix[i][j] > 9) {
                    throw new IllegalArgumentException("Unsuitable number!");
                }
            }
        }
        return matrix;
    }

    public static String text(String fileName, Class c) throws IOException {
        return Files.readString(Path.of(Objects.requireNonNull(c.getClassLoader().getResource(fileName)).getPath()), StandardCharsets.UTF_8);
    }

    public static int line(String fileName, Class c) throws IOException {
        return Files.lines(Path.of(c.getClassLoader().getResource(fileName).getPath()), StandardCharsets.UTF_8).findFirst().map(Integer::parseInt).orElse(-1);
    }

    public static BufferedReader getReader(String fileName, Class c) throws IOException {
        return Files.newBufferedReader(Path.of(c.getClassLoader().getResource(fileName).getPath()), StandardCharsets.UTF_8);
    }
}
