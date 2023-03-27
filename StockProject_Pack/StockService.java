package StockProject_Pack;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class StockService {

	public static void stockStatus(String[] args) throws ParseException, IOException {
		StockDTO stockDTO = new StockDTO();
		Scanner sc = new Scanner(System.in);
		System.out.print("주식의 코드를 입력해 주세요 > ");
		stockDTO.setCode(sc.next());
		String URL = "https://finance.naver.com/item/main.nhn?code=" + stockDTO.getCode();
		Document doc;
		doc = Jsoup.connect(URL).get();
		Elements todaylist = doc.select(".new_totalinfo dl>dd");

		String stockName = todaylist.get(1).text().split(" ")[1];
		stockDTO.setName(stockName);

		Elements elem = doc.select(".date");
		String[] str = elem.text().split(" ");

		String nowPrice = todaylist.get(3).text().split(" ")[1]; // 현재가격
		String priceRate = todaylist.get(3).text().split(" ")[6]; // 등락율
		String stype = todaylist.get(3).text().split(" ")[3]; // 상한가,상승,보합,하한가,하락 구분
		String vsyesterday = todaylist.get(3).text().split(" ")[4]; // 전일대비

		String startPirce = todaylist.get(5).text().split(" ")[1]; // 시가
		String topPirce = todaylist.get(6).text().split(" ")[1]; // 고가
		String downPirce = todaylist.get(8).text().split(" ")[1]; // 저가

		String volume = todaylist.get(10).text().split(" ")[1]; // 거래량

		// 출력화면
		System.out.println();
		System.out.println(stockDTO.getName() + "의 실시간 주식정보를 불러옵니다");
		System.out.println();
		System.out.println("■■■■■■■■■■ stock status ■■■■■■■■■■");
		System.out.println("현재가:" + nowPrice);
		System.out.println("등락률:" + priceRate + "% " + stype + "중 전일대비 " + vsyesterday + "원 " + stype);
		System.out.println("■■■■■■■■■■ pirce rate ■■■■■■■■■■");
		System.out.println("시가:" + startPirce);
		System.out.println("고가:" + topPirce);
		System.out.println("저가:" + downPirce);
		System.out.println("■■■■■■■■■■ trading volume ■■■■■■■■■■");
		System.out.println("거래량:" + volume);
		System.out.println();
		System.out.println("검색하신 주식의 정보는 ");
		System.out.println(str[0] + " " + str[1] + " 기준의 데이터 입니다");
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public static void stockInvestorTrends(String[] args) throws ParseException, IOException {
		StockDTO stockDTO = new StockDTO();
		Scanner sc = new Scanner(System.in);
		System.out.print("주식의 코드를 입력해 주세요 > ");
		stockDTO.setCode(sc.next());
		String URL = "https://finance.naver.com/item/main.nhn?code=" + stockDTO.getCode();
		Document doc;
		doc = Jsoup.connect(URL).get();
		Elements todaylist = doc.select(".new_totalinfo dl>dd");
		Elements InvestorTrends = doc.select(".tb_type1 tbody>tr");

		String stockName = todaylist.get(1).text().split(" ")[1];
		stockDTO.setName(stockName);

		Elements elem = doc.select(".date");
		String[] str = elem.text().split(" ");

		String sellInstitutionaName1 = InvestorTrends.get(1).text().split(" ")[0];
		String sellInstitutionaVolum1 = InvestorTrends.get(1).text().split(" ")[1];
		String sellInstitutionaName2 = InvestorTrends.get(2).text().split(" ")[0];
		String sellInstitutionaVolum2 = InvestorTrends.get(2).text().split(" ")[1];
		String sellInstitutionaName3 = InvestorTrends.get(3).text().split(" ")[0];
		String sellInstitutionaVolum3 = InvestorTrends.get(3).text().split(" ")[1];
		String sellInstitutionaName4 = InvestorTrends.get(4).text().split(" ")[0];
		String sellInstitutionaVolum4 = InvestorTrends.get(4).text().split(" ")[1];
		String sellInstitutionaName5 = InvestorTrends.get(5).text().split(" ")[0];
		String sellInstitutionaVolum5 = InvestorTrends.get(5).text().split(" ")[1];

		String buyInstitutionaName1 = InvestorTrends.get(1).text().split(" ")[2];
		String buyInstitutionaVolum1 = InvestorTrends.get(1).text().split(" ")[3];
		String buyInstitutionaName2 = InvestorTrends.get(2).text().split(" ")[2];
		String buyInstitutionaVolum2 = InvestorTrends.get(2).text().split(" ")[3];
		String buyInstitutionaName3 = InvestorTrends.get(3).text().split(" ")[2];
		String buyInstitutionaVolum3 = InvestorTrends.get(3).text().split(" ")[3];
		String buyInstitutionaName4 = InvestorTrends.get(4).text().split(" ")[2];
		String buyInstitutionaVolum4 = InvestorTrends.get(4).text().split(" ")[3];
		String buyInstitutionaName5 = InvestorTrends.get(5).text().split(" ")[2];
		String buyInstitutionaVolum5 = InvestorTrends.get(5).text().split(" ")[3];

		// InvestorTrends: InvestorTrends라는 클래스의 인스턴스를 생성합니다.
		// get(3): 생성된 InvestorTrends 인스턴스의 3번째 요소를 가져옵니다.
		// text(): 가져온 요소에서 문자열 데이터를 추출합니다.
		// split(" ")[1]: 추출된 문자열 데이터를 공백(" ")을 기준으로 분리하고, 분리된 문자열 중에서 1번째 요소를 선택합니다.

		// 출력화면
		System.out.println();
		System.out.println(stockDTO.getName() + "의 투자자별 매매동향을 불러옵니다");
		System.out.println();
		System.out.println("■■■■■ Trading trends by institutional investors ■■■■■");
		System.out.println("매도(▼)상위순 기관목록 거래원정보 입니다.");
		System.out.println();
		System.out.println("1. " + sellInstitutionaName1 + " (▼)" + sellInstitutionaVolum1 + "주 매도");
		System.out.println("2. " + sellInstitutionaName2 + " (▼)" + sellInstitutionaVolum2 + "주 매도");
		System.out.println("3. " + sellInstitutionaName3 + " (▼)" + sellInstitutionaVolum3 + "주 매도");
		System.out.println("4. " + sellInstitutionaName4 + " (▼)" + sellInstitutionaVolum4 + "주 매도");
		System.out.println("5. " + sellInstitutionaName5 + " (▼)" + sellInstitutionaVolum5 + "주 매도");
		System.out.println();
		System.out.println("매수(▲)상위순 기관목록 거래원정보 입니다.");
		System.out.println();
		System.out.println("1. " + buyInstitutionaName1 + " (▲)" + buyInstitutionaVolum1 + "주 매수");
		System.out.println("2. " + buyInstitutionaName2 + " (▲)" + buyInstitutionaVolum2 + "주 매수");
		System.out.println("3. " + buyInstitutionaName3 + " (▲)" + buyInstitutionaVolum3 + "주 매수");
		System.out.println("4. " + buyInstitutionaName4 + " (▲)" + buyInstitutionaVolum4 + "주 매수");
		System.out.println("5. " + buyInstitutionaName5 + " (▲)" + buyInstitutionaVolum5 + "주 매수");
		System.out.println();
		System.out.println("■■■■■ Trading trends Total ■■■■■");
		System.out.println("매도(▼)상위순\t\t거래량");

		System.out.println();
		System.out.println("검색하신 주식의 정보는 ");
		System.out.println(str[0] + " " + str[1] + " 기준의 데이터 입니다");
		System.out.println();
		System.out.println();
		System.out.println();

	}

	public static void stockInformation(String[] args) throws ParseException, IOException {
		StockDTO stockDTO = new StockDTO();
		Scanner sc = new Scanner(System.in);
		System.out.print("주식의 코드를 입력해 주세요 > ");
		stockDTO.setCode(sc.next());
		String URL = "https://finance.naver.com/item/main.nhn?code=" + stockDTO.getCode();
		Document doc;
		doc = Jsoup.connect(URL).get();
		Elements todaylist = doc.select(".new_totalinfo dl>dd");
		Elements information = doc.select(".tab_con1 tbody>tr");

		String stockName = todaylist.get(1).text().split(" ")[1];
		stockDTO.setName(stockName);

		Elements elem = doc.select(".date");
		String[] str = elem.text().split(" ");

		String informationName1 = information.get(0).text().split(" ")[0];
		String informationDate1 = information.get(0).text().split(" ", 2)[1];
		// 위의 코드에서 split(" ", 2)는 문자열을 공백으로 나누는데, 최대 두 개의 부분 문자열로 분할한다는 의미입니다.
		// 따라서 첫 번째 부분 문자열인 "362조"와 두 번째 부분 문자열인 "3658"을 얻을 수 있습니다.
		// 여기서 [1]은 두 번째 부분 문자열 "3658" 대신 첫 번째 부분 문자열 "362조 3658"을 선택하는 것을 의미합니다.
		String informationName2 = information.get(1).text().split(" ")[0];
		String informationDate2 = information.get(1).text().split(" ", 2)[1];
		String informationName3 = information.get(2).text().split(" ")[0];
		String informationDate3 = information.get(2).text().split(" ", 2)[1];
		String informationName4 = information.get(3).text().split(" ")[0];
		String informationDate4 = information.get(3).text().split(" ", 2)[1];
		String informationName5 = information.get(4).text().split(" ")[0];
		String informationDate5 = information.get(4).text().split(" ", 2)[1];
		String informationName6 = information.get(5).text().split(" ")[0];
		String informationDate6 = information.get(5).text().split(" ", 2)[1];
		String informationName7 = information.get(6).text().split(" ")[0];
		String informationDate7 = information.get(6).text().split(" ")[27];
		String informationName8 = information.get(7).text().split(" ")[0];
		String informationDate8 = information.get(7).text().split(" ", 2)[1];
		String informationName9 = information.get(8).text().split(" ")[0];
		String informationDate9 = information.get(8).text().split(" ", 2)[1];
		String informationName10 = information.get(9).text().split(" ")[0];
		String informationDate10 = information.get(9).text().split(" ")[19];
		String informationName11 = information.get(10).text().split(" ")[0];
		String informationDate11 = information.get(10).text().split(" ")[19];
		String informationName12 = information.get(11).text().split(" ")[0];
		String informationDate12 = information.get(11).text().split(" ")[18];
		String informationName13 = information.get(12).text().split(" ")[0];
		String informationDate13 = information.get(12).text().split(" ")[16];
		String informationName14 = information.get(13).text().split(" ")[0];
		String informationDate14 = information.get(13).text().split(" ")[2];
		String informationName15 = information.get(14).text().split(" ")[0];
		String informationDate15 = information.get(14).text().split(" ")[2];

		// 출력화면
		System.out.println();
		System.out.println(stockDTO.getName() + "의 투자정보를 불러옵니다");
		System.out.println();
		System.out.println("■■■■■ Investment information ■■■■■");
		System.out.println();
		System.out.println("종목명   \t\t=  " + stockDTO.getName());
		System.out.println(informationName1 + "   \t=  " + informationDate1);
		System.out.println(informationName2 + "   \t=  " + informationDate2);
		System.out.println(informationName3 + "   \t=  " + informationDate3);
		System.out.println(informationName4 + "   \t=  " + informationDate4);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(informationName5 + "\t=  " + informationDate5);
		System.out.println(informationName6 + "\t=  " + informationDate6);
		System.out.println(informationName7 + "\t=  " + informationDate7);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(informationName8 + "   \t=  " + informationDate8 + "원(▲)");
		System.out.println(informationName9 + "   \t=  " + informationDate9);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(informationName10 + "=  " + informationDate10);
		System.out.println(informationName11 + "   \t=  " + informationDate11);
		System.out.println(informationName12 + "   \t=  " + informationDate12);
		System.out.println(informationName13 + " =  " + informationDate13);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(informationName14 + " PER" + "   \t=  " + informationDate14);
		System.out.println(informationName15 + " 등락률" + "   \t=  " + informationDate15);

		System.out.println();
		System.out.println("검색하신 주식의 정보는 ");
		System.out.println(str[0] + " " + str[1] + " 기준의 데이터 입니다");
		System.out.println();
		System.out.println();
		System.out.println();

	}

	public static void stockAnalysis(String[] args) throws ParseException, IOException {
		StockDTO stockDTO = new StockDTO();
		Scanner sc = new Scanner(System.in);
		System.out.print("주식의 코드를 입력해 주세요 > ");
		stockDTO.setCode(sc.next());
		String URL = "https://finance.naver.com/item/main.nhn?code=" + stockDTO.getCode();
		Document doc;
		doc = Jsoup.connect(URL).get();
		Elements todaylist = doc.select(".new_totalinfo dl>dd");
		Elements Analysis = doc.select(".section.cop_analysis tbody>tr");
		Elements annualQuarterly = doc.select(".section.cop_analysis thead>tr");

		String stockName = todaylist.get(1).text().split(" ")[1];
		stockDTO.setName(stockName);

		Elements elem = doc.select(".date");
		String[] str = elem.text().split(" ");
		
		String headDate1 = annualQuarterly.get(0).text().split(" ")[0];
		String headDate2 = annualQuarterly.get(1).text().split(" ")[0];
		String headDate3 = annualQuarterly.get(1).text().split(" ")[1];
		String headDate4 = annualQuarterly.get(1).text().split(" ")[2];
		String headDate5 = annualQuarterly.get(1).text().split(" ")[3];
		String headDate6 = annualQuarterly.get(1).text().split(" ")[4];
		String headDate7 = annualQuarterly.get(1).text().split(" ")[5];
		String headDate8 = annualQuarterly.get(1).text().split(" ")[6];
		String headDate9 = annualQuarterly.get(1).text().split(" ")[7];
		String headDate10 = annualQuarterly.get(1).text().split(" ")[8];
		String headDate11 = annualQuarterly.get(1).text().split(" ")[9];
    	// section.cop_analysis thead>tr 년도별/변기별 날짜 데이터


		String corporateAnalysis1 = Analysis.get(0).text().split(" ")[0];
		String corporateAnalysis2 = Analysis.get(1).text().split(" ")[0];
		String corporateAnalysis3 = Analysis.get(2).text().split(" ")[0];
		String corporateAnalysis4 = Analysis.get(3).text().split(" ")[0];
		String corporateAnalysis5 = Analysis.get(4).text().split(" ")[0];
		String corporateAnalysis6 = Analysis.get(5).text().split(" ")[0];
		String corporateAnalysis7 = Analysis.get(6).text().split(" ")[0];
		String corporateAnalysis8 = Analysis.get(7).text().split(" ")[0];
		String corporateAnalysis9 = Analysis.get(8).text().split(" ")[0];
		String corporateAnalysis10 = Analysis.get(9).text().split(" ")[0];
		String corporateAnalysis11 = Analysis.get(10).text().split(" ")[0];
		String corporateAnalysis12 = Analysis.get(11).text().split(" ")[0];
		String corporateAnalysis13 = Analysis.get(12).text().split(" ")[0];
		String corporateAnalysis14 = Analysis.get(13).text().split(" ")[0];
		String corporateAnalysis15 = Analysis.get(14).text().split(" ")[0];
		String corporateAnalysis16 = Analysis.get(15).text().split(" ")[0];
		// section.cop_analysis tbody>tr 매출액 ~ 배당성향의 데이터

		String revenue1 = Analysis.get(0).text().split(" ")[1];
		String revenue2 = Analysis.get(0).text().split(" ")[2];
		String revenue3 = Analysis.get(0).text().split(" ")[3];
		String revenue4 = Analysis.get(0).text().split(" ")[4];
		String revenue5 = Analysis.get(0).text().split(" ")[5];
		String revenue6 = Analysis.get(0).text().split(" ")[6];
		String revenue7 = Analysis.get(0).text().split(" ")[7];
		String revenue8 = Analysis.get(0).text().split(" ")[8];
		String revenue9 = Analysis.get(0).text().split(" ")[9];
		String revenue10 = Analysis.get(0).text().split(" ")[10];
		// section.cop_analysis tbody>tr 매출액의 데이터

		String operatingProfit1 = Analysis.get(1).text().split(" ")[1];
		String operatingProfit2 = Analysis.get(1).text().split(" ")[2];
		String operatingProfit3 = Analysis.get(1).text().split(" ")[3];
		String operatingProfit4 = Analysis.get(1).text().split(" ")[4];
		String operatingProfit5 = Analysis.get(1).text().split(" ")[5];
		String operatingProfit6 = Analysis.get(1).text().split(" ")[6];
		String operatingProfit7 = Analysis.get(1).text().split(" ")[7];
		String operatingProfit8 = Analysis.get(1).text().split(" ")[8];
		String operatingProfit9 = Analysis.get(1).text().split(" ")[9];
		String operatingProfit10 = Analysis.get(1).text().split(" ")[10];
		// section.cop_analysis tbody>tr 영업이익의 데이터

		String netIncom1 = Analysis.get(2).text().split(" ")[1];
		String netIncom2 = Analysis.get(2).text().split(" ")[2];
		String netIncom3 = Analysis.get(2).text().split(" ")[3];
		String netIncom4 = Analysis.get(2).text().split(" ")[4];
		String netIncom5 = Analysis.get(2).text().split(" ")[5];
		String netIncom6 = Analysis.get(2).text().split(" ")[6];
		String netIncom7 = Analysis.get(2).text().split(" ")[7];
		String netIncom8 = Analysis.get(2).text().split(" ")[8];
		String netIncom9 = Analysis.get(2).text().split(" ")[9];
		String netIncom10 = Analysis.get(2).text().split(" ")[10];
		// section.cop_analysis tbody>tr 당기순이익의 데이터

		String operatingProfitMargin1 = Analysis.get(3).text().split(" ")[1];
		String operatingProfitMargin2 = Analysis.get(3).text().split(" ")[2];
		String operatingProfitMargin3 = Analysis.get(3).text().split(" ")[3];
		String operatingProfitMargin4 = Analysis.get(3).text().split(" ")[4];
		String operatingProfitMargin5 = Analysis.get(3).text().split(" ")[5];
		String operatingProfitMargin6 = Analysis.get(3).text().split(" ")[6];
		String operatingProfitMargin7 = Analysis.get(3).text().split(" ")[7];
		String operatingProfitMargin8 = Analysis.get(3).text().split(" ")[8];
		String operatingProfitMargin9 = Analysis.get(3).text().split(" ")[9];
		String operatingProfitMargin10 = Analysis.get(3).text().split(" ")[10];
		// section.cop_analysis tbody>tr 영업이익률의 데이터

		String netProfitMargin1 = Analysis.get(4).text().split(" ")[1];
		String netProfitMargin2 = Analysis.get(4).text().split(" ")[2];
		String netProfitMargin3 = Analysis.get(4).text().split(" ")[3];
		String netProfitMargin4 = Analysis.get(4).text().split(" ")[4];
		String netProfitMargin5 = Analysis.get(4).text().split(" ")[5];
		String netProfitMargin6 = Analysis.get(4).text().split(" ")[6];
		String netProfitMargin7 = Analysis.get(4).text().split(" ")[7];
		String netProfitMargin8 = Analysis.get(4).text().split(" ")[8];
		String netProfitMargin9 = Analysis.get(4).text().split(" ")[9];
		String netProfitMargin10 = Analysis.get(4).text().split(" ")[10];
		// section.cop_analysis tbody>tr 순이익률의 데이터

		String ROE1 = Analysis.get(5).text().split(" ")[1];
		String ROE2 = Analysis.get(5).text().split(" ")[2];
		String ROE3 = Analysis.get(5).text().split(" ")[3];
		String ROE4 = Analysis.get(5).text().split(" ")[4];
		String ROE5 = Analysis.get(5).text().split(" ")[5];
		String ROE6 = Analysis.get(5).text().split(" ")[6];
		String ROE7 = Analysis.get(5).text().split(" ")[7];
		String ROE8 = Analysis.get(5).text().split(" ")[8];
		String ROE9 = Analysis.get(5).text().split(" ")[9];
		// section.cop_analysis tbody>tr ROE의 데이터

		String debtRatio1 = Analysis.get(6).text().split(" ")[1];
		String debtRatio2 = Analysis.get(6).text().split(" ")[2];
		String debtRatio3 = Analysis.get(6).text().split(" ")[3];
		String debtRatio5 = Analysis.get(6).text().split(" ")[4];
		String debtRatio6 = Analysis.get(6).text().split(" ")[5];
		String debtRatio7 = Analysis.get(6).text().split(" ")[6];
		String debtRatio8 = Analysis.get(6).text().split(" ")[7];
		String debtRatio9 = Analysis.get(6).text().split(" ")[8];
		// section.cop_analysis tbody>tr 부채비율의 데이터
		
		String quickRatio1 = Analysis.get(7).text().split(" ")[1];
		String quickRatio2 = Analysis.get(7).text().split(" ")[2];
		String quickRatio3 = Analysis.get(7).text().split(" ")[3];
		String quickRatio5 = Analysis.get(7).text().split(" ")[4];
		String quickRatio6 = Analysis.get(7).text().split(" ")[5];
		String quickRatio7 = Analysis.get(7).text().split(" ")[6];
		String quickRatio8 = Analysis.get(7).text().split(" ")[7];
		String quickRatio9 = Analysis.get(7).text().split(" ")[8];
		// section.cop_analysis tbody>tr 당좌비율의 데이터
		
		String EPS1 = Analysis.get(9).text().split(" ")[1];
		String EPS2 = Analysis.get(9).text().split(" ")[2];
		String EPS3 = Analysis.get(9).text().split(" ")[3];
		String EPS4 = Analysis.get(9).text().split(" ")[4];
		String EPS5 = Analysis.get(9).text().split(" ")[5];
		String EPS6 = Analysis.get(9).text().split(" ")[6];
		String EPS7 = Analysis.get(9).text().split(" ")[7];
		String EPS8 = Analysis.get(9).text().split(" ")[8];
		String EPS9 = Analysis.get(9).text().split(" ")[9];
		String EPS10 = Analysis.get(9).text().split(" ")[10];
		// section.cop_analysis tbody>tr EPS의 데이터
		
		String PER1 = Analysis.get(10).text().split(" ")[1];
		String PER2 = Analysis.get(10).text().split(" ")[2];
		String PER3 = Analysis.get(10).text().split(" ")[3];
		String PER4 = Analysis.get(10).text().split(" ")[4];
		String PER5 = Analysis.get(10).text().split(" ")[5];
		String PER6 = Analysis.get(10).text().split(" ")[6];
		String PER7 = Analysis.get(10).text().split(" ")[7];
		String PER8 = Analysis.get(10).text().split(" ")[8];
		String PER9 = Analysis.get(10).text().split(" ")[9];
		String PER10 = Analysis.get(10).text().split(" ")[10];
		// section.cop_analysis tbody>tr PER의 데이터
		
		String PBR1 = Analysis.get(12).text().split(" ")[1];
		String PBR2 = Analysis.get(12).text().split(" ")[2];
		String PBR3 = Analysis.get(12).text().split(" ")[3];
		String PBR4 = Analysis.get(12).text().split(" ")[4];
		String PBR5 = Analysis.get(12).text().split(" ")[5];
		String PBR6 = Analysis.get(12).text().split(" ")[6];
		String PBR7 = Analysis.get(12).text().split(" ")[7];
		String PBR8 = Analysis.get(12).text().split(" ")[8];
		String PBR9 = Analysis.get(12).text().split(" ")[9];
		// section.cop_analysis tbody>tr PBR의 데이터
		
		String DividendPerShare1 = Analysis.get(13).text().split(" ")[1];
		String DividendPerShare2 = Analysis.get(13).text().split(" ")[2];
		String DividendPerShare3 = Analysis.get(13).text().split(" ")[3];
		String DividendPerShare4 = Analysis.get(13).text().split(" ")[4];
		// section.cop_analysis tbody>tr 주당배당금의 데이터

		// 출력화면
		System.out.println();
		System.out.println(stockDTO.getName() + "의 기업실적을 불러옵니다");
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■ financial performance analysis ■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println();
		System.out.println(stockDTO.getName() + "의 최근 연간실적 정보 입니다.");
		System.out.println();
		System.out.println();
		System.out.println(headDate1+"\t\t"+headDate2+"\t\t"+headDate3+"\t\t"+headDate4+"\t\t"+headDate5);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis1 + "(억원)" + "\t\t" + revenue1 + "\t" + revenue2 + "\t" + revenue3 + "\t" + revenue4);
		System.out.println(corporateAnalysis2 + "(억원)" + "\t\t" + operatingProfit1 + "\t\t" + operatingProfit2 + "\t\t"	+ operatingProfit3 + "\t\t" + operatingProfit4);
		System.out.println(corporateAnalysis3 + "(억원)" + "\t\t" + netIncom1 + "\t\t" + netIncom2 + "\t\t" + netIncom3			+ "\t\t" + netIncom4);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis4 + "(%)" + "\t\t" + operatingProfitMargin1 + "%" + "\t\t" + operatingProfitMargin2	+ "%" + "\t\t" + operatingProfitMargin3 + "%" + "\t\t" + operatingProfitMargin4 + "%");
		System.out.println(corporateAnalysis5 + "(%)" + "\t\t" + netProfitMargin1 + "%" + "\t\t" + netProfitMargin2		+ "%" + "\t\t" + netProfitMargin3 + "%" + "\t\t" + netProfitMargin4 + "%");
		System.out.println(corporateAnalysis6 + "(%)" + "\t\t" + ROE1 + "%" + "\t\t" + ROE2 + "%" + "\t\t" + ROE3 + "%"				+ "\t\t" + ROE4 + "%");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis7 + "(%)" + "\t\t" + debtRatio1 + "%" + "\t\t" + debtRatio2 + "%" + "\t\t"	+ debtRatio3 + "%");
		System.out.println(corporateAnalysis8 + "(%)" + "\t\t" + quickRatio1 + "%" + "\t\t" + quickRatio2 + "%" + "\t\t"	+ quickRatio3 + "%");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis10 +"\t\t\t" + EPS1 + "원" + "\t\t" + EPS2 + "원" + "\t\t"	+ EPS3 + "원"+ "\t\t"	+ EPS4 + "원");
		System.out.println(corporateAnalysis11 +"\t\t\t" + PER1 + "배" + "\t\t" + PER2 + "배" + "\t\t"	+ PER3 + "배"+ "\t\t"	+ PER4 + "배");		
		System.out.println(corporateAnalysis13 +"\t\t\t" + PBR1 + "배" + "\t\t" + PBR2 + "배" + "\t\t"	+ PBR3 + "배"+ "\t\t"	+ PBR4 + "배");		
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis14 +"\t\t" + DividendPerShare1 + "원" + "\t\t" + DividendPerShare2 + "원" + "\t\t"	+ DividendPerShare3 + "원"+ "\t\t"	+ DividendPerShare4 + "원");	
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println(stockDTO.getName() + "의 최근 분기실적 정보 입니다.");
		System.out.println();
		System.out.println();
		System.out.println(headDate1+"\t\t"+headDate6+"\t\t"+headDate7+"\t\t"+headDate8+"\t\t"+headDate9+"\t\t"+headDate10+"\t\t"+headDate11);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis1 + "(억원)" + "\t\t" + revenue5 + "\t\t" + revenue6 + "\t\t" + revenue7 + "\t\t" + revenue8+ "\t\t" + revenue9+ "\t\t" + revenue10);
		System.out.println(corporateAnalysis2 + "(억원)" + "\t\t" + operatingProfit5 + "\t\t" + operatingProfit6 + "\t\t"	+ operatingProfit7 + "\t\t" + operatingProfit8+ "\t\t" + operatingProfit9+ "\t\t" + operatingProfit10);
		System.out.println(corporateAnalysis3 + "(억원)" + "\t\t" + netIncom5 + "\t\t" + netIncom6 + "\t\t" + netIncom7			+ "\t\t" + netIncom8+ "\t\t" + netIncom9+ "\t\t" + netIncom10);
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis4 + "(%)" + "\t\t" + operatingProfitMargin5 + "%" + "\t\t" + operatingProfitMargin6	+ "%" + "\t\t" + operatingProfitMargin7 + "%" + "\t\t" + operatingProfitMargin8 + "%"+ "\t\t" + operatingProfitMargin9 + "%"+ "\t\t" + operatingProfitMargin10 + "%");
		System.out.println(corporateAnalysis5 + "(%)" + "\t\t" + netProfitMargin5 + "%" + "\t\t" + netProfitMargin6		+ "%" + "\t\t" + netProfitMargin7 + "%" + "\t\t" + netProfitMargin8 + "%"+ "\t\t" + netProfitMargin9 + "%"+ "\t\t" + netProfitMargin10 + "%");
		System.out.println(corporateAnalysis6 + "(%)" + "\t\t" + ROE5 + "%" + "\t\t" + ROE6 + "%" + "\t\t" + ROE7 + "%"				+ "\t\t" + ROE8 + "%"+ "\t\t" + ROE9 + "%");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis7 + "(%)" + "\t\t" + debtRatio5 + "%" + "\t\t" + debtRatio6 + "%" + "\t\t"	+ debtRatio7 + "%"+ "\t\t"	+ debtRatio8 + "%"+ "\t\t"	+ debtRatio9 + "%");
		System.out.println(corporateAnalysis8 + "(%)" + "\t\t" + quickRatio5 + "%" + "\t\t" + quickRatio6 + "%" + "\t\t"	+ quickRatio7 + "%"+ "\t\t"	+ quickRatio8 + "%"+ "\t\t"	+ quickRatio9 + "%");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(corporateAnalysis10 +"\t\t\t" + EPS5 + "원" + "\t\t" + EPS6 + "원" + "\t\t"	+ EPS7 + "원"+ "\t\t"	+ EPS8 + "원"+ "\t\t"	+ EPS9 + "원"+ "\t\t"	+ EPS10 + "원");
		System.out.println(corporateAnalysis11 +"\t\t\t" + PER5 + "배" + "\t\t" + PER6 + "배" + "\t\t"	+ PER7 + "배"+ "\t\t"	+ PER8 + "배"+ "\t\t"	+ PER9 + "배"+ "\t\t"	+ PER10 + "배");		
		System.out.println(corporateAnalysis13 +"\t\t\t" + PBR5 + "배" + "\t\t" + PBR6 + "배" + "\t\t"	+ PBR7 + "배"+ "\t\t"	+ PBR8 + "배"+ "\t\t"	+ PBR9 + "배");		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("검색하신 주식의 정보는 ");
		System.out.println(str[0] + " " + str[1] + " 기준의 데이터 입니다");
		System.out.println();
		System.out.println();
		System.out.println();

	}

}