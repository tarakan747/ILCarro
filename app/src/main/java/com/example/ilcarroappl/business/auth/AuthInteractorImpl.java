package com.example.ilcarroappl.business.auth;

import com.example.ilcarroappl.data.auth.AuthRepo;

import io.reactivex.Completable;

public class AuthInteractorImpl implements AuthInteractor {
    AuthRepo repository;

    public AuthInteractorImpl(AuthRepo repository) {
        this.repository = repository;
    }

    @Override
    public Completable onLogin(String email, String password) {
        return null;
    }

    @Override
    public Completable onRegistration(String name, String lastName, String email, String password) {
        try {
            isNameValid(name, lastName);
            isEmailValid(email);
            isPasswordValid(password);
            return repository.onRegistration(name, lastName, email, password);
        } catch (Throwable throwable) {
            return Completable.error(throwable);
        }
    }

    private void isPasswordValid(String password) {
        if (password.length()<8){
            throw new PasswordValidException("Password length minimum 8");
        }
    }

    private void isEmailValid(String email) {
        if (!email.contains("@")) {
            throw new EmailValidException("Email must contains @");
        }
        if (email.length() - email.lastIndexOf(".") < 2) {
            throw new EmailValidException("Email must contains 2 symbols after last dot");
        }
    }

    private void isNameValid(String name, String lastName) {
        if(name==null){
            throw new NameException("Did not enter a name!");
        }
        if (lastName == null){
            throw new NameException("did not enter a last name!");
        }
    }
}
