package com.example.shubham.minorproject;

import java.util.ArrayList;

/**
 * Created on 26-09-2017.
 */

public class ProductDetails {

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Product.Price getPrice() {
        return price;
    }

    public Product.Image getImage() {
        return image;
    }

    public String getItemHref() {
        return itemHref;
    }

    public ArrayList<Product.Image> getAdditionalImages() {
        return additionalImages;
    }

    public String getItemWebUrl() {
        return itemWebUrl;
    }

    public Seller getSeller() {
        return seller;
    }

    public Location getItemLocation() {
        return itemLocation;
    }

    public stockStatus getEstimatedAvailabilities() {
        return estimatedAvailabilities;
    }

    public review getPrimaryProductReviewRating() {
        return primaryProductReviewRating;
    }

    private String itemId;
    private String title;
    private String shortDescription;
    private Product.Price price;
    private Product.Image image;
    private String itemHref;

    private ArrayList<Product.Image> additionalImages;

    private String itemWebUrl;

    private Seller seller;
    private Location itemLocation;
    private stockStatus estimatedAvailabilities;
    private review primaryProductReviewRating;

    class review{
        String averageRating;
    }

    class stockStatus{

        String estimatedAvailabilityStatus;
    }

    class Seller{
        String username;
    }

    class Location{
        String city;
        String stateOrProvince;
        String country;

    }
}
