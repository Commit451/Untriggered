package com.commit451.untriggered;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.util.AttributeSet;
import android.widget.Switch;

/**
 * {@link Switch} that allows you to set the check state without triggering the
 * {@link OnCheckedChangeListener}
 */
public class UntriggeredSwitch extends Switch {

    OnCheckedChangeListener onCheckedChangeListener;

    public UntriggeredSwitch(Context context) {
        super(context);
    }

    public UntriggeredSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UntriggeredSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
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
     *
     * @param checked checked
     */
    public void setCheckedUntriggered(boolean checked) {
        OnCheckedChangeListener currentListener = onCheckedChangeListener;
        setOnCheckedChangeListener(null);
        setChecked(checked);
        setOnCheckedChangeListener(currentListener);
    }
}
