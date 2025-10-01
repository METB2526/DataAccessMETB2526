package model;

import java.time.LocalDate;

public class AlumnoErasmus extends Alumno
{
    // fields.
    private LocalDate _startDate;
    private LocalDate _endDate;

    // constructor.
    public AlumnoErasmus(String name, int grade, LocalDate startDate, LocalDate endDate)
    {
        setName(name);
        setGrade(grade);
        _startDate = startDate;
        _endDate = endDate;
    }

    // properties.
    public LocalDate getStartDate()
    {
        return _startDate;
    }

    public LocalDate getEndDate()
    {
        return _endDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        if(_startDate != null)
        {
            _startDate = startDate;
        }
    }

    public void setEndDate(LocalDate endDate)
    {
        if(endDate != null)
        {
            _endDate = endDate;
        }
    }

}
