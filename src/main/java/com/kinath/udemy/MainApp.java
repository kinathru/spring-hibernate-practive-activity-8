package com.kinath.udemy;

import com.kinath.udemy.entity.Employee;
import com.kinath.udemy.utils.EmployeeUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Employee.class ).buildSessionFactory();

        try
        {
            // Create employees
            System.out.println( "Generating employees..." );
            List<Employee> employeeList = EmployeeUtils.createEmployees();
            System.out.println( "Generating employees Completed." );

            // Save in db
            System.out.println( "\n\n\nSaving employees..." );
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            for( Employee employee : employeeList )
            {
                session.save( employee );
            }
            session.getTransaction().commit();
            System.out.println( "Saving employees completed." );

            // Read given employee from db
            System.out.println( "\n\n\nReading 10 employee from db..." );
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee readEmployee = session.get( Employee.class, 10 );
            if( readEmployee != null )
            {
                System.out.println( readEmployee.toString() );
            }
            else
            {
                System.out.println( "Employee does not exist!!!" );
            }
            session.getTransaction().commit();
            System.out.println( "Done." );

            // Read employees from a given company
            System.out.println( "\n\n\nReading employees from a given company..." );
            session = factory.getCurrentSession();
            session.beginTransaction();
            List resultList = session.createQuery( "from Employee e where e.company = 'HSBC'" ).getResultList();
            for( Object empl : resultList )
            {
                System.out.println( empl.toString() );
            }
            session.getTransaction().commit();
            System.out.println( "Reading employees from a given company - Done." );

            // Update given employee from db
            System.out.println( "\n\n\n Update given employee from db" );
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee updateEmp = session.get( Employee.class, 20 );
            if( updateEmp != null )
            {
                updateEmp.setFirstName( "Kinath" );
            }
            else
            {
                System.out.println( "Employee Not found!!!" );
            }
            session.getTransaction().commit();
            System.out.println( "Done." );

            // Delete given employee from db
            System.out.println( "\n\n\n Delete given employee from db" );
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee deleteEmp = session.get( Employee.class, 30 );
            if( deleteEmp != null )
            {
                session.delete( deleteEmp );
            }
            else
            {
                System.out.println( "Employee Not found!!!" );
            }
            session.getTransaction().commit();
            System.out.println( "Done" );
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
        }
        finally
        {
            factory.close();
        }
    }
}
