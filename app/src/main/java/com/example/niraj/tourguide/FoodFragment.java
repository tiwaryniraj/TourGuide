package com.example.niraj.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.foodName1),getString(R.string.foodAdd1),"0265 230 7000",R.drawable.food1));
        places.add(new Place(getString(R.string.foodName2),getString(R.string.foodAdd2),"0265 230 7000",R.drawable.food2));
        places.add(new Place(getString(R.string.foodName3),getString(R.string.foodAdd3),"0265 230 7000",R.drawable.food3));
        places.add(new Place(getString(R.string.foodName4),getString(R.string.foodAdd4),"0265 230 7000",R.drawable.food4));
        places.add(new Place(getString(R.string.foodName5),getString(R.string.foodAdd5),"0265 230 7000",R.drawable.food8));
        places.add(new Place(getString(R.string.foodName6),getString(R.string.foodAdd6),"0265 230 7000",R.drawable.food6));
        places.add(new Place(getString(R.string.foodName7),getString(R.string.foodAdd7),"0265 230 7000",R.drawable.food7));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(),places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = places.get(position);
                String url = getString(R.string.mapUrl)+place.getPlaceName()+ " " + place.getPlaceAddress() ;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        return rootView;
    }

}
