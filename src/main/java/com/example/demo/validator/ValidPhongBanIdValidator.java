package com.example.demo.validator;

import com.example.demo.entity.PhongBan;
import com.example.demo.validator.annotation.ValidPhongBanId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhongBanIdValidator implements ConstraintValidator<ValidPhongBanId, PhongBan> {
    @Override
    public boolean isValid(PhongBan phongBan, ConstraintValidatorContext context){
        return phongBan !=null && phongBan.getMa_Phong()!=null;
    }
}
