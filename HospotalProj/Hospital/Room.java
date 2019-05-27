package Hospital;

import java.io.File;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Room {

    private String isEmpty ;
    private String roomKind;
    private int floorNum;
    private int numberOfBeds;
    private int numberOfAvailableBeds;
    private int roomId;

    File file = new File ( "rooms.txt" );
    FileWriter fw;

    {
        try {
            fw = new FileWriter ( "rooms.txt" ,true);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }


   public Room(){

   }


    public Room(String roomKind, int roomId,int floorNum ,  int numberOfBeds) {

        this.roomKind = roomKind;
        this.roomId = roomId;
        this.floorNum = floorNum;
        this.numberOfBeds = numberOfBeds;
        this.numberOfAvailableBeds = numberOfBeds;
        this.isEmpty = "true";
        saveToFile ();
    }



    public void saveToFile(){
        String s = isEmpty + "," + roomKind + "," + roomId+ "," +floorNum + "," + numberOfBeds+ "," + numberOfAvailableBeds + "\n";

        try {
            fw.write (  s );
            fw.flush ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }


    public void editFileToAddPatient(int RoomNumber){
        File newFile = new File ( "editRooms.txt" );
        Scanner scanner  ;
        try {
            scanner = new Scanner (file);
            FileWriter fileWriter = new FileWriter ( "editRooms.txt" , true );
            String string ;
            String s ="";


            while(scanner.hasNext ()){
                string = scanner.nextLine ();
                String [] splitArray = string.split ( "," );
                int num = Integer.parseInt ( splitArray[2] );

                if (num != RoomNumber  )
                    s = string + "\n";
                else
                {
                    numberOfAvailableBeds = Integer.parseInt ( splitArray[5] );
                    numberOfAvailableBeds--;
                    if (numberOfAvailableBeds == 0)
                        splitArray[0] = "false";
                    if (numberOfAvailableBeds < 0)
                        numberOfAvailableBeds = 0;
                    s = splitArray[0] + "," + splitArray[1] + "," + splitArray[2] + "," + splitArray[3] + ","
                            + splitArray[4] + ","+ numberOfAvailableBeds + "\n";
                }


                fileWriter.write ( s );
            }

            file.delete ();
            newFile.renameTo ( new File ( "rooms.txt" ) );
            fileWriter.flush ();
        } catch (IOException editRoom) {

            editRoom.printStackTrace ();

        }

    }



    public void editRoomFileToReleasePatient(int RoomNumber){
        File newFile = new File ( "editRooms.txt" );
        Scanner scanner  ;
        try {
            scanner = new Scanner (file);
            FileWriter fileWriter = new FileWriter ( "editRooms.txt" , true );
            String string ;
            String s ="";


            while(scanner.hasNext ()){
                string = scanner.nextLine ();
                String [] splitArray = string.split ( "," );
                int num = Integer.parseInt ( splitArray[2] );

                if (num != RoomNumber  )
                    s = string + "\n";
                else {
                    numberOfAvailableBeds = Integer.parseInt ( splitArray[5] );
                    numberOfAvailableBeds++;
                    if (numberOfAvailableBeds > 0)
                        splitArray[0] = "true";

                    numberOfBeds = Integer.parseInt ( splitArray[4] );
                    if (numberOfAvailableBeds > numberOfBeds)
                        numberOfAvailableBeds = numberOfBeds;

                    s = splitArray[0] + "," + splitArray[1] + "," + splitArray[2] + "," + splitArray[3] + ","
                            + splitArray[4] + "," + numberOfAvailableBeds + "\n";
                }


                fileWriter.write ( s );
            }

            file.delete ();
            newFile.renameTo ( new File ( "rooms.txt" ) );
            fileWriter.flush ();
        } catch (IOException editRoom) {

            editRoom.printStackTrace ();

        }
    }



    public void editFileToDeleteRoom(int roomNum){
        File newFile = new File ( "editrooms.txt" );
        Scanner scanner ;
        try {
            scanner = new Scanner (file);
            FileWriter fileWriter = new FileWriter ( "editrooms.txt" , true );
            String string = "";

            while(scanner.hasNext ()){
                string = scanner.nextLine ();
                String [] splitArray = string.split ( "," );
                roomId = Integer.parseInt ( splitArray[2] );
                if (roomId != roomNum  )
                    fileWriter.write ( string + "\n");


            }

            file.delete ();
            newFile.renameTo ( new File ( "rooms.txt" ) );
            fileWriter.flush ();

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }



}

