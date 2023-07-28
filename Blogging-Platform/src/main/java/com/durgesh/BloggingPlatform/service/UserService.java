package com.durgesh.BloggingPlatform.service;

import com.durgesh.BloggingPlatform.dto.UserResponse;
import com.durgesh.BloggingPlatform.model.User;
import com.durgesh.BloggingPlatform.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepo iUserRepo;
    @Autowired
    private UserResponse userResponse;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetails userDetails;





    //SignUp user

    public String signUp(User user){
        if(iUserRepo.findFirstByEmail(user.getEmail())!=null) return "email already exist ..try using diffrent email id";
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        iUserRepo.save(user);
        return "Sign up successfull";
    }

    public UserResponse getUserById(int id){

        User user=iUserRepo.findById(id).orElseThrow(() -> new RuntimeException("NO such user found"));

        return new UserResponse(user.getUserId(),user.getEmail(),user.getUserHandle(),user.getUserBio());

    }
    public boolean validate(int id){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        userDetails= (UserDetails) authentication.getPrincipal();
        String name=userDetails.getUsername();
        User user =iUserRepo.findById(id).get();
        if(user.getEmail().equals(name)){
            return true;
        }
        else return false;


    }
}
