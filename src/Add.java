import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Add {

    public static void add_contact() throws IOException {

        Scanner input= new Scanner(System.in);
        boolean valid;
        String f1 = "";
        String f2 = "";
        String f3 = "";
        long f4 = -1;
        System.out.println("Enter First Name: ");
        f1 = input.nextLine();
        System.out.println("Enter Last Name: ");
        f2 = input.nextLine();
        System.out.println("Enter Address: ");
        f3 = input.nextLine();
        f3 = "\"" + f3 + "\"";
        do {
            valid = true;
            System.out.println("Enter Phone Number: ");
            try {
                f4 = Long.parseLong(input.nextLine());
            } catch (NumberFormatException e) {
                valid = false;
                System.out.println("Invalid Phone Number. Please enter it again.");
            }
        } while (!valid);
        if (f1 == "" || f2 == "" || f3 == "" || f4 == -1) {
            System.out.println("Invalid inputs, adding new contact wasn't successful .");
        }
        else {
            f1 = f1.toLowerCase();
            f2 = f2.toLowerCase();
            add_contact_based_on_name(f1, f2, f3, f4);
            add_contact_based_on_phone_number(f1, f2, f3, f4);
            System.out.println("\n----Contact saved successfully----\n");
        }
        System.out.println("----------------------------------------------");
    }

    private static void add_contact_based_on_name(String f1, String f2, String f3, long f4) throws IOException {
        String path = Main.get_path_based_on_name(f1, f2);
        File file = new File(path);
        boolean isCreated = false;
        if (!file.isFile()) {
            isCreated = file.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream(path, true), StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        String str = f1 + "," + f2 + "," + f3 + "," + f4;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        if (isCreated) out.println("First Name,Last Name,Address,Phone Number");
        out.println(str);
        out.close();
        writer.close();
        reader.close();
    }

    private static void add_contact_based_on_phone_number(String f1, String f2, String f3, long f4) throws IOException {
        String path = Main.get_path_based_on_phone_number(f4);
        File file = new File(path);
        boolean isCreated = false;
        if (!file.isFile()) {
            isCreated = file.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream(path, true), StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        String str = f1 + "," + f2 + "," + f3 + "," + f4;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        if (isCreated) out.println("First Name,Last Name,Address,Phone Number");
        out.println(str);
        out.close();
        writer.close();
        reader.close();
    }
}