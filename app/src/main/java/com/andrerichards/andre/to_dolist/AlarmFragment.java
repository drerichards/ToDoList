package com.andrerichards.andre.to_dolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Andre on 12/6/2015.
 */
public class AlarmFragment extends android.app.Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View actionView = inflater.inflate(R.layout.list_actions, container, false);
        return actionView;
    }
}
