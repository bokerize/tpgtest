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


        String fileName = null;
        if (args != null && args.length > 0 && args[0].length() > 0) {
            fileName  = args[0];
        }
        System.out.println( "run 1 of 2 : IPValidationRegex... " );

        final String finalFile = fileName;
        TimingUtil.measureDuration(() -> app.runIp(finalFile)  );
        System.out.println("run 1 of 2 complete");

        System.out.println("");
        System.out.println("");
        System.out.println( "run 2 of 2 : Student Sort... " );

        TimingUtil.measureDuration(() -> app.runStudentSort()  );
        System.out.println("run 2 of 2 complete");

    }


    public void runIp(String fileName) {

        InputStream inputStream = null;
        if (fileName != null) {
            try {
                inputStream = new FileInputStream(fileName);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("start reading IP file >>>>>");
        List<String> rejectList = new ArrayList<>();
        IPValidationRegex ipValid = new IPValidationRegex();
        if (inputStream != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                loopReader(br, ipValid, rejectList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            File defaultFile = null;
            if (inputStream == null) {
                ClassLoader classLoader = getClass().getClassLoader();
                defaultFile = new File(classLoader.getResource("ipFiles/"  + IPValidationRegex.DEFAULT_FILE).getFile());
            }

            try (BufferedReader br = new BufferedReader(new FileReader(defaultFile))) {
                loopReader(br, ipValid, rejectList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("<<<<< end reading IP file");
    }

    private void loopReader(BufferedReader br, IPValidationRegex ipValid, List<String> rejectList) throws IOException {
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (ipValid.isMatch(line)) {
                System.out.println(line);
            } else {
                rejectList.add(line);
            }
        }
    }

    public void runStudentSort() {

        List<StudentInfo> unsortedList = new ArrayList<>();
        unsortedList.add(new StudentInfo(33L, "Tina", 3.68));
        unsortedList.add(new StudentInfo(85L, "Louis", 3.85));
        unsortedList.add(new StudentInfo(56L, "Samil", 3.75));
        unsortedList.add(new StudentInfo(19L, "Samar", 3.75));
        unsortedList.add(new StudentInfo(22L, "Lorry", 3.76));

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
        System.out.println(">> Student list output : ");
        for (StudentInfo s : unsortedList) {
            System.out.println(s.getFirstName());
        }
    }




}
