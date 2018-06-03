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
public class HistoryFragment extends Fragment {


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.hisName1),getString(R.string.hisAdd1),"0265 230 7000",R.drawable.history1));
        places.add(new Place(getString(R.string.hisName2),getString(R.string.hisAdd2),"0265 230 7000",R.drawable.history2));
        places.add(new Place(getString(R.string.hisName3),getString(R.string.hisAdd3),"0265 230 7000",R.drawable.history3));
        places.add(new Place(getString(R.string.hisName4),getString(R.string.hisAdd4),"0265 230 7000",R.drawable.history4));
        places.add(new Place(getString(R.string.hisName5),getString(R.string.hisAdd5),"0265 230 7000",R.drawable.history5));
        places.add(new Place(getString(R.string.hisName6),getString(R.string.hisAdd6),"0265 230 7000",R.drawable.history6));
        places.add(new Place(getString(R.string.hisName7),getString(R.string.hisAdd7),"0265 230 7000",R.drawable.history7));

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
