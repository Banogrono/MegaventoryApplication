import entity.*;
import service.RestService;

public class Main {

    // ========================================================================================
    // Methods
    // ========================================================================================

    public static void main(String[] args) {

        var service = new RestService();

        var productEndpoint = "Product/ProductUpdate";
        var product = new Product(1112256, "Nike shoes", 99.99, 44.99);
        service.insertItem(productEndpoint, product);

        var clientEndpoint = "SupplierClient/SupplierClientUpdate";
        var client = new Client("babis", "babis@exampletest.com ", "Example 8, Athens", "1235698967");
        service.insertItem(clientEndpoint, client);

        var inventoryEndpoint = "InventoryLocation/InventoryLocationUpdate";
        var inventory = new InventoryLocation("Test", "Test Project Location", " Example 20, Athens ");
        service.insertItem(inventoryEndpoint, inventory);

        var taxEndpoint = "Tax/TaxUpdate";
        var tax = new Tax("VAT", "VAT GR", 24.0);
        service.insertItem(taxEndpoint, tax);

        var discountEndpoint = "Discount/DiscountUpdate";
        var discount = new Discount("Loyalty", "Loyalty Customer Discount", 50.0);
        service.insertItem(discountEndpoint, discount);

    }

}
