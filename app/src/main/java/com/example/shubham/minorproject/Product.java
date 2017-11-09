package com.example.shubham.minorproject;

import java.util.ArrayList;

/**
 * Created on 18-09-2017.
 */

public class Product {

    String itemId;
    String title;
    Price price;
    Image image;
    ArrayList<Image> additionalImages;
    String itemHref;
    String itemWebUrl;

    class marketPrice{
        Price originalPrice;
        String discountPercentage;
    }


    class Image{
        String imageUrl;
    }

     class Price{
        String value;
        String currency;

        public String getValue() {
            return value;
        }

        public String getCurrency() {
            return currency;
        }


        public void setValue(String value) {
            this.value = value;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }


    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public Price getPrice() {
        return price;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
