package dev.butane.oom.oombackend.models;

public class StandardUserFactory implements UserFactory {
    @Override
    public StandardUser createUser() {
        return new StandardUser();
    }
}
