package Services;

import Entities.Products;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class InventoryControl {

    private ArrayList<Products> productsList = new ArrayList<>();
    private final String FILE_PATH = "src/main/resources/data/products.csv";

    public InventoryControl(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0].trim();
                    double price = Double.parseDouble(data[1].trim());
                    int quantity = Integer.parseInt(data[2].trim());

                    Products product = new Products(name, price, quantity);
                    productsList.add(product);


                }
            }
        }
        catch (Exception e) {
            System.out.println("Error reading the CSV file" + e.getMessage());
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            }

            catch (Exception e) {
                System.out.println("Error closing the file." + e.getMessage());
            }
        }
    }
    private void writeToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FILE_PATH));
            bw.write("Name,Price,Quantity\n");
            for (Products product : productsList) {
                bw.write(product.getName() + "," + product.getPrice() + "," + product.getQuantity() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error writing to the CSV file: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }




    public void addProducts(Products product) {
        try {
            productsList.add(product);
            writeToFile();
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public void removeProductByName(String productName) {
        try {
            Products productToRemove = null;
            for (Products product : productsList) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    productToRemove = product;
                    break;
                }
            }
            if (productToRemove != null) {
                productsList.remove(productToRemove);
                writeToFile();
            }
            else {
                System.out.println("Produto não encontrado!");
            }
        }
        catch (Exception e) {
            System.out.println("Error removing product: " + e.getMessage());
        }
    }


    public void modifyProductQuantity(String productName, int newQuantity) {
        try {
            for (Products product : productsList) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    product.setQuantity(newQuantity);
                    writeToFile();
                    return;
                }
            }
            System.out.println("Produto não encontrado!");
        } catch (Exception e) {
            System.out.println("Error modifying product quantity: " + e.getMessage());
        }
    }


    public void modifyProductPrice(String productName, double newPrice) {
        try {
            for (Products product : productsList) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    product.setPrice(newPrice);
                    writeToFile();
                    return;
                }
            }
            System.out.println("Produto não encontrado!");
        } catch (Exception e) {
            System.out.println("Error modifying product price: " + e.getMessage());
        }
    }

    public void printProducts(){
        for (Products product : productsList) {
            System.out.println(product);
        }
    }

    public ArrayList<Products> getProductsList() {
        return productsList;
    }



}
