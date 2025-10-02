import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Cliente extends Persona
{
    private String _telephone;
    private Set<Empresa> _isClientOf = new HashSet<>();

    public Cliente(String name, String birthDay, String phoneNumber)
    {
        super(name, birthDay);
        setTelephone(phoneNumber);
    }

    public String getTelephone()
    {
        return _telephone;
    }

    public void setTelephone(String value)
    {
        String telephonePattern = "^((\\+|00)\\d{2,3})?\\d{9}$";

        if(Pattern.matches(telephonePattern, value))
        {
               _telephone = value;
        }
        else
       {
            throw new IllegalArgumentException(INVALID_PHONE_NUMBER);
        }
    }

    public Set<Empresa> getIsClientOf() {
        return _isClientOf;
    }

    public void setIsClientOf(Set<Empresa> isClientOf) {
        _isClientOf = isClientOf;
    }

    @Override
    public void showData()
    {
        super.showData();

        String msj = getTelephone() != null ? "\n Telephone: " + getTelephone(): "\n Telephone not available.";
        System.out.println(msj);
    }


}
