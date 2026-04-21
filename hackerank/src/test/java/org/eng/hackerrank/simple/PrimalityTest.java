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
package org.eng.hackerrank.simple;

import org.junit.jupiter.api.Test;

import static org.eng.hackerrank.simple.Primality.isPrime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by iuliana on 17/02/2024
 */
public class PrimalityTest {

    @Test
    void testPrimes(){
        assertAll(
                () -> assertFalse(isPrime("0")),
                () -> assertFalse(isPrime("1")),
                () -> assertTrue(isPrime("2")),
                () -> assertTrue(isPrime("3")),
                () -> assertTrue(isPrime("5")),
                () -> assertTrue(isPrime("7")),
                () -> assertTrue(isPrime("11")),
                () -> assertTrue(isPrime("13")),
                () -> assertTrue(isPrime("17")),
                () -> assertTrue(isPrime("29")),
                () -> assertTrue(isPrime("7698227959510126866413906652336134899568649319813920268246860935822545591175389330845650773544328161"))
        );
    }

    @Test
    void testPrimes100(){
        assertFalse(isPrime("2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251982"));
    }
}
