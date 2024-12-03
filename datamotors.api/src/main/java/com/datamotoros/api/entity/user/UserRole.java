package com.datamotoros.api.entity.user;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    UserRole(String role){
        this.role = role;
    }
    public String GetRole(){
        return role;
    }

}
