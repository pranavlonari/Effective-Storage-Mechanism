package controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class FileDownloader extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println(":In get");
		String filename = (String) request.getParameter("filename");
		System.out.println("in" + filename);
		/*String DOWNLOAD_DIRECTORY = "G://huffman//"
				+ session.getAttribute("emailid") + "//";*/
		String DOWNLOAD_DIRECTORY = "G://"
				;
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ filename + "\"");

		FileInputStream fileInputStream = new FileInputStream(
				DOWNLOAD_DIRECTORY + filename);

		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}

}
