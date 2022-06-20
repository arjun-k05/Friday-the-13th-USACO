/*
ID: --------
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;

class friday {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(new File("friday.in"));
        PrintWriter pw = new PrintWriter(new File("friday.out"));

        int yrs = sc.nextInt();
        int day = 2;

        int[] week = new int[7];
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < yrs; i++) {
            boolean isLeapYear = false;
            if ((1900 + i) % 100 == 0 && (1900 + i) % 400 == 0)
                isLeapYear = true;
            if ((1900 + i) % 4 == 0 && (1900 + i) % 100 != 0) 
                isLeapYear = true;
            
            if (isLeapYear)
                months[1] = 29;
            else
                months[1] = 28;
            
            for (int x : months) {
                day += 12;
                day %= 7;
                week[day]++;
                day += x - 12;
            }
            
        }

        for (int i = 0; i < week.length; i++) {
            pw.print(week[i] + " ");
        }

        /*   FOR THE USACO GRADING SYSTEM
        for (int i = 0; i < 6; i++) {
            pw.print(week[i] + " ");
        }
        pw.print(week[6]);
        pw.println();
        */

        pw.close();
        sc.close();
    }
}
