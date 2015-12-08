package com.andrerichards.andre.to_dolist;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by Andre on 12/6/2015.
 */
public class PencilButton extends Fragment {

    @Override
    public void onDetach() {
        super.onDetach();

        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void pencilButton(ImageButton pencilButton, final ViewGroup parent){
        pencilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "Click", Toast.LENGTH_SHORT).show();
                MainActivity mainActivity = new MainActivity();
                Fragment alarmFrag = new Fragment();
                FragmentManager fragMan = mainActivity.getSupportFragmentManager();
                Log.d("flow", "FragMan");
                FragmentTransaction transaction = fragMan.beginTransaction();

                transaction.replace(R.id.fragment, alarmFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
