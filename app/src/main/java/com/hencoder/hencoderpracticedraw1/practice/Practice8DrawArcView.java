package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint mPaint;

    public Practice8DrawArcView(Context context) {
        super(context);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(width / 2 - 200,height / 2 - 150,width / 2 + 200,height / 2 + 150,-180 ,60,false,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(width / 2 - 200,height / 2 - 150,width / 2 + 200,height / 2 + 150,250 ,100,true,mPaint);

        canvas.drawArc(width / 2 - 200,height / 2 - 150,width / 2 + 200,height / 2 + 150,20 ,140,false,mPaint);

    }
}
