
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// main
		String enteredNumber = args[0];
		int attempt = Integer.parseInt(args[1]);
		int guessedNumber = Integer.parseInt(args[2]);
		boolean isWinner = Boolean.parseBoolean(args[3]);
		if (enteredNumber == null) {
			attempt = 0;
			guessedNumber = (int) (Math.random() * 9) + 1;
			isWinner = false;
		}
		attempt = attempt + 1;
		if (attempt == 1) {
			System.out.println("Добро пожаловать в игру \"Угадай цифру\".");
			System.out.println("Угадайте цифру от 1 до 9. У Вас есть три попытки.");
			System.out.println("Попытка № " + attempt + ".");
		}
		if (enteredNumber == null) {
			System.out.println("Введите цифру от 1 до 9.");
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
				args[0] = reader.readLine();
			}
		}else{
			
		}

		// servlet

		session.setAttribute("attempt", (Integer) session.getAttribute("attempt") + 1);

		if ((Integer) session.getAttribute("attempt") == 1) {
			out.println("<h2>����� ���������� � ���� \"������ �����\".</h2>");

			out.println("<h2>�������� ����� �� 1 �� 9 ������������. � ��� ���� ����� ��� �������.</h2>");
			out.println("<h2>������� � " + (Integer) session.getAttribute("attempt") + ".</h2>");
		}

		if (request.getParameter("entered_number") == null) {

			out.println(
					"<h2>������� ����� �� 1 �� 9: <form action=\"ServletGTN\" method=\"GET\"> <input type=\"text\" name=\"entered_number\" size=\"10\"></form></h2>");
		} else {
			try {

				if (Integer.parseInt(request.getParameter("entered_number")) < 1
						|| Integer.parseInt(request.getParameter("entered_number")) > 9) {
					out.println("<h2>�������, ����������, ����� �� 1 �� 9!!!</h2>");
					session.setAttribute("attempt", (Integer) session.getAttribute("attempt") - 1);
					out.println(
							"<h2>������� ����� �� 1 �� 9: <form action=\"ServletGTN\" method=\"GET\"> <input type=\"text\" name=\"entered_number\" size=\"10\"></form></h2>");
				} else if ((Integer) session.getAttribute("guessed_number") == Integer
						.parseInt(request.getParameter("entered_number"))) {
					out.println("<h2>�� ��������! ������� "
							+ ((((Integer) session.getAttribute("attempt")) == 1) ? "� ������"
									: (((((Integer) session.getAttribute("attempt")) == 2)) ? "�� ������"
											: "� �������"))
							+ " ������� ����� " + (Integer) session.getAttribute("guessed_number") + ".</h2>");
					session.invalidate();

				} else {
					out.println(
							"<h2>��������� ���� ����� "
									+ ((Integer.parseInt(request.getParameter("entered_number")) < (Integer) session
											.getAttribute("guessed_number")) ? "������" : "������")
							+ " ������� �����.</h2>");
					if ((Integer) session.getAttribute("attempt") < 3) {
						out.println("<h2>���������� ��� ���.</h2>");

						out.println("<h2>������� � " + ((Integer) session.getAttribute("attempt") + 1) + ".</h2>");
						out.println(
								"<h2>������� ����� �� 1 �� 9: <form action=\"ServletGTN\" method=\"GET\"> <input type=\"text\" name=\"entered_number\" size=\"10\"></form></h2>");
					} else if (!(Boolean) session.getAttribute("is_winner")) {
						out.println("<h2>� ��� ����������� ��� �������. � ���������, �� ���������(((</h2>");
						out.println("<h2>����������� ����� ���� " + (Integer) session.getAttribute("guessed_number")
								+ ".</h2>");
						session.invalidate();
					}
				}

			} catch (NumberFormatException e) {
				out.println("<h2>�������, ����������, �����, � �� ����� ��� ������!!!</h2>");
				session.setAttribute("attempt", (Integer) session.getAttribute("attempt") - 1);

				out.println(
						"<h2>������� ����� �� 1 �� 9: <form action=\"ServletGTN\" method=\"GET\"> <input type=\"text\" name=\"entered_number\" size=\"10\"></form></h2>");
			}

		}

		out.close();

	}

}
