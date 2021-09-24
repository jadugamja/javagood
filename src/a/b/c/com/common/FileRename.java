package a.b.c.com.common;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileRename implements FileRenamePolicy {

	public FileRename(){
		
	}
	
	@Override
	public File rename(File sf) {
		// TODO Auto-generated method stub
		String f = sf.getName();
		System.out.println("filename >>> : " + f);
		
		try {
			String t = f;
			for (int i=0; sf.exists(); i++){
				int lt = t.lastIndexOf(".");
				String t1 = t.substring(0, lt);
				String t2 = t.substring(lt);
				String ft = "[" + i + "]";
				f = t1 + ft + t2;
				sf = new File(sf.getParent(), f);
			}
			
		}
		catch(Exception e){
			System.out.println("FileRename.rename() ===> : " + e);
		}
		
		return sf;
	}
}

