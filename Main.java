import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> serviceNames = new ArrayList<>();
        ArrayList<String> serviceCategories = new ArrayList<>();
        ArrayList<Double> hourlyRates = new ArrayList<>();
        ArrayList<Boolean> isBooked = new ArrayList<>();
        ArrayList<Integer> cart = new ArrayList<>();
        boolean running = true;

        while(running) {
            System.out.println("\nWelcome to Olivers marketplace!");
            System.out.println("1 add a Service");
            System.out.println("2 browse & book a Service");
            System.out.println("3 remove Service from Cart");
            System.out.println("4 checkout");
            System.out.println("5 exit");
            System.out.print("Choose an option: ");
            int yourChoice = input.nextInt();
            input.nextLine(); // clear input

            if (yourChoice == 1) {
                System.out.print("Enter service name: ");
                String name = input.nextLine();
                System.out.print("Enter category (example: plumbing, tutoring, cleaning): ");
                String category = input.nextLine();
                System.out.print("Enter hourly rate: ");
                double rate = input.nextDouble();
                input.nextLine(); // clear input

                serviceNames.add(name);
                serviceCategories.add(category);
                hourlyRates.add(rate);
                isBooked.add(false);
                System.out.println("service added successfully!");
            } else if (yourChoice == 2) { // this part is where requirement 3 & 4 were added, in the middle
                if (serviceNames.size() == 0) {
                    System.out.println(" not an option.");
                }
                // show categories
                ArrayList<String> categories = new ArrayList<>();
                for (int i = 0; i < serviceCategories.size(); i++) {
                    String cat = serviceCategories.get(i);
                    if (!categories.contains(cat)) {
                        categories.add(cat);
                    }
                }
                System.out.println("Categories:");
                for (int i = 0; i < categories.size(); i++) {
                    System.out.println((i+1) + ". " + categories.get(i));
                }
                System.out.print("Pick a category number: ");
                int categNum = input.nextInt();
                input.nextLine();
                if (categNum < 1 || categNum > categories.size()) {
                    System.out.println(" not an option.");
                }
                String chosenCat = categories.get(categNum-1);
                // Show services in that category
                ArrayList<Integer> found = new ArrayList<>();
                System.out.println("Services:");
                for (int i = 0; i < serviceNames.size(); i++) {
                    if (serviceCategories.get(i).equals(chosenCat)) {
                        found.add(i);
                        String status;
                        if (isBooked.get(i)) {
                            status = "fully Booked :( ";
                        } else {
                            status = "Available";
                        }
                        System.out.println(found.size() + ". " + serviceNames.get(i) + " - $" + hourlyRates.get(i) + "/hr [" + status + "]");
                    }
                }
                if (found.size() == 0) {
                    System.out.println("no services in this category.");
                }
                System.out.print("pick a service number to add to cart (0 to go back): "); // changed "book" to "add to cart"
                int servNum = input.nextInt();
                input.nextLine();

                if (servNum == 0) {
                    // go back
                } else if (servNum < 1 || servNum > found.size()) {
                    System.out.println(" not an option.");
                } else {
                    int realIndex = found.get(servNum-1);
                    if (isBooked.get(realIndex)) {
                        System.out.println("sorry this service is fully booked.");
                    } else if (cart.contains(realIndex)) {
                        System.out.println("this service is already in your cart.");
                    } else {
                        cart.add(realIndex);
                        System.out.println("Service added to cart!");
                    }
                }
                // shows cart after service is added
                System.out.println("Your cart:");
                if (cart.size() == 0) {
                    System.out.println("Cart is empty.");
                } else {
                    for (int i = 0; i < cart.size(); i++) {
                        int index = cart.get(i);
                        System.out.println((i+1) + ". " + serviceNames.get(index) + " - $" + hourlyRates.get(index) + "/hr");
                    }
                }
            } else if (yourChoice == 3) {
                // remove service from cart
                if (cart.size() == 0) {
                    System.out.println("cart is empty, nothing to remove.");
                } else {
                    System.out.println("your cart:");
                    for (int i = 0; i < cart.size(); i++) {
                        int index = cart.get(i);
                        System.out.println((i+1) + ". " + serviceNames.get(index) + " - $" + hourlyRates.get(index) + "/hr");
                    }
                    System.out.print("Enter the number of the service to remove (0 to go back): ");
                    int removeNum = input.nextInt();
                    input.nextLine();
                    if (removeNum == 0) {
                        // go back
                    } else if (removeNum < 1 || removeNum > cart.size()) {
                        System.out.println(" not an option.");
                    } else {
                        int removeIndex = cart.get(removeNum-1);
                        cart.remove(removeNum-1);
                        // updates th availability
                        isBooked.set(removeIndex, false);
                        System.out.println("Service removed from cart.");
                    }
                    // show updated cart
                    System.out.println("Your cart:");
                    if (cart.size() == 0) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (int i = 0; i < cart.size(); i++) {
                            int index = cart.get(i);
                            System.out.println((i+1) + ". " + serviceNames.get(index) + " - $" + hourlyRates.get(index) + "/hr");
                        }
                    }
                }
            } else if (yourChoice == 4) {
                // checkout
                if (cart.size() == 0) {
                    System.out.println("Cart is empty. Nothing to checkout.");
                } else {
                    double total = 0;
                    System.out.println("Invoice:");
                    for (int i = 0; i < cart.size(); i++) {
                        int index = cart.get(i);
                        System.out.println((i+1) + ". " + serviceNames.get(index) + " - $" + hourlyRates.get(index) + "/hr");
                        total = total + hourlyRates.get(index); 
                    }
                    System.out.println("Total: $" + total);
                    System.out.print("Confirm order? (yes/no): ");
                    String confirm = input.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        for (int i = 0; i < cart.size(); i++) {
                            int index = cart.get(i);
                            isBooked.set(index, true);
                        }
                        cart.clear();
                        System.out.println("Thank you for your order!");
                    } else {
                        System.out.println("Order cancelled.");
                    }
                }
            } else if (yourChoice == 5) {
                System.out.println("thanks for using olivers marketplace!"); // added my name
                running = false;
            } else {
                System.out.println(" not an option.");
            }
        }
    }
}
