package sasd97.github.com.identicons;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import sasd97.github.com.identiconview.IdenticonView;

public class IdenticonActivity extends AppCompatActivity {

    private EditText editText;
    private IdenticonView identiconView;
    private CheckBox isAutoColorMatching;
    private Button cellsColorButton;
    private Button backgroundColorButton;

    @ColorInt
    private int cellsColor = Color.WHITE;

    @ColorInt
    private int backgroundColor = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identicon);

        editText = findViewById(R.id.text);
        identiconView = findViewById(R.id.identicon);
        isAutoColorMatching = findViewById(R.id.isAutoColorMatching);
        cellsColorButton = findViewById(R.id.cellsColorButton);
        backgroundColorButton = findViewById(R.id.backgroundColorButton);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                identiconView.setText(editable.toString());
            }
        });

        isAutoColorMatching.setOnCheckedChangeListener((CompoundButton compoundButton, boolean b) -> {
            if (b) {
                cellsColorButton.setEnabled(false);
                backgroundColorButton.setEnabled(false);
                identiconView.resetColors();
                return;
            }

            cellsColorButton.setEnabled(true);
            backgroundColorButton.setEnabled(true);
            identiconView.setColors(cellsColor, backgroundColor);
        });

        cellsColorButton.setOnClickListener(v -> {
            ColorPickerDialogBuilder
                    .with(this)
                    .setTitle("Choose color")
                    .initialColor(cellsColor)
                    .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                    .density(12)
                    .setOnColorSelectedListener(selectedColor -> {
                        cellsColor = selectedColor;
                        identiconView.setColors(cellsColor, backgroundColor);
                    })
                    .build()
                    .show();
        });

        backgroundColorButton.setOnClickListener(v -> {
            ColorPickerDialogBuilder
                    .with(this)
                    .setTitle("Choose color")
                    .initialColor(backgroundColor)
                    .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                    .density(12)
                    .setOnColorSelectedListener(selectedColor -> {
                        backgroundColor = selectedColor;
                        identiconView.setColors(cellsColor, backgroundColor);
                    })
                    .build()
                    .show();
        });
    }
}
