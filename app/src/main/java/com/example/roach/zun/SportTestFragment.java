package com.example.roach.zun;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class SportTestFragment extends Fragment implements View.OnTouchListener {
    ViewFlipper flipper;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.sport_test_fragment_list_1, container, false);
        view.setOnTouchListener(this);
        flipper = (ViewFlipper) view.findViewById(R.id.flipper);
        inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int layouts[] = new int[]{R.layout.sport_test_fragment_list_2, R.layout.sport_test_fragment_list_3};
        for (int layout : layouts)
            flipper.addView(inflater.inflate(layout, null));

        return view;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float fromPosition = 0;
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN: // Пользователь нажал на экран, т.е. начало движения
                // fromPosition - координата по оси X начала выполнения операции
                fromPosition = event.getX();
                break;
            case MotionEvent.ACTION_UP: // Пользователь отпустил экран, т.е. окончание движения
                float toPosition = event.getX();
                if (fromPosition > toPosition) {
                    flipper.setInAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.go_next_in));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.go_next_out));
                    flipper.showNext();
                }
                else if (fromPosition < toPosition) {
                    flipper.setInAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.go_prev_in));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.go_prev_out));
                    flipper.showPrevious();
                }
            default:
                break;
        }
        return true;
    }
}
