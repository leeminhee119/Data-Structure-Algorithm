//실습과제 3 - 후위표기법 식 계산

public class CalculatePostfix extends Stack { // stack 클래스의 메소드 사용하기 위해
	

	
	// 후위표기법 식 계산 결과 출력 메소드
	void calculate(String post) { // 후위표기법 식을 문자열로 받아온다
		String[] pieces = post.split(" ");
		String piece;
		int result;
		
		for (int i = 0; i < pieces.length; i++) {
			piece = pieces[i];
			int temp; // '-'나 '/'할 때 순서 맞추기 위한 용도
			
			switch (piece) {
			case "+":
				result = (int)pop() + (int)pop();
				print();
				push(result); //계산한 결과값을 다시 스택에 push
				print();
				break;
			case "-":
				temp = (int)pop();  //먼저 뽑은 것은 연산자 뒤로 가야하므로
				result = (int)pop() - temp;
				print();
				push(result); //계산한 결과값을 다시 스택에 push
				print();
				break;
			case "*":
				result = (int)pop() * (int)pop();
				print();
				push(result); //계산한 결과값을 다시 스택에 push
				print();
				break;
			case "/":
				temp = (int)pop(); //먼저 뽑은 것은 연산자 뒤로 가야하므로
				result = (int)pop() / temp;
				print();
				push(result); //계산한 결과값을 다시 스택에 push
				print();
				break;
			default: //피연산자의 경우
				push(Integer.parseInt(piece));
				print();
				break;
			}
		}
		// 반복문 마치고 나면, 스택에는 결과값만 남게됨. (맨 마지막으로 push한 결과)
		
		System.out.println("<<<  답 = " + pop() + "  >>>");
	}
	
}
