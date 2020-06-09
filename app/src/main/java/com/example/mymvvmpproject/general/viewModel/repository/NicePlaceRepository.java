package com.example.mymvvmpproject.general.viewModel.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mymvvmpproject.R;
import com.example.mymvvmpproject.general.model.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {
    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> mNicePlace;

    public MutableLiveData<List<NicePlace>> getNicePlace() {
        mNicePlace = initData();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(mNicePlace);

        return data;
    }

    public static NicePlaceRepository getInstance() {
        if (instance == null) {
            return new NicePlaceRepository();
        }
        return instance;
    }


    private ArrayList<NicePlace> initData() {
        mNicePlace = new ArrayList<>();
        mNicePlace.add(new NicePlace("Name1", R.drawable.ic_launcher_background ));
        mNicePlace.add(new NicePlace("Name2", R.drawable.ic_launcher_background ));
        mNicePlace.add(new NicePlace("Name3", R.drawable.ic_launcher_background ));
        mNicePlace.add(new NicePlace("Name4", R.drawable.ic_launcher_background ));
        mNicePlace.add(new NicePlace("Name5", R.drawable.ic_launcher_background ));
        mNicePlace.add(new NicePlace("Name6", R.drawable.ic_launcher_background ));
        mNicePlace.add(new NicePlace("Name7", R.drawable.ic_launcher_background ));




        return mNicePlace;
    }
}
