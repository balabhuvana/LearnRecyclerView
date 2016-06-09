package model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kannan on 6/9/2016.
 */
public class GroceryItemFruits implements Parcelable {

    private String fruitImageUrl;
    private String fruitName;
    private long price;
    private double weight;

    protected GroceryItemFruits(Parcel in) {
        fruitImageUrl = in.readString();
        fruitName = in.readString();
        price = in.readLong();
        weight = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fruitImageUrl);
        dest.writeString(fruitName);
        dest.writeLong(price);
        dest.writeDouble(weight);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GroceryItemFruits> CREATOR = new Creator<GroceryItemFruits>() {
        @Override
        public GroceryItemFruits createFromParcel(Parcel in) {
            return new GroceryItemFruits(in);
        }

        @Override
        public GroceryItemFruits[] newArray(int size) {
            return new GroceryItemFruits[size];
        }
    };

    public String getFruitImageUrl() {
        return fruitImageUrl;
    }

    public void setFruitImageUrl(String fruitImageUrl) {
        this.fruitImageUrl = fruitImageUrl;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}
