package net.eviera.pruebas.rest;

public class UserResponse {

    private Boolean error;
    private Integer value;

    public UserResponse() {
    }

    public UserResponse(Boolean error, Integer value) {
        this.error = error;
        this.value = value;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
