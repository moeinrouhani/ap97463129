package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import Hospital.*;

public class AddPatientFrame extends JFrame {

    public AddPatientFrame()   {

        JLabel jLabel1 = new JLabel ( "Enter patients name :" );
        jLabel1.setBounds ( 40 ,50 , 200 , 20 );
        add(jLabel1);

        JTextField jTextField1 = new JTextField (  );
        jTextField1.setBounds ( 250 , 45 , 200 , 40 );
        add(jTextField1);



        JLabel jLabel2 = new JLabel ( "Enter patients disease :" );
        jLabel2.setBounds ( 40 ,150 , 200 , 20 );
        add(jLabel2);

        JTextField jTextField2 = new JTextField (  );
        jTextField2.setBounds ( 250 , 145 , 200 , 40 );
        add(jTextField2);



        JLabel jLabel3 = new JLabel ( "Enter patients age :" );
        jLabel3.setBounds ( 40 ,250 , 200 , 20 );
        add(jLabel3);

        JTextField jTextField3 = new JTextField (  );
        jTextField3.setBounds ( 250 , 245 , 200 , 40 );
        add(jTextField3);



        JLabel jLabel4 = new JLabel ( "Enter patients room number :" );
        jLabel4.setBounds ( 40 ,350 , 200 , 20 );
        add(jLabel4);

        JTextField jTextField4 = new JTextField (  );
        jTextField4.setBounds ( 250 , 345 , 200 , 40 );
        add(jTextField4);



        Button showRoomsBtn = new Button ( "show available rooms" );
        showRoomsBtn.setBounds ( 500 , 345 , 250 , 40 );
        showRoomsBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    File file = new File("rooms.txt");
                    Scanner scanner = new Scanner(file);
                    String str = "";
                    String isEmpty;

                    while(scanner.hasNextLine()){
                        StringTokenizer st = new StringTokenizer(scanner.nextLine(), ",");
                        isEmpty = st.nextToken ();
                        if (isEmpty.equals ( "true" ))
                        str += "ROOM KIND :"+ st.nextToken() + "\t\t\tROOM NUM :"+st.nextToken() +"\t\t\tFLOOR:"+st.nextToken ()+
                                "\t\t\tNUMBER OF BEDS :"+st.nextToken() + "\t\t\tAVAILABLE BEDS :"+st.nextToken() + "\n";


                    }
                    JOptionPane.showMessageDialog ( null , str , "Rooms" , JOptionPane.PLAIN_MESSAGE);

                }catch(Exception e1){
                    JOptionPane.showMessageDialog ( null , "error" );
                }
            }
        } );
        add(showRoomsBtn);




        JLabel jLabel5 = new JLabel ( "choose the doctor:" );
        jLabel5.setBounds ( 40 ,450 , 200 , 20 );
        add(jLabel5);

        JTextField jTextField5 = new JTextField (  );
        jTextField5.setBounds ( 250 , 445 , 200 , 40 );
        add(jTextField5);



        Button showDoctorsBtn = new Button ( "show doctors" );
        showDoctorsBtn.setBounds ( 500 , 445 , 250 , 40 );
        showDoctorsBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    File file2 = new File("doctors.txt");
                    Scanner scanner2 = new Scanner(file2);
                    String str = "";
                    String string;
                    String [] splitArray;

                    while(scanner2.hasNextLine()){
                        string = scanner2.nextLine ();
                        splitArray = string.split ( "," );
                        str += "NAME:"+ splitArray[0] + "\t\t\tSPECIALITY:"+splitArray[2] +"\t\t\tAGE:"+ splitArray[3]+ "\n";

                    }
                    JOptionPane.showMessageDialog ( null , str , "Doctors" , JOptionPane.PLAIN_MESSAGE);

                }catch(Exception e1){
                    JOptionPane.showMessageDialog ( null , "error" );
                }
            }
        } );
        add(showDoctorsBtn);


        Button addButton = new Button ( "add patient" );
        addButton.setBounds ( 40 , 700 , 410 , 40 );
        addButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jTextField1.getText ().isEmpty ()||jTextField2.getText ().isEmpty ()||
                        jTextField3.getText ().isEmpty ()||jTextField4.getText ().isEmpty ()||jTextField5.getText ().isEmpty ()    )
                    JOptionPane.showMessageDialog ( null , "Text area empty" );

                else
                {
                    try{
                        Room room = new Room (  );
                        int numberOfRoom = Integer.parseInt ( jTextField4.getText () );
                        room.editFileToAddPatient ( numberOfRoom );
                    }catch (Exception ee){
                        JOptionPane.showMessageDialog ( null , "edit file error" );
                    }



                    try {
                        JOptionPane.showMessageDialog ( null , "patient added" , "done" , JOptionPane.PLAIN_MESSAGE);
                        setVisible ( false );
                        AddPatientFrame f = new AddPatientFrame ();
                        Patient p = new Patient ( jTextField1.getText () , jTextField2.getText ()
                                        , Integer.parseInt ( jTextField3.getText () )  ,
                                Integer.parseInt ( jTextField4.getText () ) , jTextField5.getText () );

                    } catch ( Exception e2) {
                        e2.printStackTrace ();
                    }

                }



            }
        } );
        add(addButton);



        Button backBtn = new Button ( "back" );
        backBtn.setBounds ( 500 , 700 , 250 , 40 );
        backBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible ( false );
                    Frame1 f1 = new Frame1 ();

                } catch (IOException e1) {
                    e1.printStackTrace ();
                }
            }
        } );
        add(backBtn);



        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setTitle ( "*** Add Patient ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );
    }



}
