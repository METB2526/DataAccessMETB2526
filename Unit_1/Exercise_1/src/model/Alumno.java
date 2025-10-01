package model;

public class Alumno {

    // fields.
    private String _name;
    private int _grade;

    // properties.
    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public int getGrade()
    {
        return _grade;
    }

    public void setGrade(int grade)
    {
        if(grade >= 0 && grade <= 10)
        {
            _grade = grade;
        }
    }

    // methods.
    public boolean approved()
    {
        if(_grade >= 5)
        {
            return true;
        }
        return false;
    }
}
