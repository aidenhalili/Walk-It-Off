package com.example.walkitoff;

import android.view.View;
import android.widget.AdapterView;

public class PresetSpinner extends Spinner{

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        super.onItemSelected(adapterView, view, i, l);

        MainActivity.chosenPresetLabel = selection;
    }
}
