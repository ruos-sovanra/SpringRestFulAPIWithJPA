package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.OwnerRequest;
import com.example.springdatajpa.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/owners")
public class ownerController {
    private final OwnerService ownerService;

    public HashMap<String, Object> responseMessage(Object data, String message, int status){
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload", data);
        response.put("message", message);
        response.put("status",status);
        return response;
    }

@GetMapping
    public HashMap<String, Object> getAllOwner(){
        return responseMessage(ownerService.getAllOwner(),"Owner fetch Successful!!", HttpStatus.OK.value());
    }
    @PostMapping
    public HashMap<String, Object> createOwner(@RequestBody OwnerRequest request){
        return responseMessage(ownerService.createOwner(request),"Owner Successful Created!!",HttpStatus.CREATED.value());
    }

    @PutMapping("/{id}")
    public HashMap<String,Object> updateOwner(@PathVariable Long id ,@RequestBody OwnerRequest request){
        return responseMessage(ownerService.updateOwner(request,id),"Update Successful", HttpStatus.OK.value());
    }
    @DeleteMapping("/{id}")
    public HashMap<String, Object> deleteOwner(@PathVariable Long id){
        return responseMessage(null, "Owner Deleted Successful!!", HttpStatus.OK.value());
    }

}
