package com.boycillz.barvolumedicoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth;
    private EditText edtHeight;
    private EditText edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    private static final String STATE_RESULT = "states result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.Et);
        edtHeight = findViewById(R.id.EtLebar);
        edtLength = findViewById(R.id.EtTinggi);
        btnCalculate = findViewById(R.id.BtnSubmit);
        tvResult = findViewById(R.id.Result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BtnSubmit) {
            String inputLength = edtLength.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtLength.setError("tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtWidth.setError("tidak boleh kosong");
            }

            if (!isEmptyFields) {

                double volume = Double.parseDouble(inputLength) * Double.parseDouble(inputHeight) * Double.parseDouble(inputWidth);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());

    }
}