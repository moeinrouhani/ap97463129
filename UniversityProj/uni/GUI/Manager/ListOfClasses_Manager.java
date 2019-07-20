package UniversityProj.uni.GUI.Manager;

import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListOfClasses_Manager extends JFrame {

    public ListOfClasses_Manager(ArrayList<Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                                 ArrayList<Student> studentArrayList , ArrayList <Classes> classesArrayList )
    {

        JLabel listOfClassesLabel = new JLabel ( " List of classes{" );
        listOfClassesLabel.setBounds ( 0 , 100 , 100 , 50 );
        add ( listOfClassesLabel );

        JTextArea classesArea = new JTextArea ();
        classesArea.setEditable ( false );

        for (int n=0 ; n < classesArrayList.size () ; n++)
        {

            classesArea.append ( classesArrayList.get ( n ).getClassName ()+ "\t" + classesArrayList.get ( n ).getProfessorOfClass ()+
                    "\t"+ classesArrayList.get ( n ).getPlaceOfClass () +"\t"+ classesArrayList.get ( n ).getTimeOfClass () +"\n" );

        }


            JScrollPane classesScroll = new JScrollPane ( classesArea );
            classesScroll.setBounds ( 100 , 100 , 600 , 200 );
            add(classesScroll);



        JLabel nameLabel = new JLabel ( "Name of class :" );
        nameLabel.setBounds ( 100 , 350 , 100 , 50 );
        add(nameLabel);

        JTextField nameText = new JTextField (  );
        nameText.setBounds ( 200 , 350 , 400 , 50 );
        add ( nameText );



        /*JLabel professorLabel = new JLabel ( "Professor :" );
        professorLabel.setBounds ( 400 , 350 , 100 , 50 );
        add(professorLabel);

        JTextField professorText = new JTextField (  );
        professorText.setBounds ( 500 , 350 , 200 , 50 );
        add ( professorText );*/



        JLabel detailOfclassLabel = new JLabel ( " Class students{" );
        detailOfclassLabel.setBounds ( 0 , 450 , 100 , 50 );
        add ( detailOfclassLabel );



        JButton showClass = new JButton ( "Show Class" );
        showClass.setBounds ( 100 , 650 , 250 , 50 );
        JTextArea classArea = new JTextArea (  );
        classArea.setEditable ( false );
        JScrollPane classScroll = new JScrollPane ( classArea );
        classScroll.setBounds ( 100 , 450 , 600 , 150 );
        add(classScroll);
        showClass.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if (!nameText.getText ().isEmpty () )
                {

                    String s = "" ;
                    for (int i=0 ; i < classesArrayList.size () ; i++)
                    {

//                        peyda kardane; kelase morede nazar
                        if (classesArrayList.get ( i ).getClassName ().equals ( nameText.getText () ) )
                        {

//                            print kardane daneshju haye klase morede nazar
                            for (int x=0 ; x < classesArrayList.get ( i ).getEachClassArray ().size () ; x++)
                                s = s + classesArrayList.get ( i ).getEachClassArray ().get ( x ).getName ()+"\t\t"+
                                        classesArrayList.get ( i ).getEachClassArray ().get ( x ).getSex ()+"\t\tscore : "+
                                        classesArrayList.get ( i ).getEachClassArray ().get ( x ).
                                                getScoreFromMap ( classesArrayList.get ( i ).getClassName () )+"\n";

                        }

                        classArea.setText ( s );

                    }

                }
                else
                    JOptionPane.showMessageDialog ( null , "Field empty!!!" );


            }
        } );
        add ( showClass );



        JButton backbtn = new JButton ( "Back" );
        backbtn.setBounds ( 450 , 650 , 250 , 50 );
        backbtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                ManagerFirstFrame mff = new ManagerFirstFrame (managerArrayList, professorArrayList, studentArrayList ,classesArrayList);
                setVisible ( false );

            }
        } );
        add ( backbtn );



        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setTitle ( "*** Manager ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }

}
