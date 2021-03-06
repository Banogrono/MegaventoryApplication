
package entity;

import lombok.Data;
import org.json.JSONObject;

@Data
public class Tax implements JSONableEntity {

    // ========================================================================================
    // Fields
    // ========================================================================================

    private String name;
    private String description;
    private double value;

    // ========================================================================================
    // Constructors
    // ========================================================================================

    public Tax(String name, String description, double value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public Tax() {
    }

    // ========================================================================================
    // Getters & Setters
    // ========================================================================================

    // generated by lombok

    // ========================================================================================
    // Methods
    // ========================================================================================

    public JSONObject toJSON(String mvRecordAction) {
        JSONObject mvTax = createJSONObjectFromThis();

        JSONObject container = new JSONObject();
        container.put("mvRecordAction", mvRecordAction);
        container.put("mvTax", mvTax);

        return container;
    }

    private JSONObject createJSONObjectFromThis() {
        JSONObject mvTax = new JSONObject();

        mvTax.put("TaxName", this.getName());
        mvTax.put("TaxDescription", this.getDescription());
        mvTax.put("TaxValue", String.valueOf(this.value));
        return mvTax;
    }
}
