package ru.sapteh.model;

import java.util.Objects;

public class Model {
    private int id;
    private String mark;
    private String bodyType;
    private String gasoline;

    public Model() {

    }
    public Model(int id, String mark, String bodyType, String gasoline) {
        this.mark = mark;
        this.bodyType = bodyType;
        this.gasoline = gasoline;
    }
    public Model(String mark, String bodyType, String gasoline) {
        this(0, mark, bodyType, gasoline);
    }
    public int getId() {
        return id;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getBodyType() {
        return bodyType;
    }
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    public String getGasoline() {
        return gasoline;
    }
    public void setGasoline(String gasoline) {
        this.gasoline = gasoline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id == model.id && Objects.equals(mark, model.mark) && Objects.equals(bodyType, model.bodyType) && Objects.equals(gasoline, model.gasoline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, bodyType, gasoline);
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", gasoline='" + gasoline + '\'' +
                '}';
    }
}
