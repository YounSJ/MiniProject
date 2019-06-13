package miniProject;

import java.io.*;
import java.util.*;

public class Bank { //����
	public static final String BANKFIRSTFILE = "F:\\work\\test\\bankFirstBankBook.txt";
	public static final String BANKSECONDFILE = "F:\\work\\test\\bankSecondBankBook.txt";
	public static final String BANKTHRIDFILE = "F:\\work\\test\\bankThridBankBook.txt";
	
	HashSet<Integer> hs = new HashSet<Integer>();
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	int[] bankBookCnt = new int[3]; //���� ����
	int[] balance = new int[3];
	String str1, result1, str2, result2, str3, result3;
	
	Random random = new Random();
	
	private int accountNum, password, cnt = 0;
	private String accountHolder;

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getBankBook(int i) {
		return bankBookCnt[i-1];
	}
	public void newBankBook() { //���尳��
		accountNum = random.nextInt(99)+1; //���¹�ȣ ����
		
		int size = hs.size(); //size�� �� ó���� hs.size
		while(hs.size() < size+1) { //hs.size�� size+1���� ������ ���� ����
			hs.add(accountNum); //hs�� ���� ���� while�� Ż��
		}
	}
	
	public void saveAccountNum() {
		Iterator<Integer> it = hs.iterator(); //���� 3���� �迭�� �ֱ�
		while(it.hasNext()) {
			for(int i=0; i<getCnt(); i++) {
				bankBookCnt[i] = (int) it.next();
			}
		}
		
		for(int i=0; i<bankBookCnt.length; i++) { //���¿� �ܾ��� HashMap�� ����
			hm.put(bankBookCnt[i], balance[i]);
		}
	}
	
	public void deposit(int num2, int money) { //�Ա�
		if(num2 == 1) { //1�� ����
			if(money % 10 == 0) {
				balance[0] = money;
			}
			else {
				System.out.println("1�������� �Ա��Ͻ� �� �����ϴ�");
			}
		}
		else if(num2 == 2) { //2�� ����
			if(money % 10 == 0) {
				balance[1] = money;
			}
			else {
				System.out.println("1�������� �Ա��Ͻ� �� �����ϴ�");
			}
		}
		else if(num2 == 3) { //3�� ����
			if(money % 10 == 0) {
				balance[2] = money;
			}
			else {
				System.out.println("1�������� �Ա��Ͻ� �� �����ϴ�");
			}
		}
	}
	
	public void withdraw(int num2, int money) { //�Ա�
		if(num2 == 1) { //1�� ����
			if(money % 10 == 0) {
				balance[0] = money;
			}
			else {
				System.out.println("1�������� ����Ͻ� �� �����ϴ�");
			}
		}
		else if(num2 == 2) { //2�� ����
			if(money % 10 == 0) {
				balance[1] = money;
			}
			else {
				System.out.println("1�������� ����Ͻ� �� �����ϴ�");
			}
		}
		else if(num2 == 3) { //3�� ����
			if(money % 10 == 0) {
				balance[2] = money;
			}
			else {
				System.out.println("1�������� ����Ͻ� �� �����ϴ�");
			}
		}
	}
	
	public void selectBankBook(int num2, int num3) {
		int tmp=0;
		if(num2 == 1) {
			tmp = bankBookCnt[0];
		}
		else if(num2 == 2) {
			tmp = bankBookCnt[1];
		}
		else if(num2 == 3) {
			tmp = bankBookCnt[2];
		}
		
		if(num3 == 1) {
			if(tmp == 0) {
				System.out.println("���� �����Դϴ�.");
			}
			else {
				int money = hm.get(tmp);
				money += balance[num2-1];
				hm.remove(tmp);
				hm.put(tmp, money);
			}
		}
		else if(num3 == 2) {
			if(tmp == 0) {
				System.out.println("���� �����Դϴ�.");
			}
			else {
				int money = hm.get(tmp);
				if(money - balance[num2-1] < 0) {
					System.out.println("����� �� �����ϴ�");
				}
				else {
					money -= balance[num2-1];
					hm.remove(tmp);
					hm.put(tmp, money);
				}
			}
		}
		else if(num3 == 3) {
			if(tmp == 0) {
				System.out.println("���� �����Դϴ�.");
			}
			else {
				System.out.println("�ܾ�:" + hm.get(tmp));
			}
		}
	}
	
