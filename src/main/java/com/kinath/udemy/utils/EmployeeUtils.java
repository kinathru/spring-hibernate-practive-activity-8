package com.kinath.udemy.utils;

import com.kinath.udemy.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeUtils
{
    public static List<Employee> createEmployees()
    {
        String[] firstNames = new String[]{"Vonda", "Cortez", "Adam", "Reva", "Buena", "Mao", "Nikole", "Toni", "Chung", "Jeffry", "Amanda", "Randa", "Maria", "Demetria", "Cyrstal", "Olin", "Livia", "Antionette", "Houston", "Jonas"};
        String[] lastNames = new String[]{"Mehrabi", "Swofford", "Monteiro", "Racioppi", "Dehaven", "Sinn", "Walther", "Iii", "Stallion", "Montrone", "Morello", "Corielli", "Schoenstein", "Meany", "Harthorn", "Vetter", "Marro", "Fujimura", "Alvarez", "Bisbee"};
        String[] companies = new String[]{"Google", "HSBC", "IKEA", "Shell Oil Company", "Adobe Systems"};

        List<Employee> employeeList = new ArrayList<Employee>();

        Random random = new Random();

        for( int i = 0; i < 50; i++ )
        {
            Employee employee = new Employee();
            employee.setFirstName( firstNames[random.nextInt( firstNames.length )] );
            employee.setLastName( lastNames[random.nextInt( lastNames.length )] );
            employee.setCompany( companies[random.nextInt( companies.length )] );
            employeeList.add( employee );
        }

        return employeeList;
    }
}
