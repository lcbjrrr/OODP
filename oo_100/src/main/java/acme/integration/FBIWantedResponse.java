package acme.integration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class FBIWantedResponse {
    public int total;
    public List<FBIWantedItem> items;

    public int getTotal() {
        return total;
    }

    public List<FBIWantedItem> getItems() {
        return items;
    }
}

