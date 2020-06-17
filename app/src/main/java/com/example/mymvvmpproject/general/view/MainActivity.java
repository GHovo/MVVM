package com.example.mymvvmpproject.general.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.mymvvmpproject.R;
import com.example.mymvvmpproject.adapter.RecyclerViewAdapter;
import com.example.mymvvmpproject.databinding.ActivityMainBinding;
import com.example.mymvvmpproject.general.model.NicePlace;
import com.example.mymvvmpproject.general.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private ActivityMainBinding mBinding;
    private ArrayList<NicePlace> mNicePlace;
    private MainActivityViewModel mMainActivityViewModel;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlace().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }


    private void initRecyclerView() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new RecyclerViewAdapter(mMainActivityViewModel.getNicePlace().getValue());
        mBinding.recyclerView.setAdapter(mAdapter);
    }


}
