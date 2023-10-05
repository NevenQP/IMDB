package vn.edu.usth.imdbclient.adapter;

import java.util.ArrayList;

public class Constant {
    public static ArrayList<Feat> getEmployeeData()
    {
        // create an ArrayList of type Employee class
        ArrayList<Feat> employeeList
                = new ArrayList<Feat>();
        Feat emp1 = new Feat("Chinmaya Mohapatra",
                "chinmaya@gmail.com");
        employeeList.add(emp1);
        Feat emp2
                = new Feat("Ram prakash", "ramp@gmail.com");
        employeeList.add(emp2);
        Feat emp3 = new Feat("OMM Meheta",
                "mehetaom@gmail.com");
        employeeList.add(emp3);

        return employeeList;
    }
}
