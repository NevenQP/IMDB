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
        Feat emp4 = new Feat("Hari Mohapatra",
                "harim@gmail.com");
        employeeList.add(emp4);
        Feat emp5 = new Feat(
                "Abhisek Mishra", "mishraabhi@gmail.com");
        employeeList.add(emp5);
        Feat emp6 = new Feat("Sindhu Malhotra",
                "sindhu@gmail.com");
        employeeList.add(emp6);
        Feat emp7 = new Feat("Anil sidhu",
                "sidhuanil@gmail.com");
        employeeList.add(emp7);
        Feat emp8 = new Feat("Sachin sinha",
                "sinhas@gmail.com");
        employeeList.add(emp8);
        Feat emp9 = new Feat("Amit sahoo",
                "sahooamit@gmail.com");
        employeeList.add(emp9);
        Feat emp10 = new Feat("Raj kumar",
                "kumarraj@gmail.com");
        employeeList.add(emp10);

        return employeeList;
    }
}
