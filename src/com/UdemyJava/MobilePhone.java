package com.UdemyJava;

import java.util.ArrayList;

import static com.UdemyJava.Main.scanner;


public class MobilePhone {

    private static ArrayList<Contacts> contacts = new ArrayList<>();


    public static void addContact(String name) {
        if (!findContact(name)) {
            System.out.println("Please enter the new contacts number: ");
            String number = scanner.nextLine();
            Contacts newContact = new Contacts();
            newContact.setName(name);
            newContact.setNumber(number);
            contacts.add(newContact);
        } else {
            System.out.println("Contact already exists.");
        }
    }

    public static boolean findContact(String name) {
        boolean exists = false;
        for(Contacts currentContact : contacts) {
            if(name.equals(currentContact.getName())) {
                exists = true;
            } else {
                continue;
            }
        }
        return exists;
    }

    public static int getContactIndex(String name) {
        int i = 0;
        if (findContact(name)) {
            for (Contacts currentContact : contacts) {
                if (name.equals(currentContact.getName())) {
                    break;
                } else {
                    i++;
                }
            }
            return i;
        } else {
            return -1;
        }
    }

    public static String getContactNumber(String name) {
        for (Contacts currentContact : contacts) {
            if (name.equals(currentContact.getName())) {
                return currentContact.getNumber();
            } else {
                System.out.println("Contact does not exist.");
            }
        }
        return null;
    }

    public static void removeExistingContact(String name) {
        if (findContact(name)) {
            int index = getContactIndex(name);
            contacts.remove(index);
        } else {
            System.out.println("Contact does not exist.");
        }
    }

    public static void getContacts() {
        for (Contacts currentContact: contacts) {
            System.out.println("Name: " + currentContact.getName() + " Number: "
            + currentContact.getNumber());
        }
        System.out.println();
    }

    public static void modifyContact(String name) {
        if (!findContact(name)) {
            System.out.println("Contact does not exist.");
        } else {
            System.out.println("Do you want to change the name of the contact? Y or N");
            String newName = scanner.nextLine();
            newName = newName.toUpperCase();
            if (newName.equals("N")) {
                System.out.println("Enter the new number:");
                Contacts newContact = new Contacts();
                newContact.setName(name);
                newContact.setNumber(scanner.nextLine());
                contacts.set(getContactIndex(name), newContact);
            } else {
                System.out.println("Enter the new name of the Contact.");
                Contacts newContact = new Contacts();
                newContact.setName(scanner.nextLine());
                newContact.setNumber(getContactNumber(name));
                contacts.set(getContactIndex(name), newContact);

            }
        }
    }
}

