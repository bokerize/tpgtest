package com.bok.student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by JerichoJohn on 13-Aug-17.
 */
public class StudentInfoSorter {

    public static void sort(List<? extends StudentInfo> unsortedList) {

        Collections.sort(unsortedList,new Comparator<StudentInfo>() {

            //specify order to handle NULLs
            private static final int ORD_ASC = 1;
            private static final int ORD_DESC = -1;

            private int compareNullables(Object o1, Object o2) {
                if (o1 == null && o2 != null) {
                    return 1 ;
                } else if (o1 != null && o2 == null) {
                    return -1 ;
                }
                return 0; //either both null or both not null
            }

            private int compare(Comparable n1, Comparable n2, int ord) {
                int result = compareNullables(n1, n2);
                if (result != 0) {
                    return result;
                }
                if (n1 != null && n2 != null) {
                    return n1.compareTo(n2) * ord;
                }
                return 0;
            }


            @Override
            public int compare(StudentInfo a, StudentInfo b ) {
                int result = 0; //neutral
                if (a != null && b != null) {
                    result = compare(a.getGpa(), b.getGpa(), ORD_DESC);
                    if (result == 0) {
                        result = compare(a.getFirstName(), b.getFirstName(), ORD_ASC);
                    }
                    if (result == 0) {
                        result = compare(a.getId(), b.getId(), ORD_ASC);
                    }
                } else {
                    return compareNullables(a,b);
                }
                return result;
            }
        });

    }

}
