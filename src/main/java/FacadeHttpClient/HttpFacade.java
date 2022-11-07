package FacadeHttpClient;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * GET, POST, PUT, PATCH, DELETE
 */
public class HttpFacade {

    private final String USERS_URL = "https://reqres.in/api/users";

    public String getUserEmailById(int id) {
        String url = USERS_URL + "/" + id;
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response;
        String responseString;
        try {
            response = client.execute(new HttpGet(url));
            if (response.getCode() == 200) {
                responseString = EntityUtils.toString(((CloseableHttpResponse) response).getEntity());
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(responseString, JsonObject.class);
                return jsonObject.getAsJsonObject("data").get("email").toString();
            } else {
                throw new NoSuchElementException("Resource not found");
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String createUser(String name, String job) {
        CloseableHttpClient client = HttpClients.createDefault();
        String json = String.format("{\"name\":\"%s\", \"job\":\"%s\"}", name, job);
        HttpPost httpPost = new HttpPost(USERS_URL);
        httpPost.setEntity(new StringEntity(json));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response;
        String responseString;
        try {
            response = client.execute(httpPost);
            responseString = EntityUtils.toString((response).getEntity());
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(responseString, JsonObject.class);
            return jsonObject.get("id").toString();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String updateUserByIdWithPut(int id, String newName, String newJob) {
        String url = USERS_URL + "/" + id;
        HttpPut httpPut = new HttpPut(url);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
        String json = String.format("{\"name\":\"%s\", \"job\":\"%s\"}", newName, newJob);
        httpPut.setEntity(new StringEntity(json));
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String responseString =  EntityUtils.toString(httpclient.execute(httpPut).getEntity());
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(responseString, JsonObject.class);
            return jsonObject.get("updatedAt").toString();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String updateUserByIdWithPatch(int id, String newName, String newJob) {
        String url = USERS_URL + "/" + id;
        HttpPatch httpPatch = new HttpPatch(url);
        httpPatch.setHeader("Accept", "application/json");
        httpPatch.setHeader("Content-type", "application/json");
        String json = String.format("{\"name\":\"%s\", \"job\":\"%s\"}", newName, newJob);
        httpPatch.setEntity(new StringEntity(json));
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String responseString =  EntityUtils.toString(httpclient.execute(httpPatch).getEntity());
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(responseString, JsonObject.class);
            return jsonObject.get("updatedAt").toString();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteUserById(int id) {
        String url = USERS_URL + "/" + id;
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.setHeader("Accept", "application/json");
        httpDelete.setHeader("Content-type", "application/json");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            return httpclient.execute(httpDelete).getCode() == 204;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String validateUrl(String url) {
        if (url.startsWith("https://") || url.startsWith("http://")) {
            return url;
        } else {
            return "http://" + url;
        }
    }
}
