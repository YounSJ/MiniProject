package miniProject;

import java.io.*;

public class BankBook extends Bank{ //����
	
	public void bankBookConfig(int bbcnt) { //����Ȯ��
		for(int i=0; i<bbcnt; i++) {
			System.out.println("���¹�ȣ:" + bankBookCnt[i]+ "\n������:" + getAccountHolder() + "\n�ܾ�:" + hm.get(bankBookCnt[i]));
		}
	}
	
	public void bankSaveBankBook(int bbcnt) {
		try {
			for(int i=0; i<bbcnt; i++) {
				if(i == 0) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(BANKFIRSTFILE));
					bw.write("���¹�ȣ:" + bankBookCnt[0] + "\n�ܾ�:" + hm.get(bankBookCnt[0]) + "\n������:" + getAccountHolder());
					bw.close();
				}
				else if(i == 1) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(BANKSECONDFILE));
					bw.write("���¹�ȣ:" + bankBookCnt[1] + "\n�ܾ�:" + hm.get(bankBookCnt[1]) + "\n������:" + getAccountHolder());
					bw.close();
				}
				else if(i == 2) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(BANKTHRIDFILE));
					bw.write("���¹�ȣ:" + bankBookCnt[2] + "\n�ܾ�:" + hm.get(bankBookCnt[2]) + "\n������:" + getAccountHolder());
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
				String result1 = str1.substring(5); //���¹�ȣ
				String str1_1 = br.readLine(); //�ܾ�
				String str1_2 = br.readLine(); //������
				String result1_2 = str1_2.substring(4);
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKFIRSTFILE));
				bw.write("���¹�ȣ:" + result1 + "\n�ܾ�:" + hm.get(bankBookCnt[0]) + "\n������:" + result1_2);
				bw.close();
			}
			else if(number == 1) {
				BufferedReader br = new BufferedReader(new FileReader(BANKSECONDFILE));
				String str2 = br.readLine();
				String result2 = str2.substring(5); //���¹�ȣ
				String str2_1 = br.readLine(); //�ܾ�
				String str2_2 = br.readLine(); //������
				String result2_2 = str2_2.substring(4);
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKSECONDFILE));
				bw.write("���¹�ȣ:" + result2 + "\n�ܾ�:" + hm.get(bankBookCnt[1]) + "\n������:" + result2_2);
				bw.close();
			}
			else if(number == 2) {
				BufferedReader br = new BufferedReader(new FileReader(BANKTHRIDFILE));
				String str3 = br.readLine();
				String result3 = str3.substring(5); //���¹�ȣ
				String str3_1 = br.readLine(); //�ܾ�
				String str3_2 = br.readLine(); //������
				String result3_2 = str3_2.substring(4);
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(BANKTHRIDFILE));
				bw.write("���¹�ȣ:" + result3 + "\n�ܾ�:" + hm.get(bankBookCnt[2]) + "\n������:" + result3_2);
				bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}