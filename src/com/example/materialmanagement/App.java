package com.example.materialmanagement;

import java.util.Scanner;

public class App {
    private static MaterialManager materialManager = new MaterialManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("1. Add Material");
            System.out.println("2. List Materials");
            System.out.println("3. Update Material");
            System.out.println("4. Delete Material");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (option) {
                case 1:
                    addMaterial(scanner);
                    break;
                case 2:
                    listMaterials();
                    break;
                case 3:
                    updateMaterial(scanner);
                    break;
                case 4:
                    deleteMaterial(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 5);
        scanner.close();
    }

    private static void addMaterial(Scanner scanner) {
        System.out.print("Enter material name: ");
        String name = scanner.nextLine();
        System.out.print("Enter material quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Material material = new Material(name, quantity);
        materialManager.addMaterial(material);
        System.out.println("Material added successfully.");
    }

    private static void listMaterials() {
        for (Material material : materialManager.getAllMaterials()) {
            System.out.println(material);
        }
    }

    private static void updateMaterial(Scanner scanner) {
        System.out.print("Enter material ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new material name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new material quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Material material = new Material(id, name, quantity);
        materialManager.updateMaterial(material);
        System.out.println("Material updated successfully.");
    }

    private static void deleteMaterial(Scanner scanner) {
        System.out.print("Enter material ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        materialManager.deleteMaterial(id);
        System.out.println("Material deleted successfully.");
    }
}