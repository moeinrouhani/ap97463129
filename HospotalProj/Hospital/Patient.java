package Hospital;

import java.io.*;
import java.util.*;

public class Patient {

    private String name;
    private String disease;
    private int    age;
    private int roomNum;
    private String doctorOfPatient;


    File file = new File ( "patients.txt" );
    FileWriter fw;

    {
        try {
            fw = new FileWriter ( "patients.txt" , true);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public Patient(){

    }



    public Patient(String name , String disease , int age ,int room ,String doctorOfPatient )  {
        this.name = name;
        this.disease = disease;
        this.age = age;
        roomNum = room;
        this.doctorOfPatient = doctorOfPatient;
        String s = name + "," + disease + "," + age + "," + roomNum + "," + doctorOfPatient + "\n";
        saveToFile (s);
    }



    public void saveToFile(String s){
        try {
            fw.write (s);
            fw.flush ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }


//  method to release patient & delete that from the file
    public void editToRelease(String nameToRelease){

        File newFile = new File ( "editPatients.txt" );
        Scanner scanner ;
        try {
            scanner = new Scanner (file);
            FileWriter fileWriter = new FileWriter ( "editPatients.txt" , true );
            String string = "";
            String nameOfPatient;

            while(scanner.hasNext ()){
                string = scanner.nextLine ();
                String [] splitArray = string.split ( "," );
                nameOfPatient = splitArray[0];
                if (! nameOfPatient.equals ( nameToRelease )  )
                    fileWriter.write ( string + "\n");
                else
                {
                    Room room = new Room (  );
                    int roomNum = Integer.parseInt ( splitArray[3] );
                    //to + the number of available beds
                    room.editRoomFileToReleasePatient ( roomNum);
                }

            }

            file.delete ();
            newFile.renameTo ( new File ( "patients.txt" ) );
            fileWriter.flush ();

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }


    }


}
