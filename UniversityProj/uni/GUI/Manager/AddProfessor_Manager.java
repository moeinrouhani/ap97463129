package UniversityProj.uni.GUI.Manager;

import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddProfessor_Manager extends JFrame {

    public AddProfessor_Manager(ArrayList<Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                                ArrayList<Student> studentArrayList , ArrayList <Classes> classesArrayList ){

        JLabel nameLabel = new JLabel ( "Name :" );
        nameLabel.setBounds ( 100 , 100 , 100 , 50 );
        add(nameLabel);

        JTextField nameText = new JTextField (  );
        nameText.setBounds ( 200 , 100 , 400 , 50 );
        add ( nameText );



        JLabel passwordLabel = new JLabel ( "password :" );
        passwordLabel.setBounds ( 100 , 200 , 100 , 50 );
        add(passwordLabel);

        JTextField passwordText = new JTextField (  );
        passwordText.setBounds ( 200 , 200 , 400 , 50 );
        add ( passwordText );



        JRadioButton radioButton1 = new JRadioButton ( "Male" );
        JRadioButton radioButton2 = new JRadioButton ( "Female" );
        radioButton1.setBounds ( 100, 300, 100, 50 );
        radioButton2.setBounds ( 200, 300, 100, 50 );
        ButtonGroup bg = new ButtonGroup ();
        bg.add ( radioButton1 );
        bg.add ( radioButton2 );
        radioButton1.setSelected ( true );
        add ( radioButton1 );
        add ( radioButton2 );



        JButton addStudentbtn = new JButton ( "Add Professor" );
        addStudentbtn.setBounds ( 100 , 650 , 250 , 50 );
        addStudentbtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String sex;
                if (radioButton1.isSelected ())
                    sex = "male";
                else
                    sex = "female";


                if (!nameText.getText ().isEmpty () && !passwordText.getText ().isEmpty ())
                {

                    Professor p1 = new Professor ( nameText.getText () , sex , passwordText.getText () );
                    professorArrayList.add ( p1 );
                    setVisible ( false );
                    AddProfessor_Manager addProfessor_manager = new AddProfessor_Manager ( managerArrayList, professorArrayList, studentArrayList, classesArrayList );
                    JOptionPane.showMessageDialog ( null, "Professor added" );

                }
                else {
                    JOptionPane.showMessageDialog ( null, "field empty!!!" );
                }



            }
        } );
        add ( addStudentbtn );



        JButton backbtn = new JButton ( "Back" );
        backbtn.setBounds ( 450 , 650 , 250 , 50 );
        backbtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                ManagerFirstFrame mff = new ManagerFirstFrame (managerArrayList, professorArrayList,
                        studentArrayList,classesArrayList );
                setVisible ( false );

            }
        } );
        add ( backbtn );



        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setTitle ( "*** ADD PROFESSOR ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }

}
