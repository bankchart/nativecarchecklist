package com.example.nativecarchecklist;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class ProgressChecklist extends TextView {
	private int mMaxValue = 100; 

	
	public ProgressChecklist(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ProgressChecklist(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ProgressChecklist(Context context) {
		super(context);
	}
	
	public void setMaxValue(int maxValue){
		mMaxValue = maxValue;
	}

	public synchronized void setValue(int value) {

		this.setText(String.valueOf(value));
		
	
		LayerDrawable background = (LayerDrawable) this.getBackground();
		
		
		ClipDrawable barValue = (ClipDrawable) background.getDrawable(1);
		

		int newClipLevel = (int) (value * 10000 / mMaxValue);
		
		barValue.setLevel(newClipLevel);

		drawableStateChanged();
	}

}