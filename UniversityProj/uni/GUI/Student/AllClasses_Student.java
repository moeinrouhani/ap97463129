package UniversityProj.uni.GUI.Student;

import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AllClasses_Student extends JFrame {

    public AllClasses_Student(ArrayList<Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                              ArrayList<Student> studentArrayList , ArrayList <Classes> classesArrayList, String nameOfStudent )
    {

        JLabel listOfClassesLabel = new JLabel ( "    All classes{" );
        listOfClassesLabel.setBounds ( 0 , 100 , 100 , 50 );
        add ( listOfClassesLabel );



        JTextArea classesArea = new JTextArea ();
        classesArea.setEditable ( false );
        JScrollPane classesScroll = new JScrollPane ( classesArea );
        classesScroll.setBounds ( 100, 100, 600, 400 );
        add ( classesScroll );

        for (int n=0 ; n < classesArrayList.size () ; n++)
        {

            boolean studentHasThatClass = false;

            for (int i=0 ; i < classesArrayList.get ( n ).getEachClassArray ().size () ; i++)
            {

                if (nameOfStudent.equals ( classesArrayList.get ( n ).getEachClassArray ().get ( i ).getName () ))
                    studentHasThatClass = true;

            }
            if (studentHasThatClass == false)
                classesArea.append ( classesArrayList.get ( n ).getClassName ()+ "\t" + classesArrayList.get ( n ).getProfessorOfClass ()+
                        "\t"+ classesArrayList.get ( n ).getPlaceOfClass () +"\t"+ classesArrayList.get ( n ).getTimeOfClass () +"\n" );

        }



        JLabel takeNameLabel = new JLabel ( "Name to take :" );
        takeNameLabel.setBounds ( 100 , 550 , 100 , 50 );
        add ( takeNameLabel );

        JTextField takeNameText = new JTextField (  );
        takeNameText.setBounds ( 200 , 550 , 400 , 50 );
        add ( takeNameText );



        JButton AddClass = new JButton ( "Add Class" );
        AddClass.setBounds ( 100 , 650 , 250 , 50 );
        AddClass.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Student st = null;

                if (!takeNameText.getText ().isEmpty ())
                {
                    for (int x=0 ; x < studentArrayList.size () ; x++)
                    {

                        if (nameOfStudent.equals ( studentArrayList.get ( x ).getName () ))
                        {

                            st = studentArrayList.get ( x );

                        }

                    }

                    for (int x=0 ; x < classesArrayList.size () ; x++)
                    {

                        if (takeNameText.getText ().equals ( classesArrayList.get ( x ).getClassName () ))
                        {

                            classesArrayList.get ( x ).addStudentToEachClassArray ( st );
                            st.addScoreToMap ( classesArrayList.get ( x ).getClassName () , 0 );

                            JOptionPane.showMessageDialog ( null, "Class added" );
                            setVisible ( false );
                            AllClasses_Student allClassesStudent = new AllClasses_Student ( managerArrayList, professorArrayList, studentArrayList, classesArrayList, nameOfStudent );

                        }

                    }

                }
                else
                    JOptionPane.showMessageDialog ( null , "Field empty!!!" );

            }
        } );
        add ( AddClass );



        JButton backbtn = new JButton ( "Back" );
        backbtn.setBounds ( 450 , 650 , 250 , 50 );
        backbtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                StudentFirstFrame firstFrame = new StudentFirstFrame ( managerArrayList, professorArrayList, studentArrayList ,classesArrayList,nameOfStudent);
                setVisible ( false );

            }
        } );
        add ( backbtn );




        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setTitle ( "*** Student ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }

}
