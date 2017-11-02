package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    private Paint mPaint;
    private List<Data> mDataList;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDataList = new ArrayList<>();
        mDataList.add(new Data("Froyo",0, Color.GREEN));
        mDataList.add(new Data("GB",1, Color.GREEN));
        mDataList.add(new Data("ICS",1, Color.GREEN));
        mDataList.add(new Data("JB",8, Color.GREEN));
        mDataList.add(new Data("KitKat",15, Color.GREEN));
        mDataList.add(new Data("L",20, Color.GREEN));
        mDataList.add(new Data("M",7, Color.GREEN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int width = canvas.getWidth();
        int height = canvas.getHeight();


        int rectWidth = width / 11;
        int rectHeight = height - 150;
        int space = 15;
        RectF rectf = new RectF();
        mPaint.setTextSize(14);
        Paint.FontMetrics metrics = mPaint.getFontMetrics();
        for (int i = 0; i < mDataList.size(); i++) {
            Data data = mDataList.get(i);

            mPaint.setColor(data.mColor);
            mPaint.setStyle(Paint.Style.FILL);
            rectf.left = rectWidth * (i + 1) + space * (i + 2);
            rectf.top = rectHeight - data.mValue * space;
            rectf.right = rectf.left + rectWidth;
            rectf.bottom = rectHeight;
            canvas.drawRect(rectf,mPaint);

            mPaint.setColor(Color.WHITE);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(1);

            float startX = (rectf.left + rectf.right) / 2 - mPaint.measureText(data.mName) / 2;
            float startY = rectHeight + (metrics.bottom - metrics.top);

            canvas.drawText(data.mName,startX,startY,mPaint);

        }
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(rectWidth,30,rectWidth,rectHeight,mPaint);
        canvas.drawLine(rectWidth,rectHeight,rectWidth + (space + rectWidth) * (mDataList.size() + 2),rectHeight,mPaint);


        mPaint.setTextSize(30);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        float startX = width / 2 - mPaint.measureText("直方图") / 2;
        float startY = height - 80;
        canvas.drawText("直方图",startX,startY,mPaint);
    }


}
