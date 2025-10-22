import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactManager implements Serializable
{
    protected ArrayList<Contact> _contacts;

    public ContactManager()
    {
        _contacts = new ArrayList<>();
    }

    public void addContact(Contact contact)
    {
        if(contact != null)
        {
            _contacts.add(contact);
        }
        else
        {
            System.err.println("Contact must be not null.");
        }
    }

    /*
    * Method seeks the contact and displays it on the screen.
    * */
    public void seekContact(String name, String surname)
    {
        // try to use Streams.
        List<Contact> myContacts =  _contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name) && contact.getSurname().equalsIgnoreCase(surname))
                .toList();  //.collect(Collectors.toList());


        if(myContacts.isEmpty())
        {
            System.out.println("No results found.");
        }
        else
        {
            myContacts.forEach(contact -> System.out.println(contact.toString()));
        }
    }

    /*
    * Method displays all contacts that have the same phone number.
    * */
    public void getContactByPhone(String phone)
    {
        // try to use filter with lambda.
        List<Contact> myContacts = _contacts.stream()
                .filter(contact -> contact.getPhone().equals(phone))
                .toList();

        if(myContacts.isEmpty())
        {
            System.out.println("No results found.");
        }
        else
        {
            myContacts.forEach(contact -> System.out.println(contact.toString()));
        }
    }

    /*
    * Method displays all available contacts in sorted order.
    * */
    public void showAllContacts()
    {
        if(_contacts.isEmpty())
        {
            System.out.println("No results found.");
        }
        else
        {
            // try to test two comparison levels as a filter.
            _contacts.stream()
                    .sorted(Comparator.comparing(Contact::getName)
                            .thenComparing(Contact::getSurname))
                    .forEach(contact -> System.out.println(contact.toString()));
        }
    }


}
