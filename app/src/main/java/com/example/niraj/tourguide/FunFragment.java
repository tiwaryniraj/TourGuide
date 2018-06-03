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
public class FunFragment extends Fragment {


    public FunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Central Bus Station","Maharaja Sayajirao University, Pratapgunj","0265 230 7000",R.drawable.fun1));
        places.add(new Place("Inorbit Mall","Near Akota Gardens","0265 230 7000",R.drawable.fun2));
        places.add(new Place("Eva The Mall","Patidar Crossing, Near Saraswati Complex","0265 230 7000",R.drawable.fun3));
        places.add(new Place("Centre Square","Sayaji Path, Shubhanpura","0265 230 7000",R.drawable.fun4));
        places.add(new Place("Seven Seas","Near IPCL Circle, Harshadrai Mehta Marg","0265 230 7000",R.drawable.fun5));
        places.add(new Place("Vadodara Central","Race Cource Road, Genda Circle","0265 230 7000",R.drawable.fun6));
        places.add(new Place("Bansal Mall","otri - Bhayli Rd, near, Saiyed Vasna","0265 230 7000",R.drawable.fun7));

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
