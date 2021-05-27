package javaMVCModels;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotepadModel {
	
	
	 private String lastPath; 
	 
	 
	 	public NotepadModel(){
	        lastPath="";
	    }
	    public String getData(String path) throws FileNotFoundException, IOException {
	        String aux, texto="";
	        try{
	            FileReader fr= new FileReader(path);
	            BufferedReader br= new BufferedReader(fr);
	            while((aux=br.readLine())!=null){
	                texto+=aux+'\n';
	            }
	            this.lastPath = path;
	            return texto;
	        } catch(Exception er)
	        {
	            texto=er.getMessage();
	        }
	        return texto;
	    }
	    
	    public boolean writeDataInSpecificDirectory(String data, String path) throws IOException, FileNotFoundException {
	        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
	            writer.write(data);
	            this.lastPath=path;
	            return true;
	        } catch(Exception er)
	        {
	            return false;
	        }
	    }
	    
	    public boolean writeDataInLastDirectory(String data) throws IOException, FileNotFoundException {
	        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.lastPath))){
	            writer.write(data);
	            return true;
	        } catch(Exception er)
	        {
	            return false;
	        }
	    }
	    
	    public boolean isSaved(String text) throws IOException,FileNotFoundException
	    {
	        String textInFile="", aux;
	        try (BufferedReader br= new BufferedReader(new FileReader(this.lastPath))){
	            textInFile+=br.readLine();
	            while((aux=br.readLine())!=null) {
	                textInFile=aux;
	            }
	            return textInFile.equals(text);
	        } 
	        catch(Exception err){
	            return false;
	        }
	    }
	    
	    public void clearLastPath() {
	    	lastPath = "";
	    }
}
