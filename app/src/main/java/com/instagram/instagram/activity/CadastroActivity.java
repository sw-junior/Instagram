package com.instagram.instagram.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.instagram.instagram.R;
import com.instagram.instagram.helper.ConfiguracaoFirebase;
import com.instagram.instagram.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button botaoCadastrar;
    private ProgressBar progressBar;

    private Usuario usuario;

    private FirebaseAuth autenticacao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                String nome  = campoNome.getText().toString();
                String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();

                if ( !nome.isEmpty()) {
                    if ( !email.isEmpty()) {
                        if ( !senha.isEmpty()) {

                            usuario = new Usuario();
                            usuario.setNome(nome);
                            usuario.setSenha(email);
                            usuario.setSenha(senha);
                            cadastrar(usuario);


                        }else {
                            Toast.makeText(CadastroActivity.this, "Preecha a senha!",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }else {
                        Toast.makeText(CadastroActivity.this, "Preecha o e-mail!",
                                Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(CadastroActivity.this, "Preecha o nome!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    private void cadastrar (Usuario usuario) {

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(

                usuario.getEmail(),
                usuario.getSenha()
        );

    }
    public void inicializarComponentes() {

        campoNome      = findViewById(R.id.editCadastroNome);
        campoEmail     = findViewById(R.id.editCadastroEmail);
        campoSenha     = findViewById(R.id.editCadastroSenha);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        progressBar    = findViewById(R.id.progressCadastro);
    }

    }


