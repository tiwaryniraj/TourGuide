package com.example.niraj.tourguide;

public class Place {
    private String mPlaceName;
    private String mPlaceAddress;
    private String mPlaceContact;
    private int mImageResourceId;

    public Place(String placeName, String placeAddress,String placeContact , int imageResourceId) {
        this.mPlaceName = placeName;
        this.mPlaceAddress = placeAddress;
        this.mPlaceContact = placeContact;
        this.mImageResourceId = imageResourceId;
    }
    public String getPlaceName() {
        return mPlaceName;
    }

    public String getPlaceAddress() {
        return mPlaceAddress;
    }

    public String getPlaceContact() {
        return mPlaceContact;
    }

    public int getImageResourceId() { return mImageResourceId; }

}