	public void printReceipt(int recepitNum) {
		try {			
			BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\work\\test\\Receipt.txt"));
			
			switch(recepitNum) {
			case 1:
				bw.write("���¹�ȣ:" + bankBookCnt[0] + "\n�ܾ�:" + hm.get(bankBookCnt[0]));
				bw.newLine();
				break;
			case 2:
				if(bankBookCnt[1] == 0 && hm.get(bankBookCnt[1]) == 0) {
					System.out.println("���� �����Դϴ�.");
				}
				else {
					bw.write("���¹�ȣ:" + bankBookCnt[1] + "\n�ܾ�:" + hm.get(bankBookCnt[1]));
					bw.newLine();
				}
				break;
			case 3:
				if(bankBookCnt[2] == 0 && hm.get(bankBookCnt[2]) == 0) {
					System.out.println("���� �����Դϴ�.");
				}
				else {
					bw.write("���¹�ȣ:" + bankBookCnt[2] + "\n�ܾ�:" + hm.get(bankBookCnt[2]));
					bw.newLine();
				}
				break;
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int callBankFirstFile() { //���� �ҷ�����
		//ù��° ����
		int firstBankBookNum = 0;
		
		File file1 = new File(BANKFIRSTFILE);
		if(file1.exists()) {
			try {
				BufferedReader firstFile = new BufferedReader(new FileReader(BANKFIRSTFILE));
				
				str1 = firstFile.readLine().substring(5); //���¹�ȣ �ҷ�����
				firstBankBookNum = Integer.parseInt(str1);;
				
				firstFile.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return firstBankBookNum;
	}
	
	public int callBankFirstFileBalance() { //ù��° ���� �ܾ�
		//ù��° ����
		int firstBankBookBalance = 0;
		
		File file1 = new File(BANKFIRSTFILE);
		if(file1.exists()) {
			try {
				BufferedReader firstFile = new BufferedReader(new FileReader(BANKFIRSTFILE));
				
				String str1 = firstFile.readLine();
				String str1_1 = firstFile.readLine().substring(3); //���¹�ȣ �ҷ�����
				firstBankBookBalance = Integer.parseInt(str1_1);
				
				firstFile.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return firstBankBookBalance;
	}
	
	public int callBankSecondFile() { //�ι�° ����
		//�ι�° ����
		int secondBankBookNum = 0;
		
		File file2 = new File(BANKSECONDFILE);
		if(file2.exists()) {
			try {
				BufferedReader secondFile = new BufferedReader(new FileReader(BANKSECONDFILE));
				str2 = secondFile.readLine().substring(5); //���¹�ȣ �ҷ�����
				secondBankBookNum = Integer.parseInt(str2);
				
				secondFile.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return secondBankBookNum;
	}
	
	public int callBankSecondFileBalance() { //�ι�° ���� �ܾ�
		//ù��° ����
		int secondBankBookBalance = 0;
		
		File file2 = new File(BANKSECONDFILE);
		if(file2.exists()) {
			try {
				BufferedReader secondFile = new BufferedReader(new FileReader(BANKSECONDFILE));
				
				String str2 = secondFile.readLine();
				String str2_1 = secondFile.readLine().substring(3); //�ι�° ���� �ܾ�
				secondBankBookBalance = Integer.parseInt(str2_1);
				
				secondFile.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return secondBankBookBalance;
	}
	
	public int callBankThridFile() {
		//����° ����
		int thridBankBookNum = 0;
		File file3 = new File(BANKTHRIDFILE);
		if(file3.exists()) {
			try {
				BufferedReader thridFile = new BufferedReader(new FileReader(BANKTHRIDFILE));
				str3 = thridFile.readLine().substring(5); //���¹�ȣ �ҷ�����
				thridBankBookNum = Integer.parseInt(str3);
				
				thridFile.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return thridBankBookNum;
	}
	
	public int callBankThridFileBalance() { //����° ���� �ܾ� 
		//ù��° ����
		int thridBankBookBalance = 0;
		
		File file3 = new File(BANKTHRIDFILE);
		if(file3.exists()) {
			try {
				BufferedReader thridFile = new BufferedReader(new FileReader(BANKTHRIDFILE));
				
				String str3 = thridFile.readLine();
				String str3_1 = thridFile.readLine().substring(3); //����° ���� �ܾ�
				thridBankBookBalance = Integer.parseInt(str3_1);
				
				thridFile.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return thridBankBookBalance;
	}
	
	public void after(int number, int bankFirstBalance) {
		hm.put(bankBookCnt[number-1], bankFirstBalance);
	}
	
	public void afterprint(int number) {
		System.out.println("�ܾ�:" + hm.get(bankBookCnt[number-1]));
	}
}
