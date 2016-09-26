package com.henrymeza.registrocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VerContacto extends AppCompatActivity {
    private static TextView tvNombreCompleto;
    private static TextView tvFechaNacimiento;
    private static TextView tvTelefono;
    private static TextView tvEmail;
    private static TextView tvDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_contacto);

        Bundle extras= getIntent().getExtras();
        String vtxtNombreCompleto=extras.getString(getResources().getString(R.string.nombreCompleto));
        String vtxtFechaNacimiento=extras.getString(getResources().getString(R.string.fechaNacimiento));
        String vtxtTelefono=extras.getString(getResources().getString(R.string.telefono));
        String vtxtEmail=extras.getString(getResources().getString(R.string.email));
        String vtxtDescripcion=extras.getString(getResources().getString(R.string.descripcion));

        tvNombreCompleto=(TextView) findViewById(R.id.tvNombreCompleto);
        tvFechaNacimiento=(TextView)findViewById(R.id.tvFechaNacimiento);
        tvTelefono=(TextView)findViewById(R.id.tvTelefono);
        tvEmail=(TextView)findViewById(R.id.tvEmail);
        tvDescripcion=(TextView)findViewById(R.id.tvDescripcion);

        tvNombreCompleto.setText(vtxtNombreCompleto);
        tvFechaNacimiento.setText(vtxtFechaNacimiento);
        tvTelefono.setText(vtxtTelefono);
        tvEmail.setText(vtxtEmail);
        tvDescripcion.setText(vtxtDescripcion);
    }

    public void btnEditar_Click(View v) {

        Intent intMainActivity= new Intent(this,MainActivity.class);

        intMainActivity.putExtra(getResources().getString(R.string.nombreCompleto),tvNombreCompleto.getText().toString());
        intMainActivity.putExtra(getResources().getString(R.string.fechaNacimiento),tvFechaNacimiento.getText().toString());
        intMainActivity.putExtra(getResources().getString(R.string.telefono),tvTelefono.getText().toString());
        intMainActivity.putExtra(getResources().getString(R.string.email),tvEmail.getText().toString());
        intMainActivity.putExtra(getResources().getString(R.string.descripcion),tvDescripcion.getText().toString());
        startActivity(intMainActivity);
        finish();
    }
}
