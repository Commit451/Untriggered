package com.commit451.untriggered;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/**
 * {@link ToggleButton} that allows you to set the check state without triggering the
 * {@link OnCheckedChangeListener}
 */
public class UntriggeredToggleButton extends ToggleButton {

    OnCheckedChangeListener onCheckedChangeListener;

    public UntriggeredToggleButton(Context context) {
        super(context);
    }

    public UntriggeredToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UntriggeredToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @CallSuper
    @Override
    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    /**
     * Set the checked state without triggering the registered {@link OnCheckedChangeListener}
     * @param checked checked
     */
    public void setCheckedUntriggered(boolean checked) {
        OnCheckedChangeListener currentListener = onCheckedChangeListener;
        setOnCheckedChangeListener(null);
        setChecked(checked);
        setOnCheckedChangeListener(currentListener);
    }
}
