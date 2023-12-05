package com.example.finalassign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("https://newsimg.sedaily.com/2023/07/16/29S5JPWPBV_1.jpeg");
        arrayList.add("https://d3kxs6kpbh59hp.cloudfront.net/community/COMMUNITY/53ace7ca657149afa4165d1b8217c677/0d08151067cc4536b09b2753f9fd793d_1630028730.jpg");
        arrayList.add("https://images.freeimages.com/images/large-previews/c31/colors-1383652.jpg");
        arrayList.add("https://images.freeimages.com/images/large-previews/8b0/lake-1332261.jpg");
        arrayList.add("https://images.freeimages.com/images/large-previews/8b0/lake-1332261.jpg");
        arrayList.add("https://images.freeimages.com/images/large-previews/8b0/lake-1332261.jpg");

        ImageAdapter adapter = new ImageAdapter(requireContext(), arrayList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, String path) {
                //Do something like opening the image in new activity or showing it in full screen or something else.
            }
        });

        return view;
    }
}

