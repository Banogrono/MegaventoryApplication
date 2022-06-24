import entity.*;
import entity.SaleOrder;
import entity.SaleOrderDetails;
import service.MegaventoryRestApiClient;

public class Main {

    // ========================================================================================
    // Methods
    // ========================================================================================

    public static void main(String[] args) {

        var apiClient = new MegaventoryRestApiClient();

        createAndInsertEntities(apiClient);

        createAndInsertNewSaleOrder(apiClient);

    }

    private static void createAndInsertNewSaleOrder(MegaventoryRestApiClient service) {

        var saleEndpoint = "SalesOrder/SalesOrderUpdate";
        var saleOrder = new SaleOrder(5, 3);
        var saleOrderDetails = new SaleOrderDetails("1112256", 1, 1, 2);  // todo: think about getting those IDs form the api

        saleOrder.addSaleDetails(saleOrderDetails);
        saleOrder.setSaleOrderStatus("Verified");

        service.insertEntity(saleEndpoint, saleOrder);
    }

    private static void createAndInsertEntities(MegaventoryRestApiClient apiClient) {
        var productEndpoint = "Product/ProductUpdate";
        var product = new Product(1112256, "Nike shoes", 99.99, 44.99);
        apiClient.insertEntity(productEndpoint, product);

        var clientEndpoint = "SupplierClient/SupplierClientUpdate";
        var client = new Client("babis", "babis@exampletest.com ", "Example 8, Athens", "1235698967");
        apiClient.insertEntity(clientEndpoint, client);

        var inventoryEndpoint = "InventoryLocation/InventoryLocationUpdate";
        var inventory = new InventoryLocation("Test", "Test Project Location", " Example 20, Athens ");
        apiClient.insertEntity(inventoryEndpoint, inventory);

        var taxEndpoint = "Tax/TaxUpdate";
        var tax = new Tax("VAT", "VAT GR", 24.0);
        apiClient.insertEntity(taxEndpoint, tax);

        var discountEndpoint = "Discount/DiscountUpdate";
        var discount = new Discount("Loyalty", "Loyalty Customer Discount", 50.0);
        apiClient.insertEntity(discountEndpoint, discount);
    }

}
