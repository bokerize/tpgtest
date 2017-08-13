package com.bok.student;


import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;


public class StudentInfoSorterTest {


    private static List<StudentInfo> unsortedListGpa;
    private static List<StudentInfo> expectedListGpa;

    private static List<StudentInfo> unsortedListName;
    private static List<StudentInfo> expectedListName;

    private static List<StudentInfo> unsortedListGpaWithNull;
    private static List<StudentInfo> expectedListGpaWithNull;

    private static List<StudentInfo> unsortedListNameWithNull;
    private static List<StudentInfo> expectedListNameWithNull;

    private static List<StudentInfo> unsortedListAll;
    private static List<StudentInfo> expectedListAll;

    private static List<StudentInfo> unsortedListGiven;
    private static List<StudentInfo> expectedListGiven;
    @BeforeClass
    public static void setUpClass() {

        unsortedListGpa = new ArrayList<>();
        unsortedListGpa.add(new StudentInfo(1L, "AAA", 0.1));
        unsortedListGpa.add(new StudentInfo(7L, "AAA", 4.5));
        unsortedListGpa.add(new StudentInfo(4L, "AAA", 0.4));
        unsortedListGpa.add(new StudentInfo(3L, "AAA", 0.3));
        unsortedListGpa.add(new StudentInfo(6L, "AAA", 3.4));
        unsortedListGpa.add(new StudentInfo(2L, "AAA", 0.2));
        unsortedListGpa.add(new StudentInfo(5L, "AAA", 1.4));
        unsortedListGpa.add(new StudentInfo(8L, "AAA", 9.4));

        expectedListGpa = new ArrayList<>();
        expectedListGpa.add(new StudentInfo(8L, "AAA", 9.4));
        expectedListGpa.add(new StudentInfo(7L, "AAA", 4.5));
        expectedListGpa.add(new StudentInfo(6L, "AAA", 3.4));
        expectedListGpa.add(new StudentInfo(5L, "AAA", 1.4));
        expectedListGpa.add(new StudentInfo(4L, "AAA", 0.4));
        expectedListGpa.add(new StudentInfo(3L, "AAA", 0.3));
        expectedListGpa.add(new StudentInfo(2L, "AAA", 0.2));
        expectedListGpa.add(new StudentInfo(1L, "AAA", 0.1));


        unsortedListName = new ArrayList<>();
        unsortedListName.add(new StudentInfo(8L, "AAA", 4.0));
        unsortedListName.add(new StudentInfo(7L, "AAB", 4.0));
        unsortedListName.add(new StudentInfo(5L, "zzz", 4.0));
        unsortedListName.add(new StudentInfo(6L, "AABa", 4.0));

        expectedListName = new ArrayList<>();
        expectedListName.add(new StudentInfo(8L, "AAA", 4.0));
        expectedListName.add(new StudentInfo(7L, "AAB", 4.0));
        expectedListName.add(new StudentInfo(6L, "AABa", 4.0));
        expectedListName.add(new StudentInfo(5L, "zzz", 4.0));




        unsortedListGpaWithNull = new ArrayList<>();
        unsortedListGpaWithNull.add(new StudentInfo(1L, "AAA", 0.1));
        unsortedListGpaWithNull.add(new StudentInfo(10L, "AAA", null));
        unsortedListGpaWithNull.add(new StudentInfo(7L, "AAA", 4.5));
        unsortedListGpaWithNull.add(new StudentInfo(4L, "AAA", 0.4));
        unsortedListGpaWithNull.add(new StudentInfo(3L, "AAA", 0.3));
        unsortedListGpaWithNull.add(new StudentInfo(9L, "AAA", null));
        unsortedListGpaWithNull.add(new StudentInfo(6L, "AAA", 3.4));
        unsortedListGpaWithNull.add(new StudentInfo(2L, "AAA", 0.2));
        unsortedListGpaWithNull.add(new StudentInfo(5L, "AAA", 1.4));
        unsortedListGpaWithNull.add(new StudentInfo(8L, "AAA", 9.4));

        expectedListGpaWithNull = new ArrayList<>();
        expectedListGpaWithNull.add(new StudentInfo(8L, "AAA", 9.4));
        expectedListGpaWithNull.add(new StudentInfo(7L, "AAA", 4.5));
        expectedListGpaWithNull.add(new StudentInfo(6L, "AAA", 3.4));
        expectedListGpaWithNull.add(new StudentInfo(5L, "AAA", 1.4));
        expectedListGpaWithNull.add(new StudentInfo(4L, "AAA", 0.4));
        expectedListGpaWithNull.add(new StudentInfo(3L, "AAA", 0.3));
        expectedListGpaWithNull.add(new StudentInfo(2L, "AAA", 0.2));
        expectedListGpaWithNull.add(new StudentInfo(1L, "AAA", 0.1));
        expectedListGpaWithNull.add(new StudentInfo(9L, "AAA", null));
        expectedListGpaWithNull.add(new StudentInfo(10L, "AAA", null));


        unsortedListNameWithNull = new ArrayList<>();
        unsortedListNameWithNull.add(new StudentInfo(4L, null, 4.0));
        unsortedListNameWithNull.add(new StudentInfo(8L, "AAA", 4.0));
        unsortedListNameWithNull.add(new StudentInfo(7L, "AAB", 4.0));
        unsortedListNameWithNull.add(new StudentInfo(9L, null, 4.0));
        unsortedListNameWithNull.add(new StudentInfo(5L, "zzz", 4.0));
        unsortedListNameWithNull.add(new StudentInfo(6L, "AABa", 4.0));


        expectedListNameWithNull = new ArrayList<>();
        expectedListNameWithNull.add(new StudentInfo(8L, "AAA", 4.0));
        expectedListNameWithNull.add(new StudentInfo(7L, "AAB", 4.0));
        expectedListNameWithNull.add(new StudentInfo(6L, "AABa", 4.0));
        expectedListNameWithNull.add(new StudentInfo(5L, "zzz", 4.0));
        expectedListNameWithNull.add(new StudentInfo(4L, null, 4.0));
        expectedListNameWithNull.add(new StudentInfo(9L, null, 4.0));


        unsortedListAll = new ArrayList<>();
        unsortedListAll.add(new StudentInfo(6L, "Nida", 0.5));
        unsortedListAll.add(new StudentInfo(12L, null, null));
        unsortedListAll.add(new StudentInfo(15L, "Michelle", null));
        unsortedListAll.add(new StudentInfo(4L, "Nida", 0.5));
        unsortedListAll.add(new StudentInfo(14L, "Michelle", 0.0));
        unsortedListAll.add(new StudentInfo(5L, "Nile", 4.0));
        unsortedListAll.add(new StudentInfo(7L, "Niles", 4.0));
        unsortedListAll.add(new StudentInfo(8L, "Annabelle", 4.0));
        unsortedListAll.add(new StudentInfo(11L, null, null));
        unsortedListAll.add(new StudentInfo(2L, "Juness", 3.5));
        unsortedListAll.add(new StudentInfo(1L, "Bella", 2.5));
        unsortedListAll.add(new StudentInfo(13L, "Michelle", 0.0));
        unsortedListAll.add(new StudentInfo(9L, "Mae", 4.0));
        unsortedListAll.add(new StudentInfo(10L, "Mae", null));
        unsortedListAll.add(new StudentInfo(3L, "Mary", 2.1));

        expectedListAll = new ArrayList<>();
        expectedListAll.add(new StudentInfo(8L, "Annabelle", 4.0));
        expectedListAll.add(new StudentInfo(9L, "Mae", 4.0));
        expectedListAll.add(new StudentInfo(5L, "Nile", 4.0));
        expectedListAll.add(new StudentInfo(7L, "Niles", 4.0));
        expectedListAll.add(new StudentInfo(2L, "Juness", 3.5));
        expectedListAll.add(new StudentInfo(1L, "Bella", 2.5));
        expectedListAll.add(new StudentInfo(3L, "Mary", 2.1));
        expectedListAll.add(new StudentInfo(4L, "Nida", 0.5));
        expectedListAll.add(new StudentInfo(6L, "Nida", 0.5));
        expectedListAll.add(new StudentInfo(13L, "Michelle", 0.0));
        expectedListAll.add(new StudentInfo(14L, "Michelle", 0.0));
        expectedListAll.add(new StudentInfo(10L, "Mae", null));
        expectedListAll.add(new StudentInfo(15L, "Michelle", null));
        expectedListAll.add(new StudentInfo(11L, null, null));
        expectedListAll.add(new StudentInfo(12L, null, null));
        //executed only once, before the first test

        unsortedListGiven = new ArrayList<>();
        unsortedListGiven.add(new StudentInfo(33L, "Tina", 3.68));
        unsortedListGiven.add(new StudentInfo(85L, "Louis", 3.85));
        unsortedListGiven.add(new StudentInfo(56L, "Samil", 3.75));
        unsortedListGiven.add(new StudentInfo(19L, "Samar", 3.75));
        unsortedListGiven.add(new StudentInfo(22L, "Lorry", 3.76));

        expectedListGiven = new ArrayList<>();
        expectedListGiven.add(new StudentInfo(85L, "Louis", 3.85));
        expectedListGiven.add(new StudentInfo(22L, "Lorry", 3.76));
        expectedListGiven.add(new StudentInfo(19L, "Samar", 3.75));
        expectedListGiven.add(new StudentInfo(56L, "Samil", 3.75));
        expectedListGiven.add(new StudentInfo(33L, "Tina", 3.68));

    }

