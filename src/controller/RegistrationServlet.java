package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.RegistrationBean;


import converter.RegistrationConverter;
import db.DAO;
import db.DBQuires;

import service.RegistrationService;
import util.GeneratePassword;


/**
 * Servlet implementation class Registration
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationServlet() {
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
		String action=request.getParameter("page");
		System.out.println(action);
		String nextPath="";
		if("Registration".equalsIgnoreCase(action)){
		
		RegistrationService service=new RegistrationService();
		boolean isSuccess=service.insertValues(request);
		if(isSuccess==false)
			request.setAttribute("message", "Error while inserting values<br> This might happen because of the below errors <br>1.Duplicate Email-Id <br>2.Unable to connect Database<br>3.Unable to connect Internet");
			else
			{
				
				String UPLOAD_DIRECTORY = "G:\\Huffman\\"+request.getParameter("emailid");
				
				File file = new File(UPLOAD_DIRECTORY);
				if (!file.exists()) {
					if (file.mkdir()) {
						System.out.println("Directory is created!");
					} else {
						System.out.println("Failed to create directory!");
					}
				}
					
				
				
				
			request.setAttribute("message", "Account created successfully<br> Please visit your "+request.getParameter("emailid")+" for the credential");
			}
		nextPath="/JSP/Registration.jsp";
		}
		else if("login".equals(action))
		{
			RegistrationService ls =new RegistrationService();
			String username=ls.checkCredintials(request);
			
			if(username==null)
			{
				request.setAttribute("username","invalid");
				nextPath="/JSP/Login.jsp";
			}
			else
			{
				session.setAttribute("emailid", request.getParameter("uname"));
				request.setAttribute("username", username);
				nextPath="/JSP/Portal.jsp";
			}
		}
		else if ("forgetpassword".equalsIgnoreCase(action)) {
			RegistrationService ls=new RegistrationService();
			boolean isSuccess=ls.forgetPassword(request);
			if(isSuccess==false)
				request.setAttribute("msg", "false");
			else
				request.setAttribute("msg", "true");
			nextPath="/JSP/Forgetpassword.jsp";
		}
		else if("changepwd".equals(action)){
			
			RegistrationService ls = new RegistrationService();
			int noofrowsaffected=ls.changepwd(request,(String)session.getAttribute("emailid"));
			System.out.println(session.getAttribute("emailid"));
			if(noofrowsaffected>0){
				request.setAttribute("message", "Password Change Successfully");
			}
			else{
				request.setAttribute("message", "Current Password does not match");
			}

			nextPath="/JSP/Changepassword.jsp";
			}
		
	else if("history".equals(action)){
		
ArrayList<RegistrationBean> a = new ArrayList<RegistrationBean>();
		// TODO Auto-generated method stub
		String email  = 		(String)	session.getAttribute("emailid");
		DAO data = new DAO();
		System.out.println(email + "-----------");
		Connection conn = data.getConnection();
		String validateUser = "select * from  receive where emailid=? ";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, email);

			// execute insert SQL statement
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				RegistrationBean b = new RegistrationBean();
				b.setFname(result.getString(2));
				b.setMno(result.getString(3));
				b.setMailid(result.getString(4));
				System.out.println("-------------");
				a.add(b);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		request.setAttribute("file", a);
		
		nextPath = "/JSP/Receive.jsp";
		
	}
		
		
		else if("send".equals(action)){
			DBQuires db = new DBQuires();
			ArrayList<String> userList = db.getUserList();
			request.setAttribute("userList", userList);
			nextPath = "/JSP/SendFile.jsp";
			
			
		}
		else if("receive".equals(action)){
String emailid = 		(String)	session.getAttribute("emailid");
String UPLOAD_DIRECTORY = "G://Huffman//"+session.getAttribute("emailid");
File file = new File(UPLOAD_DIRECTORY);
if (!file.exists()) {
	if (file.mkdir()) {
		System.out.println("Directory is created!");
	} else {
		System.out.println("Failed to create directory!");
	}
}

			File folder = new File("G://Huffman//"+session.getAttribute("emailid"));
			File[] listOfFiles = folder.listFiles();
			ArrayList<String> filelist=new ArrayList<String>();
			DBQuires db = new DBQuires();
			    for (int i = 0; i < listOfFiles.length; i++) {
			      if (listOfFiles[i].isFile()) {
			    	  System.out.println(listOfFiles[i].getName());
			    	  filelist.add(listOfFiles[i].getName());
			    	  filelist.add(""+(listOfFiles[i].length()/1024));
			        
			      } 
			    }
			    
request.setAttribute("filelist", filelist);

			nextPath="/JSP/Download.jsp";	}
		
		
		else{
			System.out.println("IIIIIIIIIIIIIIIII");
		DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			
			 String name=null;
			if(ServletFileUpload.isMultipartContent(request)){
	            try {
	            	String UPLOAD_DIRECTORY = "";
	            	String username = "";
	            	String mailid = "";
	            	List<FileItem> multiparts = sfu.parseRequest(request);
	              
	                for(FileItem item : multiparts){
	                    if(!item.isFormField()){
	                         name = new File(item.getName()).getName();
	                      
	                        item.write( new File("G:\\" + File.separator + name));
	                  	  
	    	        		try{  
	    	        			
	    	        		FileInputStream fin=new FileInputStream("H:\\" +  name);
	    	        		System.out.println(UPLOAD_DIRECTORY+")))))))))))))))))))");
	    	        		FileOutputStream fout=new FileOutputStream(UPLOAD_DIRECTORY+"//"+mailid+"//" +  name);  
	    	        		DeflaterOutputStream out=new DeflaterOutputStream(fout);  
	    	        		  
	    	        		int i;  
	    	        		while((i=fin.read())!=-1){  
	    	        		out.write((byte)i);  
	    	        		out.flush();  
	    	        		} 
	    	        		
	    	        		fin.close();  
	    	        		out.close();  
	    	        		}catch(Exception e){System.out.println(e);} 
	    	               
                    
	                    }else
	                    {
	                    	System.out.println("******************");
		             			 username = item.getString();
		             			System.out.println(username+"$$$$$$$$$$$$$$$$$$$$$4");
		             			if(username.contains("@"))
		             			{
		             				mailid = username;
		             		 UPLOAD_DIRECTORY=	"G://Huffman//";
		             			System.out.println("Path="+UPLOAD_DIRECTORY);
		             			File file = new File(UPLOAD_DIRECTORY);
		             			if (!file.exists()) {
		             				if (file.mkdir()) {
		             					System.out.println("Directory is created!");
		             				} else {
		             					System.out.println("Failed to create directory!");
		             				}
		             			}
		             			}
	                    
		             		
	                    
	                    
	                    
	                    }
	                    
	                }
	           
	               //File uploaded successfully

	        		// TODO Auto-generated method stub
	                File f = new File(UPLOAD_DIRECTORY+"//"+mailid+"//" +  name);
	        		int rows = 0;
	        		DAO dao = new DAO();
	        		Connection conn = dao.getConnection();
	        		String email = (String) session.getAttribute("emailid");
	        		String insertquery = "insert into receive values(?,?,?,?)";
	        		PreparedStatement pstmt = null;
	        		try {
	        			pstmt = conn.prepareStatement(insertquery);
	        			pstmt.setString(1, email);
	        			pstmt.setString(3, f.length()+"");
	        			pstmt.setString(2, name);
	        			pstmt.setString(4, mailid);
	        			rows = pstmt.executeUpdate();

	        		} catch (SQLException e) {
	        			System.out.println(e);
	        		} finally {
	        			try {
	        				pstmt.close();

	        				conn.close();
	        			} catch (SQLException e) {
	        				// TODO Auto-generated catch block
	        				e.printStackTrace();
	        			}

	        		}

	        	
	        		
	                       request.setAttribute("message", "File Uploaded Successfully");
	            } catch (Exception ex) {
	            	ex.printStackTrace();
	            	System.out.println(ex);
	            	System.out.println("not success");
	               request.setAttribute("message", "File Upload Failed due to " + ex);
	            }          
	         
	        }else{
	         	System.out.println("not success");
	            request.setAttribute("message",
	                                 "Sorry this Servlet only handles file upload request");
	        }
			DBQuires db = new DBQuires();
			ArrayList<String> userList = db.getUserList();
			request.setAttribute("userList", userList);

			nextPath="/JSP/SendFile.jsp";
			}
			RequestDispatcher rd=request.getRequestDispatcher(nextPath);	
			rd.forward(request, response);
		
		
		
	}

}
