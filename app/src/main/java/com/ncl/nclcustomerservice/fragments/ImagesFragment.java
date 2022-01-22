package com.ncl.nclcustomerservice.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;
import com.ncl.nclcustomerservice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sowmy on 9/21/2018.
 */

public class ImagesFragment extends Fragment {
    @BindView(R.id.show_image)
    PhotoView photoView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.image_fragment,container,false);
       ButterKnife.bind(this,view);

            Picasso.with(getActivity()).load(getArguments().getString("images")).into(photoView);

       return view;
    }
}
