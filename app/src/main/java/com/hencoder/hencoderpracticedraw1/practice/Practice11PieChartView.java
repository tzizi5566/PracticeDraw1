package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

  private Paint mPaint, mPaint2;
  private RectF mRectF;

  private int mWidth, mHeight;
  private float mRadius;

  private List<ViewData> mList;
  private String[] mColors;

  public Practice11PieChartView(Context context) {
    this(context, null);
  }

  public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mWidth = w;
    mHeight = h;
    mRadius = Math.min(mWidth / 2, mHeight / 2) * 0.8f;
    mRectF = new RectF(-mRadius, -mRadius, mRadius, mRadius);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //综合练习
    //练习内容：使用各种 Canvas.drawXXX() 方法画饼图

    canvas.translate(mWidth / 2, mHeight / 2);

    float startAngle = 0;

    for (int i = 0; i < mList.size(); i++) {
      ViewData viewData = mList.get(i);

      mPaint.setColor(Color.parseColor(mColors[i]));

      float pxs =
          (float) (mRadius * Math.cos(Math.toRadians(startAngle - 180 + viewData.getNum() / 2)));
      float pys =
          (float) (mRadius * Math.sin(Math.toRadians(startAngle - 180 + viewData.getNum() / 2)));
      float pxt = (float) ((mRadius + 30) * Math.cos(
          Math.toRadians(startAngle - 180 + viewData.getNum() / 2)));
      float pyt = (float) ((mRadius + 30) * Math.sin(
          Math.toRadians(startAngle - 180 + viewData.getNum() / 2)));

      if (i == 0) {
        mRectF.set(mRectF.left - 10, mRectF.top - 10, mRectF.right - 10, mRectF.bottom - 10);
        canvas.drawArc(mRectF, startAngle - 180, viewData.getNum(), true, mPaint);

        canvas.drawLine(pxs - 10, pys - 10, pxt - 10, pyt - 10, mPaint2);

        canvas.drawText(viewData.getName(), pxt - 10, pyt - 10, mPaint2);
      } else {
        mRectF.set(-mRadius, -mRadius, mRadius, mRadius);
        canvas.drawArc(mRectF, startAngle - 180, viewData.getNum(), true, mPaint);

        canvas.drawLine(pxs, pys, pxt, pyt, mPaint2);

        canvas.drawText(viewData.getName(), pxt, pyt, mPaint2);
      }

      startAngle += viewData.getNum() + 2;
    }
  }

  private void init() {
    mList = new ArrayList<>();
    mList.add(new ViewData("Lollipop", 120));
    mList.add(new ViewData("Marshmallow", 60 - 2));
    mList.add(new ViewData("Froyo", 0));
    mList.add(new ViewData("Gingerbread", 10 - 2));
    mList.add(new ViewData("Ice Cream Sandwich", 10 - 2));
    mList.add(new ViewData("Jelly Bean", 70 - 2));
    mList.add(new ViewData("KitKat", 85 - 2));

    mColors = new String[] {
        "#F44336", "#FFC107", "#000000", "#9C27B0", "#9E9E9E", "#009688", "#2196F3"
    };

    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint2.setColor(Color.WHITE);
  }

  private class ViewData {
    private String name;
    private float num;

    ViewData(String name, float num) {
      this.name = name;
      this.num = num;
    }

    String getName() {
      return name;
    }

    float getNum() {
      return num;
    }
  }
}
