import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contacts;
    private static Scanner in;
    private static int id = 0;

    public static void main(String[] args) {

        contacts = new ArrayList<>();
        showInitialOption();
    }

    private static void showInitialOption() {
        in = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Please select an option\t: " +
                    "\n\t1. Manage Contacts" +
                    "\n\t2. Messages" +
                    "\n\t3. Quit");
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    manageContacs();
                    break;
                case 2:
                    messages();
                    break;
            }
        }
    }

    private static void manageContacs() {
        System.out.println("Select an option\t:"+
                "\n\t1.Show all contacts" +
                "\n\t2.Add a new contact" +
                "\n\t3.Search for a contact" +
                "\n\t4.Delete a contact" +
                "\n\t5.Go back to previous menu");
        in = new Scanner(System.in);
        int choice = in.nextInt();
        in.nextLine();
        switch(choice){
            case 1 :
                showAllContacts();
                break;
            case 2 :
                addContact();
                break;
            case 3 :
                searchForAContact();
                break;
            case 4 :
                deleteAContact();
                break;
        }
    }
    private static void messages(){
        int choice = 0;
        while (choice !=3) {
            System.out.println("Select an option\t:" +
                    "\n\t1.See the list of all messages" +
                    "\n\t2.Send a new messages" +
                    "\n\t3.Go back to previous menu");
            in = new Scanner(System.in);
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    seeMessagesList();
                    break;
                case 2:
                    sendANewMessage();
                    break;
            }
        }
    }

    //Messages Functions
    private static void sendANewMessage() {
        System.out.println("Enter Contact's Name to Message");
        String name = in.nextLine();
        if(name.equals("")){
            System.out.println("Enter Contact's Name to Message");
            sendANewMessage();
        }else{
            boolean exist = false;
            for (Contact c :contacts){
                if(c.getName().equals(name)){
                    exist = true;
                }
            }
            if(exist){
                System.out.println("Write a message");
                String text = in.nextLine();
                if(text.equals("")){
                    System.out.println("Write a message");
                    sendANewMessage();
                }else{
                    id++;
                    Messages newMessages = new Messages(name,text,id);
                    for (Contact c :contacts) {
                        if(c.getName().equals(name)){
                            ArrayList <Messages> newMessage = c.getMessages();
                            newMessage.add(newMessages);
                            Contact currentContact = c;
                            currentContact.setMessages(newMessage);
                            contacts.remove(c);
                            contacts.add(currentContact);
                        }
                    }
                }
            }else{
                System.out.println("there's no contact's name");
            }
        }
    }

    private static void seeMessagesList() {
        ArrayList <Messages> allMessages = new ArrayList<>();
        for (Contact c:contacts) {
            allMessages.addAll(c.getMessages());
        }
        if (allMessages.size()>0){
            for (Messages m: allMessages) {
                m.getDetails();
                System.out.println("====================");
            }
        }else{
            System.out.println("No Message");
        }
    }

    //Contacs Functions
    private static void deleteAContact() {
        System.out.println("Enter a deleted contact name wannabe");
        String name = in.nextLine();
        if(name.equals("")){
            System.out.println("Enter a deleted contact name wannabe");
        }else{
            boolean exist = false;
            for (Contact c: contacts) {
                if(c.getName().equals(name)){
                    exist = true;
                    contacts.remove(c);
                }
            }
            if(!exist){
                System.out.println("Not Found");
            }
        }
    }

    private static void searchForAContact() {
        System.out.println("Enter a contact name");
        String name = in.nextLine();
        if(name.equals("")){
            System.out.println("Enter a contact name");
        }else{
            boolean exist = false;
            for(Contact c : contacts){
                if(c.getName().equals(name)){
                    exist = true;
                    c.getDetails();
                }
            }
            if(!exist){
                System.out.println("not found");
            }
        }
    }

    private static void addContact() {
        System.out.println("Adding a new Contact");


        System.out.println("Enter Name\t:");
        String name = in.nextLine();
        System.out.println("Enter Number:");
        String number = in.nextLine();
        System.out.println("Enter Email\t:");
        String email = in.nextLine();

        if(name.equals("")||number.equals("")||email.equals("")){
            System.out.println("Please enter completely");
            addContact();
        } else {
            boolean exist = false;
            for (Contact c : contacts){
                if (c.getName().equals(name)){
                    exist = true;
                }
            }
            if(exist){
                System.out.println("You already have the contact's name");
            }
            else{
                Contact contact = new Contact(name,number,email);
                contacts.add(contact);
                System.out.println(name + " added");
            }

        }
    }

    private static void showAllContacts() {
        for (Contact c: contacts) {
            c.getDetails();
            System.out.println("==================");
        }
        if(contacts.size() == 0){
            System.out.println("you don't have any contact yet");
            System.out.println("please add a contact");
            addContact();
        }
    }
}

