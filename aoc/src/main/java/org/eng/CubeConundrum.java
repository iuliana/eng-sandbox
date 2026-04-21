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
package org.eng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by iuliana on 10/12/2023
 * <a href="https://adventofcode.com/2023/day/2">Day Two</a>
 */
public class CubeConundrum {

    public static final Pattern GAME = Pattern.compile("^(Game\\s)([0-9]+)(:\\s)(.*)");

    public static final Handful TOTAL = new Handful(12, 13, 14);

    public record Handful( int red, int green, int blue) {}

    public record Game(int id, List<Handful> handful){}

    public static Game parseGame(String line) {
        var matcher = GAME.matcher(line);
        if(matcher.find()) {
            var groupId = matcher.group(2);
            var sets = matcher.group(4).split(";");
            var games = new ArrayList<Handful>();
            Arrays.stream(sets).forEach(s -> {
                var cubes = s.split(",");
                var r = 0;
                int g = 0;
                int b = 0;
                for (String c : cubes) {
                    if (c.contains("red")) {
                        r = Integer.parseInt(c.replace(" red", "").strip());
                    }
                    if (c.contains("green")) {
                        g = Integer.parseInt(c.replace(" green", "").strip());
                    }
                    if (c.contains("blue")) {
                        b = Integer.parseInt(c.replace(" blue", "").strip());
                    }
                }
                games.add(new Handful(r, g, b));
            });

            return new Game(Integer.parseInt(groupId.strip()), games);
        }
        return null;
    }
}
