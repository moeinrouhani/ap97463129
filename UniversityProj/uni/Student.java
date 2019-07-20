package UniversityProj.uni;

import java.util.ArrayList;
import java.util.HashMap;

public class Student  {

    String name;
    String sex;
    String password;
    int    score;
    HashMap < String  , Integer> eachStudentMap   = new HashMap<String, Integer> (  );



    public Student(){}

    public Student(String name , String sex , String password){

        this.name = name;
        this.sex = sex;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }




    public void saveStudent(ArrayList < Student > studentArrayList , Student student){

        studentArrayList.add ( student );

    }




    public void addScoreToMap(String  s , int score)
    {

        eachStudentMap.put ( s , score );

    }


    public int getScoreFromMap(String s)
    {

        return eachStudentMap.get ( s );

    }



    public void removeScoreFromMap(String s)
    {

        eachStudentMap.remove ( s );

    }


}
