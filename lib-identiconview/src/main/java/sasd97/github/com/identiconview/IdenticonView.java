// Copyright © 2017 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package sasd97.github.com.identiconview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import sasd97.github.com.identiconview.field.GithubFieldProvider;
import sasd97.github.com.identiconview.field.IdenticonFieldProvider;
import sasd97.github.com.identiconview.palette.GithubPaletteProvider;
import sasd97.github.com.identiconview.palette.PaletteProvider;

import static sasd97.github.com.identiconview.IdenticonView.ColorMatchingType.AUTO_COLOR_MATCHING;
import static sasd97.github.com.identiconview.IdenticonView.ColorMatchingType.MANUAL_COLOR_MATCHING;

public class IdenticonView extends View {

    @IntDef({AUTO_COLOR_MATCHING, MANUAL_COLOR_MATCHING})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ColorMatchingType {
        int AUTO_COLOR_MATCHING = 0;
        int MANUAL_COLOR_MATCHING = 1;
    }

    private int cellSize;
    private int boundSize;
    private int verticalPadding;
    private int horizontalPadding;

    @ColorInt int activeCellsColor;
    @ColorInt int inactiveCellsColor;
    @ColorMatchingType int colorMatchingType;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private String text;

    private PaletteProvider paletteProvider = new GithubPaletteProvider();
    private IdenticonFieldProvider fieldProvider = new GithubFieldProvider();

    public IdenticonView(Context context) {
        super(context);

        if (isInEditMode()) return;
        setup(context, null);
    }

    public IdenticonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode()) return;
        setup(context, attrs);
    }

    public IdenticonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (isInEditMode()) return;
        setup(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IdenticonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        if (isInEditMode()) return;
        setup(context, attrs);
    }

    private void setup(@NonNull Context context,
                       @Nullable AttributeSet attrs) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IdenticonView);

        colorMatchingType = typedArray.getInt(R.styleable.IdenticonView_colorMode, AUTO_COLOR_MATCHING);
        activeCellsColor = typedArray.getColor(R.styleable.IdenticonView_cellsColor, Color.DKGRAY);
        inactiveCellsColor = typedArray.getColor(R.styleable.IdenticonView_backgroundColor, Color.WHITE);

        String text = typedArray.getString(R.styleable.IdenticonView_text);

        typedArray.recycle();

        setText(text);
        obtainColors(colorMatchingType);
    }

    private void obtainColors(@ColorMatchingType int colorMatchingType) {
        if (colorMatchingType != AUTO_COLOR_MATCHING) return;

        inactiveCellsColor = paletteProvider.getInactiveColor();
        activeCellsColor = paletteProvider.getActiveColor();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawIdenticon(canvas);
    }

    private void drawIdenticon(@NonNull Canvas canvas) {
        for (int row = 0; row < fieldProvider.getFieldCapacity(); row++) {
            for (int column = 0; column < fieldProvider.getFieldCapacity(); column++) {
                int x = column * cellSize + horizontalPadding;
                int y = row * cellSize + verticalPadding;

                paint.setColor(obtainColorForCell(column, row));
                canvas.drawRect(x, y, x + cellSize, y + cellSize, paint);
            }
        }
    }

    @ColorInt
    private int obtainColorForCell(int column, int row) {
        boolean isActive = fieldProvider.isCellActive(column, row);
        return isActive ? activeCellsColor : inactiveCellsColor;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        boundSize = Math.min(getMeasuredWidth(), getMeasuredHeight());

        cellSize = boundSize / fieldProvider.getFieldCapacity();

        int fieldSize = cellSize * fieldProvider.getFieldCapacity();

        horizontalPadding = (getMeasuredWidth() - fieldSize) / 2;
        verticalPadding = (getMeasuredHeight() - fieldSize) / 2;
    }

    public void setText(@Nullable String text) {
        this.text = text;
        fieldProvider.generateHash(text);
        paletteProvider.generateHash(text);
        obtainColors(colorMatchingType);
        invalidate();
    }

    public void setColors(@ColorInt int cellsColor, @ColorInt int backgroundColor) {
        colorMatchingType = MANUAL_COLOR_MATCHING;
        activeCellsColor = cellsColor;
        inactiveCellsColor = backgroundColor;
        invalidate();
    }

    public void resetColors() {
        this.colorMatchingType = AUTO_COLOR_MATCHING;
        obtainColors(colorMatchingType);
        invalidate();
    }

    public void setFieldProvider(@Nullable IdenticonFieldProvider fieldProvider) {
        if (fieldProvider == null)
            throw new IllegalArgumentException("fieldProvider should not be null");
        this.fieldProvider = fieldProvider;
        invalidate();
    }
}
