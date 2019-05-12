package assignment8;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        int num;
        char Cheker ;
        System.out.print ("enter the number of students you're going to enter:");

        Scanner sc = new Scanner ( System.in );
        Scanner sc2 = new Scanner ( System.in );
        num = sc.nextInt ();


        File Gfile = new File ("/Users/mac/Documents/java/test-tamrin-8/src/assignment8/Graduated_Student_File.txt");

        Gfile.createNewFile ();
        File UnGfile = new File ("/Users/mac/Documents/java/test-tamrin-8/src/assignment8/UnGraduated_Student_File.txt");

        UnGfile.createNewFile ();


        String[] studentInfo = new String[num];
        String infoFirstNameSetter = null;
        String infoLastNameSetter;
        int infoNumSetter1 ;
        int infoNumSetter2 ;

        //*****getting the students information begins*****


        PrintWriter GraduatedPW = new PrintWriter ("Graduated_Student_File.txt") ;
        PrintWriter UnGraduatedPW = new PrintWriter ("UnGraduated_Student_File.txt") ;

        for (int i=0 ; i<num ; i++)
        {
            System.out.print ("\nis the "+ (i+1) +"th student graduated?(true or false)");
            Cheker = sc2.next ().charAt ( 0 );


            if (Cheker == 't')
            {
                /*System.out.print ("\nenter the first name of your "+ (i+1) +"th student");
                infoFirstNameSetter = sc.next ();
                //GraduatedPW.print (infoFirstNameSetter + "\t");

                System.out.print ("\nenter the last name of your "+ (i+1) +"th student");
                infoLastNameSetter = sc.next ();
                //GraduatedPW.print (infoLastNameSetter + "\t");

                System.out.print ("\nenter the student number of your "+ (i+1) +"th student");
                infoNumSetter1 = sc.nextInt ();
                //GraduatedPW.print (infoNumSetter1 + "\t");

                System.out.print ("\nenter the graduate year of your "+ (i+1) +"th student");
                infoNumSetter2 = sc.nextInt ();
                //GraduatedPW.print (infoNumSetter2 + "\t");


                //GraduatedPW.println ( "," );*/

                //Graduated_Student Gs = new Graduated_Student ( infoFirstNameSetter , infoLastNameSetter , infoNumSetter1, infoNumSetter2 );
                Graduated_Student Gs=new Graduated_Student (  );
                Gs.GetGraduatedStudent ();
                //GraduatedPW.println ( Gs );
            }


            else if (Cheker == 'f')
            {
                /*System.out.println ("\nenter the first name of your "+ (i+1) +"th student");
                infoFirstNameSetter = sc.next ();
                UnGraduatedPW.print (infoFirstNameSetter + "\t");

                System.out.println ("\nenter the last name of your "+ (i+1) +"th student");
                infoLastNameSetter = sc.next ();
                UnGraduatedPW.print (infoLastNameSetter + "\t");

                System.out.println ("\nenter the student number of your "+ (i+1) +"th student");
                infoNumSetter1 = sc.nextInt ();
                UnGraduatedPW.print (infoNumSetter1 + "\t");

                System.out.println ("\nenter the passed units of your "+ (i+1) +"th student");
                infoNumSetter2 = sc.nextInt ();
                UnGraduatedPW.print (infoNumSetter2 + "\t");

                GraduatedPW.println ( "," );

                Ungraduate_Student Ugs = new Ungraduate_Student (infoFirstNameSetter , infoLastNameSetter, infoNumSetter1 , infoNumSetter2 );*/
                Ungraduate_Student Ugs = new Ungraduate_Student (  );
                Ugs.GetUnGraduatedStudent ();
            }

            else
                break;

        }

        GraduatedPW.close ();
        UnGraduatedPW.close ();
        //*****getting the students information ends*****



        /*String line = new String (  );

        Scanner sc3 = new Scanner ( file );
        while (sc3.hasNext ()){
            line = sc3.next ();
        }*/



    }
}
