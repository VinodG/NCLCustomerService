package com.ncl.nclcustomerservice.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.view.MenuItem;

import com.ncl.nclcustomerservice.R;
import com.ncl.nclcustomerservice.abstractclasses.NetworkChangeListenerActivity;
import com.ncl.nclcustomerservice.commonutils.Common;
import com.ncl.nclcustomerservice.fragments.ImagesFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sowmy on 9/21/2018.
 */

public class ImageViewActivity extends NetworkChangeListenerActivity {

    @BindView(R.id.imageViewPager)
    ViewPager imageViewPager;
    @BindView(R.id.toolbar)
    androidx.appcompat.widget.Toolbar toolbar;
    private int position;
    private List<String> image = new ArrayList<>();
    int TAG=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PHOTOS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        image = (List<String>) getIntent().getSerializableExtra("images");
        position = getIntent().getIntExtra("position", -1);
        ImageAdapter imageAdapter = new ImageAdapter(getSupportFragmentManager(), image);
        imageViewPager.setAdapter(imageAdapter);
        imageViewPager.setOffscreenPageLimit(image.size());
        imageViewPager.setCurrentItem(position);
    }

    private void goToFragment(Fragment fragment, boolean b) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt("tab_position", TAG);
//        bundle.putString("id",ticket_master_id);
//        bundle.putSerializable(AppUtils.DASHBOARD, getIntent().getSerializableExtra(AppUtils.DASHBOARD));
        fragment.setArguments(bundle);
//        if (b) {
        transaction.replace(R.id.content_frame, fragment);
        // transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
//        } else {
//            transaction.replace(R.id.content_frame, fragment);
//          //  transaction.addToBackStack(null);
//            transaction.commit();
//        }
    }

    @Override
    protected void onInternetConnected() {

    }

    @Override
    protected void onInternetDisconnected() {

    }

    class ImageAdapter extends FragmentPagerAdapter {
        List<String> image;

        public ImageAdapter(FragmentManager fm, List<String> imageLists) {
            super(fm);
            this.image = imageLists;
        }

        @Override
        public Fragment getItem(int pos) {
            ImagesFragment imagesFragment = new ImagesFragment();
            Bundle b = new Bundle();
            Common.Log.i("pos" + pos);
            Common.Log.i("ImagePath" + image.get(pos));
            b.putSerializable("images",(Serializable) image.get(pos));
            imagesFragment.setArguments(b);
            return imagesFragment;
        }

    @Override
    public int getCount() {
            return image.size();
    }
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back_1 activity from here

                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
