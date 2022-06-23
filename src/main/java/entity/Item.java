package entity;

import org.json.JSONObject;

public interface Item {

    public JSONObject toJSON(String mvRecordAction);
}
