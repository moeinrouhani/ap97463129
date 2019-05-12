package assignment8;

import java.io.*;
import java.util.*;

public class Graduated_Student extends Student {

    private int graduateYear;

    //***** Constructors part *****
    public Graduated_Student() throws FileNotFoundException {

    }

    public Graduated_Student( String firstName , String lastName , int studentNumber , int graduateYear ) throws FileNotFoundException {

        this.setFirstName ( firstName );
        this.setLastName ( lastName );
        this.setStudentNumber ( studentNumber );

        try {
            if (graduateYear>1380)
                this.graduateYear = graduateYear;

        }
        catch (Exception e){
            System.out.println ("graduate year must be more than 1380");
        }
    }
    //***** Constructors part *****





    private PrintWriter GraduatedPW = new PrintWriter ("Graduated_Student_File.txt" ) ;
    Scanner sc = new Scanner ( System.in );

    public void GetGraduatedStudent() throws IOException {
        System.out.print ("enter the first name of your student:\t");
        setFirstName ( sc.next () );
        System.out.print ("enter the last name of your student:\t");
        setLastName ( sc.next () );
        System.out.print ("enter the student number of your student:\t");
        setStudentNumber ( sc.nextInt () );
        System.out.print ("enter the graduate year of your student:\t");

        graduateYear = sc.nextInt ();
        //try {
            if (graduateYear > 1380)
                setGraduateYear ( graduateYear );
        //}catch (Exception e){
        else {
               System.out.println ("graduate year must be more than 1380");
               setGraduateYear ( 0 );}
        //}


        toString ();
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        try {
        if (graduateYear>1380)
            this.graduateYear = graduateYear;

        }
        catch (Exception e){
            System.out.println ("graduate year must be more than 1380");
        }

    }


    //***** override part *****
    @Override
    public String toString (){
        //GraduatedPW.printf ( "%s \t %s \t %d \t %d " , getFirstName () , getLastName () , getStudentNumber () , getGraduateYear ()  );
        GraduatedPW.println ( getFirstName () + "\t" + getLastName () + "\t" + getStudentNumber () + "\t" + getGraduateYear () + "\n");
        System.out.printf ( "%s \t %s \t %d \t %d " , getFirstName () , getLastName () , getStudentNumber () , getGraduateYear ()  );
        GraduatedPW.close ();

        return null;

    }


    @Override
    public int getStudentNumber() {
        return super.getStudentNumber ();
    }

    @Override
    public void setStudentNumber(int studentNumber) {
        super.setStudentNumber ( studentNumber );
    }

    @Override
    public String getFirstName() {
        return super.getFirstName ();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName ( firstName );
    }

    @Override
    public String getLastName() {
        return super.getLastName ();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName ( lastName );
    }

    @Override
    public boolean getGraduateInfo() {
        return super.getGraduateInfo ();
    }

    @Override
    public void setGraduateInfo(boolean graduateInfo) {
        super.setGraduateInfo ( graduateInfo );
    }

    //***** override part *****

}
