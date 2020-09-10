package com.example.techtrix;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DataViewHolder extends RecyclerView.ViewHolder
{

    TextView albumId, id, title, url, thumbnailUrl;
    public DataViewHolder(@NonNull View itemView) {
        super(itemView);

        albumId=itemView.findViewById(R.id.albumId);
        id=itemView.findViewById(R.id.id_id);
        title=itemView.findViewById(R.id.title);
        url=itemView.findViewById(R.id.url);
        thumbnailUrl=itemView.findViewById(R.id.thumbmaiUrl);
    }
}
