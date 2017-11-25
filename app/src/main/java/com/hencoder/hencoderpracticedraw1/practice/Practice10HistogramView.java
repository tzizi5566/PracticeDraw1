package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

  public static final int START_X = 80;//X轴开始坐标
  public static final int START_Y = 450;//Y轴开始坐标
  public static final int RECT_WIDTH = 65;//单个柱形宽度
  public static final int RECT_MARGIN = 13;//两个柱形之间距离

  private Paint mPaint1, mPaint2, mPaint3;
  private RectF mRectF;
  private Rect mTextRect;

  private float[] mLinesPoint;
  private List<ViewData> mList;

  public Practice10HistogramView(Context context) {
    this(context, null);
  }

  public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //综合练习
    //练习内容：使用各种 Canvas.drawXXX() 方法画直方图

    for (int i = 0; i < mList.size(); i++) {
      ViewData viewData = mList.get(i);

      float l = START_X + 15;
      float r = l + RECT_WIDTH;

      mRectF.set(
          l + (RECT_WIDTH + RECT_MARGIN) * i,
          START_Y - viewData.getNum(),
          r + (RECT_WIDTH + RECT_MARGIN) * i,
          START_Y);
      canvas.drawRect(mRectF, mPaint1);

      mPaint2.getTextBounds(viewData.getName(), 0, viewData.getName().length(), mTextRect);
      canvas.drawText(
          viewData.getName(),
          (mRectF.left + mRectF.right) / 2 - mTextRect.width() / 2,
          mRectF.bottom + mTextRect.height() + 3,
          mPaint2);
    }

    canvas.drawLines(mLinesPoint, mPaint3);
  }

  private void init() {
    mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint1.setColor(Color.parseColor("#72B916"));

    mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint2.setColor(Color.WHITE);
    mPaint2.setTextSize(18F);

    mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint3.setStyle(Paint.Style.STROKE);
    mPaint3.setColor(Color.WHITE);
    mPaint3.setStrokeWidth(1.5F);

    mRectF = new RectF();
    mTextRect = new Rect();

    mList = new ArrayList<>();
    mList.add(new ViewData("Froyo", 1.5F));
    mList.add(new ViewData("GB", 12.0F));
    mList.add(new ViewData("ICS", 13.0F));
    mList.add(new ViewData("JB", 140.0F));
    mList.add(new ViewData("KitKat", 260.0F));
    mList.add(new ViewData("L", 305.0F));
    mList.add(new ViewData("M", 137.0F));

    mLinesPoint = new float[] { START_X, 50, START_X, START_Y, START_X, START_Y, 650, START_Y };
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
