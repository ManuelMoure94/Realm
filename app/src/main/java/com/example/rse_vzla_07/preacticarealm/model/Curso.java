package com.example.rse_vzla_07.preacticarealm.model;

import io.realm.RealmObject;

/**
 * Created by RSE_VZLA_07 on 25/4/2018.
 */

public class Curso extends RealmObject {

    private String name;
    private String duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
