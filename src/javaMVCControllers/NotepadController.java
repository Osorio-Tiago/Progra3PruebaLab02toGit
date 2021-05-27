package javaMVCControllers;
import java.io.FileNotFoundException;
import java.io.IOException;

import javaMVCModels.NotepadModel;
import javaMVCViews.NotepadView;

public class NotepadController {
    private NotepadModel noteModel;
    
    public NotepadController(){
        this.noteModel= new NotepadModel();
    }
	 public void startApplication(){
	        NotepadView notePad= new NotepadView();
	        noteModel= new NotepadModel();
	        notePad.setVisible(true);   
	    }
	 
	    public String getMessage(String path){
	        try{
	            return noteModel.getData(path);
	        } catch(Exception er){
	            return "There was an error";
	        }
	    }
	    
	    public boolean savedFile(String text) throws IOException {
	        try{
	        	return noteModel.isSaved(text);
	        } catch(Exception er)
	        {
	            return false;
	        }
	    }
	    public boolean writeMessageInDirectory(String message, String path) throws FileNotFoundException, IOException{
	        try{
	           return noteModel.writeDataInSpecificDirectory(message, path);
	        }catch(Exception er){
	            return false;
	        }
	    }
	    
	    public boolean writeMessageDefault(String message) throws FileNotFoundException, IOException {
	        try {
	            return noteModel.writeDataInLastDirectory(message);
	        }
	        catch(Exception er){
	            return false;
	        }
	    }
	 
	    public void clearPath() {
	    		noteModel.clearLastPath();
	    }
}
