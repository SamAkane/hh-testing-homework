
package ru.hh.school.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snippet {

    @SerializedName("requirement")
    @Expose
    private String requirement;
    @SerializedName("responsibility")
    @Expose
    private Object responsibility;

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Object getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Object responsibility) {
        this.responsibility = responsibility;
    }

}
