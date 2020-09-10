package com.example.techtrix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.http.GET;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder>
{

private List<OurDataSet> list;
private Context context;

    public DataAdapter(List<OurDataSet> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.row,viewGroup,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int i)
    {
        OurDataSet currentData=list.get(i);
        dataViewHolder.albumId.setText(currentData.getAlbumId());
        dataViewHolder.id.setText(currentData.getId());
        dataViewHolder.title.setText(currentData.getTitle());
        dataViewHolder.url.setText(currentData.getUrl());
        dataViewHolder.thumbnailUrl.setText(currentData.getThumbnailUrl());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
