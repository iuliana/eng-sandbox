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
package org.eng;

import org.eng.utilities.InReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author iuliana.cosmina on 07/10/2024
 */
public class TrebuchetDay1Test {

    @Test
    void testSolution() throws IOException {
        var sum = InReader.lines("input.txt", this.getClass())
                .map(l -> {
                    StringBuilder first = new StringBuilder();
                    StringBuilder last = new StringBuilder();

                    for (int i = 0; i < l.length()-1; i++) {
                        if(first.toString().isBlank() && (l.charAt(i) + "").matches("-?\\d+")) {
                            first.append(l.charAt(i));
                            break;
                        }
                    }

                    for (int i = l.length()-1; i > 0; i--) {
                        if(last.toString().isBlank() && (l.charAt(i) + "").matches("-?\\d+")) {
                            last.append(l.charAt(i));
                            break;
                        }
                    }

                    if (first.toString().isBlank() && !last.toString().isBlank()) {
                        first.append(last);
                    }
                    if (last.toString().isBlank() && !first.toString().isBlank()) {
                        last.append(first);
                    }
                    System.out.println(l + ": " + (first+ last.toString()));
                    return  Integer.parseInt(first+ last.toString());
                })
                .reduce(Integer::sum)
                .orElse(Integer.MIN_VALUE);

        assertEquals(54708, sum);
    }
}
