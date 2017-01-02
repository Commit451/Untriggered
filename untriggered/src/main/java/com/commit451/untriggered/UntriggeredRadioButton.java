package com.commit451.untriggered;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

/**
 * {@link AppCompatRadioButton} that allows you to set the check state without triggering the
 * {@link android.widget.CompoundButton.OnCheckedChangeListener}
 */
public class UntriggeredRadioButton extends AppCompatRadioButton {

    OnCheckedChangeListener onCheckedChangeListener;

    public UntriggeredRadioButton(Context context) {
        super(context);
    }

    public UntriggeredRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UntriggeredRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @CallSuper
    @Override
    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    /**
     * Set the checked state without triggering the registered {@link android.widget.CompoundButton.OnCheckedChangeListener}
     * @param checked checked
     * @see {@link #setChecked(boolean)}
     */
    public void setCheckedUntriggered(boolean checked) {
        OnCheckedChangeListener currentListener = onCheckedChangeListener;
        setOnCheckedChangeListener(null);
        setChecked(checked);
        setOnCheckedChangeListener(currentListener);
    }
}
