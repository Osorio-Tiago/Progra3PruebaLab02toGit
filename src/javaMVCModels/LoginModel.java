package javaMVCModels;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginModel {
    public boolean Confirmation(String tUser,String tPassword) throws FileNotFoundException, IOException {
        try {
            String aux, user="", password="", rutaArchivo= new File ("User and password/Login.txt").getAbsolutePath();
            FileReader fr= new FileReader(rutaArchivo);
            BufferedReader br= new BufferedReader(fr);
            while((aux=br.readLine())!=null){
                user=aux;
                password=br.readLine();
            }
            if(user.equals(tUser) && password.equals(tPassword)){
                return true;
            }
            else{
                return false;
            }
        } catch(Exception er){
            return false;
        }
    }
}