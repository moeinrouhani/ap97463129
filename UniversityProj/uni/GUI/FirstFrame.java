package UniversityProj.uni.GUI;

import UniversityProj.uni.GUI.Manager.ManagerFirstFrame;
import UniversityProj.uni.GUI.Professor.ProfessorFirstFrame;
import UniversityProj.uni.GUI.Student.StudentFirstFrame;
import UniversityProj.uni.Classes;
import UniversityProj.uni.Manager;
import UniversityProj.uni.Professor;
import UniversityProj.uni.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class FirstFrame extends JFrame {



    public FirstFrame(ArrayList <Manager> managerArrayList , ArrayList<Professor> professorArrayList ,
                      ArrayList<Student> studentArrayList , ArrayList <Classes> classesArrayList ){

        JLabel usernameLabel = new JLabel ( "Username :" );
        usernameLabel.setBounds ( 100 , 100 , 100 , 50 );
        add(usernameLabel);

        JTextField usernameTextField = new JTextField (  );
        usernameTextField.setBounds ( 200 , 100 , 400 , 50 );
        add ( usernameTextField );



        JLabel passwordLabel = new JLabel ( "password :" );
        passwordLabel.setBounds ( 100 , 200 , 100 , 50 );
        add(passwordLabel);

        JPasswordField passwordTextField = new JPasswordField (  );
        passwordTextField.setBounds ( 200 , 200 , 400 , 50 );
        add ( passwordTextField );



        JButton signin = new JButton ( "Sign In" );
        signin.setBounds ( 100 , 650 , 600 , 50 );
        signin.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean entered = false;

                if ( usernameTextField.getText ().isEmpty () || (new String ( passwordTextField.getPassword () ) ).isEmpty () )
                    JOptionPane.showMessageDialog ( null , "field empty!!!" );


                else
                {

                    for (int n=0 ; n < managerArrayList.size () ; n++)
                    {

                        if ( managerArrayList.get ( n ).getName ().contains ( usernameTextField.getText () ) &&
                                managerArrayList.get ( n ).getPassword ().equals ( new String ( passwordTextField.getPassword () ) ) )
                        {

                            setVisible ( false );
                            ManagerFirstFrame mff = new ManagerFirstFrame (managerArrayList, professorArrayList, studentArrayList , classesArrayList );
                            entered = true;

                        }

                    }



                    for (int n=0 ; n < professorArrayList.size () ; n++)
                    {
                        if (professorArrayList.get ( n ).getName ().equals ( usernameTextField.getText () ) &&
                                professorArrayList.get ( n ).getPassword ().equals ( new String ( passwordTextField.getPassword () ) ) )
                        {

                            setVisible ( false );
                            ProfessorFirstFrame mff = new ProfessorFirstFrame (managerArrayList, professorArrayList,
                                    studentArrayList,classesArrayList , usernameTextField.getText () );
                            entered = true;

                        }

                    }



                    for (int n=0 ; n < studentArrayList.size () ; n++)
                    {

                        if (studentArrayList.get ( n ).getName ().equals ( usernameTextField.getText () ) &&
                                studentArrayList.get ( n ).getPassword ().equals ( new String ( passwordTextField.getPassword () ) ) )
                        {

                            setVisible ( false );
                            StudentFirstFrame mff = new StudentFirstFrame (managerArrayList, professorArrayList, studentArrayList
                                    ,classesArrayList,usernameTextField.getText ());
                            entered = true;

                        }

                    }



                    if (entered == false)
                        JOptionPane.showMessageDialog ( null , "username or password incorrect!!!" );



                }




            }
        } );
        add ( signin );



        setSize ( 800 , 800 );
        setLocation ( 300 , 0 );
        setTitle ( "*** Welcome ***" );
        setLayout ( null );
        setVisible ( true );
        setDefaultCloseOperation ( EXIT_ON_CLOSE );

    }



}
