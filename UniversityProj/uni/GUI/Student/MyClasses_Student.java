package UniversityProj.uni.GUI.Student;

import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyClasses_Student extends JFrame {


    public MyClasses_Student(ArrayList<Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                             ArrayList<Student> studentArrayList , ArrayList <Classes> classesArrayList , String nameOfStudent)
    {

        JLabel listOfClassesLabel = new JLabel ( " My classes{" );
        listOfClassesLabel.setBounds ( 0 , 100 , 100 , 50 );
        add ( listOfClassesLabel );

        JTextArea classesArea = new JTextArea ();
        classesArea.setEditable ( false );
        JScrollPane classesScroll = new JScrollPane ( classesArea );
        classesScroll.setBounds ( 100, 100, 600, 400 );
        add ( classesScroll );



        for (int n=0 ; n < classesArrayList.size () ; n++)
        {

            int score = 0;

            for (int i=0 ; i < classesArrayList.get ( n ).getEachClassArray ().size () ; i++)
            {

                if (nameOfStudent.equals ( classesArrayList.get ( n ).getEachClassArray ().get ( i ).getName () ))
                {

                    score = classesArrayList.get ( n ).getEachClassArray ().get ( i ).getScore ();
                    classesArea.append ( classesArrayList.get ( n ).getClassName ()+ "\t" + classesArrayList.get ( n ).getProfessorOfClass ()+
                            "\t"+ classesArrayList.get ( n ).getPlaceOfClass () +"\t"+ classesArrayList.get ( n ).getTimeOfClass () +
                            "\tscore :"+ classesArrayList.get ( n ).getEachClassArray ().get ( i ).
                            getScoreFromMap (classesArrayList.get ( n ).getClassName () ) +"\n" );

                }

            }

        }




        JLabel dltNameLabel = new JLabel ( "Name to delete:" );
        dltNameLabel.setBounds ( 100 , 550 , 100 , 50 );
        add ( dltNameLabel );

        JTextField dltNameText = new JTextField (  );
        dltNameText.setBounds ( 200 , 550 , 400 , 50 );
        add ( dltNameText );



        JButton deleteClassBtn = new JButton ( "Delete class " );
        deleteClassBtn.setBounds ( 100 , 650 , 250 , 50 );
        deleteClassBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if (!dltNameText.getText ().isEmpty ())
                {

                    for (int x=0 ; x < classesArrayList.size () ; x++)
                    {

                        if (dltNameText.getText ().equals ( classesArrayList.get ( x ).getClassName () ))
                        {

                            classesArrayList.get ( x ).deleteStudentFromClassesArray ( nameOfStudent );

                            JOptionPane.showMessageDialog ( null, "Class deleted" );
                            setVisible ( false );
                            MyClasses_Student myClasses_student = new MyClasses_Student ( managerArrayList, professorArrayList, studentArrayList, classesArrayList, nameOfStudent );

                        }

                    }


                }
                else
                    JOptionPane.showMessageDialog ( null , "field empty!!!" );

            }
        } );
        add ( deleteClassBtn );



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
