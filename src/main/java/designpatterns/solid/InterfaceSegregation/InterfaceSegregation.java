package designpatterns.solid.InterfaceSegregation;
/*
* Interfaces should not force classes to implement what they can’t do. Large interfaces should be divided into small ones.
* */
public class InterfaceSegregation implements Decryptable , PasswordHasher{
    @Override
    public String decodePasswordFromHash(String hash) {
        return "decoded from base64";
    }

    @Override
    public String hashPassword(String password) {
       return "hashed with base64";
    }
}
/*
* This would break this law since one of our algorithms, the SHA256 is not decryptable practically, (it’s a one-way function).
* Instead, we can add another interface to the applicable classes to implement their decoding algorithm
* */
interface PasswordHasherBadDesign{
    String hashPassword(String password);
    String decodePasswordFromHash(String hash);
}
//Break the above interface into two interfaces.
interface Decryptable
{
    String decodePasswordFromHash(String hash);
}
interface PasswordHasher{
    String hashPassword(String password);
}
