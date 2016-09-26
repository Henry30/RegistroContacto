package com.henrymeza.registrocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VerContacto extends AppCompatActivity {

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

        TextView tvNombreCompleto=(TextView) findViewById(R.id.tvNombreCompleto);
        TextView tvFechaNacimiento=(TextView)findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono=(TextView)findViewById(R.id.tvTelefono);
        TextView tvEmail=(TextView)findViewById(R.id.tvEmail);
        TextView tvDescripcion=(TextView)findViewById(R.id.tvDescripcion);

        tvNombreCompleto.setText(vtxtNombreCompleto);
        tvFechaNacimiento.setText(vtxtFechaNacimiento);
        tvTelefono.setText(vtxtTelefono);
        tvEmail.setText(vtxtEmail);
        tvDescripcion.setText(vtxtDescripcion);
    }

    public void btnEditar_Click(View v) {
        //Intent intActEditarContacto= new Intent(this,MainActivity.class);
        //startActivity(intActEditarContacto);

        Intent intMainActivity= new Intent(this,MainActivity.class);
        TextView txtNombreCompleto=(TextView) findViewById(R.id.tvNombreCompleto);
        TextView txtFechaNacimiento=(TextView) findViewById(R.id.tvFechaNacimiento);
        TextView txtTelefono=(TextView) findViewById(R.id.tvTelefono);
        TextView txtEmail=(TextView) findViewById(R.id.tvEmail);
        TextView txtDescripcion=(TextView) findViewById(R.id.tvDescripcion);
        intMainActivity.putExtra(getResources().getString(R.string.nombreCompleto),txtNombreCompleto.getText().toString());
        intMainActivity.putExtra(getResources().getString(R.string.fechaNacimiento),txtFechaNacimiento.getText().toString());
        intMainActivity.putExtra(getResources().getString(R.string.telefono),txtTelefono.getText().toString());
        intMainActivity.putExtra(getResources().getString(R.string.email),txtEmail.getText().toString());
        intMainActivity.putExtra(getResources().getString(R.string.descripcion),txtDescripcion.getText().toString());
        startActivity(intMainActivity);
        finish();
    }
}
