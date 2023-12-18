import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int exit = 0;
        int answer;
        do {
            System.out.println("-------- Welcome to Address Book CLI ---------");
            System.out.println("Enter '1' to Add contact");
            System.out.println("Enter '2' to Search contact");
            System.out.println("Enter '0' to Exit");
            System.out.println("----------------------------------------------");
            try {
                answer = input.nextInt();
            } catch (NumberFormatException e) {
                answer = -1;
            }
            if(answer == 1)
                Add.add_contact();
            else if (answer == 2)
                Search.choose_field();
        } while (answer != exit);
        System.out.println("Application terminating...");
    }

    public static String get_path_based_on_name(String f1, String f2) {
        return System.getProperty("user.dir")+"/src/Address_Book/contacts" + f1.charAt(0) + f2.charAt(0) + ".txt";
    }

    public static String get_path_based_on_phone_number(long f1) {
        String phone_number = String.valueOf(f1);

        return System.getProperty("user.dir")+"/src/Address_Book/contacts" +
                phone_number.substring(0, min(3, phone_number.length())) +
                "000".substring(min(3, phone_number.length()), 3) +
                ".txt";
    }
}