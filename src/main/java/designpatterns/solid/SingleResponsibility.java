package designpatterns.solid;
/*
*
*  Each class should have only one sole purpose, and not be filled with excessive functionality.
* */
public class SingleResponsibility {

}
//As per name of the class, this is used for hashing passwords, saving password logic should not be in this class.
//Refactor and move savePassword logic to new class i.e.PersistPassword.
class PasswordHasher{
    public String hashAndSavePassword(String password){
        hashPassword(password);
        savePassword(password);
        return "";
    }
    public void hashPassword(String password){
        //Logic to hash password
    }

    public void savePassword(String password){
        //Logic to save hashed password.
    }
}

