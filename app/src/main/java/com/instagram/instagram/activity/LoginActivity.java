package com.instagram.instagram.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.instagram.instagram.R;


public class LoginActivity extends AppCompatActivity {

    private TextView textCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textCadastrar = findViewById(R.id.textCadastrar);

        textCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity( intent );
            }
        });
    }


}