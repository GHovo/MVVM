package com.example.mymvvmpproject.general.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymvvmpproject.general.model.NicePlace;
import com.example.mymvvmpproject.general.model.network.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<NicePlace>> mNicePlace;
    private NicePlaceRepository mRepository;

    public void init() {
        if(mNicePlace != null){
            return;
        }
        mRepository = NicePlaceRepository.getInstance();
        mNicePlace = mRepository.getNicePlace();
    }

    public LiveData<List<NicePlace>> getNicePlace(){
        return mNicePlace;
    }
}
