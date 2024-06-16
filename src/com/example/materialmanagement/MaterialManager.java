package com.example.materialmanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    private static final String FILE_NAME = "materials.txt";
    private List<Material> materials;

    public MaterialManager() {
        materials = new ArrayList<>();
        loadMaterials();
    }

    public void addMaterial(Material material) {
        materials.add(material);
        saveMaterials();
    }

    public List<Material> getAllMaterials() {
        return new ArrayList<>(materials);
    }

    public void updateMaterial(Material material) {
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId() == material.getId()) {
                materials.set(i, material);
                saveMaterials();
                return;
            }
        }
    }

    public void deleteMaterial(int id) {
        materials.removeIf(material -> material.getId() == id);
        saveMaterials();
    }

    private void loadMaterials() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                materials.add(new Material(id, name, quantity));
            }
        } catch (IOException e) {
            System.err.println("Could not load materials: " + e.getMessage());
        }
    }

    private void saveMaterials() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Material material : materials) {
                writer.write(material.getId() + "," + material.getName() + "," + material.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Could not save materials: " + e.getMessage());
        }
    }
}