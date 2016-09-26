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
![Alt text](https://cloud.githubusercontent.com/assets/17391733/18820595/98dfceac-8364-11e6-9b67-7a86cf4e6fc9.png)

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
        />
    <Button
        android:id="@+id/btnGrabar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/mensaje_btnGrabar"
        android:onClick="btnSiguiente_Click"
        />
</LinearLayout>
