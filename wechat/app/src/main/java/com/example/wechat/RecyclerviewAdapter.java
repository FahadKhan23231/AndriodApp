package com.example.wechat;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.viewholder> {
Context context;
ArrayList<Contactmodel> arrcontact;

RecyclerviewAdapter(Context context, ArrayList<Contactmodel>arrcontact){
    this.context=context;
    this.arrcontact=arrcontact;
}

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.contact_list,parent,false);
       viewholder viewholder = new viewholder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
    holder.img.setImageResource(arrcontact.get(position).img);
    holder.name.setText(arrcontact.get(position).name);
    holder.msg.setText(arrcontact.get(position).message);


    }

    @Override
    public int getItemCount() {
        return arrcontact.size();
    }

    public  class viewholder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView name;
    EditText msg;
        public viewholder(View a){
            super(a);
            name = itemView.findViewById(R.id.txtname);
            img= itemView.findViewById(R.id.imageView);
            msg= itemView.findViewById(R.id.message);

        }

    }



}
