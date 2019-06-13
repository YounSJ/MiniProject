package miniProject;

import java.io.*;
import java.net.*;

public class BankServer {
	public static final String BANKFIRSTFILE = "F:\\work\\test\\bankFirstBankBook.txt";
	public static final String BANKSECONDFILE = "F:\\work\\test\\bankSecondBankBook.txt";
	public static final String BANKTHRIDFILE = "F:\\work\\test\\bankThridBankBook.txt";
	
	public static String callFirstAccountHolder() {
		String str1_2 = null;
		
		File file1 = new File(BANKFIRSTFILE);
		if(file1.exists()) {
			try {
				BufferedReader firstFile = new BufferedReader(new FileReader(BANKFIRSTFILE));
				
				String str1 = firstFile.readLine();
				String str1_1 = firstFile.readLine();
				str1_2 = firstFile.readLine().substring(4);
				
				firstFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str1_2;
	}
	
	public static String callSecondAccountHolder() {
		String str2_2 = null;
		
		File file2 = new File(BANKSECONDFILE);
		if(file2.exists()) {
			try {
				BufferedReader SecondFile = new BufferedReader(new FileReader(BANKSECONDFILE));
				
				String str2 = SecondFile.readLine();
				String str2_1 = SecondFile.readLine();
				str2_2 = SecondFile.readLine().substring(4);
				
				SecondFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str2_2;
	}
	
	public static String callThridAccountHolder() {
		String str3_2 = null;
		
		File file3 = new File(BANKTHRIDFILE);
		if(file3.exists()) {
			try {
				BufferedReader ThridFile = new BufferedReader(new FileReader(BANKTHRIDFILE));
				
				String str3 = ThridFile.readLine();
				String str3_1 = ThridFile.readLine();
				str3_2 = ThridFile.readLine().substring(4);
				
				ThridFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str3_2;
	}
	
	public static void main(String[] args) {
		BankBook bank = new BankBook();
		ServerSocket ss = null;
		Socket soc = null;
		int result1 = bank.callBankFirstFile();
		int result2 = bank.callBankSecondFile();
		int result3 = bank.callBankThridFile();
		
		try {
			ss = new ServerSocket(33333);
			System.out.println("Listening...");
			soc = ss.accept(); //접속을 대기해라.
			
			BufferedReader br =
					new BufferedReader(
							new InputStreamReader(
									soc.getInputStream()));
			String readLine = br.readLine();
			String readLineBalance = br.readLine();
			int clientResult = Integer.parseInt(readLine);
			int balance = Integer.parseInt(readLineBalance);
			
			if(result1 == clientResult && balance >= 0) {
				//파일 저장
				String AccountHolder = callFirstAccountHolder(); //예금주
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKFIRSTFILE));
				bw.write("계좌번호:" + result1 + "\n잔액:" + balance + "\n예금주:" + AccountHolder);
				bw.close();
			}
			else if(result2 == clientResult && balance >= 0) {
				//파일 저장
				String AccountHolder = callSecondAccountHolder(); //예금주
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKSECONDFILE));
				bw.write("계좌번호:" + result2 + "\n잔액:" + balance + "\n예금주:" + AccountHolder);
				bw.close();
			}
			else if(result3 == clientResult && balance >= 0) {
				//파일 저장
				String AccountHolder = callThridAccountHolder(); //예금주
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKTHRIDFILE));
				bw.write("계좌번호:" + result3 + "\n잔액:" + balance + "\n예금주:" + AccountHolder);
				bw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(soc != null) soc.close();
				if(ss != null) ss.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
