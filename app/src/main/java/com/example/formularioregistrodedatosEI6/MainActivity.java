package com.example.formularioregistrodedatosEI6;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns; 
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // elementos de la interfaz a usar
    private EditText etName, etSurname, etEmail;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // la interfaz con el código de nuestro Java
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etEmail = findViewById(R.id.etEmail);
        btnSubmit = findViewById(R.id.btnSubmit);

        //  el listener para el botón Enviar
        btnSubmit.setOnClickListener(v -> {
            // si obtenemos los valores de los campos
            String name = etName.getText().toString().trim();
            String surname = etSurname.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            // aqui erificamos que los campos no estén vacíos
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(surname) || TextUtils.isEmpty(email)) {
                // un mensaje de error si algún campo está vacío
                Toast.makeText(MainActivity.this, "Por favor rellene todos los campos para proseguir", Toast.LENGTH_SHORT).show();
            } else if (!isValidEmail(email)) {
                // un mensaje de error si el correo no es válido
                Toast.makeText(MainActivity.this, "Por favor ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
            } else {
                // aca un Toastada con el saludo si todos los campos están completos
                String message = "Hola " + name + " " + surname + ", su email es " + email;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    // una forma  para validar el correo electrónico
    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
