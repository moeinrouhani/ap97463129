package UniversityProj.uni.GUI.Manager;

import UniversityProj.uni.GUI.FirstFrame;
import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagerFirstFrame extends JFrame {

    public ManagerFirstFrame(ArrayList<Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                             ArrayList<Student> studentArrayList ,ArrayList <Classes> classesArrayList ){

        JButton addStudentbtn = new JButton ( "Add student" );
        addStudentbtn.setBounds ( 100 , 100 , 250 , 50 );
        addStudentbtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddStudent_Manager addStudent_manager = new AddStudent_Manager (managerArrayList, professorArrayList, studentArrayList,classesArrayList );
                setVisible ( false );

            }
        } );
        add ( addStudentbtn );



        JButton addProfessor = new JButton ( "Add professor" );
        addProfessor.setBounds ( 450 , 100 , 250 , 50 );
        addProfessor.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddProfessor_Manager addProfessor_manager = new AddProfessor_Manager (managerArrayList, professorArrayList, studentArrayList ,classesArrayList);
                setVisible ( false );

            }
        } );
        add ( addProfessor );



        JButton addClass = new JButton ( "Add class" );
        addClass.setBounds ( 100 , 200 , 250 , 50 );
        addClass.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddClass_Manager addClass_manager = new AddClass_Manager (managerArrayList, professorArrayList, studentArrayList ,classesArrayList);
                setVisible ( false );

            }
        } );
        add ( addClass );



        JButton listOfclas = new JButton ( "List of classes" );
        listOfclas.setBounds ( 450 , 200 , 250 , 50 );
        listOfclas.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                ListOfClasses_Manager lcm = new ListOfClasses_Manager (managerArrayList, professorArrayList, studentArrayList ,classesArrayList);
                setVisible ( false );

            }
        } );
        add ( listOfclas );



        JButton logoutBtn = new JButton ( "Log out" );
        logoutBtn.setBounds ( 100 , 650 , 600 , 50 );
        logoutBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible ( false );
                FirstFrame f = new FirstFrame (  managerArrayList , professorArrayList ,studentArrayList ,classesArrayList );

            }
        } );
        add ( logoutBtn );



        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setTitle ( "*** Manager ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }



}
