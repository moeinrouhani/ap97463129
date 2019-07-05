package assignment10;

import assignment10.Links;

import java.util.*;

public class Main {
    public static void main(String[] args)  {

        String url;
        String savePath;
        int pageNUmToDownload;

        Scanner sc1 = new Scanner ( System.in );

        System.out.print ("Enter URL in this way (https//...) : ");
        url = sc1.next ();

        System.out.print ("\n\nEnter your saving path (without .txt) : ");
        savePath = sc1.next ();
        savePath = savePath + ".txt";

        System.out.print ( "\n\nEnter number of pages that you want to download : " );
        pageNUmToDownload = sc1.nextInt ();



        Links links = new Links ( url , savePath , pageNUmToDownload );
        links.getLinks ( url );
        links.mineLinks ();

//        /Users/mac/Documents/java/downloader/links
//        https://stackoverflow.com




    }
}
