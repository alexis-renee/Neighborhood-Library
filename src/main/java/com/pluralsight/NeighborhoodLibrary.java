package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book(1, "0531456", "Atomic Habits");
        books[1] = new Book(2, "7777754", "7 Habits of Highly Efficient people");
        books[2] = new Book(3, "11111189", "Think and Grow Rich");
        books[3] = new Book(4, "12121212", "The Subtle Art of Not Giving a F*ck: A Counterintuitive Approach to Living a Good Life");
        books[4] = new Book(5, "45237689", "48 Laws of Power");

        Scanner scanner = new Scanner(System.in);



        while (true) {

            System.out.println("Welcome to the the Neighborhood Library. Please choose an option to continue");
            System.out.println("1 to Show Available Books");
            System.out.println("2 to Show Checked Out Books");
            System.out.println("3 to Exit");

            int response = scanner.nextInt();
            scanner.nextLine(); // Consume newline


            switch (response) {

                case 1:
                    showAvailableBooks(books, scanner);
                    break;
                case 2:
                    showCheckedOutBooks(books, scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;

            }
        }
    }

    // Method to show available books
    public static void showAvailableBooks(Book[] books, Scanner scanner) {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }
        System.out.println("Select a book to check out (enter ID) or type 'exit' to go back to home screen:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("exit")) {
            return;
        }
        int selectedId = Integer.parseInt(input);
        for (Book book : books) {
            if (book.getId() == selectedId) {
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                book.checkOut(name);
                break;
            }
        }
    }

    // Method showing checked out books
    public static void showCheckedOutBooks(Book[] books, Scanner scanner) {
        System.out.println("Checked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle()
                        + ", Checked Out To: " + book.getCheckedOutTo());
            }
        }
        System.out.println("C - Check In a book");
        System.out.println("X - Go back to home screen");
        String input = scanner.nextLine();

        switch (input.toUpperCase()) {
            case "C":
                checkInBook(books, scanner);
                break;
            case "X":
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Method to check in a book
    public static void checkInBook(Book[] books, Scanner scanner) {
        System.out.println("Enter the ID of the book you want to check in:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Book book : books) {
            if (book.getId() == id) {
                book.checkIn();
                return;
            }
        }

        System.out.println("Book with ID " + id + " not found.");

    }
}


