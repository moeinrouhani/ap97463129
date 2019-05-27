package GUI;

import Hospital.Patient;
import Hospital.Personnel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddPersonnelFrame extends JFrame {

    public AddPersonnelFrame(){

        JLabel jLabel1 = new JLabel ( "Enter persons name :" );
        jLabel1.setBounds ( 40 ,50 , 200 , 20 );
        add(jLabel1);

        JTextField jTextField1 = new JTextField (  );
        jTextField1.setBounds ( 250 , 45 , 200 , 40 );
        add(jTextField1);



        JLabel jLabel2 = new JLabel ( "Enter persons job:" );
        jLabel2.setBounds ( 40 ,150 , 200 , 20 );
        add(jLabel2);

        JTextField jTextField2 = new JTextField (  );
        jTextField2.setBounds ( 250 , 145 , 200 , 40 );
        add(jTextField2);



        JLabel jLabel3 = new JLabel ( "Enter persons degree :" );
        jLabel3.setBounds ( 40 ,250 , 200 , 20 );
        add(jLabel3);

        JTextField jTextField3 = new JTextField (  );
        jTextField3.setBounds ( 250 , 245 , 200 , 40 );
        add(jTextField3);



        JLabel jLabel4 = new JLabel ( "Enter persons age :" );
        jLabel4.setBounds ( 40 ,350 , 200 , 20 );
        add(jLabel4);

        JTextField jTextField4 = new JTextField (  );
        jTextField4.setBounds ( 250 , 345 , 200 , 40 );
        add(jTextField4);



        Button addButton = new Button ( "Add to personnel" );
        addButton.setBounds ( 40 , 700 , 410 , 40 );
        addButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jTextField1.getText ().isEmpty ()||jTextField2.getText ().isEmpty ()||
                        jTextField3.getText ().isEmpty ()||jTextField4.getText ().isEmpty ()    )
                    JOptionPane.showMessageDialog ( null , "Text area empty" );

                else
                {
                try {
                    JOptionPane.showMessageDialog ( null , "Person added" , "done" , JOptionPane.PLAIN_MESSAGE);
                    setVisible ( false );
                    AddPersonnelFrame f = new AddPersonnelFrame ();
                    Personnel p = new Personnel ( jTextField1.getText () , jTextField2.getText ()
                            ,  jTextField3.getText () , Integer.parseInt ( jTextField4.getText () ) );


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
        setTitle ( "*** Add Personnel ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );
    }
}
