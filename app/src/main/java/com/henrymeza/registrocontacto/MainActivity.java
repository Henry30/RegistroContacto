package com.henrymeza.registrocontacto;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
//import android.support.design.

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog fromDatePickerDialog;

    private SimpleDateFormat dateFormatter;


    private DatePicker datePicker;
    private Calendar calendar;

    private int year, month, day;

    private static TextInputEditText txtNombreCompleto;
    private static TextInputEditText txtFechaNacimiento;
    private static TextInputEditText txtTelefono;
    private static TextInputEditText txtEmail;
    private static TextInputEditText txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombreCompleto = (TextInputEditText) findViewById(R.id.txtNombreCompleto);
        txtFechaNacimiento = (TextInputEditText) findViewById(R.id.txtFechaNacimiento);
        txtTelefono = (TextInputEditText) findViewById(R.id.txtTelefono);
        txtEmail = (TextInputEditText) findViewById(R.id.txtEmail);
        txtDescripcion  = (TextInputEditText) findViewById(R.id.txtDescripcion);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        Bundle extras= getIntent().getExtras();
        if(extras!=null) {
            String vtxtNombreCompleto = extras.getString(getResources().getString(R.string.nombreCompleto));
            String vtxtFechaNacimiento = extras.getString(getResources().getString(R.string.fechaNacimiento));
            String vtxtTelefono = extras.getString(getResources().getString(R.string.telefono));
            String vtxtEmail = extras.getString(getResources().getString(R.string.email));
            String vtxtDescripcion = extras.getString(getResources().getString(R.string.descripcion));

            txtNombreCompleto.setText(vtxtNombreCompleto);
            txtFechaNacimiento.setText(vtxtFechaNacimiento);
            txtTelefono.setText(vtxtTelefono);
            txtEmail.setText(vtxtEmail);
            txtDescripcion.setText(vtxtDescripcion);
        }
    }

    private void showDate(int year, int month, int day) {
        txtFechaNacimiento.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
    public void showDatePickerDialog(View v) {

        setDateTimeField();
    }
    private void setDateTimeField() {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                showDate(year,monthOfYear+1,dayOfMonth);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        fromDatePickerDialog.show();

    }

    public void btnSiguiente_Click(View v) {
        Intent intActVerContacto= new Intent(this,VerContacto.class);

        intActVerContacto.putExtra(getResources().getString(R.string.nombreCompleto),txtNombreCompleto.getText().toString());
        intActVerContacto.putExtra(getResources().getString(R.string.fechaNacimiento),txtFechaNacimiento.getText().toString());
        intActVerContacto.putExtra(getResources().getString(R.string.telefono),txtTelefono.getText().toString());
        intActVerContacto.putExtra(getResources().getString(R.string.email),txtEmail.getText().toString());
        intActVerContacto.putExtra(getResources().getString(R.string.descripcion),txtDescripcion.getText().toString());
        startActivity(intActVerContacto);
        finish();

    }

}
