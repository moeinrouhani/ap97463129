package znu.ap.assignment1;

public class Main {

    public static void main(String[] args) {

        int num = 7;
        int row = (num-1)/2;
        int putSpace = row;
        int putstar = 1;


        //building top part of diamond---------------------------------------------
        for (int lines=0 ; lines<row ; lines++)
        {

            for (int i = putSpace; i > 0; i--)
            {
                System.out.print (" ");
            }
            putSpace--;

            for (int j = 1 ; j <= putstar ; j++)
            {
                System.out.print ("*");
            }
            putstar=putstar+2;


            System.out.println ();
        }

        //building center of diamond---------------------------------------------
        for (int i=1 ; i<=num ; i++)
            System.out.print ("*");

        System.out.println ();
        putSpace = 1;
        putstar = putstar - 2;

        //building bottom part of diamond---------------------------------------------
        for (int lines=0 ; lines<row ; lines++)
        {

            for (int i = 0; i < putSpace; i++)
            {
                System.out.print (" ");
            }
            putSpace++;


            for (int j = 0 ; j < putstar ; j++)
            {
                System.out.print ("*");
            }
            putstar=putstar-2;


            System.out.println ();
        }
    }

}
