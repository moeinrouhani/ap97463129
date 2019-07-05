package assignment10;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.*;
import java.util.*;

public class Links {

    String url = "";
    String location = "";
    int    linkNUmToDownload;



    public Links(){  }

    public Links(String url , String path , int number){

        this.url = url;
        this.location = path;
        this.linkNUmToDownload = number;

        String[] splitURL = url.split ( "//" );
        domain = splitURL[1];

    }

    String domain;
    String stringOfLinks      = url + "\n" ;
    String stringOfMinedLinks = "";

    Set<String> setOfString = new HashSet<> ();
    PriorityQueue <String> queueOfString = new PriorityQueue<> ();



    public void getLinks( String url ){

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            String check ;

            for (Element link : links)
            {
                check = link.attr ( "abs:href" );
                if (check.contains ( domain ) && !setOfString.contains ( check ))
                {
                    setOfString.add ( check );
                    queueOfString.offer ( check );
                    stringOfLinks = stringOfLinks + check + "\n" ;
                }

            }

        } catch (IOException e) {
            e.printStackTrace ();
        }


    }



    public void mineLinks(){

        int i = 0;
        while ( i  < linkNUmToDownload)
        {
            getLinks ( queueOfString.peek () );
            stringOfMinedLinks = stringOfMinedLinks + queueOfString.peek() + "\n";
            queueOfString.poll ();
            i++;
            if (i % 10 == 0)
            {
                System.out.println ("\nmined linkes till now :" + i + "\n" + stringOfMinedLinks);
                System.out.println ("\nall the links : \n" + queueOfString );
            }

        }

        saveToFile (  );
    }


    public void saveToFile(){

        try {

            File file = new File ( location );
            FileWriter fileWriter = new FileWriter ( file  );
            fileWriter.write ( url + "\n" );
            fileWriter.write ( stringOfLinks + "\n");
            fileWriter.flush ();

        } catch (IOException e) {
            e.printStackTrace ();
        }

    }


}
