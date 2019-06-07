package assignment9;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        String direction;
        String searchName ;
        int layerNum;
        Long startTime=System.currentTimeMillis();
        Scanner scanner = new Scanner ( System.in );

        System.out.print ("Enter Directory : ");
        direction = scanner.next ();

        System.out.print ("Enter layers number : ");
        layerNum = scanner.nextInt ();

        System.out.print ("Enter searching name : ");
        searchName = scanner.next ();

        System.out.println ("\n***********************\n");
        File fileDirection = new File ( direction );

        searchFile ( fileDirection , searchName , layerNum );

        System.out.println("Time : " + (System.currentTimeMillis()-startTime) +" ms");


    }

    public static void searchFile (File f,String searchName,int layerNum)throws IOException{

        int actualLayer = 0;

        for (File directionFile : f.listFiles())
        {
            if (actualLayer <= layerNum-1)
            {

                if (directionFile.isDirectory())
                {

                    if (directionFile.getName().contains(searchName))
                    {
                        System.out.println("FileName:"+directionFile.getName()+"\tDirectory:"+directionFile.getAbsolutePath()+"\n");
                        saveToFile ( directionFile.getName() , directionFile.getAbsolutePath() );
                        addToHashmap (  directionFile.getName() , directionFile.getAbsolutePath() );
                    }

                    actualLayer++;
                    searchFile ( directionFile , searchName , layerNum );
                    actualLayer--;
                }
                else
                {
                    if (directionFile.getName().contains(searchName))
                    {

                        System.out.println("FileName:"+directionFile.getName()+"\tDirectory:"+directionFile.getAbsolutePath()+"\n");
                        saveToFile ( directionFile.getName() , directionFile.getAbsolutePath() );
                        addToHashmap ( directionFile.getName() , directionFile.getAbsolutePath() );
                        actualLayer=layerNum+10;

                    }
                }

            }
        }
    }



    public static void saveToFile(String name , String path) throws IOException{

        File searched = new File ( "searched.txt" );
        FileWriter fileWriter = new FileWriter ( "searched.txt" ,true );
        String s =  name + "\t,\t" + path + "\n";
        fileWriter.write ( s );
        fileWriter.flush ();
    }



    public static void addToHashmap(String key , String value){
        HashMap<String , String > hashMap = new HashMap<> (  );
        hashMap.put ( key , value );
    }

}
