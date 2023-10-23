package model;

import utils.RenderTable;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Product {
    private static int lastId = 0;
    private int Id;
    private String proName;
    private float unitPrice;
    private int qty;
    private LocalDate localDate;

    public Product() {
        Id = ++lastId;
        LocalDate.now();
    }

    public Product(int id, String proName, float unitPrice, int qty, LocalDate localDate) {
        Id = id;
        this.proName = proName;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.localDate = localDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Product write(Scanner scanner) {

        System.out.println("Product ID: " + Id);

        System.out.print("Enter product name: ");
        proName = scanner.nextLine();
        System.out.print("Enter product unit price: ");
        unitPrice = scanner.nextFloat();
        System.out.print("Enter product quantity: ");
        qty = scanner.nextInt();
        localDate = LocalDate.now();
        scanner.nextLine();

        return this;
    }

    public void readProduct(int readId, List<Product> productList) {

        boolean isFound = false;

        for (Product product : productList) {
            if (product.getId() == readId) {
                RenderTable.readTable(productList);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Product not found!!!");
        }
    }

    public void updateAll(int updateId, List<Product> productList, Scanner scanner) {
        boolean isFound = false;
        for (Product product : productList) {
            if (product.getId() == updateId) {
                boolean validInput = false;

                while (!validInput) {
                    System.out.print("Enter your new Product ID: ");
                    int updatedId = scanner.nextInt();
                    scanner.nextLine();
                    if (product.getId() == updatedId) {
                        System.out.println("Please Enter ID again, You have input the same ID");
                    } else {
                        product.setId(updatedId);
                        validInput = true;
                    }
                }
                System.out.print("Enter the new Product name: ");
                String updatedName = scanner.nextLine();
                product.setProName(updatedName);
                System.out.print("Enter the new Product Unit Price: ");
                float updatedUnitPrice = scanner.nextFloat();
                product.setUnitPrice(updatedUnitPrice);
                System.out.print("Enter the new Product QTY: ");
                int updatedQty = scanner.nextInt();
                scanner.nextLine();
                product.setQty(updatedQty);

                System.out.println("Product updated successfully.");
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Product not found!!!");
        }
    }

    public void updateByName(int updateId, List<Product> productList, Scanner scanner) {
        boolean isFound = false;
        for (Product product : productList) {
            if (product.getId() == updateId) {
                System.out.print("Enter the new Product Name: ");
                String updatedName = scanner.nextLine();
                product.setProName(updatedName);

                System.out.println("Product updated successfully.");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Product not found!!!");
        }
    }

    public void updateByUnitPrice(int updateId, List<Product> productList, Scanner scanner) {
        boolean isFound = false;
        for (Product product : productList) {
            if (product.getId() == updateId) {
                System.out.print("Enter the new Product Unit Price: ");
                float updatedUnitPrice = scanner.nextFloat();
                product.setUnitPrice(updatedUnitPrice);

                System.out.println("Product updated successfully.");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Product not found!!!");
        }
    }

    public void updateByQty(int updateId, List<Product> productList, Scanner scanner) {
        boolean isFound = false;
        for (Product product : productList) {
            if (product.getId() == updateId) {
                System.out.print("Enter the new Product Quantity: ");
                int updatedQty = scanner.nextInt();
                product.setQty(updatedQty);

                System.out.println("Product updated successfully.");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Product not found!!!");
        }
    }

    public void deleteProduct(int deleteId, List<Product> productList, Scanner scanner) {

        Product productToDelete = null;

        for (Product product : productList) {
            if (product.getId() == deleteId) {
                productToDelete = product;
                break;
            }
        }

        if (productToDelete != null) {
            productList.remove(productToDelete);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found!!!");
        }
    }
}
