/**
 * Part of MegaventoryApplication
 * Created by: @Author V
 * Date: @Date 24-Jun-22
 * Time: 11:27
 * =============================================================
 **/

package entity;

import lombok.Data;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Data
public class SaleOrder implements JSONableEntity {

    // ========================================================================================
    // Fields
    // ========================================================================================

    private int clientID;

    private int inventoryLocationID;
    private String saleOrderStatus;
    private List<SaleOrderDetails> saleDetails;

    // ========================================================================================
    // Constructors
    // ========================================================================================


    public SaleOrder(int clientID, int inventoryLocationID, String saleOrderStatus, List<SaleOrderDetails> saleDetails) {
        this.clientID = clientID;
        this.inventoryLocationID = inventoryLocationID;
        this.saleOrderStatus = saleOrderStatus;
        this.saleDetails = saleDetails;
    }

    public SaleOrder(int clientID, int inventoryLocationID) {
        this.clientID = clientID;
        this.inventoryLocationID = inventoryLocationID;
        saleDetails = new ArrayList<>();
    }

    public SaleOrder() {
        saleDetails = new ArrayList<>();
    }

    // ========================================================================================
    // Getters & Setters
    // ========================================================================================

    // generated by lombok

    // ========================================================================================
    // Methods
    // ========================================================================================

    // ------------------------ Public methods -------------------------

    @Override
    public JSONObject toJSON(String mvRecordAction) {
        JSONObject[] detailList = getListOfSaleDetails();
        JSONObject mvSalesOrder = createJSONObjectFromThis(detailList);

        JSONObject container = new JSONObject();
        container.put("mvSalesOrder", mvSalesOrder);
        container.put("mvRecordAction", mvRecordAction);

        return container;
    }

    private JSONObject createJSONObjectFromThis(JSONObject[] detailList) {
        JSONObject mvSalesOrder = new JSONObject();
        mvSalesOrder.put("SalesOrderClientId", getClientID());
        mvSalesOrder.put("SalesOrderStatus", getSaleOrderStatus());
        mvSalesOrder.put("SalesOrderDetails", detailList);
        mvSalesOrder.put("SalesOrderInventoryLocationID", getInventoryLocationID());
        return mvSalesOrder;
    }

    public void addSaleDetails(SaleOrderDetails saleOrderDetails) {
        this.getSaleDetails().add(saleOrderDetails);
    }

    public void removeSaleDetails(SaleOrderDetails saleOrderDetails) {
        this.getSaleDetails().remove(saleOrderDetails);
    }

    public SaleOrderDetails getSaleDetailsWithIndex(int index) {
        return this.getSaleDetails().get(index);
    }

    // ------------------------ Private methods ------------------------

    private JSONObject[] getListOfSaleDetails() {
        List<JSONObject> saleDetailsJSONList = new ArrayList<>();

        for (var details : getSaleDetails()) {
            JSONObject salesOrderDetails = details.toJSON(null);
            saleDetailsJSONList.add(salesOrderDetails);
        }

        JSONObject[] details = new JSONObject[saleDetailsJSONList.size()];
        details = saleDetailsJSONList.toArray(details);

        return details;
    }

}