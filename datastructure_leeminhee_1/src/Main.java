// 2018110988 �̹��� �ڷᱸ���׾˰���1 1������ //
// �����Ͽ� ������ ��¹��� �ȳ��� ���� �Է��Ͻø� �˴ϴ�.
// ��os���� �۾��Ͽ� ������Ʈ ���� ��ü�� �����Ͽ����ϴ�.


import java.util.Scanner;

class myArray <E> {
	Scanner scanner = new Scanner(System.in);
	E[] arr;    //�迭 �̸�: arr
	E[] temp; // �迭 ũ�� Ȯ�� �Ǵ� ��ҽ� ����� �ӽ� �迭
	int size;   //�ʱ� ������ 0��
	

	
	// �迭 �����ϱ�
	myArray(int length) {     //������
		arr = (E[]) new Object[length];   //�迭�� ��ü ũ��: length; Object�� ���۷��� ���� �Ŀ� (E[])�� ����ȯ.
		size = 0;      //�ʱ� �迭 ������: 0
	}
	
	void add(E elem) {    // �ʱ� �迭�� ���� ������ �� �� �޼ҵ�
		if (size < arr.length) {
			arr[size++] = elem;  // arr[size]�� elem ���� �Ŀ� size++
		}
	}
	
	// �迭 Ȯ��/��� ���
	void resize(int new_size) {
		temp = (E[]) new Object[new_size];   // �����͸� �ӽ÷� �������� new_size ũ���� �迭
		for (int i=0; i<size; i++) {  
			temp[i] = arr[i];     // ������ �Ű��ֱ�
		}
		arr = temp;   // �ٽ� ���� �迭�� ���� (ũ�� new_size ��) => arr�� ����Ű�� ������ �迭�� ������ �÷��ǿ� ���� ó��.
	}

	
	//�� �������� �޼ҵ�
	E peek(int index) {
		if ((index >= 0) && (index <= size-1)) {
			return (E)arr[index];   //����ȯ
		}
		else {
			return null;
		}
	}
	
	//���� �޼ҵ� - ���� ����
	void insert_last(E elem) {
		if (size == arr.length) {  
			resize(2*size);   //Ȯ�� (2�� ũ���� ���ο� �迭 ����)
			arr[size++] = elem;   //size 1 Ű��� array�� ���� ����.
		}
		else {
			arr[size++] = elem;    
		}
	}
	
	//���� �޼ҵ� - �߰��� ����
	void insert_mid(int k, E elem) {  // k ��ġ (�ε���)�� elem(����) ����.
		if (size == arr.length) {  //�迭�� ���� á�� ��� (�ϳ� �� �߰��� overflow)
			resize(2*size);   //Ȯ�� (2�� ũ���� ���ο� �迭 ����)
			
			//�� �׸��� �� �ڸ� (�ε��� k)�� ���� �迭�� ������ �׸���� k��° �����ͱ����� ������ �� ĭ�� �̵�.
			for (int i = size-1; i >= k; i--) {
				arr[i+1] = arr[i];
			}
			arr[k] = elem;
			size++;
		}
		else {
			//������ �ڸ� ������ֱ� ���� �ڿ������� ��ĭ�� �̵�
			for (int i = size-1; i >= k; i--) {  
				arr[i+1] = arr[i];
			}
			arr[k] = elem;
			size++;
		}
	}
	
	//���� �޼ҵ� - �� �� ���� ����
	void remove_last() {
		arr[size-1] = null;
		size --;
		
		
		// ��� ���� 25%���϶�� ũ�� ���� ���
		if (size <= (0.25 * arr.length)) {
			resize((1/2) * arr.length);
		}
	}
	
