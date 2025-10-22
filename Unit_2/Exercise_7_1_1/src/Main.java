import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean exitProgram = false;
        SerializeManager mySerialize = new SerializeManager("contacts.obj");
        ContactManager myContacts = new ContactManager();

        while (!exitProgram)
        {
            switch (showMenu())
            {
                case 1:
                    myContacts.addContact(createContact());
                    break;
                case 2:
                    myContacts.showAllContacts();
                    break;
                case 3:
                    String name = getNameOrSurnameOrPhone("name");
                    String surname = getNameOrSurnameOrPhone("surname");
                    myContacts.seekContact(name, surname);
                    break;
                case 4:
                    String phoneNumber = getNameOrSurnameOrPhone("phone");
                    myContacts.getContactByPhone(phoneNumber);
                    break;
                case 5:
                    myContacts = mySerialize.loadData();
                    break;
                case 6:
                    mySerialize.saveData(myContacts);
                    break;
                case 7:
                    System.out.println("Bye, see ya !!");
                    exitProgram = true;
                    break;
                default:
                    break;
            }
        }
    }

    public static int showMenu()
    {
        Scanner myScan = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("Welcome to Contact Manager.");
            System.out.println("\n Options:");
            System.out.println("1. Create Contact.");
            System.out.println("2. Display all Contacts.");
            System.out.println("3. Seek contact by name and surname.");
            System.out.println("4. Seek contact by phone number.");
            System.out.println("5. Load saved data.");
            System.out.println("6. Save data.");
            System.out.println("7. Exit");
            choice = Integer.parseInt(myScan.nextLine());
        }while(choice < 1 || choice > 7);

//        myScan.close();
        return choice;
    }

    public static Contact createContact()
    {
        Scanner myScan = new Scanner(System.in);
        boolean exit = false;
        Contact newContact = null;

        try
        {
            do
            {
                System.out.println("Enter Contact Name:");
                String name = myScan.nextLine();
                System.out.println("Enter Contact Surname:");
                String surname = myScan.nextLine();
                System.out.println("Enter Contact Email:");
                String email = myScan.nextLine();
                System.out.println("Enter Contact Phone Number:");
                String phone = myScan.nextLine();
                System.out.println("Enter description:");
                String description = myScan.nextLine();

                if (!name.isEmpty() || !surname.isEmpty() || !email.isEmpty() || !phone.isEmpty() || !description.isEmpty())
                {
                    newContact = new Contact(name, surname, email, phone, description);
                    exit = true;
                }

                System.out.println("Contact created successfully.");
            }while (!exit);
        }
        catch (Exception e)
        {
            System.out.println("Error Creating Contact: "  + e.getMessage());
        }

//        myScan.close();

        return newContact;
    }

    /*
    * returns the name, surname or phone number, depending on the parameter.
    * */
    private static String getNameOrSurnameOrPhone(String nameOrSurname)
    {
        String name = "";
        Scanner myScan = new Scanner(System.in);
        try
        {
            System.out.printf("Enter contact %s: \n", nameOrSurname);
            name = myScan.nextLine();
        }
        catch (Exception e)
        {
            System.out.println("Error: "  + e.getMessage());
        }

//        myScan.close();
        return name;
    }
}