import contactBook.Contact;
import contactBook.ContactBook;

import java.util.Scanner;


public class Main {
    //Constantes que definem os comandos
    public static final String ADD_CONTACT    = "AC";
    public static final String REMOVE_CONTACT = "RC";
    public static final String GET_PHONE      = "GP";
    public static final String GET_EMAIL      = "GE";
    public static final String SET_PHONE      = "SP";
    public static final String SET_EMAIL      = "SE";
    public static final String LIST_CONTACTS  = "LC";
    public static final String QUIT           = "Q";
    public static final String GET_CONTACT    = "GN";
    public static final String VERIFY_CONTACT_REPEAT= "EP";
	

    //Constantes que definem as mensagens para o utilizador
    public static final String CONTACT_EXISTS = "contactBook.Contact already exists.";
    public static final String NAME_NOT_EXIST = "contactBook.Contact does not exist.";
    public static final String CONTACT_ADDED = "contactBook.Contact added.";
    public static final String CONTACT_REMOVED = "contactBook.Contact removed.";
    public static final String CONTACT_UPDATED = "contactBook.Contact updated.";
    public static final String BOOK_EMPTY = "contactBook.Contact book empty.";
    public static final String QUIT_MSG = "Goodbye!";
    public static final String COMMAND_ERROR = "Unknown command.";



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ContactBook cBook = new ContactBook();
        String comm = getCommand(in);

        while (!comm.equals(QUIT)){
            switch (comm) {
                case ADD_CONTACT:
                    addContact(in,cBook);
                    break;
                case REMOVE_CONTACT:
                    deleteContact(in,cBook);
                    break;
                case GET_PHONE:
                    getPhone(in,cBook);
                    break;
                case GET_EMAIL:
                    getEmail(in,cBook);
                    break;
                case SET_PHONE:
                    setPhone(in,cBook);
                    break;
                case SET_EMAIL:
                    setEmail(in,cBook);
                    break;
                case LIST_CONTACTS:
                    listAllContacts(cBook);
                    break;
		case VERIFY_CONTACT_REPEAT:
                 	verifyContactsRepeats(cBook);
                 break;
                case GET_CONTACT:
				 getNameByContact(in, cBook);
				 break;
                default:
                    System.out.println(COMMAND_ERROR);
            }
            System.out.println();
            comm = getCommand(in);
        }
        System.out.println(QUIT_MSG);
        System.out.println();
        in.close();
    }
	private static void verifyContactsRepeats(ContactBook cBook) {
        cBook.samePhone();
        if(cBook.samePhone() == true) {
            System.out.println(CONTACT_SHARE_NUMBERS);
        }else
            System.out.println(DIFFERENT_NUMBERS);}
	
    private static String getCommand(Scanner in) {
        String input;

        input = in.nextLine().toUpperCase();
        return input;
    }

    private static void getNameByContact(Scanner in, ContactBook cBook) {
		int phone;
		phoneNumber = in.nextInt();  in.nextLine();
		
		 
		 if(!cBook.hasName(phone))
			 System.out.println(CONTACT_WITH_SAME_NUMBER);
		 else
		 System.out.println(cBook.getName(phone));
		
	}

    
    private static void addContact(Scanner in, ContactBook cBook) {
        String name, email;
        int phone;

        name = in.nextLine();
        phone = in.nextInt(); in.nextLine();
        email = in.nextLine();
        if (!cBook.hasContact(name)) {
            cBook.addContact(name, phone, email);
            System.out.println(CONTACT_ADDED);
        }
        else System.out.println(CONTACT_EXISTS);
    }

    private static void deleteContact(Scanner in, ContactBook cBook) {
        String name;
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            cBook.deleteContact(name);
            System.out.println(CONTACT_REMOVED);
        }
        else System.out.println(NAME_NOT_EXIST);
    }

    private static void getPhone(Scanner in, ContactBook cBook) {
        String name;
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            System.out.println(cBook.getPhone(name));
        }
        else System.out.println(NAME_NOT_EXIST);
    }

    private static void getEmail(Scanner in, ContactBook cBook) {
        String name;
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            System.out.println(cBook.getEmail(name));
        }
        else System.out.println(NAME_NOT_EXIST);
    }

    private static void setPhone(Scanner in, ContactBook cBook) {
        String name;
        int phone;
        name = in.nextLine();
        phone = in.nextInt(); in.nextLine();
        if (cBook.hasContact(name)) {
            cBook.setPhone(name,phone);
            System.out.println(CONTACT_UPDATED);
        }
        else System.out.println(NAME_NOT_EXIST);
    }

    private static void setEmail(Scanner in, ContactBook cBook) {
        String name;
        String email;
        name = in.nextLine();
        email = in.nextLine();
        if (cBook.hasContact(name)) {
            cBook.setEmail(name,email);
            System.out.println(CONTACT_UPDATED);
        }
        else System.out.println(NAME_NOT_EXIST);
    }

    private static void listAllContacts(ContactBook cBook) {
        if (cBook.getNumberOfContacts() != 0) {
            cBook.initializeIterator();
            while( cBook.hasNext() ) {
                Contact c = cBook.next();
                System.out.println(c.getName() + "; " + c.getEmail() + "; " + c.getPhone());
            }
        }
        else System.out.println(BOOK_EMPTY);
    }
}
//#vski na prozis
