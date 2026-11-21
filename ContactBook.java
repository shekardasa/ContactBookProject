
package com.contactbook;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    // Start application
    public void start() {

        int choice = 0;

        do {
            System.out.println("\n===== CONTACT BOOK MENU =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        addContact();
                        break;

                    case 2:
                        viewContacts();
                        break;

                    case 3:
                        searchContact();
                        break;

                    case 4:
                        deleteContact();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }

        } while (choice != 5);
    }

    // Add Contact
    private void addContact() {

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (name.trim().isEmpty() ||
            phone.trim().isEmpty() ||
            email.trim().isEmpty()) {

            System.out.println("All fields are required!");
            return;
        }

        Contact contact = new Contact(name, phone, email);

        contacts.add(contact);

        System.out.println("Contact added successfully!");
    }

    // View Contacts
    private void viewContacts() {

        if (contacts.isEmpty()) {

            System.out.println("No contacts found.");

        } else {

            System.out.println("\n===== CONTACT LIST =====");

            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }

    // Search Contact
    private void searchContact() {

        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (Contact c : contacts) {

            if (c.getName().equalsIgnoreCase(name)) {

                System.out.println("Contact found!");
                System.out.println(c);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Delete Contact
    private void deleteContact() {

        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();

        boolean removed = contacts.removeIf(
            c -> c.getName().equalsIgnoreCase(name)
        );

        if (removed) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }
}