// Copyright © 2017 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package sasd97.github.com.identiconview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import sasd97.github.com.identiconview.providers.GithubFieldProvider;
import sasd97.github.com.identiconview.providers.IdenticonFieldProvider;

public class IdenticonView extends View {

    private int cellSize;
    private int boundSize;
    private int verticalPadding;
    private int horizontalPadding;

    private IdenticonFieldProvider identiconFieldProvider = new GithubFieldProvider();

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public IdenticonView(Context context) {
        super(context);
        setup();
    }

    public IdenticonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public IdenticonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IdenticonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup() {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        setText("Hello World!");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawIdenticon(canvas);
    }

    private void drawIdenticon(@NonNull Canvas canvas) {
        for (int row = 0; row < identiconFieldProvider.getFieldCapacity(); row++) {
            for (int column = 0; column < identiconFieldProvider.getFieldCapacity(); column++) {
                int x = column * cellSize + horizontalPadding;
                int y = row * cellSize + verticalPadding;

                paint.setColor(obtainColorForCell(column, row));
                canvas.drawRect(x, y, x + cellSize, y + cellSize, paint);
            }
        }
    }

    @ColorInt
    private int obtainColorForCell(int column, int row) {
        boolean isActive = identiconFieldProvider.isCellActive(column, row);
        return isActive ? Color.RED : Color.BLACK;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        boundSize = Math.min(getMeasuredWidth(), getMeasuredHeight());

        cellSize = boundSize / identiconFieldProvider.getFieldCapacity();

        int fieldSize = cellSize * identiconFieldProvider.getFieldCapacity();

        horizontalPadding = (getMeasuredWidth() - fieldSize) / 2;
        verticalPadding = (getMeasuredHeight() - fieldSize) / 2;
    }

    public void setText(@Nullable String text) {
        identiconFieldProvider.generateFieldFor(text);
        invalidate();
    }

    public void setIdenticonFieldProvider(@Nullable IdenticonFieldProvider identiconFieldProvider) {
        if (identiconFieldProvider == null)
            throw new IllegalArgumentException("identiconFieldProvider should not be null");
        this.identiconFieldProvider = identiconFieldProvider;
        invalidate();
    }
}
