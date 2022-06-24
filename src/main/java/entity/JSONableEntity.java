package entity;

import org.json.JSONObject;

public interface JSONableEntity {

    JSONObject toJSON(String mvRecordAction);
}
