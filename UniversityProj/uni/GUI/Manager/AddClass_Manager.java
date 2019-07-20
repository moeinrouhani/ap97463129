package UniversityProj.uni.GUI.Manager;

import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddClass_Manager extends JFrame {



    public AddClass_Manager(ArrayList<Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                            ArrayList<Student> studentArrayList , ArrayList <Classes> classesArrayList ){

        JLabel nameLabel = new JLabel ( "Name of Class :" );
        nameLabel.setBounds ( 100 , 100 , 100 , 50 );
        add(nameLabel);

        JTextField nameText = new JTextField (  );
        nameText.setBounds ( 200 , 100 , 400 , 50 );
        add ( nameText );



        JLabel professorLabel = new JLabel ( "Professor :" );
        professorLabel.setBounds ( 100 , 200 , 100 , 50 );
        add(professorLabel);

        JTextField professortext = new JTextField (  );
        professortext.setBounds ( 200 , 200 , 400 , 50 );
        add ( professortext );



        JButton showProfessorsBtn = new JButton ( "Professors" );
        showProfessorsBtn.setBounds ( 600 , 200 , 100 ,50 );
        showProfessorsBtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e)
            {


                JTextArea professorsTextArea = new JTextArea (  );
                professorsTextArea.setEditable ( false );
                JScrollPane scrollPane = new JScrollPane ( professorsTextArea );
                scrollPane.setBounds ( 200 , 0 , 400 , 100 );
                add ( scrollPane );

                for (int n=0 ; n < professorArrayList.size () ; n++)
                {

                    professorsTextArea.append ( professorArrayList.get ( n ).getName ()+ "\t\t\t" +
                            professorArrayList.get ( n ).getSex ()+"\n" );

                }



            }
        } );
        add ( showProfessorsBtn );



        JLabel placeLabel = new JLabel ( "Place :" );
        placeLabel.setBounds ( 100 , 300 , 100 , 50 );
        add(placeLabel);

        JTextField placeText = new JTextField (  );
        placeText.setBounds ( 200 , 300 , 400 , 50 );
        add ( placeText );



        JLabel timeLabel = new JLabel ( "Time :" );
        timeLabel.setBounds ( 100 , 400 , 100 , 50 );
        add(timeLabel);

        JTextField timeText = new JTextField (  );
        timeText.setBounds ( 200 , 400 , 400 , 50 );
        add ( timeText );



       /* JLabel capacityLabel = new JLabel ( "Capacity :" );
        capacityLabel.setBounds ( 100 , 500 , 100 , 50 );
        add(capacityLabel);

        JTextField capacityText = new JTextField (  );
        capacityText.setBounds ( 200 , 500 , 400 , 50 );
        add ( capacityText );*/



        JButton addClassbtn = new JButton ( "Add Class" );
        addClassbtn.setBounds ( 100 , 650 , 250 , 50 );
        addClassbtn.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e)
            {


                if (!nameText.getText ().isEmpty () && !professortext.getText ().isEmpty () && !placeText.getText ().isEmpty ()
                        && !timeText.getText ().isEmpty ())
                {

                    for (int x=0 ; x < professorArrayList.size () ; x++)
                    {

                        if (professortext.getText ().equals ( professorArrayList.get ( x ).getName () ) )
                        {

                            Classes class1 = new Classes ( nameText.getText () , professortext.getText () , placeText.getText () , timeText.getText () );
                            classesArrayList.add ( class1 );
                            professorArrayList.get ( x ).addClasstoEachprofessorArray ( class1 );
                            setVisible ( false );
                            AddClass_Manager addClass_manager = new AddClass_Manager ( managerArrayList, professorArrayList, studentArrayList, classesArrayList );
                            JOptionPane.showMessageDialog ( null, "Class added " );

                        }

                    }



                }

                else {
                    JOptionPane.showMessageDialog ( null, "field empty!!!" );
                }



            }
        } );
        add ( addClassbtn );



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
        setTitle ( "*** ADD CLASS ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }

}
