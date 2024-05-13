import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class LoginDetails_TestDriverClass {

    LoginDetails_TestDriverClass(String DB) {
        try {
            Scanner prompt = new Scanner(System.in);
            BufferedReader read = new BufferedReader(new FileReader(DB));
            String line = null;
            boolean isUserFound = false;
            LoginDetails[] user = new LoginDetails[5];
            final int LENGTH = user.length;
            int count = 0;

            for (int i = 0; i < LENGTH; i++) {
                user[i] = new LoginDetails();
            }

            // Reading data from DB.txt file to the program [ArrayOfObject]
            String[] content;
            while ((line = read.readLine()) != null) {
                content = line.split(",");
                user[count].setUsername(content[0]);
                user[count].setPassword(content[1]);

                System.out.println(user[count].getUsername() + " " + user[count].getPassword());
                count++;
            }
            System.out.println(">>>>> > " + count);
            System.out.print("Enter your username: ");
            String username = prompt.nextLine();
            System.out.print("Enter your password: ");
            String password = prompt.nextLine();

            // Forloop for reading the content that now on the array of objects
            for (int run = 0; run < LENGTH; run++) {
                System.out.println(">> : " + user[run].getUsername() + " " + user[run].getPassword());
                if (user[run].getUsername().equals(username) && user[run].getPassword().equals(password)) {
                    isUserFound = true;
                    System.out.println("Login successful.\nWelcome " + username.toUpperCase());
                    break;
                }
            }

            if (!isUserFound) {
                System.out.println("Username not found:(");
            }

            prompt.close();
            read.close();
        } catch (Exception error) {
            error.getMessage();
            System.out.println(error.getMessage());
        }

        System.out.println("\n****File System Read Successful****");
    }

    static public void main(String... main) {
        new LoginDetails_TestDriverClass("C:/Users/LATITUDE 5410/eclipse-workspace/File_Array_of_Objects/DB.txt");
    }

}
