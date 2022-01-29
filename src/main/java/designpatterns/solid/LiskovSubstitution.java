package designpatterns.solid;
/*
* A sub-class should be able to fulfill each feature of its parent class and could be treated as its parent class.
* */
public class LiskovSubstitution {
    public static void main(String[] args) {
        MD5 md5 = new MD5();
        md5.generateHash("Password");
        System.out.println(md5.hash);
        Base64 base64 = new Base64();
        base64.generateHash("Password");
        System.out.println(base64.hash);
    }
}
abstract class Hashed{
    PasswordHasherService passwordHasher;
    String hash;

    public void generateHash(String password)
    {
        hash = passwordHasher.hashPassword(password);
    }
}

class Base64 extends Hashed{
    public Base64(){
        this.passwordHasher = new Base64Hasher();
    }
}
class MD5 extends Hashed{
    public MD5(){
        this.passwordHasher = new MD5Hasher();
    }
}
