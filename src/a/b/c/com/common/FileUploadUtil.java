package a.b.c.com.common;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadUtil {

	public static final String ECODE_TYPE = "EUC-KR";
	public static final int SIZE_LIMIT = 5240880;	
	private MultipartRequest m;
	
	public FileUploadUtil(){}
	
	public boolean fileUpload(HttpServletRequest hReq, String filePaths){
			
		boolean fb = false;
		try{
			m = new MultipartRequest( hReq
                                     ,filePaths
                                     ,FileUploadUtil.SIZE_LIMIT
                                     ,FileUploadUtil.ECODE_TYPE
                                     ,new FileRename());			
			return fb = true;			
		}
		catch(Exception e){
			// 개소리야 baby가 왜 들어감?
			System.out.println("FileUploadUtil.fileUpldad() >>> : " + e);
		}
		
		return fb;		
	}
	
	// fileUpload3(request, filePahts, size_limit2, encode_type)
	public boolean fileUpload3(HttpServletRequest request, String filePaths, int size_limit2, String encode_type) {
		// TODO Auto-generated method stub
		boolean fb = false;
		try
		{
			m = new MultipartRequest( request
                                     ,filePaths
                                     ,size_limit2
                                     ,encode_type                                     
									 ,new DefaultFileRenamePolicy());
			return fb = true;			
		}
		catch(Exception e){
			System.out.println("FileUploadUtil.fileUpload3() >>> : " + e);
		}
		
		return fb;
	} // end of fileUpload3()	
	
	// getParameter(s)
	public String getParameter(String s){
		return m.getParameter(s);
	} // end of getParameter(s)
	
	// getParameterValues(s)
	public String[] getParameterValues(String s){
		return m.getParameterValues(s);		
	} // end of getParameterValues(s)

	// getFileName(f)
	public String getFileName(String f){
		return m.getFilesystemName(f);
	} // end of getFileName(f)
	
	// getFileNames()
	public ArrayList<String> getFileNames(){

		@SuppressWarnings("unchecked")
		Enumeration<String> en = m.getFileNames();
		ArrayList<String> a = new ArrayList<String>();
		
		while (en.hasMoreElements()){
			String f = en.nextElement().toString();
			a.add(m.getFilesystemName(f));
		}		
		
		return a;
	} // end of getFileNames()
	
} // end of FileUploadUtil
