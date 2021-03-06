package br.ufms.facom.mariocarvalho.p_12_sqlite_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegister;
    private DBHelper mDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DBHelper(MainActivity.this);

        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnSave);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmResult = mDBHelper.getPassword(user);
                if(password.equals(confirmResult)){
                    startActivity(new Intent(MainActivity.this, Details.class).putExtra("user_key", user));
                }else{
                    Toast.makeText(MainActivity.this, "Usuário ou senha não conferem", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cadastrar", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Add.class));
            }
        });


    }
}
