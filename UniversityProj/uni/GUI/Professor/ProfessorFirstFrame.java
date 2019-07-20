package UniversityProj.uni.GUI.Professor;

import UniversityProj.uni.GUI.FirstFrame;
import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfessorFirstFrame extends JFrame {

    public ProfessorFirstFrame (ArrayList<Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                                ArrayList<Student> studentArrayList , ArrayList <Classes> classesArrayList , String nameOfProfessor )
    {

        JLabel listOfClassesLabel = new JLabel ( " List of classes{" );
        listOfClassesLabel.setBounds ( 0 , 100 , 100 , 50 );
        add ( listOfClassesLabel );


        JTextArea allClassesArea = new JTextArea (  );
        allClassesArea.setEditable ( false );
        allClassesArea.setColumns ( 3 );
        JScrollPane allClassesScroll = new JScrollPane ( allClassesArea );
        allClassesScroll.setBounds ( 100 , 100 , 600 , 100 );
        add(allClassesScroll);
        for (int x =0 ; x < professorArrayList.size () ; x++)
        {

//          peyda krdne ostade morede nazar
            if (nameOfProfessor.equals ( professorArrayList.get ( x ).getName () ))
            {

//                print klas haye ostade morede nazar
                for (int y = 0; y < professorArrayList.get ( x ).getEachProfessorArray ().size (); y++)
                {

                    allClassesArea.append ( professorArrayList.get ( x ).getEachProfessorArray ().get ( y ).getClassName () +
                            "\t\t" + professorArrayList.get ( x ).getEachProfessorArray ().get ( y ).getPlaceOfClass () +
                            "\t\t" + professorArrayList.get ( x ).getEachProfessorArray ().get ( y ).getTimeOfClass () + "\n");

                }

            }

        }





        JLabel classNameLabel = new JLabel ( "name of class :" );
        classNameLabel.setBounds ( 100 , 250 , 100 , 50 );
        add(classNameLabel);

        JTextField classNameText = new JTextField (  );
        classNameText.setBounds ( 200 , 250 , 350 , 50 );
        add ( classNameText );



        JLabel detailOfclassLabel = new JLabel ( " Detail of class{" );
        detailOfclassLabel.setBounds ( 0 , 350 , 100 , 50 );
        add ( detailOfclassLabel );





        JButton showClassBtn = new JButton ( "show class" );
        showClassBtn.setBounds ( 600 , 250 , 100 ,50 );
        JTextArea classArea = new JTextArea (  );
        classArea.setEditable ( false );
        classArea.setColumns ( 3 );
        JScrollPane classScroll = new JScrollPane ( classArea );
        classScroll.setBounds ( 100 , 350 , 600 , 100 );
        add(classScroll);
        showClassBtn.addActionListener ( new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (classNameText.getText ().isEmpty ())
                    JOptionPane.showMessageDialog ( null , "choose a class from top classes to see the students of that class" );

                String s ="";
                for (int x =0 ; x < classesArrayList.size () ; x++)
                {

//                  peyda krdne clase morede nazar
                    if (classNameText.getText ().equals ( classesArrayList.get ( x ).getClassName () ))
                    {

//                      print daneshju haye clase morede nazar
                        for (int y = 0; y < classesArrayList.get ( x ).getEachClassArray ().size (); y++)
                        {

                            s = s+ classesArrayList.get ( x ).getEachClassArray ().get ( y ).getName () +
                                    "\t\t" + classesArrayList.get ( x ).getEachClassArray ().get ( y ).getSex () +
                                    "\t\tscore : " + classesArrayList.get ( x ).getEachClassArray ().get ( y ).
                                    getScoreFromMap ( classesArrayList.get ( x ).getClassName () ) + "\n";

                        }

                        classArea.setText ( s );

                    }

                }


            }
        } );
        add ( showClassBtn );



        JLabel studentNameLabel = new JLabel ( "Student name :" );
        studentNameLabel.setBounds ( 100 , 500 , 100 , 50 );
        add(studentNameLabel);

        JTextField studentNameText = new JTextField (  );
        studentNameText.setBounds ( 200 , 500 , 350 , 50 );
        add ( studentNameText );

        JButton deleteStudentBtn = new JButton ( "Delete Student" );
        deleteStudentBtn.setBounds ( 600 , 500 , 100 , 50 );
        deleteStudentBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if ( !studentNameText.getText ().isEmpty () && !classNameText.getText ().isEmpty () )
                {

                    /*for (int x =0 ; x < professorArrayList.size () ; x++)
                    {

//                        peyda krdne ostade morede nazar
                        if (nameOfProfessor.equals ( professorArrayList.get ( x ).getName () ))
                        {

//                      print klas haye ostade morede nazar
                            for (int y = 0; y < professorArrayList.get ( x ).getEachProfessorArray ().size (); y++)
                            {

                                if (professorArrayList.get ( x ).getEachProfessorArray ().get ( y ).getEachClassArray () )

                            }

                        }

                    }*/

                    for (int n=0 ; n < studentArrayList.size () ; n++)
                    {

                        if (studentArrayList.get ( n ).getName ().equals ( studentNameText.getText () ) )
                        {

                            studentArrayList.get ( n ).removeScoreFromMap ( classNameText.getText () );

                        }

                    }

                    for (int n=0 ; n < classesArrayList.size () ; n++)
                    {

                        if (classNameText.getText ().equals ( classesArrayList.get ( n ).getClassName () ))
                        {

                            classesArrayList.get ( n ).deleteStudentFromClassesArray ( studentNameText.getText () );
                            JOptionPane.showMessageDialog ( null , "Student deleted!!!" );
                            setVisible ( false );
                            ProfessorFirstFrame p = new ProfessorFirstFrame ( managerArrayList, professorArrayList, studentArrayList, classesArrayList, nameOfProfessor );
                            JOptionPane.showMessageDialog ( null , "Student deleted!!!" );

                        }

                    }

                }
                else
                    JOptionPane.showMessageDialog ( null , "Field Empty!!!" );

            }
        } );
        add ( deleteStudentBtn );



        JLabel studentScoreLabel = new JLabel ( "Student score :" );
        studentScoreLabel.setBounds ( 100 , 550 , 100 , 50 );
        add(studentScoreLabel);

        JTextField studentscoreText = new JTextField (  );
        studentscoreText.setBounds ( 200 , 550 , 350 , 50 );
        add ( studentscoreText );

        JButton submitScoreBtn = new JButton ( "Submit score" );
        submitScoreBtn.setBounds ( 600 , 550 , 100 , 50 );
        submitScoreBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if (!classNameText.getText ().isEmpty () && !studentNameText.getText ().isEmpty () && !studentscoreText.getText ().isEmpty () )
                {

                    for (int n=0 ; n < classesArrayList.size () ; n++)
                    {

                        if (classNameText.getText ().equals ( classesArrayList.get ( n ).getClassName () ))
                        {

                            classesArrayList.get ( n ).submitScoreToClassFile ( studentNameText.getText () ,
                                    classNameText.getText (),Integer.parseInt ( studentscoreText.getText () ) );
                            JOptionPane.showMessageDialog ( null , "Score Submitted!!!" );
                            setVisible ( false );
                            ProfessorFirstFrame p = new ProfessorFirstFrame ( managerArrayList, professorArrayList, studentArrayList, classesArrayList, nameOfProfessor );

                        }

                    }

                }
                else
                    JOptionPane.showMessageDialog ( null , "Field empty!!!" );

            }
        } );
        add ( submitScoreBtn );



        JButton logoutBtn = new JButton ( "Log out" );
        logoutBtn.setBounds ( 100 , 650 , 600 , 50 );
        logoutBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible ( false );
                FirstFrame f = new FirstFrame ( managerArrayList, professorArrayList, studentArrayList ,classesArrayList);

            }
        } );
        add ( logoutBtn );



        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setTitle ( "*** Professor ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );


    }

}
