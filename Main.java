import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> serviceNames = new ArrayList<>();
        ArrayList<String> serviceCategories = new ArrayList<>();
        ArrayList<Double> hourlyRates = new ArrayList<>();

        boolean running = true;

        while(running) {
            System.out.println("\nWelcome to Olivers marketplace!");
            System.out.println("1 add a Service");
            System.out.println("2 exit");
            System.out.print("Choose an option: ");
            int yourChoice = input.nextInt();
            input.nextLine(); // clears the input
            if (yourChoice == 1) {
                System.out.print("Enter service name: ");
                String name = input.nextLine();
                System.out.print("Enter category (example: plumbing, tutoring, cleaning): ");
                String category = input.nextLine();
                System.out.print("Enter hourly rate: ");
                double rate = input.nextDouble();
                input.nextLine(); // clears the input

                serviceNames.add(name);
                serviceCategories.add(category);
                hourlyRates.add(rate);
                System.out.println(" service added successfully!");
            } else if (yourChoice == 2) {
                System.out.println(" thanks for using the marketplace!");
                running = false;
            } else {
                System.out.println(" not an option.");
            }
        }
    }
}

