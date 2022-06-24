
package service;

import entity.APIAccessDetails;
import entity.JSONableEntity;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MegaventoryRestApiClient {


    // ========================================================================================
    // Methods
    // ========================================================================================

    // ------------------------ Public methods -------------------------

    public void insertEntity(String endpoint, JSONableEntity entity) {

        makePostRequest(endpoint, entity, "Insert");

    }

    public void updateItem(String endpoint, JSONableEntity entity) {
        makePostRequest(endpoint, entity, "Update");
    }

    // ------------------------ Private methods ------------------------

    private void makePostRequest(String query, JSONableEntity entity, String mvRecordAction) {
        try {
            HttpURLConnection connection = getPostConnectionToResources(query);

            JSONObject body = getBody(entity, mvRecordAction);

            setBodyForPostRequest(connection, body);

            System.out.println("Service: HTTP Status code: " + getResponseCode(connection));

            StringBuffer response = getAPIResponse(connection);

            closeConnection(connection);

            JSONObject contentJSON = new JSONObject(response.toString());
            System.out.println(contentJSON);
            System.out.println();

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    }

    private JSONObject getBody(JSONableEntity entity, String mvRecordAction) {
        JSONObject body = entity.toJSON(mvRecordAction);
        body.put("APIKEY", APIAccessDetails.key);
        return body;
    }

    private void setBodyForPostRequest(HttpURLConnection connection, JSONObject body) throws IOException {
        try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
            writer.write(body.toString().getBytes(StandardCharsets.UTF_8));
        }
    }

    private int getResponseCode(HttpURLConnection connection) throws IOException {
        return connection.getResponseCode();
    }

    private StringBuffer getAPIResponse(HttpURLConnection connection) throws IOException {
        return readData(connection.getInputStream());
    }

    private void closeConnection(HttpURLConnection connection) {
        connection.disconnect();
    }

    private HttpURLConnection getPostConnectionToResources(String query) throws IOException {
        URL url = new URL(APIAccessDetails.resource + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }

    // todo: refactor
    private StringBuffer readData(InputStream inputStream) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content;
        } catch (Exception e) {
            return null;
        }

    }

}
