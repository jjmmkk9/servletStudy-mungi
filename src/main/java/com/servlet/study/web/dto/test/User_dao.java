package com.servlet.study.web.dto.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User_dao {
	private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
//드라이버 로딩
    public User_dao(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("<JDBC 오류> Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
  //select 구문
  	public ArrayList<User_dto>USer_Select(){
      	String server = "web-study.ca7yqvnelwuw.ap-northeast-2.rds.amazonaws.com"; // 서버 주소
          String database = "user_info" ;//DataBase이름
          String Suser_name = "admin"; // 서버 아이디
          String Spassword = "1q2w3e4r"; // 서버 비밀번호
          
          ArrayList<User_dto> dtos = new ArrayList<User_dto>();
          //연결
          try{
          	con = DriverManager.getConnection(server + "/" + database + "?useSSL=false", Suser_name, Spassword);
              stmt = con.createStatement();
              rs = stmt.executeQuery("SELECT * FROM USER");
              System.out.println("Connect completed.");
              
              while(rs.next()){
              	int num = rs.getInt("num");
                  String id = rs.getString("id");
                  String password = rs.getString("password");
                  String name = rs.getString("name");
                  String nickname = rs.getString("nickname");
                  String email = rs.getString("email");
                  
                 User_dto dto = new User_dto(num, id, password, name, nickname, email);
                  dtos.add(dto);
                }
          } catch(SQLException e) {
              System.err.println("con 오류:" + e.getMessage());
              e.printStackTrace();
          } finally {
              try{  //종료
                  if(rs != null) rs.close();
                  if(stmt != null) stmt.close();
                  if(con != null) con.close();
              }catch (Exception e){
                  e.printStackTrace();
              }
          }
          return dtos;
      }
}
