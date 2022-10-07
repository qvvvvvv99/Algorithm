import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 // 현재 날짜 구하기
		 LocalDate now = LocalDate.now();         
		 // 포맷 정의        
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 // 포맷 적용       
		 String formatedNow = now.format(formatter);         
		 // 결과 출력       
		 System.out.println(formatedNow);  
	}
}

//
//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
