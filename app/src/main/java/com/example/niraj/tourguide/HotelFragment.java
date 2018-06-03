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
public class HotelFragment extends Fragment {


    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Fortune Inn Promenade","Near Akota Gardens.","0265 230 7000",R.drawable.hotel1));
        places.add(new Place("Best Western Hotel","Behind Alkapuri Petrol Pump","0265 234 0050",R.drawable.hotel2));
        places.add(new Place("GenX Vadodara","7, Jetalpur Rd, Sampatrao Colony, Alkapuri","0265 230 7000",R.drawable.hotel3));
        places.add(new Place("Eastin Residences","78, RC Dutt Road, Sampatrao Colony, Alkapuri","0265 230 7000",R.drawable.hotel4));
        places.add(new Place("The Gateway","Akota Gardens, Near Gold Gym, Productivity Road","0265 230 7000",R.drawable.hotel5));
        places.add(new Place("The Fern","Near Urmi Char Rasta, Off, Dinesh Mill Rd","0265 230 7000",R.drawable.hotel6));
        places.add(new Place("WelcomHotel","RC Dutt Rd, Alkapuri","0265 230 7000",R.drawable.hotel7));

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

    @Override
    public void onStop() {
        super.onStop();
    }
}
