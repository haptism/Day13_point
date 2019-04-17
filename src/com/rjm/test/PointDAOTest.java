package com.rjm.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.rjm.point.PointDAO;
import com.rjm.point.PointDTO;

public class PointDAOTest {

	@Test
	public void selectListTest() throws Exception {
		PointDAO pointDAO = new PointDAO();
		ArrayList<PointDTO> ar = pointDAO.selectList();
		assertNotEquals(0, ar.size());
	}

	// @Test
	public void selectOneTest() throws Exception {
		PointDAO pointDAO = new PointDAO();
		PointDTO pointDTO = pointDAO.selectOne(122);
		assertNotNull(pointDTO);

	}

	// @Test
	public void deleteTest() throws Exception {
		PointDAO pointDAO = new PointDAO();
		int result = pointDAO.delete(1);
		assertEquals(1, result);

	}

	// @Test
	public void test() throws Exception {
		PointDAO pointDAO = new PointDAO();
		PointDTO pointDTO = new PointDTO();
		pointDTO.setNum(1);
		pointDTO.setSid("iu");
		pointDTO.setKor(20);
		int result = pointDAO.insert(pointDTO);
		assertEquals(1, result);
	}

}