

package entity;

import lombok.Data;
import org.json.JSONObject;

@Data
public class Discount implements JSONableEntity {

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
        JSONObject mvDiscount = createJSONObjectFromThis();

        JSONObject container = new JSONObject();
        container.put("mvRecordAction", mvRecordAction);
        container.put("mvDiscount", mvDiscount);

        return container;
    }

    private JSONObject createJSONObjectFromThis() {
        JSONObject mvDiscount = new JSONObject();

        mvDiscount.put("DiscountName", this.getName());
        mvDiscount.put("DiscountDescription", this.getDescription());
        mvDiscount.put("DiscountValue", this.getValue());
        return mvDiscount;
    }

}
