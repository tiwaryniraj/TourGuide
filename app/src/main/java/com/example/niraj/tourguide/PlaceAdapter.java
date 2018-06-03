package com.example.niraj.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(@NonNull Context context, @NonNull ArrayList<Place> places) {
        super(context, 0,places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentPlace.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView addressTextView = listItemView.findViewById(R.id.address_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        addressTextView.setText(currentPlace.getPlaceAddress());

        TextView contactTextView = listItemView.findViewById(R.id.contact_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        contactTextView.setText(currentPlace.getPlaceContact());

        ImageView imageView = listItemView.findViewById(R.id.imageView);
        imageView.setImageResource(currentPlace.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
