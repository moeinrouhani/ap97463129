package GUI;

import Hospital.Patient;
import Hospital.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BuildingManagementFrame extends JFrame {

    public BuildingManagementFrame(){

        Button btn = new Button ( "List of Rooms" );
        btn.setBounds ( 40 , 40 , 720 , 40 );
        btn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    File file = new File("rooms.txt");
                    Scanner scanner = new Scanner(file);
                    String str = "";
                    String string;
                    String [] splitArray ;

                    while(scanner.hasNextLine()){
                        string = scanner.nextLine ();
                        splitArray = string.split ( "," );

                        str +="ROOM KIND:"+ splitArray[1] + "\t\t\t" + "ROOM NUMBER:" + splitArray[2] +"\t\t\tFLOOR NUMBER:"+splitArray[3]
                               + "\t\t\t"+"NUMBER OF BEDS:"+splitArray[4] + "\t\t\t" + "NUMBER OF AVAILABLE BEDS:"+splitArray[5]+"\n";
                    }
                    JOptionPane.showMessageDialog ( null , str , "Rooms" , JOptionPane.PLAIN_MESSAGE);



                    JTextArea jTextArea = new JTextArea ( str );
                    jTextArea.setBounds ( 40 , 100 , 720 , 400 );
                    JScrollPane jScrollPane = new JScrollPane ( jTextArea );
                    jTextArea.setEditable ( false );
                    add(jScrollPane);
                    add(jTextArea);

                }catch(Exception e1){
                    JOptionPane.showMessageDialog ( null , "Error" );
                }



            }
        } );
        add(btn);



        JLabel jLabel4 = new JLabel ( "Enter deleting room number :" );
        jLabel4.setBounds ( 40 ,405 , 200 , 20 );
        add(jLabel4);

        JTextField jTextField4 = new JTextField (  );
        jTextField4.setBounds ( 250 , 400 , 200 , 40 );
        add(jTextField4);



        Button deleteRoom = new Button ( "DELETE Room" );
        deleteRoom.setBounds ( 500 , 400 , 250 , 40 );
        deleteRoom.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jTextField4.getText ().isEmpty ())
                    JOptionPane.showMessageDialog ( null , "Text area empty" );
                else
                {
                Room room = new Room (  );
                room.editFileToDeleteRoom ( Integer.parseInt ( jTextField4.getText () ) );
                JOptionPane.showMessageDialog( null , "done" );
                BuildingManagementFrame buildingManagementFrame = new BuildingManagementFrame ();

                }


            }
        } );
        add(deleteRoom) ;



//        JSeparator separator = new JSeparator ( JSeparator.VERTICAL );
//        add(separator);
//        add(new JSeparator ( JSeparator.VERTICAL ));




        JLabel jLabel1 = new JLabel ( "new Room :" );
        jLabel1.setBounds ( 40 ,505 , 100 , 20 );
        add(jLabel1);

        JTextField jTextField1 = new JTextField (  );
        jTextField1.setBounds ( 150 , 500 , 100 , 40 );
        jTextField1.setText ( "Room ID" );
        add(jTextField1);



        JTextField jTextField3 = new JTextField (  );
        jTextField3.setBounds ( 260 , 500 , 100 , 40 );
        jTextField3.setText ( "floor " );
        add(jTextField3);



        String [] comboxStr = {"Emergernt Room" , "SpecialCare Room" , "Sterilization Room"};
        JComboBox jComboBox = new JComboBox ( comboxStr );
        jComboBox.setBounds ( 370 , 500 , 180 , 40 );
        add(jComboBox);



        JTextField jTextField2 = new JTextField (  );
        jTextField2.setBounds ( 560 , 500 , 100 , 40 );
        jTextField2.setText ( "Beds Number" );
        add(jTextField2);



        Button btn2 = new Button ( "Add Room" );
        btn2.setBounds ( 40 , 600 , 720 , 40 );
        btn2.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Room room ;
                    if (jComboBox.getSelectedItem ().equals ( "Emergernt Room" ))
                        room = new Room ("EmergerntRoom" , Integer.parseInt ( jTextField1.getText () ),
                                Integer.parseInt ( jTextField3.getText () ), Integer.parseInt ( jTextField2.getText () ));

                    else if (jComboBox.getSelectedItem ().equals ( "SpecialCare Room" ))
                        room = new Room ( "SpecialCareRoom" , Integer.parseInt ( jTextField1.getText () ),
                                Integer.parseInt ( jTextField3.getText () ), Integer.parseInt ( jTextField2.getText () ) );

                    else if (jComboBox.getSelectedItem ().equals ( "Sterilization Room" ))
                    {
                        jTextField2.setText ( "1" );
                        jTextField2.setEditable ( false );
                        room = new Room ( "SterilizationRoom" , Integer.parseInt ( jTextField1.getText () ),
                                Integer.parseInt ( jTextField3.getText () ) , 1 );
                    }

                    JOptionPane.showMessageDialog ( null , "Room Added" , "Rooms" , JOptionPane.PLAIN_MESSAGE);
                    setVisible ( false );
                    BuildingManagementFrame b = new BuildingManagementFrame ();
                }catch(Exception e1) {
                    JOptionPane.showMessageDialog ( null , "error" );
                }

            }
        } );
        add(btn2);



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
        setTitle ( "*** Building Management ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }


}
