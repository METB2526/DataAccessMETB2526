import java.util.HashSet;
import java.util.Set;

public class Directivo extends Empleado
{
    // fileds.
    private String _category;
    private Set<Empleado> _supervise = new HashSet<>();

    // constructor.
    public Directivo(String name, String birthDate, double grossSalary, String category)
    {
        super(name, birthDate, grossSalary);
        setCategory(category);
    }

    // properties.
    public String getCategory()
    {
        return _category;
    }

    public void setCategory(String category)
    {
        if(category == null || category.isEmpty())
        {
            throw new IllegalArgumentException("incorrect category format.");
        }

        _category = category;
    }

    public Set<Empleado> getSupervise() {
        return _supervise;
    }

    public void setSupervise(Set<Empleado> supervise) {
        _supervise = supervise;
    }

    // methods.
    public int subordinados()
    {
        return getSupervise().size();
    }

    @Override
    public void showData()
    {
        super.showData();
        System.out.printf("\n Category: " + getCategory());
        System.out.printf("\n Supervise: " + subordinados() + " employees.");
    }
}
