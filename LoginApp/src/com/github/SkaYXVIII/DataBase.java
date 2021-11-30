package com.github.SkaYXVIII;

import java.util.Arrays;
import java.util.HashMap;

public class DataBase {
    private final HashMap<String , String> users = new HashMap<>();
    private boolean result;

    public DataBase(boolean isHardCoded){
        if (isHardCoded) fillDataBase();
    }

    public HashMap<String, String> getUsers() {
        return users;
    }

    public boolean checkUser(String username, char[] password){
        if (username == null || password == null) return false;

        result = false;
        users.forEach((key,value) -> {
            if (key.equals(username)){
                if (Arrays.equals(value.toCharArray(), password)){
                    result = true;
                }
            }
        });
        return result;
    }

    private void fillDataBase(){
        users.put("Bartek", "123456");
        users.put("Maciek", "qwerty");
        users.put("Admin", "Admin");
        users.put("Student", "Student");
    }
}
