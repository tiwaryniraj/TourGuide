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
        places.add(new Place(getString(R.string.fun1Name),getString(R.string.fun1Add),"0265 230 7000",R.drawable.fun1));
        places.add(new Place(getString(R.string.fun2Name),getString(R.string.fun2Add),"0265 230 7000",R.drawable.fun2));
        places.add(new Place(getString(R.string.fun3Name),getString(R.string.fun3Add),"0265 230 7000",R.drawable.fun3));
        places.add(new Place(getString(R.string.fun4Name),getString(R.string.fun4Add),"0265 230 7000",R.drawable.fun4));
        places.add(new Place(getString(R.string.fun5Name),getString(R.string.fun5Add),"0265 230 7000",R.drawable.fun5));
        places.add(new Place(getString(R.string.fun6Name),getString(R.string.fun6Add),"0265 230 7000",R.drawable.fun6));
        places.add(new Place(getString(R.string.fun7Name),getString(R.string.fun7Add),"0265 230 7000",R.drawable.fun7));

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
