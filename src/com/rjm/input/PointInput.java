package com.rjm.input;

import java.util.Scanner;

import com.rjm.point.PointDTO;

public class PointInput {

	public int setNum(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.println(str + " 번호를 입력");
		int num = sc.nextInt();
		return num;
	}

	public PointDTO setPoint() {
		PointDTO pointDTO = new PointDTO();
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 입력");
		pointDTO.setNum(sc.nextInt());
		System.out.println("학생 ID 입력");
		pointDTO.setSid(sc.next());
		System.out.println("국어 점수 입력");
		pointDTO.setKor(sc.nextInt());
		System.out.println("영어 점수 입력");
		pointDTO.setEng(sc.nextInt());
		System.out.println("수학 점수 입력");
		pointDTO.setMath(sc.nextInt());
		System.out.println("반 번호 입력");
		pointDTO.setBnum(sc.nextInt());
		pointDTO.setTotal(pointDTO.getKor() + pointDTO.getEng() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal() / 3.0);

		return pointDTO;
	}

}
