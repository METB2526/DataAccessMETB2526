package model;

public class AlumnoFCT extends Alumno
{
    // fields
    private String _company;
    private String _tutor;
    private String _instructor;

    // constructor
    public AlumnoFCT(String name, int grade, String company, String tutor, String instructor)
    {
        setName(name);
        setGrade(grade);
        _company = company;
        _tutor = tutor;
        _instructor = instructor;
    }

    // properties.
    public String getCompany()
    {
        return _company;
    }

    public String getTutor()
    {
        return _tutor;
    }

    public String getInstructor()
    {
        return _instructor;
    }

    public void setCompany(String company)
    {
        if(company != null)
        {
            _company = company;
        }
    }

    public void setTutor(String tutor)
    {
        if(tutor != null)
        {
            _tutor = tutor;
        }
    }

    public void setInstructor(String instructor)
    {
        if(instructor != null)
        {
            _instructor = instructor;
        }
    }

}
