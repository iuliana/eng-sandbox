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

import org.eng.InReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by iuliana on 18/12/2023
 *
 * @version TODO
 */
public class MyRegexTest {

    @Test
    void invalidIPs(){
        var checker = new MyRegex();
        assertFalse(checker.isValidIP("000.12.234.23.23"));
        assertFalse(checker.isValidIP("666.666.23.23"));
        assertFalse(checker.isValidIP(".213.123.23.32"));
        assertFalse(checker.isValidIP("23.45.22.32."));
        assertFalse(checker.isValidIP("I.Am.not.an.ip"));
    }

    @Test
    void validIPs(){
        var checker = new MyRegex();
        assertTrue(checker.isValidIP("000.12.12.034"));
        assertTrue(checker.isValidIP("121.234.12.12"));
        assertTrue(checker.isValidIP("23.45.12.56"));
        assertTrue(checker.isValidIP("192.168.0.5"));
        assertTrue(checker.isValidIP("127.0.0.1"));
    }

    @Test
    void hrSample() throws IOException {
        var ins = InReader.lines("regex-00.in", this.getClass());
        var sb = new StringBuilder();
        var checker = new MyRegex();
        ins.map(checker::isValidIP).forEach(b -> sb.append(STR."\{b}\n"));
        sb.setLength(sb.length() - 1);

        var out = InReader.text("regex-00.out", this.getClass());
        assertEquals(sb.toString(), out);
    }


    @Test
    void hrRegex2Sample() throws IOException {
        var ins = InReader.lines("regex-01.in", this.getClass());
        var sb = new StringBuilder();
        ins.map(MyRegex2::deleteDups).forEach(b -> sb.append(STR."\{b}\n"));
        sb.setLength(sb.length() - 1);

        var out = InReader.text("regex-01.out", this.getClass());
        assertEquals(sb.toString(), out);
    }

}
