

import java.util.EmptyStackException;
public class Stack<E> {
	E[] stack;
	int top;
	
	//생성자
	Stack() {
		stack = (E[]) new Object[1];
		top = -1;  // 스택에 아무 것도 없을 때 top은 -1
	}
	
	int size() { //사이즈 리턴
		return top+1; // 배열의 size는 가장 마지막 인덱스인 top
	}
	boolean isEmpty() { //스택이 비었다면 true 리턴
		if (top == -1) {
			return true;
		}
		return false;
	}
	
	//resize 메소드
	void resize(int new_size) {
		E[] temp = (E[]) new Object[new_size];   // 데이터를 임시로 저장해줄 new_size 크기의 배열
		for (int i=0; i<size(); i++) {  
			temp[i] = stack[i];     // 데이터 옮겨주기
		}
		stack = temp;   
	}
	
	//push메소드
	void push(E item) {
		//집어넣기 전 배열(스택)이 가득찼다면 배열 확대
		if (size() == stack.length) { // 스택이 가득 찼을 때
			resize(2*stack.length);
		}
		stack[++top] = item;  // top을 먼저 1 증가시키고 그 인덱스에 item저장
	}
	
	//pop 메소드
	E pop() {
		if (isEmpty()) throw new EmptyStackException(); //underflow 발생시 프로그램 종료.
		E popped = stack[top];
		stack[top--] = null;
		//뽑아낸 후 배열의 사이즈가 일정 크기 이하라면 배열 축소
		if (size() == 0) {
			resize(1);
		}
		else if (size() <= stack.length * 1/4) { 
			//배열 총 길이의 1/4보다 사용하고 있는 사이즈가 더 작다면 배열 축소
			resize(stack.length * 1/2);
		}
		return popped;
	}
	
	//peek메소드
	E peek() {
		if (isEmpty()) throw new EmptyStackException(); //underflow 발생시 프로그램 종료.
		return stack[top];  //가장 위에 있는 (top에 해당하는) 원소를 리턴.
	}
	
	// 스택 전체를 출력하는 메소드
	void print() {
		System.out.print("스택 전체 (top부터 차례대로): ");
		for (int i = 0; i < stack.length; i++ ) {
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}
}
