package io.kualityforyou.ppmtool.services;

import io.kualityforyou.ppmtool.constants.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValidationErrorService {

    public ResponseEntity<?> mapValidationService(BindingResult result) {
        if (result.hasErrors()) {

            List<ErrorMessage> errorList = new ArrayList<>();
            for (FieldError error: result.getFieldErrors()) {
                ErrorMessage errorMessage = new ErrorMessage(error.getField(), error.getDefaultMessage());
                errorList.add(errorMessage);
            }
            return new ResponseEntity<List<ErrorMessage>>(errorList, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
