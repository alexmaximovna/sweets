package ru.imit.omsu.sweet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Draw2D extends View {
    private float mOffset;
    private int mColor;
    private float[] basePoints = {
            120, 0, 120, 20, 120, 20, 125, 0, 130, 0, 132, 10
    };
    private float[] copyPoints = new float[12];

    public Draw2D(Context c, float offset, int color) {
        super(c);
        mOffset = offset;
        mColor = color;
    }

    private void drawLines(Canvas canvas, Paint p, float xOffset, float yOffset) {
        canvas.drawLine(10 + xOffset, yOffset, 10 + xOffset, 40 + yOffset, p);
        canvas.drawLine(30 + xOffset, yOffset, 40 + xOffset, 40 + yOffset, p);
        canvas.drawLine(40 + xOffset, yOffset, 75 + xOffset, 35 + yOffset, p);
        canvas.drawLine(50 + xOffset, 5+ yOffset, 100 + xOffset, 15 + yOffset, p);
        canvas.drawLine(60 + xOffset, yOffset, 110 + xOffset, 2 + yOffset, p);
        canvas.drawLine(60 + xOffset, 40 + yOffset, 110 + xOffset, 40 + yOffset, p);
        for (int i = 0; i < 12; i += 2) {
            copyPoints[i] = basePoints[i] + xOffset;
            copyPoints[i+1] = basePoints[i+1] + yOffset;
        }
        canvas.drawLines(copyPoints, 0, 12, p);
    }

    private void drawVerticalLine(Canvas canvas, Paint p, float length, float x, float y) {
        canvas.drawLine(x, y, x, y + length, p);
    }

    private void drawDiagonalLine(Canvas canvas, Paint p, float length, float x, float y) {
        canvas.drawLine(x, y, x + length, y + length, p);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(mColor);
        float yOffset = 10;

        canvas.save();
        drawLines(canvas, p, mOffset, yOffset);
        canvas.scale(2, 2);
        canvas.translate(60, 0);
        drawLines(canvas, p, mOffset/2, yOffset/2);
        canvas.restore();

        yOffset +=100;
        canvas.save();
        p.setStrokeWidth(1);
        drawLines(canvas, p, mOffset, yOffset);
        canvas.scale(2, 2);
        canvas.translate(60, 0);
        drawLines(canvas, p, mOffset/2, yOffset/2);
        canvas.restore();

        yOffset += 100;
        canvas.save();
        p.setStrokeWidth(2);
        drawLines(canvas, p, mOffset, yOffset);
        canvas.scale(2, 2);
        canvas.translate(60, 0);
        drawLines(canvas, p, mOffset/2, yOffset/2);
        canvas.restore();

        p.setAntiAlias(true);
        p.setStrokeWidth(0);
        yOffset += 100;
        canvas.save();
        drawLines(canvas, p, mOffset, yOffset);
        canvas.scale(2, 2);
        canvas.translate(60, 0);
        drawLines(canvas, p, mOffset/2, yOffset/2);
        canvas.restore();

        yOffset += 100;
        canvas.save();
        p.setStrokeWidth(1);
        drawLines(canvas, p, mOffset, yOffset);
        canvas.scale(2, 2);
        canvas.translate(60, 0);
        drawLines(canvas, p, mOffset/2, yOffset/2);
        canvas.restore();

        yOffset += 100;
        canvas.save();
        p.setStrokeWidth(2);
        drawLines(canvas, p, mOffset, yOffset);
        canvas.scale(2, 2);
        canvas.translate(60, 0);
        drawLines(canvas, p, mOffset/2, yOffset/2);
        canvas.restore();

        yOffset += 100;
        canvas.save();
        p.setStrokeWidth(1);
        float x = 10 + mOffset;
        for (float length = 1; length <= 10; length +=1 ) {
            p.setAntiAlias(false);
            drawVerticalLine(canvas, p, length, x, yOffset);
            x += 5;
            p.setAntiAlias(true);
            drawVerticalLine(canvas, p, length, x, yOffset);
            x += 5;
        }
        p.setStrokeWidth(5);
        for (float length = 1; length <= 10; length +=1 ) {
            p.setAntiAlias(false);
            drawVerticalLine(canvas, p, length, x, yOffset);
            x += 10;
            p.setAntiAlias(true);
            drawVerticalLine(canvas, p, length, x, yOffset);
            x += 10;
        }
        canvas.restore();

        yOffset += 20;
        canvas.save();
        p.setStrokeWidth(1);
        x = 10 + mOffset;
        for (float length = 1; length <= 10; length +=1 ) {
            p.setAntiAlias(false);
            drawDiagonalLine(canvas, p, length, x, yOffset);
            x += 5;
            p.setAntiAlias(true);
            drawDiagonalLine(canvas, p, length, x, yOffset);
            x += 5;
        }
        p.setStrokeWidth(2);
        for (float length = 1; length <= 10; length +=1 ) {
            p.setAntiAlias(false);
            drawDiagonalLine(canvas, p, length, x, yOffset);
            x += 10;
            p.setAntiAlias(true);
            drawDiagonalLine(canvas, p, length, x, yOffset);
            x += 10;
        }
        canvas.restore();

        yOffset += 20;
        canvas.save();
        p.setStrokeWidth(1);
        x = 10 + mOffset;
        for (float length = 1; length <= 10; length +=1 ) {
            p.setAntiAlias(false);
            canvas.drawLine(x, yOffset, x + 1, yOffset + length, p);
            x += 5;
            p.setAntiAlias(true);
            canvas.drawLine(x, yOffset, x + 1, yOffset + length, p);
            x += 5;
        }
        p.setStrokeWidth(2);
        for (float length = 1; length <= 10; length +=1 ) {
            p.setAntiAlias(false);
            canvas.drawLine(x, yOffset, x + 1, yOffset + length, p);
            x += 10;
            p.setAntiAlias(true);
            canvas.drawLine(x, yOffset, x + 1, yOffset + length, p);
            x += 10;
        }
        canvas.restore();

        yOffset += 20;
        canvas.save();
        p.setStrokeWidth(1);
        x = 10 + mOffset;
        for (float length = 1; length <= 10; length +=1 ) {
            p.setAntiAlias(false);
            canvas.drawLine(x, yOffset, x + length, yOffset + 1, p);
            x += 5;
            p.setAntiAlias(true);
            canvas.drawLine(x, yOffset, x + length, yOffset + 1, p);
            x += 5;
        }
        p.setStrokeWidth(2);
        for (float length = 1; length <= 10; length +=1 ) {
            p.setAntiAlias(false);
            canvas.drawLine(x, yOffset, x + length, yOffset + 1, p);
            x += 10;
            p.setAntiAlias(true);
            canvas.drawLine(x, yOffset, x + length, yOffset + 1, p);
            x += 10;
        }
        canvas.restore();

    }

}
