package org.eng;


import org.eng.utilities.InReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.eng.TrebuchetTwoDay1.*;

public class TrebuchetTwoDay1Test {

    @Test
    void checkgetDigits() {
       assertEquals(73, getDigits("7seven743"));
       assertEquals(31, getDigits("3331"));
       assertEquals(29, getDigits("two1nine"));
       assertEquals(83, getDigits("eightwothree"));
       assertEquals(13, getDigits("abcone2threexyz"));
       assertEquals(24, getDigits("xtwone3four"));
       assertEquals(42, getDigits("4nineeightseven2"));
       assertEquals(14, getDigits("zoneight234"));
       assertEquals(76, getDigits("7pqrstsixteen"));
       assertEquals(14, getDigits("zoneight234"));
       assertEquals(87, getDigits("8fivefivefour7sxsrvdrz"));
       assertEquals(66, getDigits("ndtkjbsix6three9gdsjlljtj6six"));
       assertEquals(33, getDigits("3threefour62three3vrmnmgx"));
       assertEquals(14, getDigits("mdbqqjmpvonetwo1six31fourntbfb"));
       assertEquals(94, getDigits("nine6lqhnvbpxoneseveneightsxjfkz4vr"));
       assertEquals(76, getDigits("7vt426"));
       assertEquals(52, getDigits("5knflhntzthreeseventwo"));
       assertEquals(66, getDigits("sixpmhzqrlkrthreefour1pcgvz96"));
       assertEquals(42, getDigits("four4bqzqscdbctssgxfzjjntwonfcktjrtnxskjpkhvlfjt"));
       assertEquals(82, getDigits("eight6nlzdskjfourbmdvcrcgrshbjcxfour2"));
    }

    @Test
    void checkItOut () {
        assertEquals("4", findDigitFromStart("dprrtrngrfccz4eight4two8sthmfive"));
    }

    @Test
    void checkfindDigitFromStart () {
        assertEquals("9", findDigitFromStart("9fgsixzkbscvbxdsfive6spjfhzxbzvgbvrthreeoneightn"));
        assertEquals("5", findDigitFromStart("fiveqqjljzfcmbfqvkscpzscpsevenine1xvjlgk"));
        assertEquals("2", findDigitFromStart("two1nine"));
        assertEquals("1", findDigitFromStart("oneightn"));
        assertEquals("8", findDigitFromStart("eightwo"));
    }

    @Test
    void checkfindDigitFromEnd () {
        assertEquals("8", findDigitFromEnd("9fgsixzkbscvbxdsfive6spjfhzxbzvgbvrthreeoneightn"));
        assertEquals("1", findDigitFromEnd("fiveqqjljzfcmbfqvkscpzscpsevenine1xvjlgk"));
        assertEquals("9", findDigitFromEnd("two1nine"));
        assertEquals("8", findDigitFromEnd("oneightn"));
        assertEquals("2", findDigitFromEnd("eightwo"));
    }


    @Test
    void checkfull4() throws IOException {
        assertEquals(281, computeWithEntry(InReader.lines("input4.txt", this.getClass())));
    }

    @Test
    void checkfull3() throws IOException {
        assertEquals(273, computeWithEntry(InReader.lines("input3.txt", this.getClass())));
    }

    @Test
    void checkfull2() throws IOException {
        assertEquals(327, computeWithEntry(InReader.lines("input2.txt", this.getClass())));
    }

    @Test
    void checkfull5() throws IOException {
        assertEquals(600, computeWithEntry(InReader.lines("input5.txt", this.getClass())));
    }

    @Test
    void checkfull6() throws IOException {
        assertEquals(998, computeWithEntry(InReader.lines("input6.txt", this.getClass())));
    }

    @Test
    void checkfull7() throws IOException {
        assertEquals(1207, computeWithEntry(InReader.lines("input7.txt", this.getClass())));
    }
}
