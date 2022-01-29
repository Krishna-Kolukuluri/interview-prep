package designpatterns.solid.dependendencyinversion;

import designpatterns.solid.*;

/*
* Components should depend on abstractions, not on concretions
* */
public class DependencyInversion {
}

//Dependency Inversion principal in play, as user of this PasswordService will be able to send whichever instance of
// PasswordHasher to hash their password.
/*
Our service does not care about the algorithm, it's up to the client to choose it. We don’t depend on the concrete
implementation, but the abstraction.
* */
class PasswordService{
    PasswordHasher passwordHasher;
    public PasswordService(PasswordHasher passwordHasher){
        this.passwordHasher = passwordHasher;
    }
    void hashPassword(String password){
        passwordHasher.hashPassword(password);
    }
}
/*
* Violates dependency inversion principal by tightly coupling PasswordServiceViolatingDI with Base64 hasher.
* */
class PasswordServiceViolatingDI{
    Base64 base64;//Concrete object initiations. blocking users of this service to provide option to send their desired password hasher.
    void hashPassword(String password){
        base64.hashPassword(password);
    }
}
interface PasswordHasher{
    void hashPassword(String password);
}
class Base64 implements PasswordHasher{
    @Override
    public void hashPassword(String password) {
    }
}
class MD5 implements PasswordHasher{
    @Override
    public void hashPassword(String password) {
    }
}