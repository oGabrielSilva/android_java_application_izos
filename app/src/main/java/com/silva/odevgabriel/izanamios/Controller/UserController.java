package com.silva.odevgabriel.izanamios.Controller;

import com.silva.odevgabriel.izanamios.Model.User;

public class UserController {

    private UserController() {}

    public static User get() {
        return new User();
    }
}