    @Test
    public void testGpa() {
        System.out.println(" test Gpa : " );
        StudentInfoSorter.sort(unsortedListGpa);

        for (int i = 0; i < unsortedListGpa.size(); i++) {
            assertEquals(expectedListGpa.get(i).getId(),  unsortedListGpa.get(i).getId());
            System.out.println(" sorted : " + unsortedListGpa.get(i));
        }
        System.out.println("");
    }

    @Test
    public void testName() {
        System.out.println(" test Name : " );
        StudentInfoSorter.sort(unsortedListName);

        for (int i = 0; i < unsortedListName.size(); i++) {
            assertEquals(expectedListName.get(i).getId(),  unsortedListName.get(i).getId());
            System.out.println(" sorted : " + unsortedListName.get(i));
        }
        System.out.println("");
    }

    public void testGpaWithNull() {
        System.out.println(" test Gpa with NULL: " );
        StudentInfoSorter.sort(unsortedListGpaWithNull);

        for (int i = 0; i < unsortedListGpaWithNull.size(); i++) {
            assertEquals(expectedListGpaWithNull.get(i).getId(),  unsortedListGpaWithNull.get(i).getId());
            System.out.println(" sorted : " + unsortedListGpaWithNull.get(i));
        }
        System.out.println("");
    }

