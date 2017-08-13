package com.bok;

//import com.bok.ip.IPValidationRegex;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.bok.ip.*;
import com.bok.student.*;
import com.bok.timing.*;
import java.util.concurrent.*;

public class App
{
    public static void main( String[] args )
    {
        App app = new App();

        System.out.println( "run 1 of 2 : IPValidationRegex... " );

        TimingUtil.measureDuration(() -> app.runIp()  );
        System.out.println("run 1 of 2 complete");

        System.out.println("");
        System.out.println("");
        System.out.println( "run 2 of 2 : Student Sort... " );

        TimingUtil.measureDuration(() -> app.runStudentSort()  );
        System.out.println("run 2 of 2 complete");

    }


    public void runStudentSort() {

        List<StudentInfo> unsortedList = new ArrayList<>();
        unsortedList.add(new StudentInfo(12L, null, null));
        unsortedList.add(new StudentInfo(1L, "Bella", 2.5));
        unsortedList.add(new StudentInfo(2L, "Juness", 3.5));
        unsortedList.add(new StudentInfo(3L, "Mary", 2.1));
        unsortedList.add(new StudentInfo(4L, "Nida", 0.5));
        unsortedList.add(new StudentInfo(6L, "Nida", 0.5));
        unsortedList.add(new StudentInfo(5L, "Nile", 4.0));
        unsortedList.add(new StudentInfo(7L, "Niles", 4.0));
        unsortedList.add(new StudentInfo(8L, "Annabelle", 4.0));
        unsortedList.add(new StudentInfo(9L, "Mae", 4.0));
        unsortedList.add(new StudentInfo(10L, "Mae", null));
        unsortedList.add(new StudentInfo(11L, null, null));
        unsortedList.add(new StudentInfo(13L, "Michelle", 0.0));
        unsortedList.add(new StudentInfo(14L, "Michelle", 0.0));
        unsortedList.add(new StudentInfo(15L, "Michelle", null));

//        System.out.println("");
//        System.out.println(">> Unsorted: ");
//        for (StudentInfo s : unsortedList) {
//            System.out.println(s);
//        }

        StudentInfoSorter.sort(unsortedList);


//        System.out.println("");
//        System.out.println(">> Sorted: ");
//        for (StudentInfo s : unsortedList) {
//            System.out.println(s);
//        }

        System.out.println("");
        System.out.println(">> Clean output : ");
        for (StudentInfo s : unsortedList) {
            System.out.println(s.getFirstName());
        }
    }

    public void runIp() {

        ClassLoader classLoader = getClass().getClassLoader();
        File f = new File(classLoader.getResource("ipFiles/"  + IPValidationRegex.DEFAULT_FILE).getFile());

        System.out.println("start reading >>>>>");
        List<String> rejectList = new ArrayList<>();
        try (
            BufferedReader br = new BufferedReader(new FileReader(f))) {
            IPValidationRegex ipValid = new IPValidationRegex();

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (ipValid.isMatch(line)) {
                    System.out.println(line);
                } else {
                    rejectList.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("<<<<< end reading");
//        for (String reject : rejectList) {
//            System.out.println("reject : " + reject);
//        }
    }



}
