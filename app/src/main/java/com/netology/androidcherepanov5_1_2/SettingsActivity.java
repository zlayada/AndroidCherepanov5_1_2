package com.netology.androidcherepanov5_1_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;


public class SettingsActivity extends AppCompatActivity {

    private EditText mAddress_link;
    private Button mBtnAddress;

    private int permissionStatus;
    static final int REQUEST_CODE_PERMISSION_READ_STORAGE = 10;


    private final String IMAGE_SETTING = "image_setting";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mAddress_link = findViewById(R.id.address_link);
        mBtnAddress = findViewById(R.id.btnAddress);

        permissionStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        Button mBtnAddress = findViewById(R.id.btnAddress);


        mBtnAddress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (permissionStatus == PackageManager.PERMISSION_GRANTED) {

                    loadImage();
                    finish();

                } else {

                    ActivityCompat.requestPermissions(SettingsActivity.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                            REQUEST_CODE_PERMISSION_READ_STORAGE);
                }
            }
        });


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {

            case REQUEST_CODE_PERMISSION_READ_STORAGE:

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    loadImage();
                    finish();
                }
        }
    }

    private void loadImage() {

        // Проверка на пустую строку при вводе файла
        if ("".equals(mAddress_link.getText().toString())) {
            Toast.makeText(this, getString(R.string.space_address), Toast.LENGTH_SHORT).show();
            return;
        }

        if (isExternalStorageReadable()) {

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), mAddress_link.getText().toString());

            if (file.exists()) {

                String path = file.getAbsolutePath();

                Intent resultIntent = new Intent();
                resultIntent.putExtra(IMAGE_SETTING, path);
                setResult(RESULT_OK, resultIntent);

                Toast.makeText(this, getString(R.string.ok_file), Toast.LENGTH_SHORT).show();


            } else {

                Toast.makeText(this, getString(R.string.not_file), Toast.LENGTH_SHORT).show();
            }

        } else {

            Toast.makeText(this, getString(R.string.error_text), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isExternalStorageReadable() {

        String state = Environment.getExternalStorageState();

        return state.equals(Environment.MEDIA_MOUNTED) || state.equals(Environment.MEDIA_MOUNTED_READ_ONLY);
    }


}
