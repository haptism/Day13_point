package com.rjm.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.rjm.input.PointInput;
import com.rjm.point.PointDAO;
import com.rjm.point.PointDTO;
import com.rjm.view.PointView;

public class PointController {
	private PointDAO pointDAO;
	private PointInput pointInput;
	private PointView pointView;
	private Scanner sc;

	public PointController() {
		pointDAO = new PointDAO();
		pointInput = new PointInput();
		pointView = new PointView();
		sc = new Scanner(System.in);
	}

	public void start() throws Exception {
		boolean check = true;
		ArrayList<PointDTO> ar = null;
		PointDTO pointDTO = null;

		while (check) {
			System.out.println("1. 정보      추가");
			System.out.println("2. 정보      삭제");
			System.out.println("3. 정보 번호 조회");
			System.out.println("4. 정보 전체 조회");
			System.out.println("5. 종             료");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				pointDTO = pointInput.setPoint();
				select = pointDAO.insert(pointDTO);
				String message = "추가 실패";
				if (select > 0) {
					message = "추가 성공";
				}
				pointView.view(message);
				break;
			case 2:
				select = pointInput.setNum("삭제");
				select = pointDAO.delete(select);
				String message2 = "삭제 실패";
				if (select > 0) {
					message2 = "삭제 성공";
				}
				pointView.view(message2);

				break;
			case 3:
				select = pointInput.setNum("조회 ");
				pointDTO = pointDAO.selectOne(select);
				if (pointDTO != null) {
					pointView.view(pointDTO);
				} else {
					pointView.view("없는 번호");
				}
				break;
			case 4:
				ar = pointDAO.selectList();
				pointView.view(ar);
				break;
			default:
				check = !check;
				System.out.println("종료");
			}
		}
	}

	// 1. 정보 추가
	// 2. 정보 삭제
	// 3. 정보 번호 조회
	// 4. 정보 전체 조회
	// 5. 종 료

}