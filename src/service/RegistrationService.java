package service;



import javax.servlet.http.HttpServletRequest;

import util.EMail;
import bean.RegistrationBean;
import converter.RegistrationConverter;
import db.DBQuires;

public class RegistrationService {

	public boolean insertValues(HttpServletRequest request) {
		// TODO Auto-generated method stub
		RegistrationConverter convert =new RegistrationConverter();
		RegistrationBean bean=convert.getValues(request);
		DBQuires db =new DBQuires();
		boolean isSuccess = db.insertRegistrationForm(bean);
		if(isSuccess==true){
			EMail mail =new EMail();
			isSuccess=mail.sendMail(bean);
		}
		return isSuccess;
		
		
	}
	public String checkCredintials(HttpServletRequest request) {
		// TODO Auto-generated method stub
		RegistrationConverter lc=new RegistrationConverter();
		RegistrationBean bean=lc.getLoginData(request);
		DBQuires db=new DBQuires();
		String userName=db.checkLogin(bean);
		return userName;
		
	}

	public boolean forgetPassword(HttpServletRequest request) {
		// TODO Auto-generated method stub
		RegistrationConverter lc=new RegistrationConverter();
		RegistrationBean bean=lc.getForgetPassword(request);
		DBQuires db=new DBQuires();
		bean=db.getForgetPassword(bean);
		if(bean==null)
			return false;
		else{
			EMail mail= new EMail();
		mail.sendMail(bean);
		}
		return true;
	}

	public int changepwd(HttpServletRequest request,String emailid) {
		// TODO Auto-generated method stub
		RegistrationConverter lc=new RegistrationConverter();
		RegistrationBean rb=lc.getChangepwd(request);
		DBQuires db=new DBQuires();
		return db.changePwd(rb,emailid);
		
	}

}
