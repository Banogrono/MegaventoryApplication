
package entity;

import lombok.Data;
import org.json.JSONObject;

@Data
public class Client implements Item  {

    // ========================================================================================
    // Fields
    // ========================================================================================

    private String name;
    private String email;
    private String shippingAddress;
    private String phone;

    // ========================================================================================
    // Constructors
    // ========================================================================================

    public Client(String name, String email, String shippingAddress, String phone) {
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.phone = phone;
    }

    public Client() {
    }

    // ========================================================================================
    // Getters & Setters
    // ========================================================================================

    // generated by lombok

    // ========================================================================================
    // Methods
    // ========================================================================================

    public JSONObject toJSON(String mvRecordAction) {
        //      creating the json object
        JSONObject json = new JSONObject();

//        Insert action
        json.put("mvRecordAction", mvRecordAction);

//        creating the product details
        JSONObject mvSupplierClient = new JSONObject();

        mvSupplierClient.put("SupplierClientName", this.getName());
        mvSupplierClient.put("SupplierClientEmail", this.getEmail());
        mvSupplierClient.put("SupplierClientShippingAddress1", this.getShippingAddress());
        mvSupplierClient.put("SupplierClientPhone1", this.getPhone());

//        add product details to final json
        json.put("mvSupplierClient", mvSupplierClient);

        return json;
    }

}
