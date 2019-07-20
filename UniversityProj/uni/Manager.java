package UniversityProj.uni;

import java.util.ArrayList;

public class Manager {

    String name;
    String sex;
    String password;



    public Manager(){}

    public Manager (String name , String sex , String password  )
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



    public void saveManager(ArrayList < Manager > managerArrayList , Manager manager) {

        managerArrayList.add ( manager );

    }



}
