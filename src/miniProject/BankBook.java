package miniProject;

import java.io.*;

public class BankBook extends Bank{ //≈Î¿Â
	
	public void bankBookConfig(int bbcnt) { //≈Î¿Â»Æ¿Œ
		for(int i=0; i<bbcnt; i++) {
			System.out.println("∞Ë¡¬π¯»£:" + bankBookCnt[i]+ "\nøπ±›¡÷:" + getAccountHolder() + "\n¿‹æ◊:" + hm.get(bankBookCnt[i]));
		}
	}
	
	public void bankSaveBankBook(int bbcnt) {
		try {
			for(int i=0; i<bbcnt; i++) {
				if(i == 0) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(BANKFIRSTFILE));
					bw.write("∞Ë¡¬π¯»£:" + bankBookCnt[0] + "\n¿‹æ◊:" + hm.get(bankBookCnt[0]) + "\nøπ±›¡÷:" + getAccountHolder());
					bw.close();
				}
				else if(i == 1) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(BANKSECONDFILE));
					bw.write("∞Ë¡¬π¯»£:" + bankBookCnt[1] + "\n¿‹æ◊:" + hm.get(bankBookCnt[1]) + "\nøπ±›¡÷:" + getAccountHolder());
					bw.close();
				}
				else if(i == 2) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(BANKTHRIDFILE));
					bw.write("∞Ë¡¬π¯»£:" + bankBookCnt[2] + "\n¿‹æ◊:" + hm.get(bankBookCnt[2]) + "\nøπ±›¡÷:" + getAccountHolder());
					bw.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void afterSaveBankBook(int number) {
		try {
			if(number == 0) {
				BufferedReader br = new BufferedReader(new FileReader(BANKFIRSTFILE));
				String str1 = br.readLine();
				String result1 = str1.substring(5); //∞Ë¡¬π¯»£
				String str1_1 = br.readLine(); //¿‹æ◊
				String str1_2 = br.readLine(); //øπ±›¡÷
				String result1_2 = str1_2.substring(4);
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKFIRSTFILE));
				bw.write("∞Ë¡¬π¯»£:" + result1 + "\n¿‹æ◊:" + hm.get(bankBookCnt[0]) + "\nøπ±›¡÷:" + result1_2);
				bw.close();
			}
			else if(number == 1) {
				BufferedReader br = new BufferedReader(new FileReader(BANKSECONDFILE));
				String str2 = br.readLine();
				String result2 = str2.substring(5); //∞Ë¡¬π¯»£
				String str2_1 = br.readLine(); //¿‹æ◊
				String str2_2 = br.readLine(); //øπ±›¡÷
				String result2_2 = str2_2.substring(4);
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKSECONDFILE));
				bw.write("∞Ë¡¬π¯»£:" + result2 + "\n¿‹æ◊:" + hm.get(bankBookCnt[1]) + "\nøπ±›¡÷:" + result2_2);
				bw.close();
			}
			else if(number == 2) {
				BufferedReader br = new BufferedReader(new FileReader(BANKTHRIDFILE));
				String str3 = br.readLine();
				String result3 = str3.substring(5); //∞Ë¡¬π¯»£
				String str3_1 = br.readLine(); //¿‹æ◊
				String str3_2 = br.readLine(); //øπ±›¡÷
				String result3_2 = str3_2.substring(4);
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKTHRIDFILE));
				bw.write("∞Ë¡¬π¯»£:" + result3 + "\n¿‹æ◊:" + hm.get(bankBookCnt[2]) + "\nøπ±›¡÷:" + result3_2);
				bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}