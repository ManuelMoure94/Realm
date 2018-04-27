package com.example.rse_vzla_07.preacticarealm.crud;

import com.example.rse_vzla_07.preacticarealm.model.Curso;
import com.example.rse_vzla_07.preacticarealm.model.Profesor;

import io.realm.Realm;

/**
 * Created by RSE_VZLA_07 on 26/4/2018.
 */

public class CRUDCurso {

    public final static void addCurso(final String profesorId, final Curso curso) {

        int id = Integer.parseInt(profesorId);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesorRealm = realm.where(Profesor.class).equalTo("id", id).findFirst();

        if (profesorRealm != null) {
            profesorRealm.getCursos().add(curso);
            realm.insertOrUpdate(profesorRealm);
            realm.commitTransaction();
        }
    }

    public final static void updateCursoByName(String name) {

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Curso curso = realm.where(Curso.class).equalTo("name", name).findFirst();
        curso.setName("Realm Android");
        realm.insertOrUpdate(curso);
        realm.commitTransaction();
    }

    public final static void deleteCursoByName(String name) {

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Curso curso = realm.where(Curso.class).equalTo("name", name).findFirst();
        curso.deleteFromRealm();
        realm.commitTransaction();
    }
}
