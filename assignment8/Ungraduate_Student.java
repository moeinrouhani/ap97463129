package assignment8;

import java.io.*;
import java.util.*;

public class Ungraduate_Student extends Student{

    private int passedUnits;


    //***** Constructors part *****

    public Ungraduate_Student() throws FileNotFoundException {

    }

    public Ungraduate_Student(String firstName , String lastName , int studentNumber ,int passedUnits) throws FileNotFoundException {

        this.setFirstName ( firstName );
        this.setLastName ( lastName );
        this.setStudentNumber ( studentNumber );

        try{
            if (passedUnits < 250)
                this.passedUnits = passedUnits;
        }
        catch (Exception e)
        {
            System.out.println ("passed units must be under 250");
        }
    }

    //***** Constructors part *****




    private PrintWriter UnGraduatedPW = new PrintWriter ("UnGraduated_Student_File.txt") ;
    Scanner sc = new Scanner ( System.in );


    public void GetUnGraduatedStudent() throws IOException {
        System.out.print ("enter the first name of your student:\t");
        setFirstName ( sc.next () );
        System.out.print ("enter the last name of your student:\t");
        setLastName ( sc.next () );
        System.out.print ("enter the student number of your student:\t");
        setStudentNumber ( sc.nextInt () );
        System.out.print ("enter the passed units of your student:\t");

        passedUnits = sc.nextInt ();
        try {
            if (passedUnits < 250)
                setPassedUnits ( passedUnits );
        }catch (Exception e){
            System.out.println ("graduate year must be less than 1380");
            setPassedUnits ( 0 );
        }


        toString ();
    }


    public int getPassedUnits() {
        return passedUnits;
    }

    public void setPassedUnits(int passedUnits) {
        if (passedUnits<250)
            this.passedUnits = passedUnits;
    }

    //***** override part *****

    @Override
    public String toString (){
        UnGraduatedPW.println ( getFirstName () + "\t" + getLastName () + "\t" + getStudentNumber () + "\t" + getPassedUnits () + "\n");
        //UnGraduatedPW.printf ( "%s \t %s \t %d \t %d" , getFirstName () , getLastName () , getStudentNumber () , getPassedUnits ()  );
        System.out.printf ( "%s \t %s \t %d \t %d" , getFirstName () , getLastName () , getStudentNumber () , getPassedUnits ()  );
        UnGraduatedPW.close ();
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
