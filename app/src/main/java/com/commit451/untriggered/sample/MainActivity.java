package com.commit451.untriggered.sample;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;

import com.commit451.untriggered.UntriggeredCheckBox;
import com.commit451.untriggered.UntriggeredRadioButton;
import com.commit451.untriggered.UntriggeredRatingBar;
import com.commit451.untriggered.UntriggeredSeekBar;
import com.commit451.untriggered.UntriggeredSwitchCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewGroup root = (ViewGroup) findViewById(R.id.root);
        final UntriggeredCheckBox checkBox = (UntriggeredCheckBox) findViewById(R.id.checkbox);
        final UntriggeredRadioButton radioButton = (UntriggeredRadioButton) findViewById(R.id.radio);
        final UntriggeredSwitchCompat switchCompat = (UntriggeredSwitchCompat) findViewById(R.id.switch_thing);
        final UntriggeredRatingBar ratingBar = (UntriggeredRatingBar) findViewById(R.id.ratingbar);
        final UntriggeredSeekBar seekBar= (UntriggeredSeekBar) findViewById(R.id.seekbar);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Snackbar.make(root, "Checkbox set to " + isChecked + " and I am triggered!", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Snackbar.make(root, "Radio set to " + isChecked + " and I am triggered!", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Snackbar.make(root, "Switch set to " + isChecked + " and I am triggered!", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Snackbar.make(root, "RatingBar set to " + rating + " and I am triggered!", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Snackbar.make(root, "Seekbar set to " + progress + " and I am triggered!", Snackbar.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setCheckedUntriggered(!checkBox.isChecked());
                radioButton.setCheckedUntriggered(!radioButton.isChecked());
                switchCompat.setCheckedUntriggered(!switchCompat.isChecked());
                seekBar.setProgressUntriggered(50);
                ratingBar.setRatingUntriggered(2.5f);
            }
        });
    }
}
