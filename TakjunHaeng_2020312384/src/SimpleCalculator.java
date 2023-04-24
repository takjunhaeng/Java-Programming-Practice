import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

class AddZeroException extends RuntimeException {
	private int a, b;
}
class SubtractZeroException extends RuntimeException {

}
class OutOfRangeException extends RuntimeException {
	
}



public class SimpleCalculator {

	static void checkPlusZero(int a, int b) {
		if(a == 0 || b == 0) {
			throw new AddZeroException();
		}
	}
	static void checkMinusZero(int a, int b) {
		if(a == 0 || b == 0) {
			throw new SubtractZeroException();
		}
	}
	static void checkOutOfRange(int result) {
		if(result <0 || result > 1000) {
			throw new OutOfRangeException();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> inputLine = new ArrayList<>();
		Scanner scn = new Scanner(System.in);
		String input = scn.nextLine();
		String[] inputNum = input.split("\\+|-");
		int firstNum = Integer.valueOf(inputNum[0]);
		int secondNum = Integer.valueOf(inputNum[1]);

		int result = 0;
		
		try {
			if(input.contains("+")) {
				checkPlusZero(firstNum, secondNum);
				result = firstNum + secondNum;
			}
			else {
				if(firstNum == 0 || secondNum == 0) {
					checkMinusZero(firstNum, secondNum);
				}
				result = firstNum - secondNum;
			}

			checkOutOfRange(result);
			
			System.out.println(result);
		} catch(AddZeroException e) {
			System.out.println("AddZeroException");
		} catch(SubtractZeroException e) {
			System.out.println("SubtractZeroException");
		} catch(OutOfRangeException e) {
			System.out.println("OutOfRangeException");
		}
		
	}
	
	


}
