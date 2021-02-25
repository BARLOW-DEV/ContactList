package com.UdemyJava;

import java.util.Scanner;



public class Main {

    public static java.util.Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;

        printMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();

        while(!quit) {
            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    quit = true;
                    continue;
                case 1:
                    addNewContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    printContacts();
                    break;
            }
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("0 Quit");
        System.out.println("1 Add Contact");
        System.out.println("2 Remove Contact");
        System.out.println("3 Update Contact");
        System.out.println("4 Print List of Contacts");
        System.out.println("Enter your choice: ");
    }

    public static void printContacts() {
        MobilePhone.getContacts();
    }

    public static void addNewContact() {
        System.out.println("Please enter the new contact's name: ");
        String contact = scanner.nextLine();
        MobilePhone.addContact(contact);
    }

    public static void removeContact() {
        System.out.println("Please enter the contact you wish to remove: ");
        String contact = scanner.nextLine();
        MobilePhone.removeExistingContact(contact);
    }

    public static void updateContact() {
        System.out.println("Enter the name of the contact you wish to edit:");
        MobilePhone.modifyContact(scanner.nextLine());
    }

}
