package assignment3;

import java.util.Random;
import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {

        System.out.println ("enter a number:");
        Scanner numget = new Scanner ( System.in );
        int num = numget.nextInt ();



        int mainArray[][]= new int[num][num];
        Random rand = new Random (  );


        //putting random nums in the array
        for (int i=0 ; i<num ; i++)
        {
            for (int j=0 ; j<num ; j++)
            {
                int value = rand.nextInt ( 100 );
                mainArray[i][j] = value;
            }
        }


        //printing the array
        for (int i=0 ; i<num ; i++)
        {
            for (int j=0 ; j<num ; j++)
            {
                System.out.print (mainArray[i][j] + "  ");
            }
            System.out.println ( );
        }
        System.out.println ( );
        System.out.println ( );


        //print the array in the wanted way
        int y=0;
        int x=0;
        int holder=1;
        boolean checker = false;
        boolean firstchecker = false;
        boolean secondchecker = false;
        while (checker == false)
        {


            while (firstchecker == false)
            {
                System.out.print (mainArray[y][x] + "\t , \t");

                if (x==0)
                {
                    y=0;
                    x=holder;
                    holder++;
                }

                else
                {
                    y++;
                    x--;

                }

                if (holder>=num-1)
                    holder = num-1;

                if (y == num-1 && x == 0)
                    firstchecker = true;
            }


            holder = 1;
            while (secondchecker == false)
            {
                System.out.print (mainArray[y][x] + "\t , \t");

                if (y == num-1)
                {
                    x = num-1;
                    y = holder;
                    holder++;
                }

                else
                {
                    x--;
                    y++;
                }

                if (holder>=num-1)
                    holder = num-1;

                if (y == num-1 && x == num-1)
                    secondchecker = true;
            }


            System.out.println (mainArray[num-1][num-1]);
            checker = true;
        }
    }

}
