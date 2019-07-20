package UniversityProj.uni.GUI.Student;



import UniversityProj.uni.GUI.FirstFrame;
import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentFirstFrame extends JFrame {

    public StudentFirstFrame(ArrayList<Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                             ArrayList<Student> studentArrayList , ArrayList <Classes> classesArrayList , String nameOfStudent )
    {

        JButton myClasses = new JButton ( "My classes/Delete" );
        myClasses.setBounds ( 100 , 100 , 250 , 50 );
        myClasses.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible ( false );
                MyClasses_Student m = new MyClasses_Student ( managerArrayList, professorArrayList, studentArrayList, classesArrayList, nameOfStudent );

            }
        } );
        add ( myClasses );



        JButton allClasses = new JButton ( "List of classes/Take" );
        allClasses.setBounds ( 450 , 100 , 250 , 50 );
        allClasses.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible ( false );
                AllClasses_Student a = new AllClasses_Student ( managerArrayList, professorArrayList, studentArrayList, classesArrayList, nameOfStudent );

            }
        } );
        add ( allClasses );



        JButton logoutBtn = new JButton ( "Log out" );
        logoutBtn.setBounds ( 100 , 650 , 600 , 50 );
        logoutBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible ( false );
                FirstFrame firstFrame = new FirstFrame (managerArrayList, professorArrayList, studentArrayList ,classesArrayList);

            }
        } );
        add ( logoutBtn );



        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setTitle ( "*** Student ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }

}
