package com.example.rse_vzla_07.preacticarealm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rse_vzla_07.preacticarealm.R;
import com.example.rse_vzla_07.preacticarealm.crud.CRUDProfesor;
import com.example.rse_vzla_07.preacticarealm.model.Profesor;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private EditText nombreEt, emailEt;
    private Button saveBtn, readAllBtn, readByNameBtn, readByIdBtn, updateByIdBtn, deleteByIdBtn, deleteAllBtn, cursos;
    private Profesor profesor;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        configView();
    }

    private void configView() {

        profesor = new Profesor();
        nombreEt = findViewById(R.id.EtNombre);
        emailEt = findViewById(R.id.EtEmail);
        saveBtn = findViewById(R.id.btnSave);
        readAllBtn = findViewById(R.id.btnReadAll);
        readByNameBtn = findViewById(R.id.btnReadbyName);
        readByIdBtn = findViewById(R.id.btnReadbyId);
        updateByIdBtn = findViewById(R.id.btnUpdateById);
        deleteByIdBtn = findViewById(R.id.btnDeleteById);
        deleteAllBtn = findViewById(R.id.btnDeleteAll);
        cursos = findViewById(R.id.cursos);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesor.setName(nombreEt.getText().toString());
                profesor.setEmail(emailEt.getText().toString());
                CRUDProfesor.addProfesor(profesor);
            }
        });

        readAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getAllProfesor();
            }
        });

        readByNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getProfesorByName(nombreEt.getText().toString());
            }
        });

        readByIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getProfesorById(Integer.parseInt(nombreEt.getText().toString()));
            }
        });

        updateByIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.updateProfesorById(1);
            }
        });

        deleteByIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.delateProfesorById(1);
            }
        });

        deleteAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.delateAllProfesor();
            }
        });

        cursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CursoActivity.class));
            }
        });
    }
}
