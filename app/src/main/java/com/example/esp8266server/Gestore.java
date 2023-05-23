package com.example.esp8266server;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Gestore {

    private AppCompatActivity activity;

    private BgTask runningTask = null;

    private Client client = null;

    public TextView receiver;

    public Gestore(AppCompatActivity aAppCompatActivity){
        this.activity = aAppCompatActivity;
    }

    public AppCompatActivity getActivity() {
        return activity;
    }

    public void startBgTask(String... params) {
        if (runningTask != null) {
            runningTask = null;
        }
        runningTask = new BgTask(this, params);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void createMainActivity() {
        this.receiver = this.activity.findViewById(R.id.receiver);
        Button sender = this.activity.findViewById(R.id.sender);

        sender.setOnClickListener(view -> {
            this.client.sendMsg("11");
        });
    }

    public void writeMsg(String msg){
        this.receiver.setText(msg);
    }
}