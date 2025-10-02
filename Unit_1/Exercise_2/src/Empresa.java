import java.util.HashSet;
import java.util.Set;

public class Empresa
{
    // feilds.
    private String _name;
    private Set<Empleado> _employeePortfolio = new HashSet<Empleado>();
    private Set<Cliente> _clientPorfolio = new HashSet<>();

    // properties.
    public Empresa (String name)
    {
        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("incorrect name format.");
        }
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Set<Empleado> getEmployeePortfolio() {
        return _employeePortfolio;
    }

    public void setEmployeePortfolio(Set<Empleado> employeePortfolio) {
        _employeePortfolio = employeePortfolio;
    }

    public Set<Cliente> getClientPorfolio() {
        return _clientPorfolio;
    }

    public void setClientPorfolio(Set<Cliente> clientPorfolio) {
        _clientPorfolio = clientPorfolio;
    }

    // methods.
    public int totalEmployees()
    {
        return _employeePortfolio.size();
    }

    public int  totalClients()
    {
        return _clientPorfolio.size();
    }

}
