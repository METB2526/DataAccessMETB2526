package handler;

import model.Alumno;

import java.util.ArrayList;

public class Alumnos
{
    private ArrayList<Alumno> _studentList= new ArrayList<>();

    /**
     * add new student to list.
     */
    public void addAlumno(Alumno a)
    {
        _studentList.add(a);
    }

    /**
     *  returns the student from the list position.
     */
    public Alumno getAlumno(int index)
    {
        if( index >= 0 && index < _studentList.size())
        {
            return (Alumno)_studentList.get(index);
        }

        return null;
    }

    /**
     * returns the students' average grade.
     */
    public float getAverage()
    {
        if(_studentList.isEmpty()) //if(_studentList.size() == 0)
        {
            return 0;
        }
        else
        {
            float average = 0;

            for(int i = 0; i < _studentList.size(); i++)
            {
                average += ((Alumno)_studentList.get(i)).getGrade();
            }

            return (average / _studentList.size());
        }
    }

}
