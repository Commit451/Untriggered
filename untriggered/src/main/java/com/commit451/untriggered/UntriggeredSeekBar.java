package com.commit451.untriggered;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;

/**
 * {@link AppCompatSeekBar} that allows you to set the progress without triggering the
 * {@link android.widget.SeekBar.OnSeekBarChangeListener}
 */
public class UntriggeredSeekBar extends AppCompatSeekBar {

    OnSeekBarChangeListener onSeekBarChangeListener;

    public UntriggeredSeekBar(Context context) {
        super(context);
    }

    public UntriggeredSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UntriggeredSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @CallSuper
    @Override
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        super.setOnSeekBarChangeListener(onSeekBarChangeListener);
        this.onSeekBarChangeListener = onSeekBarChangeListener;
    }

    /**
     * Set the progress without triggering the registered {@link android.widget.SeekBar.OnSeekBarChangeListener}
     * @param progress progress
     * @see {@link #setProgress(int)}
     */
    public void setProgressUntriggered(int progress) {
        OnSeekBarChangeListener currentListener = onSeekBarChangeListener;
        setOnSeekBarChangeListener(null);
        setProgress(progress);
        setOnSeekBarChangeListener(currentListener);
    }

    /**
     * Set the progress without triggering the registered {@link android.widget.SeekBar.OnSeekBarChangeListener}
     * @param progress progress
     * @param animate animate
     * @see {@link #setProgress(int, boolean)} (int)}
     */
    @TargetApi(24)
    public void setProgressUntriggered(int progress, boolean animate) {
        OnSeekBarChangeListener currentListener = onSeekBarChangeListener;
        setOnSeekBarChangeListener(null);
        setProgress(progress, animate);
        setOnSeekBarChangeListener(currentListener);
    }
}
