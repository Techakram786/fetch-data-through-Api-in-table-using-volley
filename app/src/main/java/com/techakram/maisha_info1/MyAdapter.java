package com.techakram.maisha_info1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techakram.maisha_info1.models.Response;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewholder>
{
    Context mcontext;
    private ArrayList<Response> responses;

    public MyAdapter(Context mcontext,ArrayList<Response> responses) {
        this.mcontext=mcontext;
        this.responses=responses;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.card,viewGroup,false);
        return new viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
      Response r=responses.get(position);
      //holder.textView1.setText(r.getFname());
        Log.e("Adapterdata",r.getFname() );
       holder.textView1.setText(r.getFname());
       holder.textView2.setText(r.getLname());
       holder.textView3.setText(r.getType());
       holder.textView4.setText(r.getNumber());
       holder.textView5.setText(r.getAddress());

    }
    @Override
    public int getItemCount()
    {
        return responses.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3,textView4,textView5;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            textView1= itemView.findViewById(R.id.tv1);
            textView2= itemView.findViewById(R.id.tv2);
            textView3= itemView.findViewById(R.id.tv3);
            textView4= itemView.findViewById(R.id.tv4);
            textView5= itemView.findViewById(R.id.tv5);

        }
    }
}

