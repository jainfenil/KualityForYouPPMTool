package io.kualityforyou.ppmtool.constants;

import lombok.Data;

@Data
public class ErrorMessage {

    private String errorField;
    private String errorDescription;

    public ErrorMessage(String errorField, String errorDescription) {
        this.errorField = errorField;
        this.errorDescription = errorDescription;
    }

}
