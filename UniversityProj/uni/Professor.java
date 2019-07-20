package UniversityProj.uni;

import java.util.ArrayList;

public class Professor {

    String name;
    String password;
    String sex;
    ArrayList < Classes > eachProfessorArray = new ArrayList<> (  );



    public Professor(){}

    public Professor(String name , String sex , String password)
    {

        this.name = name;
        this.sex = sex;
        this.password = password;

    }



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() { return sex; }

    public ArrayList<Classes> getEachProfessorArray()
    {
        return eachProfessorArray;
    }



    public void saveProfessor(ArrayList < Professor > professorArrayList , Professor professor)
    {

        professorArrayList.add ( professor );

    }



    public void addClasstoEachprofessorArray(Classes c)
    {

        eachProfessorArray.add ( c );

    }



}
