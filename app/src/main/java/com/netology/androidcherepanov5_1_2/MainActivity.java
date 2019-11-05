package com.netology.androidcherepanov5_1_2;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mKey0;
    private Button mKey1;
    private Button mKey2;
    private Button mKey3;
    private Button mKey4;
    private Button mKey5;
    private Button mKey6;
    private Button mKey7;
    private Button mKey8;
    private Button mKey9;
    private Button mKeyPoint;
    private Button mEngin;
    private Button mEnginI;

    private Button mKeyСlear;
    private Button mKeySign;
    private Button mPercent;
    private Button mKeyDivision;
    private Button mKeyMltiplication;
    private Button mSubtraction;
    private Button mKeyAddition;
    private Button mKeyFinal;
    private Button mBtnSetting;

    private FrameLayout mCalcClassic;
    private FrameLayout mCalcEngin;

    private TextView mCell00; // Поле вывода калькулятора

    private int znak; // Переменная для смены знака

    private final int SETTINGS_REQUEST = 1;
    private final String IMAGE_SETTING = "image_setting";
    private ImageView mPic_fon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInit(); // Инициализируем элементы экрана

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == SETTINGS_REQUEST && resultCode == RESULT_OK) {
            String path = data.getStringExtra(IMAGE_SETTING);
            Bitmap image = BitmapFactory.decodeFile(path);
            mPic_fon.setImageBitmap(image);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void viewInit() {

        mKey0 = findViewById(R.id.key0);
        mKey1 = findViewById(R.id.key1);
        mKey2 = findViewById(R.id.key2);
        mKey3 = findViewById(R.id.key3);
        mKey4 = findViewById(R.id.key4);
        mKey5 = findViewById(R.id.key5);
        mKey6 = findViewById(R.id.key6);
        mKey7 = findViewById(R.id.key7);
        mKey8 = findViewById(R.id.key8);
        mKey9 = findViewById(R.id.key9);
        mKeyPoint = findViewById(R.id.keyPoint);
        mEngin = findViewById(R.id.engin);

        mKeyСlear = findViewById(R.id.keyСlear);
        mKeySign = findViewById(R.id.keySign);
        mPercent = findViewById(R.id.keyPercent);
        mKeyDivision = findViewById(R.id.keyDivision);
        mKeyMltiplication = findViewById(R.id.keyMltiplication);
        mSubtraction = findViewById(R.id.keySubtraction);
        mKeyAddition = findViewById(R.id.keyAddition);
        mKeyFinal = findViewById(R.id.keyFinal);

        mCell00 = findViewById(R.id.cell00);

        mCalcClassic = findViewById(R.id.calcClassic);
        mCalcEngin = findViewById(R.id.calcEngin);

        mEnginI = findViewById(R.id.engini);

        mBtnSetting = findViewById(R.id.keySettings);
        mPic_fon = findViewById(R.id.pic_fon);

    }

    public void onClick(View view) {
        // Обрабатываем нажатия кнопок

        switch (view.getId()) {
            case R.id.key0:
                mCell00.setText(R.string.key0);
                znak = 0;
                break;

            case R.id.key1:
                mCell00.setText(R.string.key1);
                znak = 1;
                break;

            case R.id.key2:
                mCell00.setText(R.string.key2);
                znak = 2;
                break;

            case R.id.key3:
                mCell00.setText(R.string.key3);
                znak = 3;
                break;

            case R.id.key4:
                mCell00.setText(R.string.key4);
                znak = 4;
                break;

            case R.id.key5:
                mCell00.setText(R.string.key5);
                znak = 5;
                break;

            case R.id.key6:
                mCell00.setText(R.string.key6);
                znak = 6;
                break;

            case R.id.key7:
                mCell00.setText(R.string.key7);
                znak = 7;
                break;

            case R.id.key8:
                mCell00.setText(R.string.key8);
                znak = 8;
                break;

            case R.id.key9:
                mCell00.setText(R.string.key9);
                znak = 9;
                break;

            case R.id.keyPoint:
                mCell00.setText(R.string.keyPoint);
                break;

            case R.id.keyСlear:
                mCell00.setText(R.string.fildClear);
                znak = 0;
                break;

            case R.id.keySign:

                znak = znak*(-1);
                mCell00.setText(Integer.toString(znak));

                break;

            case R.id.engin:

                mCell00.setText(R.string.tEngin);
                mCalcClassic.setVisibility(View.GONE);
                mCalcEngin.setVisibility(View.VISIBLE);

                break;

            case R.id.engini:

                mCell00.setText(R.string.tClassic);
                mCalcClassic.setVisibility(View.VISIBLE);
                mCalcEngin.setVisibility(View.GONE);

                break;

            case R.id.keySettings:

                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(settingsIntent, SETTINGS_REQUEST);

            default:
                break;

        }

    }

}
