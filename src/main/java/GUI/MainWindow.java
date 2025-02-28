package GUI;

import Services.InventoryControl;
import Entities.Products;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private InventoryControl inventoryControl;

    public MainWindow() {
        inventoryControl = new InventoryControl();

        setTitle("StockFlow");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("StockFlow - Inventory Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton btnAddProduct = new JButton("Add Product");
        JButton btnRemoveProduct = new JButton("Remove Product");
        JButton btnViewStock = new JButton("View Products");
        JButton btnEditProduct = new JButton("Edit Product");

        Dimension buttonSize = new Dimension(200, 40);
        btnAddProduct.setPreferredSize(buttonSize);
        btnRemoveProduct.setPreferredSize(buttonSize);
        btnViewStock.setPreferredSize(buttonSize);
        btnEditProduct.setPreferredSize(buttonSize);

        buttonPanel.add(btnAddProduct);
        buttonPanel.add(btnRemoveProduct);
        buttonPanel.add(btnViewStock);
        buttonPanel.add(btnEditProduct);

        add(buttonPanel, BorderLayout.CENTER);

        btnAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        btnRemoveProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeProduct();
            }
        });

        btnViewStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStock();
            }
        });

        btnEditProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProduct();
            }
        });

        setVisible(true);
    }

    private void addProduct() {
        JTextField nameField = new JTextField(15);
        JTextField priceField = new JTextField(10);
        JTextField quantityField = new JTextField(5);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Product Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Add Product", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Products product = new Products(name, price, quantity);
            inventoryControl.addProducts(product);
            JOptionPane.showMessageDialog(null, "Product " + name + " added with quantity " + quantity);
        }
    }

    private void removeProduct() {
        String productName = JOptionPane.showInputDialog("Enter the name of the product to remove:");
        if (productName != null && !productName.isEmpty()) {
            inventoryControl.removeProductByName(productName);
            JOptionPane.showMessageDialog(null, "Product " + productName + " removed.");
        } else {
            JOptionPane.showMessageDialog(null, "Product name cannot be empty.");
        }
    }

    private void viewStock() {
        StringBuilder stockDetails = new StringBuilder();
        for (Products product : inventoryControl.getProductsList()) {
            stockDetails.append(product.toString()).append("\n");
        }
        if (stockDetails.length() > 0) {
            JOptionPane.showMessageDialog(null, stockDetails.toString(), "Current Stock", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No products in stock.");
        }
    }

    private void editProduct() {
        JTextField nameField = new JTextField(15);
        JTextField newQuantityField = new JTextField(5);
        JTextField newPriceField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Product Name:"));
        panel.add(nameField);
        panel.add(new JLabel("New Quantity:"));
        panel.add(newQuantityField);
        panel.add(new JLabel("New Price:"));
        panel.add(newPriceField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Edit Product", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String quantityText = newQuantityField.getText();
            String priceText = newPriceField.getText();

            if (!quantityText.isEmpty()) {
                int newQuantity = Integer.parseInt(quantityText);
                inventoryControl.modifyProductQuantity(name, newQuantity);
            }

            if (!priceText.isEmpty()) {
                double newPrice = Double.parseDouble(priceText);
                inventoryControl.modifyProductPrice(name, newPrice);
            }

            JOptionPane.showMessageDialog(null, "Product " + name + " updated.");
        }
    }
}
