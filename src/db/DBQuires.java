package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.connector.Request;

import util.GeneratePassword;
import bean.RegistrationBean;


public class DBQuires {

	public boolean insertRegistrationForm(RegistrationBean rb) {
		// TODO Auto-generated method stub
		int rows = 0;
		DAO dao = new DAO();

		Connection conn = dao.getConnection();
		
		String insertquery = "insert into registration values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		System.out.println(rb.getFname());
		System.out.println(rb.getMailid()+rb.getLname()+rb.getGender()+rb.getMailid()+rb.getMno());
		rb.setPassword(GeneratePassword.randomPasswordIs());
		try {
			pstmt = conn.prepareStatement(insertquery);
			pstmt.setString(1, rb.getFname());
			pstmt.setString(2, rb.getLname());
			pstmt.setString(3, rb.getMailid());
			pstmt.setString(4, rb.getGender());
			pstmt.setString(5, rb.getMno());
			pstmt.setString(6, rb.getPassword());

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
		if (rows == 0)
			return false;

		return true;

	}

	public String checkLogin(RegistrationBean bean) {
		// TODO Auto-generated method stub
		DAO data = new DAO();
		Connection conn = data.getConnection();
		System.out.println("Trying to Login");
		System.out.println("UNMAE"+bean.getMailid()+bean.getPassword());
		String validateUser = "select fname from  registration where emailid=? and password = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, bean.getMailid());
			preparedStatement.setString(2, bean.getPassword());

			// execute insert SQL statement
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				System.out.println("Login Successfull");
				return result.getString(1);
			}
			

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

		return null;
	}

	public RegistrationBean getForgetPassword(RegistrationBean bean) {
		// TODO Auto-generated method stub
		DAO data = new DAO();
		Connection conn = data.getConnection();
		String validateUser = "select password from  registration where emailid=? ";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, bean.getMailid());

			// execute insert SQL statement
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				bean.setPassword(result.getString(1));
				return bean;
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

		return null;
	}

	public int changePwd(RegistrationBean rb, String emailid) {

		DAO data = new DAO();
		Connection conn = data.getConnection();
		String validateUser = "select password from  registration where emailid=? ";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, emailid);

			System.out.println("Email id" + emailid + rb.getPassword());
			// execute insert SQL statement
			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				System.out.println(result.getString(1));
				if (result.getString(1).equals(rb.getPassword())) {
					validateUser = "update registration set password=? where emailid=?";
					preparedStatement = conn.prepareStatement(validateUser);
					preparedStatement.setString(1, rb.getChangepwd());
					preparedStatement.setString(2, emailid);
					return preparedStatement.executeUpdate();
				} else {
					return 0;
				}
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return 0;

		// TODO Auto-generated method stub

	}

	public ArrayList<String> getUserList() {
		// TODO Auto-generated method stub
		ArrayList<String> userList = new ArrayList<String>();
		DAO data = new DAO();
		Connection conn = data.getConnection();
		String validateUser = "select emailid from  registration";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);

			// execute insert SQL statement
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				userList.add(result.getString(1));
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

		return userList;
	}

}
