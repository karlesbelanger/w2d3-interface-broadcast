package com.example.fragmentcommunication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private Button mButton;

    ActivityInterface mCallback;

    public BlankFragment() {
        // Required empty public constructor
    }

    //1. Create Interface
    public interface ActivityInterface {
        void doMagic();
    }

    //3. Pass a reference of that interface to the Fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (ActivityInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton = (Button) view.findViewById(R.id.f_blank_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.doMagic();
            }
        });
    }
}
