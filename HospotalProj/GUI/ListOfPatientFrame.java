package GUI;

import Hospital.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListOfPatientFrame extends JFrame {




    public ListOfPatientFrame(){

        Button btn = new Button ( "List of patients" );
        btn.setBounds ( 40 , 40 , 720 , 40 );
        btn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    File file = new File("patients.txt");
                    Scanner scanner = new Scanner(file);
                    String str = "";


                    while(scanner.hasNextLine()){
                        StringTokenizer st = new StringTokenizer(scanner.nextLine(), ",");
                        str +="NAME:"+ st.nextToken() + "\t\t\t" + " DISEASE :" +st.nextToken() +
                                 "\t\t\tAGE :"+st.nextToken() + "\t\t\tROOM NUMBER :"+st.nextToken() +"\t\t\tDOCTOR NAME :"+st.nextToken()+ "\n";
                    }
                    JOptionPane.showMessageDialog ( null , str , "Patients" , JOptionPane.PLAIN_MESSAGE);



                    JTextArea jTextArea = new JTextArea ( str );
                    jTextArea.setBounds ( 40 , 100 , 720 , 400 );
                    JScrollPane jScrollPane = new JScrollPane ( jTextArea );
                    jTextArea.setEditable ( false );
                    add(jScrollPane);

                }catch(Exception e1){
                    JOptionPane.showMessageDialog ( null , "Error" );
                }



            }
        } );
        add(btn);



   /*     JTable jtablee = new JTable (  );
        DefaultTableColumnModel model = (DefaultTableColumnModel) jtablee.getModel ();
        Object [] row = new Object [5];
        File file = new File("patients.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner (file);
            String string;
            String [] splitArray ;
            String [][] data = new String[0][];
            String [] columns = new String[]{"NAME", "DISEASE", "AGE", "ROOM NUMBER", "DOCTOR NAME"};

            while(scanner.hasNextLine()){
                for (int i=0 ; scanner.hasNext () ; i++ )
                {
                    string = scanner.nextLine ();
                    splitArray = string.split ( "," );
                    data[i][0] = splitArray[0];
                    data[i][1] = splitArray[1];
                    data[i][2] = splitArray[2];
                    data[i][3] = splitArray[3];
                    data[i][4] = splitArray[4];


                }
            }
            JTable jTable1 = new JTable ( data , columns );
            jTable1.setPreferredScrollableViewportSize ( new Dimension ( 700 , 400 ) );
            jTable1.setLocation ( 50 , 50 );
            jTable1.setFillsViewportHeight ( true );

            JScrollPane jScrollPane = new JScrollPane ( jTable1 );
            add(jScrollPane);
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }*/



        JLabel jLabel1 = new JLabel ( "Enter releasing patients name :" );
        jLabel1.setBounds ( 40 ,605 , 210 , 20 );
        add(jLabel1);

        JTextField jTextField1 = new JTextField (  );
        jTextField1.setBounds ( 300 , 600 , 450 , 40 );
        add(jTextField1);

        Button btn2 = new Button ( "Release patient" );
        btn2.setBounds ( 40 , 700 , 410 , 40 );
        btn2.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Patient patient = new Patient (  );
                    patient.editToRelease ( jTextField1.getText () );
                    JOptionPane.showMessageDialog ( null , "patient released" , "Patients" , JOptionPane.PLAIN_MESSAGE);
                    setVisible ( false );
                    ListOfPatientFrame listOfPatientFrame = new ListOfPatientFrame ();
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
        setTitle ( "*** List / Release Patients ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }


}
