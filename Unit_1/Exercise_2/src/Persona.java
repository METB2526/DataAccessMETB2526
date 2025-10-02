import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Persona
{
    public static final String INVALID_DATE_OF_BIRTH = "Invalid birth date.";
    public static final String INVALID_PHONE_NUMBER = "Invalid phone Number.";
    public static final String SALARY_NOT_VALID = "Salary not valid.";

    private String _name;
    private LocalDate _dateOfBirth;

    public Persona(String name, String birthDate)
    {
        setName(name);
        setDateOfBirth(birthDate);
    }

    public String getName() {
        return _name;
    }

    public LocalDate getDateOfBirth()
    {
        return _dateOfBirth;
    }

    public void setName(String name)
    {
        if(name != null)
        {
            _name = name;
        }
    }

    /**
     * @param birthDate mandatary format date "yyyy/mm/dd".
     */
    public void setDateOfBirth(String birthDate) throws DateTimeException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dateOfBirth = LocalDate.parse(birthDate, formatter);

        if(dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException(INVALID_DATE_OF_BIRTH);
        }

        _dateOfBirth = dateOfBirth;
    }

    /**
     * @return amount of years between two LocalDate
     */
    public int getAge()
    {
        Period age =  getDateOfBirth().until(LocalDate.now());

        return age.getYears();
    }

    /**
     * It shows all Persona class data on the screen.
     */
    public void showData()
    {
        if(getName() == null || getDateOfBirth() == null)
        {
            System.err.println("There are null values in the fields.");
            return;
        }

        System.out.println("Name: " + getName() + "\n Age: " + getAge());
    }
}