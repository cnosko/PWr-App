package layout;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ikurek.pwr.R;
import com.ikurek.pwr.RadioService;

import java.io.IOException;


public class RadioFragment extends Fragment {

    public MediaPlayer radioPlayer;
    int volumeSetByUser;
    AudioManager audioManager;
    String url = "http://radioluz.pwr.wroc.pl:8000/luzhifi.mp3";
    Snackbar snackbar;
    AudioManager.OnAudioFocusChangeListener afChangeListener;
    Intent playRadioInService;


    public RadioFragment() {
        // Required empty public constructor
    }


    public static RadioFragment newInstance() {
        RadioFragment fragment = new RadioFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_radio, container, false);

        ImageButton imageButtonPlay = (ImageButton) view.findViewById(R.id.imageButtonPlayRadio);

        imageButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRadioInService = new Intent(getActivity(), RadioService.class);
                playRadioInService.setAction("play");
                getActivity().startService(playRadioInService);
            }
        });


        ImageButton imageButtonStop = (ImageButton) view.findViewById(R.id.imageButtonStopRadio);

        imageButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().stopService(playRadioInService);
            }
        });




        return view;
    }

}
