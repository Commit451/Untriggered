package com.commit451.untriggered;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;

/**
 * {@link AppCompatSpinner} that allows you to set the check state without triggering the
 * {@link android.widget.CompoundButton.OnCheckedChangeListener}
 */
public class UntriggeredSpinner extends AppCompatSpinner {

    OnItemSelectedListener onItemSelectedListener;

    public UntriggeredSpinner(Context context) {
        super(context);
    }

    public UntriggeredSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UntriggeredSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.onItemSelectedListener = onItemSelectedListener;
    }

    /**
     * Set the selection without triggering the registered {@link android.widget.AdapterView.OnItemSelectedListener}
     * @param selection selection
     * @param animate if you want it to animate
     * @see {@link #setSelection(int, boolean)}
     */
    public void setSelectionUntriggered(int selection, boolean animate) {
        OnItemSelectedListener currentListener = onItemSelectedListener;
        setOnItemSelectedListener(null);
        setSelection(selection, animate);
        setOnItemSelectedListener(currentListener);
    }
}
