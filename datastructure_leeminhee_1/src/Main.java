// 실행하여 나오는 출력문의 안내에 따라 입력하시면 됩니다.
// 맥os에서 작업하여 프로젝트 파일 전체를 압축하였습니다.


import java.util.Scanner;

class myArray <E> {
	Scanner scanner = new Scanner(System.in);
	E[] arr;    //배열 이름: arr
	E[] temp; // 배열 크기 확장 또는 축소시 사용할 임시 배열
	int size;   //초기 데이터 0개
	

	
	// 배열 생성하기
	myArray(int length) {     //생성자
		arr = (E[]) new Object[length];   //배열의 전체 크기: length; Object로 레퍼런스 만든 후에 (E[])로 형변환.
		size = 0;      //초기 배열 사이즈: 0
	}
	
	void add(E elem) {    // 초기 배열에 값을 저장할 때 쓸 메소드
		if (size < arr.length) {
			arr[size++] = elem;  // arr[size]에 elem 저장 후에 size++
		}
	}
	
	// 배열 확대/축소 기능
	void resize(int new_size) {
		temp = (E[]) new Object[new_size];   // 데이터를 임시로 저장해줄 new_size 크기의 배열
		for (int i=0; i<size; i++) {  
			temp[i] = arr[i];     // 데이터 옮겨주기
		}
		arr = temp;   // 다시 원래 배열에 복사 (크기 new_size 됨) => arr가 가리키던 기존의 배열은 가비지 컬렉션에 의해 처리.
	}

	
	//값 가져오는 메소드
	E peek(int index) {
		if ((index >= 0) && (index <= size-1)) {
			return (E)arr[index];   //형변환
		}
		else {
			return null;
		}
	}
	
	//삽입 메소드 - 끝에 삽입
	void insert_last(E elem) {
		if (size == arr.length) {  
			resize(2*size);   //확장 (2배 크기의 새로운 배열 생성)
			arr[size++] = elem;   //size 1 키우고 array에 원소 저장.
		}
		else {
			arr[size++] = elem;    
		}
	}
	
	//삽입 메소드 - 중간에 삽입
	void insert_mid(int k, E elem) {  // k 위치 (인덱스)에 elem(원소) 삽입.
		if (size == arr.length) {  //배열이 가득 찼을 경우 (하나 더 추가시 overflow)
			resize(2*size);   //확장 (2배 크기의 새로운 배열 생성)
			
			//새 항목이 들어갈 자리 (인덱스 k)를 위해 배열의 마지막 항목부터 k번째 데이터까지의 순서로 한 칸씩 이동.
			for (int i = size-1; i >= k; i--) {
				arr[i+1] = arr[i];
			}
			arr[k] = elem;
			size++;
		}
		else {
			//삽입할 자리 만들어주기 위해 뒤에서부터 한칸씩 이동
			for (int i = size-1; i >= k; i--) {  
				arr[i+1] = arr[i];
			}
			arr[k] = elem;
			size++;
		}
	}
	
	//삭제 메소드 - 맨 끝 원소 삭제
	void remove_last() {
		arr[size-1] = null;
		size --;
		
		
		// 사용 비율 25%이하라면 크기 절반 축소
		if (size <= (0.25 * arr.length)) {
			resize((1/2) * arr.length);
		}
	}
	
