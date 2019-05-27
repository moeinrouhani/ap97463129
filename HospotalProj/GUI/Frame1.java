package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame1 extends JFrame {

    public Frame1() throws IOException {

        JButton addPatientButton = new JButton ( "Add Patient" );
        addPatientButton.setBounds ( 40 , 40 , 350 , 150 );
        addPatientButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible ( false );
                AddPatientFrame apf = new AddPatientFrame ();
            }
        } );
        add(addPatientButton);



        JButton releasingPatientButton = new JButton ( "List of patients / Release Patient" );
        releasingPatientButton.setBounds ( 410 , 40 , 350 , 150 );
        releasingPatientButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible ( false );
                ListOfPatientFrame ls = new ListOfPatientFrame ();
            }
        } );
        add(releasingPatientButton);



        JButton addPersonnelButton = new JButton ( "Add personnel" );
        addPersonnelButton.setBounds ( 40 , 420 , 350 , 150 );
        addPersonnelButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible ( false );
                AddPersonnelFrame addPersonnelFrame = new AddPersonnelFrame ();
            }
        } );
        add(addPersonnelButton);



        JButton firePersonnelButton = new JButton ( "list of Personnel / Fire personnel" );
        firePersonnelButton.setBounds ( 410 , 420 , 350 , 150 );
        firePersonnelButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible ( false );
                ListOfPersonnelFrame listOfPersonnelFrame = new ListOfPersonnelFrame ();
            }
        } );
        add(firePersonnelButton);



        JButton listOfPersonnelButton = new JButton ( "Building management" );
        listOfPersonnelButton.setBounds ( 40 , 230 , 720 , 150 );
        listOfPersonnelButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible ( false );
                BuildingManagementFrame b = new BuildingManagementFrame ();
            }
        } );
        add(listOfPersonnelButton);



        setTitle ( "*** Hospital ***" );
        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );
    }
}
