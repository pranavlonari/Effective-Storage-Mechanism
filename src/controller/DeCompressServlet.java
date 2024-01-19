package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.zip.InflaterInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class DeCompressServlet
 */
public class DeCompressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeCompressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String UPLOAD_DIRECTORY = "G:\\Huffman";
		
		File file = new File(UPLOAD_DIRECTORY);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		 String name=null;
		System.out.println(UPLOAD_DIRECTORY);
		if(ServletFileUpload.isMultipartContent(request)){
                try {
                    List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                  
                    for(FileItem item : multiparts){
                        if(!item.isFormField()){
                             name = new File(item.getName()).getName();
                            item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        }
                    }
           
               //File uploaded successfully
                
                // create Encrypt folder
                 file = new File(UPLOAD_DIRECTORY+"//Encrypt");
        		if (!file.exists()) {
        			if (file.mkdir()) {
        				System.out.println("Directory is created!");
        			} else {
        				System.out.println("Failed to create directory!");
        			}
        		}
        		 file = new File(UPLOAD_DIRECTORY+"//Decrypt");
         		if (!file.exists()) {
         			if (file.mkdir()) {
         				System.out.println("Directory is created!");
         			} else {
         				System.out.println("Failed to create directory!");
         			}
         		}
                //DeCompress the File
        		System.out.println(UPLOAD_DIRECTORY +"//"+  name);
        		session.setAttribute("name", name);
        		try{  
        			FileInputStream fin=new FileInputStream(UPLOAD_DIRECTORY+"//" +  name);  
        			InflaterInputStream in=new InflaterInputStream(fin);  
        			FileOutputStream fout=new FileOutputStream(UPLOAD_DIRECTORY+"//Encrypt//" +  name);  
        			  
        			int i;  
        			while((i=in.read())!=-1){  
        			fout.write((byte)i);  
        			fout.flush();  
        			}  
        			fin.close();  
        			fout.close();  
        			in.close();  
        			}catch(Exception e){System.out.println(e);}  
        		
        		
        		
        		/*AdaptiveHuffmanDecompress co = new AdaptiveHuffmanDecompress();
        		co.decompress(UPLOAD_DIRECTORY+"//" +  name,UPLOAD_DIRECTORY+"//Encrypt//" +  name);*/
                System.out.println("success");

         
            }
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
		}
		else{
			name = (String)session.getAttribute("name");
			response.setContentType("text/html");  
    		PrintWriter out = response.getWriter();  
    		response.setContentType("APPLICATION/OCTET-STREAM");  
    		response.setHeader("Content-Disposition","attachment; filename=\"" + name + "\"");   
    		  
    		FileInputStream fileInputStream = new FileInputStream(UPLOAD_DIRECTORY+"//Encrypt//" +  name);  
    		            
    		int i;   
    		while ((i=fileInputStream.read()) != -1) {  
    		out.write(i);   
    		}   
    		fileInputStream.close();   
    		out.close();   

		}
		
		// TODO Auto-generated method stub
	}

}
