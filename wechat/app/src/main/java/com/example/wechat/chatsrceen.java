package com.example.wechat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class chatsrceen extends AppCompatActivity {

ArrayList<Contactmodel> arrcontact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView=findViewById(R.id.chats);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrcontact.add(new Contactmodel(R.drawable.img1,"Fahad" , "Heelo Fahad"));
        arrcontact.add(new Contactmodel(R.drawable.img2,"Naeem" , "Aj Aoo Gay"));
        arrcontact.add(new Contactmodel(R.drawable.img3,"Faisal" , "Chlo Lets See"));
        arrcontact.add(new Contactmodel(R.drawable.img4,"AwaisBhai" , "AoA Awais Bhai"));
        arrcontact.add(new Contactmodel(R.drawable.img5,"Fatima" , "Fahad!cannten pr aoo"));
        arrcontact.add(new Contactmodel(R.drawable.img6,"zainab" , "Hi zaianb"));
        arrcontact.add(new Contactmodel(R.drawable.img7,"Areeba" , "Sii Hay"));
        arrcontact.add(new Contactmodel(R.drawable.img8,"AyeshaUni" , "Ayesha kidr hay"));
        arrcontact.add(new Contactmodel(R.drawable.img9,"Ahmed" , "Nus wa"));
        arrcontact.add(new Contactmodel(R.drawable.img10,"zain" , "nus wa"));

        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this,arrcontact);
        recyclerView.setAdapter(adapter);




    }
}
