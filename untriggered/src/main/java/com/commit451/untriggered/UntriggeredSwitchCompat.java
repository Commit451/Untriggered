package com.commit451.untriggered;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;

/**
 * {@link SwitchCompat} that allows you to set the check state without triggering the
 * {@link OnCheckedChangeListener}
 */
public class UntriggeredSwitchCompat extends SwitchCompat {

    OnCheckedChangeListener onCheckedChangeListener;

    public UntriggeredSwitchCompat(Context context) {
        super(context);
    }

    public UntriggeredSwitchCompat(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UntriggeredSwitchCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @CallSuper
    @Override
    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    /**
     * Set the checked state without triggered the registered {@link OnCheckedChangeListener}
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
