//실습과제1 - 중위표기법 => 후위표기법
public class OperatorStack extends Stack { //스택클래스에 있는 메소드 사용


	
	//연산자 우선순위
	int order(char op) {
		// 연산자, 괄호 우선순위 : *,/  >  +,-  >  (,)
		switch(op) {
		case '(':
		case ')':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1; // op에 연산자나 괄호도 아닌 게 온다면 (피연산자) -1 반환.
	}
	
	//중위->후위 변환 (후위로 변환한 식을 한 단위씩 모두 char로 저장한 배열 반환)
	void change(String eq) {
		char ch; // 단위 하나 하나 캐릭터로 받아오기 위한 변수
		
		for (int i = 0; i < eq.length(); i++) { //식을 앞에서부터 한자리씩 순환
			ch = eq.charAt(i);
			
			switch(ch) {
			case '(':   //왼쪽 괄호라면 바로 push
				push(ch);
				break;
			case ')':   //오른쪽 괄호라면 왼쪽 괄호가 나올 때까지 pop,출력
				while ((char)peek() != '(') {
					System.out.print(pop());
				}
				pop();  //반복문 마치면 top이 왼쪽괄호 -> pop
				break;
			case '+':   //모든 연산자에 대해서는 자기보다 낮은 연산자가 top으로 올 때까지 pop, 출력
			case '-':
			case '*':
			case '/':
				while (!isEmpty() && order((char)peek()) >= order(ch)) {
					System.out.print(pop());
				}
				push(ch); //반복문 마치면 top이 자기보다 낮은 우선순위의 연산자 -> 이 때 push
				break;
			default:    // 피연산자인 경우 바로 출력
				System.out.print(ch);
				break;
			}
		}
		//스택에 남아있는 나머지 연산자를 모두 pop, 출력
		while (!isEmpty()) {
			System.out.print(pop());
		}
		System.out.println();
	}
}
