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
        places.add(new Place(getString(R.string.hotel1nmae),getString(R.string.hotel1Add),"0265 230 7000",R.drawable.hotel1));
        places.add(new Place(getString(R.string.hotel2name),getString(R.string.hotel2Add),"0265 234 0050",R.drawable.hotel2));
        places.add(new Place(getString(R.string.hotel3name),getString(R.string.hotel3Add),"0265 230 7000",R.drawable.hotel3));
        places.add(new Place(getString(R.string.hotel4name),getString(R.string.hotel4Add),"0265 230 7000",R.drawable.hotel4));
        places.add(new Place(getString(R.string.hotel5name),getString(R.string.hotel5Add),"0265 230 7000",R.drawable.hotel5));
        places.add(new Place(getString(R.string.hotel6name),getString(R.string.hotel6Add),"0265 230 7000",R.drawable.hotel6));
        places.add(new Place(getString(R.string.hotel7name),getString(R.string.hotel7Add),"0265 230 7000",R.drawable.hotel7));

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

    @Override
    public void onStop() {
        super.onStop();
    }
}