    @Test
    public void testNameWithNull() {
        System.out.println(" test Name with NULL: " );
        StudentInfoSorter.sort(unsortedListNameWithNull);

        for (int i = 0; i < unsortedListNameWithNull.size(); i++) {
            assertEquals(expectedListNameWithNull.get(i).getId(),  unsortedListNameWithNull.get(i).getId());
            System.out.println(" sorted : " + unsortedListNameWithNull.get(i));
        }
        System.out.println("");
    }

    @Test
    public void testAll() {
        System.out.println(" test All : " );
        StudentInfoSorter.sort(unsortedListAll);

        for (int i = 0; i < unsortedListAll.size(); i++) {
            assertEquals(expectedListAll.get(i).getId(),  unsortedListAll.get(i).getId());
            System.out.println(" sorted : " + unsortedListAll.get(i));
        }
        System.out.println("");
    }

    @Test
    public void testGiven() {
        System.out.println(" test Given : " );
        StudentInfoSorter.sort(unsortedListGiven);

        for (int i = 0; i < unsortedListGiven.size(); i++) {
            assertEquals(expectedListGiven.get(i).getId(),  unsortedListGiven.get(i).getId());
            System.out.println(" sorted : " + unsortedListGiven.get(i));
        }
        System.out.println("");
    }


}