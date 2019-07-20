package UniversityProj.uni;

import java.util.ArrayList;

public class Classes {

    String className;
    String professorOfClass;
    String placeOfClass;
    String timeOfClass;
    int score;
    ArrayList < Student  > eachClassArray = new ArrayList<> (  );



    public Classes(){}

    public Classes(String className , String professorOfClass , String placeOfClass , String time ){

        this.className = className;
        this.professorOfClass = professorOfClass;
        this.placeOfClass = placeOfClass;
        this.timeOfClass = time;

    }



    public String getClassName() {
        return className;
    }

    public String getProfessorOfClass() {
        return professorOfClass;
    }

    public String getPlaceOfClass() {
        return placeOfClass;
    }

    public String getTimeOfClass() {
        return timeOfClass;
    }

    public ArrayList<Student> getEachClassArray() {
        return eachClassArray;
    }



    public void saveClassToArray(ArrayList < Classes > classesArrayList , Classes classes){

        classesArrayList.add ( classes );

    }



    public void deleteStudentFromClassesArray(String nameOfStudent)
    {

        for (int x = 0 ; x < eachClassArray.size () ; x++)
        {

            if (eachClassArray.get ( x ).getName ().equals ( nameOfStudent ) )
                eachClassArray.remove ( x );

        }

    }



    public void addStudentToEachClassArray( Student s )
    {

        eachClassArray.add ( s );

    }



    public void submitScoreToClassFile( String nameOfStudent ,String nameOfClass , int score )
    {

        for (int x = 0 ; x < eachClassArray.size () ; x++)
        {

            if (eachClassArray.get ( x ).getName ().equals ( nameOfStudent ) )
                eachClassArray.get ( x ).addScoreToMap ( nameOfClass , score );

        }


    }



}
