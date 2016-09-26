# Registro Contacto en Android

Pantalla Inicial de Registro de Contacto
![Alt text](https://cloud.githubusercontent.com/assets/17391733/18820524/da02fc02-8363-11e6-831a-e2f4be49b977.png)

Seleccionamos la Fecha

![Alt text](https://cloud.githubusercontent.com/assets/17391733/18820582/7f8d556e-8364-11e6-99cf-522824a351d2.png)

Pantalla Con Datos Llenados
![Alt text](https://cloud.githubusercontent.com/assets/17391733/18820595/98dfceac-8364-11e6-9b67-7a86cf4e6fc9.png)

Vista del Registro de Contacto
![Alt text](https://cloud.githubusercontent.com/assets/17391733/18820623/c87c2bba-8364-11e6-8c21-282938a33c08.png)

Editar Registro de Contacto
![Alt text](https://cloud.githubusercontent.com/assets/17391733/18821336/cb7b2c84-836a-11e6-88df-4b30d8458b24.png)

Codigo Activity_Main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="vertical"
    tools:context="com.henrymeza.registrocontacto.MainActivity">

    <android.support.design.widget.TextInputEditText
        android:id="@+id/txtNombreCompleto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/mensaje_txtNombreCompleto"/>
    <android.support.design.widget.TextInputEditText
        android:id="@+id/txtFechaNacimiento"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/mensaje_txtFechaNacimiento"
        />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/mensaje_btnFecha"
        android:onClick="showDatePickerDialog" />
    <android.support.design.widget.TextInputEditText
        android:id="@+id/txtTelefono"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/mensaje_txtTelefono"

        />
    <android.support.design.widget.TextInputEditText
        android:id="@+id/txtEmail"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/mensaje_txtEmail"
        />
    <android.support.design.widget.TextInputEditText
        android:id="@+id/txtDescripcion"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/mensaje_txtDescripcion"
        android:scrollbars="vertical"
        android:inputType="textMultiLine"
        />
    <Button
        android:id="@+id/btnGrabar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/mensaje_btnGrabar"
        android:onClick="btnSiguiente_Click"
        />
</LinearLayout>


Clase MainActivity


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

Activity_ver_contacto.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="vertical"
    tools:context="com.henrymeza.registrocontacto.VerContacto">
    <TextView
        android:id="@+id/tvTituloConfirmarDatos"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/tutilo_confirmarDatos"
        android:textStyle="bold"
        android:textSize="@dimen/size_LetraTituloConfirmarDatos"
        android:layout_gravity="center"
        />
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    >
    <TextView
        android:id="@+id/tvTituloNombreCompleto"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/mensaje_txtNombreCompleto"
        android:textStyle="bold"
        />

        <TextView
            android:id="@+id/tvNombreCompleto"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
        />
</LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        >
    <TextView
        android:id="@+id/tvTituloFechaNacimiento"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/mensaje_txtFechaNacimiento"
        android:textStyle="bold"
        />
    <TextView
        android:id="@+id/tvFechaNacimiento"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        >
        <TextView
            android:id="@+id/tvTituloTelefono"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/mensaje_txtTelefono"
            android:textStyle="bold"
            />
    <TextView
        android:id="@+id/tvTelefono"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"

        />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        >
        <TextView
            android:id="@+id/tvTituloEmail"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/mensaje_txtEmail"
            android:textStyle="bold"
            />
    <TextView
        android:id="@+id/tvEmail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        >
        <TextView
            android:id="@+id/tvTituloDescripcion"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/mensaje_txtDescripcion"
            android:textStyle="bold"
            />
    <TextView
        android:id="@+id/tvDescripcion"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        />
    </LinearLayout>
    <Button
        android:id="@+id/btnGrabar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/mensaje_btnEditar"
        android:onClick="btnEditar_Click"
        />

</LinearLayout>


Clase VerContacto

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

Archivo string.xml
<resources>
    <string name="app_name">Registro de Contacto</string>
    <string name="tutilo_confirmarDatos">Confirmar Datos</string>
    <string name="mensaje_btnFecha">Seleccionar Fecha</string>
    <string name="mensaje_btnGrabar">Siguiente</string>
    <string name="mensaje_btnEditar">Editar Datos</string>
    <string name="mensaje_txtNombreCompleto">Nombre Completo: </string>
    <string name="mensaje_txtFechaNacimiento">Fecha Nacimiento: </string>
    <string name="mensaje_txtTelefono">Nro de Teléfono: </string>
    <string name="mensaje_txtEmail">Email: </string>
    <string name="mensaje_txtDescripcion">Descripción del Contacto: </string>

    <string name="nombreCompleto">nombreCompleto</string>
    <string name="fechaNacimiento">fechaNacimiento</string>
    <string name="telefono">telefono</string>
    <string name="email">email</string>
    <string name="descripcion">descripcion</string>
</resources>

archivo dimens.xml
<resources>
    <!-- Default screen margins, per the Android Design guidelines. -->
    <dimen name="activity_horizontal_margin">16dp</dimen>
    <dimen name="activity_vertical_margin">16dp</dimen>
    <dimen name="size_LetraTituloConfirmarDatos">20dp</dimen>
</resources>


