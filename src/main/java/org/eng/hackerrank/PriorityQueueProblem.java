package org.eng.hackerrank;

import java.util.*;

import static java.lang.System.out;

/**
 * Created by iuliana on 20/12/2023
 * <a href="https://www.hackerrank.com/challenges/java-priority-queue/problem">Priority Queue</a>
 */

class Student  implements Comparable<Student> {
    int id; String name; double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student o) {
        int res =  Double.compare(o.getCGPA(), this.getCGPA());
        if (res == 0) {
            res = this.getName().compareTo(o.getName());
            if (res == 0) {
                return Integer.compare(o.getID(), this.getID());
            }
            return res;
        }
        return res;
    }

    @Override
    public String toString() {
        return STR."Student{id=\{id}, name='\{name}\{'\''}, cgpa=\{cgpa}\{'}'}";
    }
}

class Priorities {
    /**
     *   process all the given events and return all the students yet to be served in the priority order
     */
    public List<Student>  getStudents(List<String> events) {
        var result = new ArrayList<Student>();
        var pq = new PriorityQueue<Student>();
        events.forEach(event -> {
            if (event.equals("SERVED")){
                pq.poll();
            } else {
                var terms = event.split(" ");
                pq.add(new Student(Integer.parseInt(terms[3]), terms[1], Double.parseDouble(terms[2])));
            }
        });
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}

public class PriorityQueueProblem {

    private final static Priorities priorities = new Priorities();

    public static void main(String... args) {
        var events = new ArrayList<String>();
        try(var scan = new Scanner(System.in)){
            var n = Integer.parseInt(scan.nextLine());
            if (n < 2 || n > 1000) {
                throw  new IllegalArgumentException("Unsuitable number of events");
            }

            while (n-- != 0) {
                var event = scan.nextLine();
                events.add(event);
            }

            var students = priorities.getStudents(events);
            if (students.isEmpty()) {
                out.println("EMPTY");
            } else {
                for (Student st: students) {
                    out.println(st.getName());
                }
            }
        }
    }
}
