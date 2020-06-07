package com.example.mymvvmpproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymvvmpproject.R;
import com.example.mymvvmpproject.general.model.NicePlace;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
      private List<NicePlace> nicePlaceList;
      private Context mContext;

    public RecyclerViewAdapter(List<NicePlace> nicePlaceList) {
        this.nicePlaceList = nicePlaceList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent,false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     holder.mName.setText(nicePlaceList.get(position).getName());
     holder.mImgUrl.setImageResource(R.drawable.ic_launcher_background);
//        RequestOptions defaultOption = new RequestOptions()
//                .error(R.drawable.ic_launcher_background);
//        Glide.with(mContext)
//                .setDefaultRequestOptions(defaultOption)
//                .load(nicePlaceList.get(position).getImg())
//                .into(holder.mImgUrl);
    }

    @Override
    public int getItemCount() {
        return nicePlaceList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mImgUrl;
        private TextView mName;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
         mImgUrl = itemView.findViewById(R.id.image_view);
         mName = itemView.findViewById(R.id.text_vew);

        }
    }
}
