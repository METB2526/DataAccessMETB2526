import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable
{
    // Fields.
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String description;

    // Constructor.
    public Contact(String name, String surname, String email, String phone, String description)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }

    // Properties.
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {

        if(surname == null || surname.isEmpty())
        {
            throw new IllegalArgumentException("Surname cannot be null or empty");
        }

        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if(email == null || email.isEmpty())
        {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        if(phone == null || phone.isEmpty())
        {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }

        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        if(description == null || description.isEmpty())
        {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }

        this.description = description;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Surname: " + surname + ", Email: " + email + ", Phone: " + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;

        Contact contact = (Contact) o;

        return Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname) && Objects.equals(email, contact.email) && Objects.equals(phone, contact.phone);
    }

}
