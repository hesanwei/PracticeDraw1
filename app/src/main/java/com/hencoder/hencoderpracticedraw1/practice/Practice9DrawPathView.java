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

    private Paint mPaint;
    private Path mPath;

    public Practice9DrawPathView(Context context) {
        super(context);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawPath() 方法画心形
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        RectF rectF = new RectF();
        rectF.left = width / 2 -100;
        rectF.top = height / 2 - 100;
        rectF.right = width / 2;
        rectF.bottom = height / 2;

        mPath.arcTo(rectF,-225,225);

        rectF.left = width / 2 ;
        rectF.top = height / 2 - 100;
        rectF.right = width / 2 + 100;
        rectF.bottom = height / 2 ;
        mPath.arcTo(rectF,-180,225);

        mPath.lineTo(width / 2 ,height / 2 + 80);
        mPath.close();
        canvas.drawPath(mPath,mPaint);

    }
}
