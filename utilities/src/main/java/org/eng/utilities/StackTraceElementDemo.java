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
package org.eng.utilities;

import java.io.IOException;

/**
 * @author iuliana.cosmina on 09/10/2024
 */
public class StackTraceElementDemo {

    public static void main(String... args) throws IOException {
        try {
            a();
        } catch (IOException ioe) {
            StackTraceElement[] stackTrace = ioe.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                System.err.println("Exception thrown from " +
                        stackTrace[i].getMethodName() + " in class " +
                        stackTrace[i].getClassName() + " on line " +
                        stackTrace[i].getLineNumber() + " of file " +
                        stackTrace[i].getFileName());
                System.err.println();
            }
        }
    }

    static void a() throws IOException {
        b();
    }

    static void b() throws IOException {
        throw new IOException();
    }
}
