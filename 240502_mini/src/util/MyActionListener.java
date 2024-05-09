package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// 작업순서 1, 요소를 클릭시 이벤트를 처리하는 리스너가 필요해요. 

// 해당 요소(컴포넌트, 버튼, 입력창 등 그림용소) 마다, 리스너가 각각 다르다. 

// ActionListener, 구성품이 , 추상 메서드가 하나인 인터페이스: 함수형 인터페이스, 
// 언제 활용이 되나요? 람다식(화살표 함수 사용시) 이용이 됨. 

public class MyActionListener implements ActionListener{

	// 작업순서2, 재정의
	@Override
	public void actionPerformed(ActionEvent event) {
		// 작업순서3, 이용할 내용이 다 다름. 
		// 버튼을 클릭해서, 버튼의 값의 이름의 정보를 가지고 와서,
		// 그정보가 일치한다면, 버튼의 값의 내용을 변경하는 간단히 이벤트 처리. 
		
		// 작업순서4, 버튼을 클릭시 발생한 이벤트 정보를 , event 라는 객체에 담기.
		// 이벤트의 정보를 가져오는 메서드. 
		// 정보를 가져 왔지만, 기본 타입 : Object, 테스트 하는 요소 : 버튼
		// 버튼 타입으로 변경하기. 
		JButton testBtn = (JButton) event.getSource();
		
		//미니실습, 작업순서4, 이벤트 정보를 가져와서, 후처리 하기.. 
		// 위의 testBtn , 재사용
		
		//작업순서5, 정보를 받은 버튼에서, 버튼의 이름 조회. 
		// testBtn.getText() 의 이름 조회. 
		if (testBtn.getText().equals("test")) {
			testBtn.setText("테스트");
			//미니실습, 작업순서5, 가지고 온 이벤트 정보를, 버튼으로 타입 변경 후, 
			// 버튼의 이름의 문자열의 값을 비교 후, 후처리 함. 
		} else if (testBtn.getText().equals("테스트")) {
			testBtn.setText("test");
		}
		else if (testBtn.getText().equals("test2")) {
			testBtn.setText("테스트2");
		}else if (testBtn.getText().equals("테스트2")) {
			testBtn.setText("test2");
		}
	}// actionPerformed 닫기

}




