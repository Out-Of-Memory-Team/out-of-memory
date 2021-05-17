package dev.butane.oom.oombackend.models;

public class AdminUserFactory implements UserFactory {
    @Override
    public AdminUser createUser() {
        return new AdminUser();
    }

}
