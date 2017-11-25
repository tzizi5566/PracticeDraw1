package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

  private Path mPath;
  private Paint mPaint;

  public Practice9DrawPathView(Context context) {
    this(context, null);
  }

  public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //练习内容：使用 canvas.drawPath() 方法画心形

    canvas.drawPath(mPath, mPaint);
  }

  private void init() {
    RectF rectF1 = new RectF(250, 120, 350, 220);
    RectF rectF2 = new RectF(350, 120, 450, 220);

    mPath = new Path();
    mPath.addArc(rectF1, 140, 220);
    mPath.arcTo(rectF2, 180, 220, false);
    mPath.lineTo(350, 300);

    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  }
}
