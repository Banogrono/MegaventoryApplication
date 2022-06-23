

package entity;

import lombok.Data;
import org.json.JSONObject;

@Data
public class Discount implements Item  {

    // ========================================================================================
    // Fields
    // ========================================================================================

    private String name;
    private String description;
    private double value;

    // ========================================================================================
    // Constructors
    // ========================================================================================

    public Discount(String name, String description, double value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public Discount() {
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
        JSONObject mvDiscount = new JSONObject();

        mvDiscount.put("DiscountName", this.getName());
        mvDiscount.put("DiscountDescription", this.getDescription());
        mvDiscount.put("DiscountValue", this.getValue());

//        add product details to final json
        json.put("mvDiscount", mvDiscount);

        return json;
    }

}