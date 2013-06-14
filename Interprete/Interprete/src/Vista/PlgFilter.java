package Vista;
import java.io.File;
import javax.swing.filechooser.*;



public class PlgFilter extends FileFilter {
	

    public boolean accept(File f) {
    	boolean result = false;
        if (f.isDirectory()) 
            result = true;
        else{
    	  String extension = Utils.getExtension(f);
          if (extension != null && extension.equals(Utils.plg)) 
             result = true;              
        }
          return result;
    }
    
    //The description of this filter
    public String getDescription() {
        return "Just PLG Files";
    }
}
