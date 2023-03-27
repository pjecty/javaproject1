package StockProject_Pack;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class StockMain {

	public static void main(String[] args) throws ParseException, IOException {
		Scanner sc = new Scanner(System.in);
		StockService service = new StockService();
		// 삼성전자 005930
		// 카카오 035720
		// LG   003550
		// 네이버 035420

		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■ StockProgram ■■■■■■■■■■■■■■■■■■■■■");
			System.out.println();
			System.out.println("1.주가정보 2.매매동향 3.주식정보 4.실적조회 5.주가차트 6.매수매도적합성");
			System.out.println();
			System.out.print("메뉴를 선택해주세요 > ");
			int menu = sc.nextInt();

			if (menu == 1) {
				service.stockStatus(args);
			} else if (menu == 2) {
				service.stockInvestorTrends(args);
			} else if (menu == 3) {
				service.stockInformation(args);
			}else if (menu == 4) {
				service.stockAnalysis(args);
			}

			else if (menu == 0) {
				break;

			} else {
				System.out.println("다시입력하세요");
			}
			System.out.println();
		}
		System.out.println("프로그램 종료");
	}

}