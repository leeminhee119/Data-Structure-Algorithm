//자료구조및알고리즘 과제 - 스택
//실습과제 1번 - 스택 구현 @ Stack.java (Main.java 에서 실행)
//실습과제 2번 - 중위표기법 => 후위표기법 변환 @ OperatorStack.java (Main.java 에서 실행)
//실습과제 3번 - 후위표기법 식 입력, 계산 출력 @ CalculatePostfix.java (Main.java 에서 실행)
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	//실습과제 1 스택 기능 구현
		System.out.println("*** 실습과제 1 스택 기능 구현 ***");
		Stack stack = new Stack();
		stack.push("red");
		stack.push("orange");
		stack.push("yellow");
		stack.print();
		
		stack.pop();
		stack.print();
		
		stack.push("green");
		stack.print();
		System.out.println("현재 스택의 top원소: " + stack.peek());
		System.out.println();
		
	//실습과제2 중위->후위
		System.out.println("*** 실습과제2 중위->후위 ***");
		OperatorStack ops = new OperatorStack();
		System.out.print("A+B*(C+D-E)/(F+G)  =  ");
		ops.change("A+B*(C+D-E)/(F+G)");  // 중위표기법 식을 인자로 메소드 실행
		System.out.println();
		
	//실습과제3 후위표기법 식 입력받고 해당 결과물 계산 출력
		
		// 입력 형식 : 연산자, 피연산자 하나 입력할 때마다 "공백으로" 구분 !!
		// (두 자리 이상의 피연산자를 하나의 숫자로 인식하기 위해 공백으로 구분)
		// 입력 예) 10 9 31 + 5 / -   [ 즉 10-((9+31)/5) ]
		
		// 단, 나눗셈 계산은 나누어 떨어지는 경우만 고려하여 입력한다
		
		System.out.println("*** 실습과제3 후위표기법 식 계산 ***");
		Scanner sc = new Scanner(System.in);
		CalculatePostfix cal = new CalculatePostfix();
		System.out.print("후위표기법으로 표기한 식 입력: ");
		String eq = sc.nextLine();
		cal.calculate(eq);
	}

}
