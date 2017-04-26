package com.android.developer.simplerecycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.developer.simplerecycler.MainActivity;
import com.android.developer.simplerecycler.R;
import com.android.developer.simplerecycler.model.Model;
import com.android.developer.simplerecycler.model.ModelArray;
import com.android.developer.simplerecycler.model.RootModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by HP on 13-04-2017.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MyViewHolder> {
    private Context mContext;
    private List<Model> messages;
    private Model modelArray;



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        modelArray = messages.get(position);
//        displaying data
        Picasso.with(mContext).load(modelArray.getBase_url()+modelArray.getThumb()).into(holder.image_icon);
        holder.schedule_title.setText(modelArray.getSchedule_title());
        holder.time_start.setText(modelArray.getTime_start());
        holder.time_end.setText(modelArray.getTime_end());

    }

    @Override
    public int getItemCount() {



        return messages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView schedule_title, time_start, time_end,stop_one,stop_two,stop_three,stop_four;
        public ImageView image_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_icon = (ImageView)itemView.findViewById(R.id.image_icon);
            schedule_title = (TextView)itemView.findViewById(R.id.schedule_title);
            time_start = (TextView)itemView.findViewById(R.id.time_start);
            time_end = (TextView)itemView.findViewById(R.id.time_end);
            stop_one = (TextView)itemView.findViewById(R.id.stop_one);
            stop_two = (TextView)itemView.findViewById(R.id.stop_two);
            stop_three = (TextView)itemView.findViewById(R.id.stop_three);
            stop_four = (TextView)itemView.findViewById(R.id.stop_four);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public MessagesAdapter(Context context, List<Model> messages) {

        mContext = context;
        this.messages = messages;

    }


}
