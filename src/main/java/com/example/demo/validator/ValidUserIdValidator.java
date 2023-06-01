package com.example.demo.validator;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.validator.annotation.ValidUserId;
import com.example.demo.validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user ==null)
            return true;
        return user.getId() !=null;
    }
}
