import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Search {

    public static void choose_field() throws IOException {
        Scanner input = new Scanner(System.in);
        int exit = 0;
        int answer = -1;
        while (answer != exit) {
            System.out.println("Enter '1' to search contact based on name");
            System.out.println("Enter '2' to search contact based on phone number");
            System.out.println("Enter '0' to return to main menu");
            System.out.println("----------------------------------------------");
            try {
                answer = input.nextInt();
            } catch (Exception e) {
                answer = 0;
            }
            if(answer == 1)
                name_search();
            else if(answer == 2)
                number_search();
        }
    }

    public static void name_search() throws IOException {
        Scanner input= new Scanner(System.in);
        String f1, f2;
        System.out.println("Enter First Name: ");
        f1 = input.nextLine();
        f1 = f1.toLowerCase();
        System.out.println("Enter Last Name: ");
        f2 = input.nextLine();
        f2 = f2.toLowerCase();

        File file = new File(Main.get_path_based_on_name(f1, f2));
        if (!file.isFile()) {
            System.out.println("\nNo contacts found with the given information\n");
            System.out.println("----------------------------------------------");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;
        boolean first = false;
        String[] fields = new String[0];
        boolean isPresent = false;
        while ((currentLine = reader.readLine()) != null) {
            if (!first) {
                fields = currentLine.split(",");
                first = true;
            }
            else {
                String[] info = currentLine.split(",");
                if (info[0].equals(f1) && info[1].equals(f2)) {
                    isPresent = true;
                    System.out.println("\n----There is a contact for the information you gave----\n");
                    for (int i = 0; i < fields.length; i++ ) {
                        System.out.println(fields[i] +": "+ info[i]);
                    }
                }
            }
        }
        if (!isPresent) System.out.println("\nNo contacts found with the given information\n");
        System.out.println("----------------------------------------------");
        reader.close();
    }

    public static void number_search() throws IOException, FileNotFoundException{
        Scanner input = new Scanner(System.in);
        long f1 = -1;
        boolean valid;
        System.out.println("Enter Phone number: ");
        do {
            valid = true;
            try {
                f1 = Long.parseLong(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Phone number. Please enter it again.");
                valid = false;
            }
        } while (!valid);

        File file = new File(Main.get_path_based_on_phone_number(f1));
        if (!file.isFile()) {
            System.out.println("\nNo contacts found with the given information\n");
            System.out.println("----------------------------------------------");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;
        boolean first = false;
        String[] fields = new String[0];
        boolean isPresent = false;
        while ((currentLine = reader.readLine()) != null) {
            if (!first) {
                fields = currentLine.split(",");
                first = true;
            }
            else {
                String[] info = currentLine.split(",");
                if (info[3].equals(String.valueOf(f1))) {
                    isPresent = true;
                    System.out.println("\n----There is a contact for the information you gave----\n");
                    for (int i = 0; i < fields.length; i++) {
                        System.out.println(fields[i] + ": " + info[i]);
                    }
                }
            }
        }
        if (!isPresent) System.out.println("\nNo contacts found with the given information\n");
        System.out.println("----------------------------------------------");
        reader.close();
    }
}