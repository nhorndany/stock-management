import model.Product;
import utils.RenderTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        RenderTable.systemHeader();

        while (true) {
            RenderTable.renderMenuList();
            System.out.print("command -> ");
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "w" -> {

                    Product product = new Product();
                    product.write(scanner);
                    productList.add(product);
                    System.out.println("Product added successfully.");
                }

                case "*" -> {
                    RenderTable.renderProducts(productList);
                    System.out.printf("%n %n");
                }

                case "r" -> {

                    Product product = new Product();
                    System.out.print("Enter Product ID to read: ");
                    int readId = scanner.nextInt();
                    scanner.nextLine();
                    product.readProduct(readId, productList);
                }
                case "u" -> {
                    boolean exit = false;
                    while (!exit) {
                        System.out.println("What do you want to update?");
                        RenderTable.updateTable();
                        System.out.print("Option (1-5) : ");
                        int option = scanner.nextInt();
                        scanner.nextLine();

                        switch (option) {
                            case 1 -> {
                                Product product = new Product();
                                System.out.print("Enter Product ID to update: ");
                                int updateId = scanner.nextInt();
                                scanner.nextLine();

                                product.updateAll(updateId, productList, scanner);
                            }
                            case 2 -> {
                                Product product = new Product();
                                System.out.print("Enter Product ID to update: ");
                                int updateId = scanner.nextInt();
                                scanner.nextLine();

                                product.updateByName(updateId, productList, scanner);
                            }
                            case 3 -> {
                                Product product = new Product();
                                System.out.print("Enter Product ID to update: ");
                                int updateId = scanner.nextInt();
                                scanner.nextLine();

                                product.updateByUnitPrice(updateId, productList, scanner);
                            }
                            case 4 -> {
                                Product product = new Product();
                                System.out.print("Enter Product ID to update: ");
                                int updateId = scanner.nextInt();
                                scanner.nextLine();

                                product.updateByQty(updateId, productList, scanner);
                            }

                            case 5 -> {
                                exit = true;
                            }

                            default -> System.out.println("You Enter Invalid!!!");
                        }
                    }
                }
                case "d" -> {
                    Product product = new Product();
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    product.deleteProduct(deleteId, productList, scanner);
                }
                case "s" -> {
                    System.out.println("Search");
                }
                case "e" -> {
                    scanner.close();
                    System.out.println("Goodbye!!!");
                    System.exit(0);
                }
                default -> System.out.println("Input invalid !!!");
            }
        }
    }
}