	//삭제 메소드 - 중간 원소 삭제
	void remove_mid(int k) {
		arr[k] = null;  // 삭제
		
		for (int i = k + 1; i < size; i++) { // 비워진 자리 채워주기
			arr[i - 1] = arr[i];
		}
		size--;
		
		
		// 사용 비율 25%이하라면 크기 절반 축소
		if (size <= (0.25 * arr.length)) {
			resize((1/2) * arr.length);
		}
	}
	
	
	////////////
	// 현재 저장된 데이터 순서대로 출력하는 메소드 
	void print_all() {
		System.out.print("현재 저장된 데이터: ");
		for (int i=0; i<size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	
	
}
class Poly {  // String으로 입력받은 다항식을 배열로 저장해주는 클래스
	String[] mono; // 다항식 내의 단항들을 항목으로 저장한 배열.
	int highestDeg;// 다항식 최고차항의 차수.
	myArray<Integer> poly;
	
	Poly(String p) {
		p=p.replace("^",""); //'^' 없애기
		mono = p.split("\\+"); //+기준으로 split하여 단항들을 배열로.
		highestDeg = 0; // 다항식의 차수
		
		//다항식의 차수 (highestDeg) 구하는 과정
		if (mono[0].indexOf('x') == mono[0].length()-1) {
			highestDeg = 1;  //'x'이후로 아무것도 없다면 차수는 1.
		}
		else {
			highestDeg = Integer.parseInt(  mono[0].substring( mono[0].indexOf('x')+1 )  ); // 'x'이후의 문자열(차수부분)을 정수로.
		}
		
		// 배열 생성
		poly = new myArray<Integer>(highestDeg + 1); // 계수들을 알맞은 인덱스에 저장해놓은 배열.

		for (int i=0; i <= highestDeg; i++) {  // 기본 값 0으로 먼저 채워두기.
			poly.add(0);
		}
		
		
		int coeff; //계수
		int degree; //차수
		
		//mono배열을 전부 탐색, 즉 모든 단항들에 대해 따져보기
		for (int j = 0; j < mono.length; j++) { // 계수들을 배열의 각자 맞는 인덱스(차수)에 저장하는 과정.
			int x = mono[j].indexOf('x'); // 'x'의 인덱스
			if (x == -1) { //상수항이라면
				poly.remove_last();
				poly.insert_last(Integer.parseInt(mono[j]));
			}
			else {
				coeff = Integer.parseInt(mono[j].substring(0, x)); // 'x' 이전 문자열(계수부분)을 정수로 변환.
				if (x == mono[j].length() - 1) { // 'x'가 항의 마지막이라면 1차항이므로.
					degree = 1;
				} else { // 'x' 이후 문자열(차수부분)을 정수로 변환.
					degree = Integer.parseInt(mono[j].substring(x + 1));
				}
				poly.remove_mid(highestDeg - degree); // 계수가 들어갈 위치.
				poly.insert_mid(highestDeg - degree, coeff);
			}


		}
	}
	
}
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		// 1. 배열 생성하기
		System.out.print("생성할 배열의 총 길이를 정해주세요: ");
		int len = scanner.nextInt();
		
		myArray<String> mine = new myArray<String>(len);
		
		int cnt = 0; // 사용자가 몇번 입력했는지 체크할 변수 (size개를 넘지 않게 하기 위해)
		System.out.println("배열에 저장할 데이터를 입력해주세요 (" + len +"개 이하, 종료하려면 exit 입력)");
		while (true) {
			System.out.print("저장할 데이터: ");
			String item = scanner.next();
			
			if (item.equals("exit")) {
				break;
			}
			mine.add(item);    // 입력 횟수가 size개를 넘겨서 메소드 실행되더라도 메소드에서 if문으로 조건 걸어주었기 때문에 저장 안됨.
			cnt++;
			if ( cnt > mine.size ) {  // 사용자가 입력한 횟수가 size개를 넘겼을 때
				System.out.println("배열이 이미 가득 찼습니다. " + mine.size + " 번째까지만 저장되었습니다.");
				break;
			}
		}
		

		mine.print_all();
		System.out.println();
		
		//2. 값 가져오기
		System.out.println("1. 값 가져오기");
		
		System.out.print("가져올 데이터의 인덱스 입력: ");
		int index = scanner.nextInt();
		
		String data = mine.peek(index);   // bring메소드를 호출해 데이터 반환.
		
		while (true) {
			//bring메소드에서 범위를 벗어난 인덱스 입력시 null반환, 올바른 인덱스 입력시 데이터 반환.
			if (data != null) {    
				System.out.println("요청하신 인덱스의 항목은: " + data);
				break;
			}
			else {
				System.out.print("범위를 벗어난 인덱스. 다시 입력해주세요: ");
				index = scanner.nextInt();
				data = mine.peek(index);
			}
		}
		System.out.println();

		
		//3. 삽입 삭제
		System.out.println("2-1. 맨 끝에 원소 삽입하기");
		
		System.out.print("맨 끝에 삽입하실 원소를 입력하세요: ");
		data = scanner.next();
		mine.insert_last(data);
		mine.print_all();
		System.out.println();
		
		System.out.println("2-2. 중간에 원소 삽입하기");
		
		System.out.print("중간에 삽입하실 원소를 입력하세요: ");
		data = scanner.next();
		System.out.print("삽입하실 위치(인덱스)를 입력하세요: ");
		while (true) {
			int k = scanner.nextInt();
			if ((k >= mine.size) || (k < 0)) {
				System.out.print("범위를 벗어난 인덱스. 다시 입력해주세요: ");
			}
			else {
				mine.insert_mid(k, data);
				break;
			}
			
		}
		mine.print_all();
		System.out.println();

		
		System.out.println("2-3. 맨 끝의 원소 삭제하기");
		
		mine.remove_last();
		System.out.println("삭제되었습니다.");
		mine.print_all();
		System.out.println();

		
		
		System.out.println("2-4. 중간의 원소 삭제하기");
		
		System.out.print("삭제하실 원소의 인덱스를 입력하세요: ");
		while (true) {
			int k = scanner.nextInt();
			if ((k >= mine.size) || (k < 0)) { // underflow 발생시
				System.out.print("범위를 벗어난 인덱스. 다시 입력해주세요: ");
			}
			else {
				mine.remove_mid(k);
				break;
			}
		}
		mine.print_all();
		System.out.println();
		
//////////// 배열의 응용- 다항식 //////////////
		System.out.println("다항식의 덧셈 | 다항식 입력 예: 4x^5+2x+4");
		System.out.print("첫 번째 다항식을 입력하세요: ");
		String a = scanner.next();
		Poly A = new Poly(a);
		
		System.out.print("두 번째 다항식을 입력하세요: ");
		String b = scanner.next();
		Poly B = new Poly(b);
		
		int newDegree = A.highestDeg; // 두 다항식을 더한 다항식의 차수를 저장하는 변수
		if (B.highestDeg > A.highestDeg) {
			newDegree = B.highestDeg;
		}
		myArray<Integer> newPoly = new myArray<Integer>(newDegree + 1);  //더한 결과의 다항식 계수를 저장하는 배열.
		//전부 0으로 채워두기.
		for (int i=0; i<newDegree+1; i++) {
			newPoly.add(0);
		}
		
		if (B.highestDeg == A.highestDeg) {
			for (int i=0; i<newDegree+1; i++) {
				newPoly.remove_mid(i);
				newPoly.insert_mid(i, A.poly.peek(i) + B.poly.peek(i));
			}
		}
		if (B.highestDeg > A.highestDeg) {
			//차수가 차이나는 만큼 작은 차수의 다항식 앞에 0을 삽입해준다. (크기 맞춰주기 위해)
			for (int i=0; i<B.highestDeg-A.highestDeg; i++) { 
				A.poly.insert_mid(i, 0);
			}
			for (int i=0; i<newDegree+1; i++) {
				newPoly.remove_mid(i);
				newPoly.insert_mid(i, A.poly.peek(i) + B.poly.peek(i));
			}
		}
		if (A.highestDeg > B.highestDeg) {
			for (int i=0; i<A.highestDeg-B.highestDeg; i++) { 
				B.poly.insert_mid(i, 0);
			}
			for (int i=0; i<newDegree+1; i++) {
				newPoly.remove_mid(i);
				newPoly.insert_mid(i, B.poly.peek(i) + A.poly.peek(i));
			}
		}
		//계수 저장 완료.
		
		// 다항식 형태로 출력
		for (int i=0; i<newDegree+1; i++) {

			if (newPoly.peek(i) != 0) { // 계수가 0 이 아니라면 출력하도록.
				
				if (i == newDegree) {  // 마지막 상수는 출력 형태 다름.
					System.out.print(newPoly.peek(i));
				}
				else {
					System.out.print(newPoly.peek(i) + "x^" + (newDegree-i) + " + ");
				}
			}
		}
		
		
		scanner.close();
	}

}

