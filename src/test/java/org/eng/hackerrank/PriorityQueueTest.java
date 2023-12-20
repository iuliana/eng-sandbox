package org.eng.hackerrank;

import org.eng.InReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    @Test
    void stCompare() {
        var s1 = new Student(49, "Anik", 3.95d);
        var s2 = new Student(50, "Dan", 3.95d);

        System.out.println( s1.compareTo(s2));
    }

    @Test
    void stSample() throws IOException {
        var ins = InReader.lines("students-00.in", this.getClass()).collect(Collectors.toList());
        var students = new Priorities().getStudents(ins);

        var sb = new StringBuilder();
        students.forEach( s -> sb.append(STR."\{s.getName()}\n"));
        sb.setLength(sb.length() - 1);

        var out = InReader.text("students-00.out", this.getClass());
        assertEquals(out, sb.toString());
    }
}
