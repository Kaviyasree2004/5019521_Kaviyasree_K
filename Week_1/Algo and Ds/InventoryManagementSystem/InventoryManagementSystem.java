import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManager {
    private Map<String, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found!");
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        Product product1 = new Product("1", "Product 1", 100, 10.5);
        Product product2 = new Product("2", "Product 2", 200, 20.0);

        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2);

        Product updatedProduct1 = new Product("1", "Updated Product 1", 150, 15.0);
        inventoryManager.updateProduct(updatedProduct1);

        inventoryManager.deleteProduct("2");

        Product retrievedProduct = inventoryManager.getProduct("1");
        System.out.println(retrievedProduct);
    }
}
