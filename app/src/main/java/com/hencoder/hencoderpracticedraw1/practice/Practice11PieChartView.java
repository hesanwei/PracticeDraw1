package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;

import java.util.ArrayList;

public class Practice11PieChartView extends View {

    private Paint mPaint;
    private ArrayList<Data> mDataList;
    private int mTotal;

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDataList = new ArrayList<>();
        mDataList.add(new Data("Froyo", 5, Color.WHITE));
        mDataList.add(new Data("Gingerbread", 10, Color.MAGENTA));
        mDataList.add(new Data("Ice Cream Sandwich", 12, Color.GRAY));
        mDataList.add(new Data("Jelly Bean", 33, Color.GREEN));
        mDataList.add(new Data("KitKat", 70, Color.BLUE));
        mDataList.add(new Data("Lollipop", 85, Color.RED));
        mDataList.add(new Data("Marshmallow", 45, Color.YELLOW));
        mTotal = 260;//所有number 的和
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.translate(width / 2 ,height / 2);
//        RectF rectF = new RectF(0,0,width,height);
        RectF rectF = new RectF();
        float radius = 180;

        rectF.left = - radius;
        rectF.top = - radius;
        rectF.right = radius ;
        rectF.bottom = radius;
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        float startSweepAngel = 0f;
        for (int i = 0; i < mDataList.size(); i++) {
            Data data = mDataList.get(i);
            float sweepAngel = data.mValue * 1.0f / mTotal * 360f;
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(data.mColor);

            if (i == 5){
                canvas.save();
                canvas.translate(-10,-10);
                canvas.drawArc(rectF,startSweepAngel,sweepAngel,true,mPaint);
            }/*else if (i > 5){
                canvas.translate(10,10);
                canvas.drawArc(rectF,startSweepAngel,sweepAngel - 2,true,mPaint);
            }*/else {
                canvas.drawArc(rectF,startSweepAngel,sweepAngel - 2,true,mPaint);
            }

            float lineAngle = startSweepAngel + sweepAngel / 2;

            Log.d("lineAngel", "onDraw: lineAngel ==== " + lineAngle + "");


            float startX = (float) (radius * Math.cos(lineAngle / 360 * (2 * Math.PI)));
            float startY = (float) (radius * Math.sin(lineAngle / 360 * (2 * Math.PI)));
            float endX = (float) ((radius + 20) * Math.cos(lineAngle / 360 * (2 * Math.PI)));
            float endY = (float) ((radius + 20) * Math.sin(lineAngle / 360 * (2 * Math.PI)));

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(0.5f);
            mPaint.setColor(Color.WHITE);
            canvas.drawLine(startX,startY,endX,endY,mPaint);
            float endX2 ;
            float endY2 ;

            float textWidth = mPaint.measureText(data.mName);
//            float textHeight = mPaint.getFontMetrics().bottom - mPaint.getFontMetrics().top;
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setTextSize(20);
            if (lineAngle >= 90 && lineAngle <= 270){
                endX2 = endX - 100;
                endY2 = endY;
                canvas.drawText(data.mName,endX2 - textWidth - 10,endY2 ,mPaint );
            }else {
                endX2 = endX + 100;
                endY2 = endY;
                canvas.drawText(data.mName,endX2 + 10,endY2 ,mPaint );
            }

            canvas.drawLine(endX,endY,endX2,endY2,mPaint);

            if (i == 5){
                canvas.restore();//canvas 恢复到之前的一个状态  如果canvas没做过任何几何变换 那么canvas不变
            }

            startSweepAngel += sweepAngel;
        }

        mPaint.setTextSize(30);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("饼图",-mPaint.measureText("饼图") / 2,radius + 50,mPaint);

    }
}
