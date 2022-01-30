package com.seaz.proyectospringboot.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
