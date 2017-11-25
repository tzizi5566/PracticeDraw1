package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

  private Paint mPaint1, mPaint2, mPaint3, mPaint4;

  public Practice2DrawCircleView(Context context) {
    this(context, null);
  }

  public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //练习内容：使用 canvas.drawCircle() 方法画圆
    //一共四个圆：1. 实心圆 2. 空心圆 3. 蓝色实心圆 4. 线宽为 20 的空心圆

    canvas.drawCircle(220, 120, 110, mPaint1);
    canvas.drawCircle(480, 120, 110, mPaint2);
    canvas.drawCircle(220, 375, 110, mPaint3);
    canvas.drawCircle(480, 375, 110, mPaint4);
  }

  private void init() {
    mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);

    mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint2.setStyle(Paint.Style.STROKE);
    mPaint2.setStrokeWidth(3F);

    mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint3.setColor(Color.parseColor("#4A90E2"));

    mPaint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint4.setStyle(Paint.Style.STROKE);
    mPaint4.setStrokeWidth(40F);
  }
}
