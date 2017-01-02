package com.commit451.untriggered;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.AttributeSet;

/**
 * {@link AppCompatRatingBar} that allows you to set the rating without triggering the
 * {@link android.widget.RatingBar.OnRatingBarChangeListener}
 */
public class UntriggeredRatingBar extends AppCompatRatingBar {

    OnRatingBarChangeListener onSeekBarChangeListener;

    public UntriggeredRatingBar(Context context) {
        super(context);
    }

    public UntriggeredRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UntriggeredRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @CallSuper
    @Override
    public void setOnRatingBarChangeListener(OnRatingBarChangeListener listener) {
        super.setOnRatingBarChangeListener(listener);
        onSeekBarChangeListener = listener;
    }

    /**
     * Set the rating without triggering the registered {@link android.widget.RatingBar.OnRatingBarChangeListener}
     * @param rating rating
     * @see {@link #setRating(float)}
     */
    public void setRatingUntriggered(float rating) {
        OnRatingBarChangeListener currentListener = onSeekBarChangeListener;
        setOnRatingBarChangeListener(null);
        setRating(rating);
        setOnRatingBarChangeListener(currentListener);
    }
}
