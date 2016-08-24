package com.example.ricki.neroactualizado;


import android.app.ProgressDialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;

import java.io.IOException;


public class StreamFragment extends Fragment
        implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener,
        MediaController.MediaPlayerControl {// Implementa controladores de audio

     private static String TAG = "MainActivity ";
     View myView;
     private SurfaceView surfaceView;
     private SurfaceHolder surfaceHolder;
     private MediaPlayer mediaPlayer;
     private MediaController mediaController;
     private Handler handler = new Handler();
        // Se definen los componentes que están en la interfaz fragment_stream.xml
    private ProgressDialog progress;

     String url2 = "http://200.69.103.51:8000/laud"; // Servicio web de la emisora

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         myView = inflater.inflate(R.layout.fragment_stream, container, false);

         surfaceView = (SurfaceView) myView.findViewById(R.id.surfaceview); //Instancia del SurfaceHolder

         surfaceHolder = surfaceView.getHolder(); //
         //Toast.makeText(getActivity(), "Cargando Emisora...", Toast.LENGTH_LONG).show();
         surfaceHolder.addCallback(this);

         surfaceView.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 if (mediaController != null) { // Si el componente existe entonces le asigna un tiempo para que se muestre en forma permanente
                     mediaController.show(500000); //Duración del media controller en la pantalla 
                 }
                 return false;
             }
         });
         return myView;
     }



     @Override
     public void surfaceCreated(SurfaceHolder holder) {

         //Toast.makeText(getActivity(), "Cargando...", Toast.LENGTH_LONG).show();
         mediaPlayer = new MediaPlayer();
         mediaPlayer.setDisplay(surfaceHolder);
         mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
         mediaPlayer.setOnPreparedListener(this);
         try {
                 mediaPlayer.setDataSource(url2); //Lee el servicio web y trae el audio
                 mediaPlayer.prepare();

                 mediaController = new MediaController(getActivity()); //Instanciando en componente media controller

             } catch (IOException e) {
         e.printStackTrace();
         Toast.makeText(getActivity(),
         "something wrong!\n" + e.toString(),
         Toast.LENGTH_LONG).show();
        }
     }

     @Override
     public void surfaceChanged(SurfaceHolder holder,
     int format, int width, int height) {

     }

     @Override
     public void surfaceDestroyed(SurfaceHolder holder) {
         super.onDestroy();
         if (mediaPlayer != null) {
             mediaPlayer.release();
             mediaPlayer = null;
         }
     } //Destruye el hilo del audio cuando cambia de opción en el menú

     @Override
     public void onPrepared(MediaPlayer mp) {
         mediaPlayer.start(); //Inicia la reproducción de sonido después de elegir la opción desde el menú
     Toast.makeText(getActivity(),
     "Sonido en Vivo", Toast.LENGTH_SHORT).show();

     mediaController.setMediaPlayer(this);// Asigna lo leído por el media player, al componente media controller
     mediaController.setAnchorView(surfaceView); 
     handler.post(new Runnable() {

     public void run() {
         mediaController.setEnabled(true); //Habilita el componente de botones que controlan el audio star, pause y stop
         mediaController.show(); // Muestra en la pantalla la botonera
         }
         });
     }

    @Override
     public void start() {

     mediaPlayer.start(); // Da la funcionalidad al botón de iniciar la reproducción de audio
     }

     @Override
     public void pause() {
     mediaPlayer.pause(); // Pausa la reproducción de audio
     }

     @Override
     public int getDuration() {
     return mediaPlayer.getDuration(); //Muestra el tiempo que dura encendido el audio
     }

     @Override
     public int getCurrentPosition() {
     return mediaPlayer.getCurrentPosition();
     }

     @Override
     public void seekTo(int pos) {
     mediaPlayer.seekTo(pos);
     }

     @Override
     public boolean isPlaying() {
        return mediaPlayer.isPlaying(); //Evalúa si el audio está en reproducción
    }

    @Override
     public int getBufferPercentage() {
     return 0;
     }

     @Override
     public boolean canPause() {
     return true; // Habilita la funcionalidad de pausar la reproducción de audio
     }

     @Override
     public boolean canSeekBackward() {
     return false;      //Deshabilita la funcionalidad del botón de devolver el audio
     }

     @Override
     public boolean canSeekForward() {
     return false; // Deshabilita la funcionalidad del botón de adelantar el audio
     }

     @Override
     public int getAudioSessionId() {
         return mediaPlayer.getAudioSessionId();
     }// Mantiene iniciada la sesión de audio
}
