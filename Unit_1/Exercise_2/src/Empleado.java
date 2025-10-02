public class Empleado extends Persona
{
    // fields.
    private double _grossSalary;

    // constructor.
    public Empleado(String name, String birthDate, double grossSalary)
    {
        super(name, birthDate);
        setGrossSalary(grossSalary);
    }

    // properties.
    public double getGrossSalary()
    {
        return _grossSalary;
    }

    public void setGrossSalary(double grossSalary)
    {
        if(grossSalary < 0)
        {
            throw new IllegalArgumentException(SALARY_NOT_VALID);
        }

        _grossSalary = grossSalary;
    }

    // methods.
    @Override
    public void showData()
    {
        super.showData();
        // Formatted text with two decimal places and line break.
        System.out.printf("\n Gross Salary:  %.2f%n",getGrossSalary());
    }
}
