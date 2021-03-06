package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {

    private Paint mPaint;

    public Practice5DrawOvalView(Context context) {
        super(context);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
//        练习内容：使用 canvas.drawOval() 方法画椭圆

//        canvas.drawOval(width / 2 - 100,height / 2 - 100,width / 2 + 100,height / 2 + 100,mPaint);
        RectF rectF = new RectF(width / 2 - 200,height / 2 - 100,width / 2 + 200,height / 2 + 100);
        canvas.drawOval(rectF,mPaint);
    }
}
