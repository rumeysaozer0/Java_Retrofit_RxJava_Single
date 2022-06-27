package com.rumeysaozer.javaretrofitrxjavasingle.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BloodItem implements Serializable {
    public String group;
    @SerializedName("rh_factor")
    public String rhFactor;
    public String type;
    public String uid;
    public Integer id;
}
