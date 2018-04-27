package com.example.rse_vzla_07.preacticarealm.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rse_vzla_07.preacticarealm.R;
import com.example.rse_vzla_07.preacticarealm.crud.CRUDCurso;
import com.example.rse_vzla_07.preacticarealm.model.Curso;

/**
 * Created by RSE_VZLA_07 on 26/4/2018.
 */

public class CursoActivity extends AppCompatActivity {

    private EditText idProfesor, nameEt, durationEt;
    private Button saveBt, deleteBt, updateBt;
    private Curso curso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        configView();
    }

    private void configView() {

        curso = new Curso();
        idProfesor = findViewById(R.id.etid);
        nameEt = findViewById(R.id.etnombrecurso);
        saveBt = findViewById(R.id.saveCurso);
        durationEt = findViewById(R.id.etduration);
        deleteBt = findViewById(R.id.deleteCurso);
        updateBt = findViewById(R.id.updateCurso);

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curso.setName(nameEt.getText().toString());
                curso.setDuration(durationEt.getText().toString());
                CRUDCurso.addCurso(idProfesor.getText().toString(), curso);
            }
        });

        updateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDCurso.updateCursoByName(nameEt.getText().toString());
            }
        });

        deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDCurso.deleteCursoByName(nameEt.getText().toString() );
            }
        });
    }
}
