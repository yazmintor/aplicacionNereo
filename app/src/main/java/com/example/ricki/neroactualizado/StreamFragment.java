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
        MediaController.MediaPlayerControl {

     private static String TAG = "MainActivity ";
     View myView;
     private SurfaceView surfaceView;
     private SurfaceHolder surfaceHolder;
     private MediaPlayer mediaPlayer;
     private MediaController mediaController;
     private Handler handler = new Handler();

    private ProgressDialog progress;

     String url2 = "http://200.69.103.51:8000/laud";

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         myView = inflater.inflate(R.layout.fragment_stream, container, false);

         surfaceView = (SurfaceView) myView.findViewById(R.id.surfaceview);

         surfaceHolder = surfaceView.getHolder();
         //Toast.makeText(getActivity(), "Cargando Emisora...", Toast.LENGTH_LONG).show();
         surfaceHolder.addCallback(this);

         surfaceView.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 if (mediaController != null) {
                     mediaController.show(500000);
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
                 mediaPlayer.setDataSource(url2);
                 mediaPlayer.prepare();

                 mediaController = new MediaController(getActivity());

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
     }

     @Override
     public void onPrepared(MediaPlayer mp) {
         mediaPlayer.start();
     Toast.makeText(getActivity(),
     "Sonido en Vivo", Toast.LENGTH_SHORT).show();

     mediaController.setMediaPlayer(this);
     mediaController.setAnchorView(surfaceView);
     handler.post(new Runnable() {

     public void run() {
         mediaController.setEnabled(true);
         mediaController.show();
         }
         });
     }

    @Override
     public void start() {

     mediaPlayer.start();
     }

     @Override
     public void pause() {
     mediaPlayer.pause();
     }

     @Override
     public int getDuration() {
     return mediaPlayer.getDuration();
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
        return mediaPlayer.isPlaying();
    }

    @Override
     public int getBufferPercentage() {
     return 0;
     }

     @Override
     public boolean canPause() {
     return true;
     }

     @Override
     public boolean canSeekBackward() {
     return false;
     }

     @Override
     public boolean canSeekForward() {
     return false;
     }

     @Override
     public int getAudioSessionId() {
         return mediaPlayer.getAudioSessionId();
     }

    public void descargar(View view){
        progress=new ProgressDialog(getActivity());
        progress.setMessage("Descargando algo....");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

        final int totalProgressTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while(jumpTime < totalProgressTime) {
                    try {
                        jumpTime += 5;
                        progress.setProgress(jumpTime);
                        sleep(200);
                    }
                    catch (InterruptedException e) {
                        Log.e(TAG, e.getMessage());
                    }
                }
            }
        };
        t.start();
    }
}