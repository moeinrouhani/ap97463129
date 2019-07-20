package UniversityProj.uni;
import UniversityProj.uni.GUI.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList < Manager > AllManagerArrayList = new ArrayList<> (  );
        ArrayList < Classes  > AllClassesArrayList = new ArrayList<> (  );
        ArrayList < Professor > AllProfessorArrayList = new ArrayList<> (  );
        ArrayList < Student > AllStudentArrayList = new ArrayList<> (  );



        Manager m1 = new Manager ( "moein" , "male" , "1234" );
        m1.saveManager ( AllManagerArrayList , m1 );


        Professor p1 = new Professor ( "mohseni" , "female" , "poi");
        p1.saveProfessor ( AllProfessorArrayList , p1 );

        Professor p2 = new Professor ( "rahmani" , "male" , "lkj");
        p2.saveProfessor ( AllProfessorArrayList , p2 );



        Student s1 = new Student ( "ali" , "male" , "qwe" );
        s1.saveStudent ( AllStudentArrayList , s1 );

        Student s2 = new Student ( "zahra" , "female" , "zxc" );
        s2.saveStudent ( AllStudentArrayList , s2 );



        Classes c1 = new Classes ( "fizik" , "mohseni" , "omran-203"
                , "4shanbe-12" );
        c1.saveClassToArray ( AllClassesArrayList , c1 );
        p1.addClasstoEachprofessorArray ( c1 );
        c1.addStudentToEachClassArray ( s1 );
//        s1.addClassToEachStudentArray ( c1 );
        s1.addScoreToMap ( "fizik" , 0 );

        Classes c2 = new Classes ( "adp" , "rahmani" , "bargh-101"
                , "shanbe-8" );
        c2.saveClassToArray ( AllClassesArrayList , c2 );
        p2.addClasstoEachprofessorArray ( c2 );

        FirstFrame firstFrame = new FirstFrame (AllManagerArrayList,AllProfessorArrayList,AllStudentArrayList,AllClassesArrayList);

    }

}
