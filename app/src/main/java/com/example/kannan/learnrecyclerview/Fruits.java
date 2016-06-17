package com.example.kannan.learnrecyclerview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

/**
 * Created by Kannan on 6/9/2016.
 */
public class Fruits extends BaseObservable {

    @SerializedName("fruitName")
    private String fruitName;
    @SerializedName("fruitPrice")
    private String fruitPrice;
    @SerializedName("fruitWeight")
    private String fruitWeight;
    @SerializedName("fruitUrl")
    private String fruitUrl;

    @Bindable
    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
        notifyPropertyChanged(com.example.kannan.learnrecyclerview.BR.fruitName);
    }

    @Bindable
    public String getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(String fruitPrice) {
        this.fruitPrice = fruitPrice;
        notifyPropertyChanged(com.example.kannan.learnrecyclerview.BR.fruitPrice);
    }

    @Bindable
    public String getFruitWeight() {
        return fruitWeight;
    }

    public void setFruitWeight(String fruitWeight) {
        this.fruitWeight = fruitWeight;
        notifyPropertyChanged(com.example.kannan.learnrecyclerview.BR.fruitWeight);
    }

    @Bindable
    public String getFruitUrl() {
        return fruitUrl;
    }

    public void setFruitUrl(String fruitUrl) {
        this.fruitUrl = fruitUrl;
        notifyPropertyChanged(com.example.kannan.learnrecyclerview.BR.fruitUrl);
    }

    @BindingAdapter({"bind:fruitUrl"})
    public static void loadImage(ImageView view, String fruitUrl) {
        Picasso.with(view.getContext())
                .load(fruitUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }


}
