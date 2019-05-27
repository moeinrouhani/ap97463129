package Hospital;

import javax.swing.*;
import java.io.File;
import java.io.*;
import java.util.Scanner;

public class Personnel {

    String name;
    String job;
    String degree;
    int age;

    File file = new File ( "personnel.txt" );
    File fileDoctor = new File ( "doctors.txt" );


    FileWriter fw;
    {
        try {
            fw = new FileWriter ( "personnel.txt" ,true);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    FileWriter fw2;
    {
        try {
            fw2 = new FileWriter ( "doctors.txt" , true );
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }


    public Personnel(){

    }

    public Personnel(String name , String job , String degree , int age)   {

        this.name = name;
        this.job = job;
        this.degree = degree;
        this.age = age;
        saveToFilePersonnel ();

        if (this.job.equals ( "doctor" ))

            saveToFileDoctor ();

    }



    public void saveToFilePersonnel(){
        String s =  name + "," + job + "," + degree + "," + age + "\n";

        try {
            fw.write (  s );
            fw.flush ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }



    public void saveToFileDoctor(){
        String s2 =  this.name + "," +this.job + "," + this.degree + "," + this.age + "\n";

        try {
            fw2.write ( s2 );
            fw2.flush ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }



    public void deletePersonnel (String nameOfPerson){
        File newFile = new File ( "editPersonnel.txt" );
        Scanner scanner ;
        try {
            scanner = new Scanner (file);
            FileWriter fileWriter = new FileWriter ( "editPersonnel.txt" , true );
            String string = "";
            String name;

            while(scanner.hasNext ()){
                string = scanner.nextLine ();
                String [] splitArray = string.split ( "," );
                name = splitArray[0];
                if (! name.equals ( nameOfPerson )  )
                    fileWriter.write ( string + "\n");
                else
                    deleteDoctor ( name );

            }

            file.delete ();
            newFile.renameTo ( new File ( "personnel.txt" ) );
            fileWriter.flush ();

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }



    public void deleteDoctor(String nameOfDoctor){
        File oldFile = new File ( "doctors.txt" );
        File newFile = new File ( "editDoctors.txt" );
        Scanner scanner ;
        try {
            scanner = new Scanner (oldFile);
            FileWriter fileWriter = new FileWriter ( "editDoctors.txt" , true );
            String string = "";
            String name;

            while(scanner.hasNext ()){
                string = scanner.nextLine ();
                String [] splitArray = string.split ( "," );
                name = splitArray[0];
                if (! name.equals ( nameOfDoctor )  )
                    fileWriter.write ( string + "\n");

            }

            oldFile.delete ();
            newFile.renameTo ( new File ( "doctors.txt" ) );
            fileWriter.flush ();

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

}
