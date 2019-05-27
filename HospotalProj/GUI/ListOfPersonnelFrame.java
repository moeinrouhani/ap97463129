package GUI;

import Hospital.Personnel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListOfPersonnelFrame extends JFrame {

    public ListOfPersonnelFrame() {


        Button btn = new Button ( "List of personnel" );
        btn.setBounds ( 40 , 40 , 720 , 40 );
        btn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    File file = new File("personnel.txt");
                    Scanner scanner = new Scanner(file);
                    String str = "";
                    String string;
                    String [] splitArray;

                    while(scanner.hasNextLine()){
                        string = scanner.nextLine ();
                        splitArray = string.split ( "," );
                                str += "NAME:"+ splitArray[0] +"\t\t\tJOB:"+splitArray[1] +
                                        "\t\t\tDEGREE :"+ splitArray[2] + "\t\t\tAGE:"+splitArray[3] + "\n";
                    }
                    JOptionPane.showMessageDialog ( null , str , "Personnel" , JOptionPane.PLAIN_MESSAGE);

                }catch(Exception e1){
                    JOptionPane.showMessageDialog ( null , "Error" );
                }
            }
        } );
        add(btn);



        JLabel jLabel1 = new JLabel ( "Enter firing personnel name :" );
        jLabel1.setBounds ( 40 ,605 , 210 , 20 );
        add(jLabel1);

        JTextField jTextField1 = new JTextField (  );
        jTextField1.setBounds ( 300 , 600 , 450 , 40 );
        add(jTextField1);

        Button btn2 = new Button ( "Fire person" );
        btn2.setBounds ( 40 , 700 , 410 , 40 );
        btn2.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jTextField1.getText ().isEmpty ())
                    JOptionPane.showMessageDialog ( null , "Text area empty" );

                else
                {
                    Personnel personnel = new Personnel (  );
                    personnel.deletePersonnel ( jTextField1.getText () );
                    JOptionPane.showMessageDialog ( null , "Person Fired" , "done" , JOptionPane.PLAIN_MESSAGE);
                    ListOfPersonnelFrame listOfPersonnelFrame = new ListOfPersonnelFrame ();
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
        setTitle ( "*** List / Fire Personnel ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }
}
