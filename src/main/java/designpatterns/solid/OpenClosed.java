package designpatterns.solid;

import static javax.xml.crypto.dsig.Transform.BASE64;


/*
* Classes should be open for extension, closed for modification.
* */
public class OpenClosed {
}

//This class vilates Open-Closed Solid principal.
/*
* If we implemented this way, we would break the O in SOLID so bad. Every time a new algorithm is implemented,
* we need to modify the existing class, and it looks ugly
* */
class PasswordHasherHelper{
    private String hashedPassword;
    public String hashPassword(String password, String hashingType){
        if(BASE64.equals(hashingType))
        {
            hashedPassword="hashed with Base64";
        }
        else if("MD5".equals(hashingType))
        {
            hashedPassword="hashed with MD5";
        }
        return hashedPassword;
    }
}
//Above class need to be refactored as below to support Open-Closed Solid Principal;
//In this way, we can add new algorithms without touching the existing codebase
interface PasswordHasherService{
    String hashPassword(String password);
}
class Base64Hasher implements PasswordHasherService{
    @Override
    public String hashPassword(String password) {
        return "hashed with 64";
    }
}
class MD5Hasher implements PasswordHasherService{
    @Override
    public String hashPassword(String password) {
        return "hashed with SHA256";
    }
}
