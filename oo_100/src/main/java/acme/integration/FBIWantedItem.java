package acme.integration;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class FBIWantedItem {
    public String title;
    public int reward_max;

    public String getTitle() {
        return title;
    }

    public int getReward_max() {
        return reward_max;
    }
}

