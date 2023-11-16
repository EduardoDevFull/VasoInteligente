package com.example.aplicativo.client;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class DisparaAguaClient extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Socket socket = new Socket("ip-arduino", 80);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println("Comando do Arduino");
            out.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}