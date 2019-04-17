package com.rjm.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.rjm.util.DBConnector;

public class PointDAO {
	
	//접근지정자 [그외지정자] 리턴타입 메서드명([매개변수선언])
	
	//selectList : 전체 데이터를 리턴
	public ArrayList<PointDTO> selectList()throws Exception{
		Connection con = DBConnector.getConnect();
		String sql="select * from point order by num desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		PointDTO pointDTO=null;
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		while(rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setSid(rs.getString("sid"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			pointDTO.setBnum(rs.getInt("bnum"));
			ar.add(pointDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
	}
	
	
	
	//selectOne : 번호를 받아서 해당하는 데이터를 리턴
	public PointDTO selectOne(int num)throws Exception{
		Connection con = DBConnector.getConnect();
		String sql="select * from point where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		PointDTO pointDTO=null;
		if(rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setSid(rs.getString("sid"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			pointDTO.setBnum(rs.getInt("bnum"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return pointDTO;
		
	}
	
	
	
	//delete
	public int delete(int num) throws Exception{
		int result=0;
		Connection con = DBConnector.getConnect();
		String sql="delete point where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	
	//insert
	public int insert(PointDTO pointDTO) throws Exception {
		int result=0;
		//1. 4가지 정보
		//2. 드라이버로딩
		//3. 연결
		Connection con = DBConnector.getConnect();
		//4. sql문작성
		String sql="insert into point values(?,?,?,?,?,?,?,?)";
		//5. 미리보내기
		PreparedStatement st = con.prepareStatement(sql);
		//6. ? 세팅
		st.setInt(1, pointDTO.getNum());
		st.setString(2, pointDTO.getSid());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		st.setInt(8, pointDTO.getBnum());
		//7. 최종전송후 결과 처리
		result = st.executeUpdate();
		//8. 연결 끊기
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	
	//update
	
	//delete
	
	//select

}