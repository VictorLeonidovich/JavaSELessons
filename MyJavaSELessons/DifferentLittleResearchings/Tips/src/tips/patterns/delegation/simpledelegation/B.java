package tips.patterns.delegation.simpledelegation;

/*information from site:
 * ru.wikipedia.org*/

public class B {
	//������� ������, ������� �������� ����� �������������� ���������
	A a = new A();
	
	void foo() {
		a.foo();
	}

	void bar() {
		a.bar();
	}

}
