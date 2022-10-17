/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package CSC239.project1;

import java.util.Scanner;

/**
 * CSC-239 Project 1: Day of the Year 
 * Student: Margarita Kholostova 
 * Date: Oct.17
 * 17 2022 Description: This program prompts the user to input a string of text
 * representing a numeric date in the following format: MM DD YYYY The program
 * outputs the day of that particular year that the string represents.
 */
public class CSC23902Project1 {

    public static void main(String[] args) {

        //scanner new object
        Scanner console = new Scanner(System.in);
        String input = null;
        String[] dateArr;
        int[] monthDays;
        int[] monthDaysLeap;
        String[] monthNames;
        
        //arrays for correct days in month
        monthNames = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            monthDays = new int[]{31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};
            monthDaysLeap = new int[]{31, 29, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};

        boolean isRunning = true;//to check symbol for q
        boolean isValid = true; // to control for loop on 87 line
        int count, month = 0, day = 0, year = 0, daysInMonth =0;

        

            //read the input
        System.out.println("This program accepts numeric dates in the format MM DD YYYY. ");
        System.out.println("Please enter numeric date (or q to exit program): ");

        
        input = console.nextLine();
        while (isRunning && !input.equals("q")) {
        count = 0;  
  
        
        dateArr = input.split(" ", 3);
           
            try {            
            day = Integer.parseInt(dateArr[1]);
            year = Integer.parseInt(dateArr[2]);
            month = Integer.parseInt(dateArr[0]);}
            catch (NumberFormatException nfe) {
                System.out.println("Non-numeric data entered: " + dateArr[0] + " " + dateArr[1] + " " + dateArr[2]+"\n");
                isValid = false;
            }
           
        daysInMonth = getNumberOfDaysInMonth(year, month);
            
        //MONTH INPUT ERROR
            if((month<1 || month>12)){        
            System.out.printf("ERROR:  Invalid month: %d\n",month);
            isValid=false;
            }
            
        //DAY INPUT ERROR
            if((day<1 || day> daysInMonth)){
            
            System.out.printf("ERROR:  Invalid day: %d, for numeric month = %d, (year = %d)\n",day,month,year);
            System.out.println("ERROR:  Invalid Date string \"" + input + "\" resulted in invalid numeric date:"
                    + "month=" + month+ ", day=" +day +", year=" + year);
            isValid=false;
            }
            
        //YEAR INPUT ERROR
            if((year<1900 || year>2100)){
            System.out.printf("ERROR:  Invalid year %d. Year must be between 1900 and 2100.\n",year);
            isValid=false;
            }
            
            
            if(isValid) {

            for (int i = 0; i < (month - 1); i++) {

                if (isLeapYear(year)) {

                    count += (monthDaysLeap[i]);
                } else {
                    count += (monthDays[i]);
                }

            }
            count += day;
            System.out.println(count + " days have elapsed from Jan 01, " +year+ " to " + monthNames[month - 1] + " " + day + ", " + year + ".\n");
            isRunning = false;}
            
            isValid = true;
            System.out.println("Please enter numeric date (or q to exit program): ");
            isRunning = true;
            input = console.nextLine();}
            
        }  // end of public static void
    
    //Method to return the number of days in month
 public static int getNumberOfDaysInMonth (int y, int m) {
    if (m == 1 || m == 3 || m == 5 || m ==7 || m == 8 || m == 10 || m == 12)
        return 31;
    
    if (m == 4 || m == 6 || m == 9 || m == 11)
        return 30;
    
    if (m == 2) return isLeapYear (y)?29:28;   
        return 0;
}


//Method to check if year,y is leap or not
static boolean isLeapYear (int y) {
return ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0)));
}
} // end of public class
  
