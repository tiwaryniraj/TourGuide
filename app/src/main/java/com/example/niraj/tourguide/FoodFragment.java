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
        places.add(new Place("Tasty Vadapav","Opp. Ghelani Petrol Pump, Nizampura","0265 230 7000",R.drawable.food1));
        places.add(new Place("Sasumaa Gujarati Thali","GF 1/2, Gokulesh Complex, R C Dutt Road","0265 230 7000",R.drawable.food2));
        places.add(new Place("Fiorella Italian Restaurant","Aradhana Society, Alkapuri","0265 230 7000",R.drawable.food3));
        places.add(new Place("Peshawri Restaurant","Hotel Vadodara, Ground Floor, RC Dutt Road","0265 230 7000",R.drawable.food4));
        places.add(new Place("Little Italy","Shop No. 10,11,12 & 13, Arun Complex, 36 Alkapuri Society","0265 230 7000",R.drawable.food8));
        places.add(new Place("Mainland China","Bella Vista Complex, Above Shivsagar Restaurant","0265 230 7000",R.drawable.food6));
        places.add(new Place("Lazeez","Vishal Chambers, 34, RC Dutt Rd","0265 230 7000",R.drawable.food7));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(),places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = places.get(position);
                String url = "http://maps.google.com/maps?daddr="+place.getPlaceName()+ " " + place.getPlaceAddress() ;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        return rootView;
    }

}