	//���� �޼ҵ� - �߰� ���� ����
	void remove_mid(int k) {
		arr[k] = null;  // ����
		
		for (int i = k + 1; i < size; i++) { // ����� �ڸ� ä���ֱ�
			arr[i - 1] = arr[i];
		}
		size--;
		
		
		// ��� ���� 25%���϶�� ũ�� ���� ���
		if (size <= (0.25 * arr.length)) {
			resize((1/2) * arr.length);
		}
	}
	
	
	////////////
	// ���� ����� ������ ������� ����ϴ� �޼ҵ� 
	void print_all() {
		System.out.print("���� ����� ������: ");
		for (int i=0; i<size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	
	
}
class Poly {  // String���� �Է¹��� ���׽��� �迭�� �������ִ� Ŭ����
	String[] mono; // ���׽� ���� ���׵��� �׸����� ������ �迭.
	int highestDeg;// ���׽� �ְ������� ����.
	myArray<Integer> poly;
	
	Poly(String p) {
		p=p.replace("^",""); //'^' ���ֱ�
		mono = p.split("\\+"); //+�������� split�Ͽ� ���׵��� �迭��.
		highestDeg = 0; // ���׽��� ����
		
		//���׽��� ���� (highestDeg) ���ϴ� ����
		if (mono[0].indexOf('x') == mono[0].length()-1) {
			highestDeg = 1;  //'x'���ķ� �ƹ��͵� ���ٸ� ������ 1.
		}
		else {
			highestDeg = Integer.parseInt(  mono[0].substring( mono[0].indexOf('x')+1 )  ); // 'x'������ ���ڿ�(�����κ�)�� ������.
		}
		
		// �迭 ����
		poly = new myArray<Integer>(highestDeg + 1); // ������� �˸��� �ε����� �����س��� �迭.

		for (int i=0; i <= highestDeg; i++) {  // �⺻ �� 0���� ���� ä���α�.
			poly.add(0);
		}
		
		
		int coeff; //���
		int degree; //����
		
		//mono�迭�� ���� Ž��, �� ��� ���׵鿡 ���� ��������
		for (int j = 0; j < mono.length; j++) { // ������� �迭�� ���� �´� �ε���(����)�� �����ϴ� ����.
			int x = mono[j].indexOf('x'); // 'x'�� �ε���
			if (x == -1) { //������̶��
				poly.remove_last();
				poly.insert_last(Integer.parseInt(mono[j]));
			}
			else {
				coeff = Integer.parseInt(mono[j].substring(0, x)); // 'x' ���� ���ڿ�(����κ�)�� ������ ��ȯ.
				if (x == mono[j].length() - 1) { // 'x'�� ���� �������̶�� 1�����̹Ƿ�.
					degree = 1;
				} else { // 'x' ���� ���ڿ�(�����κ�)�� ������ ��ȯ.
					degree = Integer.parseInt(mono[j].substring(x + 1));
				}
				poly.remove_mid(highestDeg - degree); // ����� �� ��ġ.
				poly.insert_mid(highestDeg - degree, coeff);
			}


		}
	}
	
}
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		// 1. �迭 �����ϱ�
		System.out.print("������ �迭�� �� ���̸� �����ּ���: ");
		int len = scanner.nextInt();
		
		myArray<String> mine = new myArray<String>(len);
		
		int cnt = 0; // ����ڰ� ��� �Է��ߴ��� üũ�� ���� (size���� ���� �ʰ� �ϱ� ����)
		System.out.println("�迭�� ������ �����͸� �Է����ּ��� (" + len +"�� ����, �����Ϸ��� exit �Է�)");
		while (true) {
			System.out.print("������ ������: ");
			String item = scanner.next();
			
			if (item.equals("exit")) {
				break;
			}
			mine.add(item);    // �Է� Ƚ���� size���� �Ѱܼ� �޼ҵ� ����Ǵ��� �޼ҵ忡�� if������ ���� �ɾ��־��� ������ ���� �ȵ�.
			cnt++;
			if ( cnt > mine.size ) {  // ����ڰ� �Է��� Ƚ���� size���� �Ѱ��� ��
				System.out.println("�迭�� �̹� ���� á���ϴ�. " + mine.size + " ��°������ ����Ǿ����ϴ�.");
				break;
			}
		}
		

		mine.print_all();
		System.out.println();
		
		//2. �� ��������
		System.out.println("1. �� ��������");
		
		System.out.print("������ �������� �ε��� �Է�: ");
		int index = scanner.nextInt();
		
		String data = mine.peek(index);   // bring�޼ҵ带 ȣ���� ������ ��ȯ.
		
		while (true) {
			//bring�޼ҵ忡�� ������ ��� �ε��� �Է½� null��ȯ, �ùٸ� �ε��� �Է½� ������ ��ȯ.
			if (data != null) {    
				System.out.println("��û�Ͻ� �ε����� �׸���: " + data);
				break;
			}
			else {
				System.out.print("������ ��� �ε���. �ٽ� �Է����ּ���: ");
				index = scanner.nextInt();
				data = mine.peek(index);
			}
		}
		System.out.println();

		
		//3. ���� ����
		System.out.println("2-1. �� ���� ���� �����ϱ�");
		
		System.out.print("�� ���� �����Ͻ� ���Ҹ� �Է��ϼ���: ");
		data = scanner.next();
		mine.insert_last(data);
		mine.print_all();
		System.out.println();
		
		System.out.println("2-2. �߰��� ���� �����ϱ�");
		
		System.out.print("�߰��� �����Ͻ� ���Ҹ� �Է��ϼ���: ");
		data = scanner.next();
		System.out.print("�����Ͻ� ��ġ(�ε���)�� �Է��ϼ���: ");
		while (true) {
			int k = scanner.nextInt();
			if ((k >= mine.size) || (k < 0)) {
				System.out.print("������ ��� �ε���. �ٽ� �Է����ּ���: ");
			}
			else {
				mine.insert_mid(k, data);
				break;
			}
			
		}
		mine.print_all();
		System.out.println();

		
		System.out.println("2-3. �� ���� ���� �����ϱ�");
		
		mine.remove_last();
		System.out.println("�����Ǿ����ϴ�.");
		mine.print_all();
		System.out.println();

		
		
		System.out.println("2-4. �߰��� ���� �����ϱ�");
		
		System.out.print("�����Ͻ� ������ �ε����� �Է��ϼ���: ");
		while (true) {
			int k = scanner.nextInt();
			if ((k >= mine.size) || (k < 0)) { // underflow �߻���
				System.out.print("������ ��� �ε���. �ٽ� �Է����ּ���: ");
			}
			else {
				mine.remove_mid(k);
				break;
			}
		}
		mine.print_all();
		System.out.println();
		
//////////// �迭�� ����- ���׽� //////////////
		System.out.println("���׽��� ���� | ���׽� �Է� ��: 4x^5+2x+4");
		System.out.print("ù ��° ���׽��� �Է��ϼ���: ");
		String a = scanner.next();
		Poly A = new Poly(a);
		
		System.out.print("�� ��° ���׽��� �Է��ϼ���: ");
		String b = scanner.next();
		Poly B = new Poly(b);
		
		int newDegree = A.highestDeg; // �� ���׽��� ���� ���׽��� ������ �����ϴ� ����
		if (B.highestDeg > A.highestDeg) {
			newDegree = B.highestDeg;
		}
		myArray<Integer> newPoly = new myArray<Integer>(newDegree + 1);  //���� ����� ���׽� ����� �����ϴ� �迭.
		//���� 0���� ä���α�.
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
			//������ ���̳��� ��ŭ ���� ������ ���׽� �տ� 0�� �������ش�. (ũ�� �����ֱ� ����)
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
		//��� ���� �Ϸ�.
		
		// ���׽� ���·� ���
		for (int i=0; i<newDegree+1; i++) {

			if (newPoly.peek(i) != 0) { // ����� 0 �� �ƴ϶�� ����ϵ���.
				
				if (i == newDegree) {  // ������ ����� ��� ���� �ٸ�.
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

