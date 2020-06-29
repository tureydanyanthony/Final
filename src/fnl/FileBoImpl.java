package fnl;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class FileBoImpl implements FileBo {
	 String path="C:\\Directory1\\";

	@Override
	public String[] viewFiles() {
		File folder=new File(path);
		String[] filelist;
		filelist=folder.list();
		
		return filelist;
	}

	@Override
	public void addFiles(String filename) throws 	BusinessException{
		try {
	    	 File myObj = new File(path+filename);
	    	 
	    	 if (myObj.createNewFile()) {
	    	        
	    	        
	    	      } else {
	    	        throw new BusinessException(" File Already exists");
	    	      }
	     }catch(IOException e) {
	         throw new BusinessException("Unable to Create File ");
	     }
		
	}

	@Override
	public void deleteFiles(String filename) throws BusinessException {
		
		try { 
			  
            // Get the file 
            File f = new File(path+filename); 
            boolean s=f.delete();
            // delete file 
            if (!s) {
            	throw new BusinessException(" File not Deleted");
            }  
        } 
        catch (Exception e) { 
            throw new BusinessException("Error while deleting ");
	}
		}

	@Override
	public  boolean searchFiles(String filename) {
		String[] filelist=this.viewFiles();
		int flag=0;
		 for(String j:filelist) {
			 
				if(j.equals(filename)){
					flag=1;
					break;
				}
			}
		 if(flag==1) {
			 return true;
		 }
		 
		return false;
	}

}
