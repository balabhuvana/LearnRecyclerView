package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kannan on 6/9/2016.
 */
public class Fruits {

    @SerializedName("fruitName")
    private String fruitName;
    @SerializedName("fruitPrice")
    private String fruitPrice;
    @SerializedName("fruitWeight")
    private String fruitWeight;
    @SerializedName("fruitUrl")
    private String fruitUrl;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(String fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public String getFruitWeight() {
        return fruitWeight;
    }

    public void setFruitWeight(String fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    public String getFruitUrl() {
        return fruitUrl;
    }

    public void setFruitUrl(String fruitUrl) {
        this.fruitUrl = fruitUrl;
    }
}
