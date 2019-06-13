package miniProject;

import java.io.*;
import java.net.*;
import java.util.*;

public class Person { //��ü�� ��	
	public static final String PERSONFIRSTFILE = "F:\\work\\test\\personFirstBankBook.txt";
	public static final String PERSONSECONDFILE = "F:\\work\\test\\personSecondBankBook.txt";
	public static final String PERSONTHRIDFILE = "F:\\work\\test\\personThridBankBook.txt";
	
	public static int callPersonFirstFile() { //���� �ҷ�����
		//ù��° ����
		int firstBankBookNum = 0;
		
		File file1 = new File(PERSONFIRSTFILE);
		if(file1.exists()) {
			try {
				BufferedReader firstFile = new BufferedReader(new FileReader(PERSONFIRSTFILE));
				
				String str1 = firstFile.readLine();
				String result1 = str1.substring(5); //���¹�ȣ �ҷ�����
				firstBankBookNum = Integer.parseInt(result1);
				
				firstFile.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return firstBankBookNum;
	}
	
	public static int callPersonSecondFile() {
		//�ι�° ����
		int secondBankBookNum = 0;
		
		File file2 = new File(PERSONSECONDFILE);
		if(file2.exists()) {
			try {
				BufferedReader secondFile = new BufferedReader(new FileReader(PERSONSECONDFILE));
				
				String str2 = secondFile.readLine();
				String result2 = str2.substring(5); //���¹�ȣ �ҷ�����
				secondBankBookNum = Integer.parseInt(result2);
				
				secondFile.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return secondBankBookNum;
	}
	
	public static int callPersonThridFile() {
		//����° ����
		int thridBankBookNum = 0;
		File file3 = new File(PERSONTHRIDFILE);
		if(file3.exists()) {
			try {
				BufferedReader thridFile = new BufferedReader(new FileReader(PERSONTHRIDFILE));
				String str3 = thridFile.readLine();
				String result3 = str3.substring(5); //���¹�ȣ �ҷ�����
				thridBankBookNum = Integer.parseInt(result3);
				
				thridFile.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return thridBankBookNum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankBook bankBook = new BankBook();
		int password, cnt = 0, first = 0, second = 0, thrid = 0;
		boolean op = true;
		String name;
		
		System.out.println("������ ������ �ֽ��ϱ�?(y/n)");
		char option = sc.nextLine().charAt(0);
		switch(option) {
		case 'y':
			//������ �ҷ��;ߵ�
			int bankFirst = bankBook.callBankFirstFile();
			int bankFirstBalance = bankBook.callBankFirstFileBalance();
			int personFirst = callPersonFirstFile();
			int bankSecond = bankBook.callBankSecondFile();
			int bankSecondBalance = bankBook.callBankSecondFileBalance();
			int personSecond = callPersonSecondFile();
			int bankThrid = bankBook.callBankThridFile();
			int bankThridBalance = bankBook.callBankThridFileBalance();
			int personThrid = callPersonThridFile();

			System.out.println("1. ���࿡�� ��������");
			System.out.println("2. ATM ��������");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1: //���࿡�� ��������
				System.out.println("������ �����Ͻÿ�.(1~3)");
				int number = Integer.parseInt(sc.nextLine());
				switch(number) {
				case 1:
					if(bankFirst == personFirst) { //ù��° ����
						System.out.println("�ܾ�:" + bankBook.callBankFirstFileBalance());
						boolean op4 = true;
						while(op4) {
							System.out.println("1. �Ա�");
							System.out.println("2. ���");
							System.out.println("3. ������");
							System.out.print("����:");
							
							int num3 = Integer.parseInt(sc.nextLine());
							switch(num3) {
							case 1:
								//�Ա�
								System.out.println("�Ա��Ͻ� �ݾ���?");
								int money = Integer.parseInt(sc.nextLine());
								if(money % 10 == 0) {
									bankFirstBalance += money;
									bankBook.after(number, bankFirstBalance);
								}
								else {
									System.out.println("1�������� �Ա��Ͻ� �ݾ��� �Է����ּ���");
									money = Integer.parseInt(sc.nextLine());
									bankFirstBalance += money;
									bankBook.after(number, bankFirstBalance);
								}
								break;
							case 2:
								//���
								System.out.println("����Ͻ� �ݾ���?");
								money = Integer.parseInt(sc.nextLine());
								if(bankFirstBalance - money >= 0) {
									bankFirstBalance -= money;
									bankBook.after(number, bankFirstBalance);
								}
								else {
									System.out.println("����Ͻ� �ݾ��� �ٽ� �Է����ּ���");
									bankFirstBalance -= money;
									bankBook.after(number, bankFirstBalance);
								}
								break;
							case 3:	//������
								bankBook.afterSaveBankBook(number-1);
								bankBook.afterprint(number);
								System.out.println("Good Bye~");
								op4 = false;
								break;
							}
						}
					}
					break;
				case 2:
					if(bankSecond == personSecond) { //�ι�° ����
						System.out.println("�ܾ�:" + bankBook.callBankSecondFileBalance());
						boolean op4 = true;
						while(op4) {
							System.out.println("1. �Ա�");
							System.out.println("2. ���");
							System.out.println("3. ������");
							System.out.print("����:");
							
							int num3 = Integer.parseInt(sc.nextLine());
							switch(num3) {
							case 1:
								//�Ա�
								System.out.println("�Ա��Ͻ� �ݾ���?");
								int money = Integer.parseInt(sc.nextLine());
								if(money % 10 == 0) {
									bankSecondBalance += money;
									bankBook.after(number, bankSecondBalance);
								}
								else {
									System.out.println("1�������� �Ա��Ͻ� �ݾ��� �Է����ּ���");
									money = Integer.parseInt(sc.nextLine());
									bankSecondBalance += money;
									bankBook.after(number, bankSecondBalance);
								}
								break;
							case 2:
								//���
								System.out.println("����Ͻ� �ݾ���?");
								money = Integer.parseInt(sc.nextLine());
								if(bankSecondBalance - money >= 0) {
									bankSecondBalance -= money;
									bankBook.after(number, bankSecondBalance);
								}
								else {
									System.out.println("����Ͻ� �ݾ��� �ٽ� �Է����ּ���");
									bankSecondBalance -= money;
									bankBook.after(number, bankSecondBalance);
								}
								break;
							case 3:	//������
								bankBook.afterSaveBankBook(number-1);
								bankBook.afterprint(number);
								System.out.println("��~");
								op4 = false;
								break;
							}
						}
					}
					break;
				case 3:
					if(bankThrid == personThrid) { //����° ����
						System.out.println("�ܾ�:" + bankBook.callBankThridFileBalance());
						boolean op4 = true;
						while(op4) {
							System.out.println("1. �Ա�");
							System.out.println("2. ���");
							System.out.println("3. ������");
							System.out.print("����:");
							
							int num3 = Integer.parseInt(sc.nextLine());
							switch(num3) {
							case 1:
								//�Ա�
								System.out.println("�Ա��Ͻ� �ݾ���?");
								int money = Integer.parseInt(sc.nextLine());
								if(money % 10 == 0) {
									bankThridBalance += money;
									bankBook.after(number, bankThridBalance);
								}
								else {
									System.out.println("1�� ������ �Ա��Ͻ� �ݾ��� �Է����ּ���");
									money = Integer.parseInt(sc.nextLine());
									bankThridBalance += money;
									bankBook.after(number, bankThridBalance);
								}
								break;
							case 2:
								//���
								System.out.println("����Ͻ� �ݾ���?");
								money = Integer.parseInt(sc.nextLine());
								if(bankThridBalance - money >= 0) {
									bankThridBalance -= money;
									bankBook.after(number, bankThridBalance);
								}
								else {
									System.out.println("����Ͻ� �ݾ��� �ٽ� �Է����ּ���");
									bankThridBalance -= money;
									bankBook.after(number, bankThridBalance);
								}
								break;
							case 3:	//������
								bankBook.afterSaveBankBook(number-1);
								bankBook.afterprint(number);
								System.out.println("��~");
								op4 = false;
								break;
							}
						}
					}
					break;
				}
				break; //���࿡�� �������� break;
			case 2: //ATM ��������
				InetAddress ip = null;
				Socket soc = null;
				
				try {
					ip = InetAddress.getByName("127.0.0.1");
					soc = new Socket(ip, 33333);
					
					System.out.println("������ �����Ͻÿ�.(1~3)");
					int num5 = Integer.parseInt(sc.nextLine());
					switch(num5) {
					case 1:
						PrintWriter pw1 = new PrintWriter(soc.getOutputStream());
						pw1.println(personFirst);
						
						System.out.println("�ܾ�:" + bankBook.callBankFirstFileBalance());
						System.out.println("1. �Ա�");
						System.out.println("2. ���");
						System.out.println("3. ������");
						System.out.print("����:");
						int num6 = Integer.parseInt(sc.nextLine());
						switch(num6) {
						case 1: //�Ա�
							System.out.println("�Ա��Ͻ� �ݾ���?");
							int money = Integer.parseInt(sc.nextLine());
							if(money % 10 == 0) {
								bankFirstBalance += money;
								pw1.println(bankFirstBalance);
								System.out.println(money + "���� �Ա��ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankFirstBalance + "�� �Դϴ�.");
							}
							else {
								System.out.println("1�������� �Ա��Ͻ� �ݾ��� �Է����ּ���");
								money = Integer.parseInt(sc.nextLine());
								bankFirstBalance += money;
								pw1.println(bankFirstBalance);
								System.out.println(money + "���� �Ա��ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankFirstBalance + "�� �Դϴ�.");
							}							
							break;
						case 2: //���
							System.out.println("����Ͻ� �ݾ���?");
							money = Integer.parseInt(sc.nextLine());
							if(bankFirstBalance - money >= 0) {
								bankFirstBalance -= money;
								pw1.println(bankFirstBalance);
								System.out.println(money + "���� ����ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankFirstBalance + "�� �Դϴ�.");
							}
							else {
								System.out.println("����Ͻ� �ݾ��� �ٽ� �Է����ּ���");
								bankFirstBalance -= money;
								pw1.println(bankFirstBalance);
								System.out.println(money + "���� ����ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankFirstBalance + "�� �Դϴ�.");
							}
							break;
						case 3: //���ư���
							System.out.println("��~");
							break;
						}
						pw1.close();
						break;
					case 2:
						PrintWriter pw2 = new PrintWriter(soc.getOutputStream());
						pw2.println(personSecond);
						
						System.out.println("�ܾ�:" + bankBook.callBankSecondFileBalance());
						System.out.println("1. �Ա�");
						System.out.println("2. ���");
						System.out.println("3. ������");
						System.out.print("����:");
						num6 = Integer.parseInt(sc.nextLine());
						switch(num6) {
						case 1: //�Ա�
							System.out.println("�Ա��Ͻ� �ݾ���?");
							int money = Integer.parseInt(sc.nextLine());
							if(money % 10 == 0) {
								bankSecondBalance += money;
								pw2.println(bankSecondBalance);
								System.out.println(money + "���� �Ա��ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankSecondBalance + "�� �Դϴ�.");
							}
							else {
								System.out.println("10�� �̻� �Ա��Ͻ� �ݾ��� �Է����ּ���");
								money = Integer.parseInt(sc.nextLine());
								bankSecondBalance += money;
								pw2.println(bankSecondBalance);
								System.out.println(money + "���� �Ա��ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankSecondBalance + "�� �Դϴ�.");
							}							
							break;
						case 2: //���
							System.out.println("����Ͻ� �ݾ���?");
							money = Integer.parseInt(sc.nextLine());
							if(bankSecondBalance - money >= 0) {
								bankSecondBalance -= money;
								pw2.println(bankSecondBalance);
								System.out.println(money + "���� ����ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankSecondBalance + "�� �Դϴ�.");
							}
							else {
								System.out.println("����Ͻ� �ݾ��� �ٽ� �Է����ּ���");
								bankSecondBalance -= money;
								pw2.println(bankSecondBalance);
								System.out.println(money + "���� ����ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankSecondBalance + "�� �Դϴ�.");
							}
							break;
						case 3: //������
							System.out.println("��~");
							break;
						}
						pw2.close();
						break;
					case 3:
						PrintWriter pw3 = new PrintWriter(soc.getOutputStream());
						pw3.println(personThrid);
						
						System.out.println("�ܾ�:" + bankBook.callBankThridFileBalance());
						System.out.println("1. �Ա�");
						System.out.println("2. ���");
						System.out.println("3. ������");
						System.out.print("����:");
						num6 = Integer.parseInt(sc.nextLine());
						switch(num6) {
						case 1: //�Ա�
							System.out.println("�Ա��Ͻ� �ݾ���?");
							int money = Integer.parseInt(sc.nextLine());
							if(money % 10 == 0) {
								bankThridBalance += money;
								pw3.println(bankThridBalance);
								System.out.println(money + "���� �Ա��ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankThridBalance + "�� �Դϴ�.");
							}
							else {
								System.out.println("10�� �̻� �Ա��Ͻ� �ݾ��� �Է����ּ���");
								money = Integer.parseInt(sc.nextLine());
								bankThridBalance += money;
								pw3.println(bankThridBalance);
								System.out.println(money + "���� �Ա��ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankThridBalance + "�� �Դϴ�.");
							}							
							break;
						case 2: //���
							System.out.println("����Ͻ� �ݾ���?");
							money = Integer.parseInt(sc.nextLine());
							if(bankThridBalance - money >= 0) {
								bankThridBalance -= money;
								pw3.println(bankThridBalance);
								System.out.println(money + "���� ����ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankThridBalance + "�� �Դϴ�.");
							}
							else {
								System.out.println("����Ͻ� �ݾ��� �ٽ� �Է����ּ���");
								bankThridBalance -= money;
								pw3.println(bankThridBalance);
								System.out.println(money + "���� ����ϼ̽��ϴ�.");
								System.out.println("�ܾ��� " + bankThridBalance + "�� �Դϴ�.");
							}
							break;
						case 3: //���ư���
							System.out.println("��~");
							break;
						}
						pw3.close();
						break;
					}
				} catch (Exception e) {
					System.out.println("Server�� �����ֽ��ϴ�");
				} finally {
					try {
						if(soc != null) soc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break; //ATM �������� break;
			}
			break; //option 'y'�� break;
			
		case 'n':
			System.out.println("�� ���� ������ �����Ͻðڽ��ϱ�?");
			System.out.println("(��, ������ �ִ� 3�������� ������ �� �ֽ��ϴ�)");
			System.out.print("������ ������ ����:");
			int bbcnt = Integer.parseInt(sc.nextLine());
			if(1 <= bbcnt && bbcnt <= 3) {
				while(op) {
					System.out.println("----------------");
					System.out.println("1. ���࿡�� ���尳���ϱ�(N���� ������ ���� �� �������ּ���)");
					System.out.println("2. ����Ȯ��(���� �� ����� �����Ǿ����� �� Ȯ���Ͻÿ�)");
					System.out.println("3. ���࿡�� ��������");
					System.out.println("4. �������� ������ ���ðڽ��ϱ�?");
					System.out.println("5. ������� ��");
					System.out.print("����:");
					int num = Integer.parseInt(sc.nextLine());
					boolean op1 = true;
					switch(num) {
					case 1:
						//���࿡�� ���尳���ϱ�
						if(bankBook.getCnt() < bbcnt) {
							System.out.println("�̸��� �Է����ּ���");
							name = sc.nextLine();
							bankBook.setAccountHolder(name);
							System.out.println("���� ��й�ȣ 4�ڸ��� �Է����ּ��� (1000~9999������ ��й�ȣ�� �����մϴ�");
							password = Integer.parseInt(sc.nextLine());
							if(1000 <= password && password <= 9999) {
								bankBook.setPassword(password);
								bankBook.newBankBook();
								bankBook.setCnt(++cnt);
							}
							else {
								System.out.println("��й�ȣ ���ǿ� ��ġ���� �ʽ��ϴ�.");
							}
							bankBook.saveAccountNum();
							break;
							
						}
						else {
							System.out.println("������ �� �̻� ������ ���մϴ�.");
							break;
						}
					case 2:
						//����Ȯ��
						bankBook.bankBookConfig(bbcnt);
						break;
					case 3:
						//���࿡�� ��������
						while(op1) {
							System.out.println("---------");
							System.out.println("1~3 ���弱��"); //����� ������ ������ ���� ������ 1~3 ����
							System.out.println("4. �ڷΰ���");
							System.out.print("����:");
							
							int num2 = Integer.parseInt(sc.nextLine());
							boolean op2 = true;
							switch(num2) {
							case 1: //1�� ����
								while(op2) {
									System.out.println("---------");
									System.out.println("1. �Ա�");
									System.out.println("2. ���");
									System.out.println("3. �ܾ�Ȯ��(��,��� �� �ݵ�� �ܾ�Ȯ���� ���ּ���)");
									System.out.println("4. ���ư���");
									System.out.print("����:");
									
									int num3 = Integer.parseInt(sc.nextLine());
									switch(num3) {
									case 1:
										//�Ա�
										System.out.println("�Ա��Ͻ� �ݾ���?");
										int money = Integer.parseInt(sc.nextLine());
										bankBook.deposit(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 2:
										//���
										System.out.println("����Ͻ� �ݾ���?");
										money = Integer.parseInt(sc.nextLine());
										bankBook.withdraw(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 3:
										//�ܾ�Ȯ��
										bankBook.selectBankBook(num2, num3);
										break;
									case 4:
										//���ư���
										first = bankBook.getBankBook(num2);
										System.out.println("���ư���");
										op2 = false;
										break;
									}
								}
								break;
							case 2: //2�� ����
								while(op2) {
									System.out.println("---------");
									System.out.println("1. �Ա�");
									System.out.println("2. ���");
									System.out.println("3. �ܾ�Ȯ��(��,��� �� �ݵ�� �ܾ�Ȯ���� ���ּ���)");
									System.out.println("4. ���ư���");
									System.out.print("����:");
									
									int num3 = Integer.parseInt(sc.nextLine());
									switch(num3) {
									case 1:
										//�Ա�
										System.out.println("�Ա��Ͻ� �ݾ���?");
										int money = Integer.parseInt(sc.nextLine());
										bankBook.deposit(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 2:
										//���
										System.out.println("����Ͻ� �ݾ���?");
										money = Integer.parseInt(sc.nextLine());
										bankBook.withdraw(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 3:
										//�ܾ�Ȯ��
										bankBook.selectBankBook(num2, num3);
										break;
									case 4:
										//���ư���
										second = bankBook.getBankBook(num2);
										System.out.println("���ư���");
										op2 = false;
										break;
									}
								}
								break;
							case 3: //3�� ����
								while(op2) {
									System.out.println("---------");
									System.out.println("1. �Ա�");
									System.out.println("2. ���");
									System.out.println("3. �ܾ�Ȯ��(��,��� �� �ݵ�� �ܾ�Ȯ���� ���ּ���)");
									System.out.println("4. ���ư���");
									System.out.print("����:");
									
									int num3 = Integer.parseInt(sc.nextLine());
									switch(num3) {
									case 1:
										//�Ա�
										System.out.println("�Ա��Ͻ� �ݾ���?");
										int money = Integer.parseInt(sc.nextLine());
										bankBook.deposit(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 2:
										//���
										System.out.println("����Ͻ� �ݾ���?");
										money = Integer.parseInt(sc.nextLine());
										bankBook.withdraw(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 3:
										//�ܾ�Ȯ��
										bankBook.selectBankBook(num2, num3);
										break;
									case 4:
										//���ư���
										thrid = bankBook.getBankBook(num2);
										System.out.println("���ư���");
										op2 = false;
										break;
									}
								}
								break;
							case 4:
								op1 = false;
								break;
							}
						}
						break;
					case 4:
						//�������� ������ ���ðڽ��ϱ�?
						System.out.println("�������� �����ڽ��ϱ�?(y/n)");
						char receipt = sc.nextLine().charAt(0);
						switch(receipt) {
						case 'y':
							System.out.println("� ������ �������� ����Ͻðڽ��ϱ�?");
							int recepitNum = Integer.parseInt(sc.nextLine());
							bankBook.printReceipt(recepitNum);
							break;
						case 'n':
							System.out.println("�������� ������� �ʰڽ��ϴ�");
							break;
						}
						break;
					case 5:
						//������� ��
						for(int i=0; i<bbcnt; i++) {
							if(i == 0) {
								try {
									BufferedWriter bw = new BufferedWriter(new FileWriter(PERSONFIRSTFILE));
									bw.write("���¹�ȣ:" + first);
									bw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							else if(i == 1) {
								try {
									BufferedWriter bw = new BufferedWriter(new FileWriter(PERSONSECONDFILE));
									bw.write("���¹�ȣ:" + second);
									bw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							else if(i == 2) {
								try {
									BufferedWriter bw = new BufferedWriter(new FileWriter(PERSONTHRIDFILE));
									bw.write("���¹�ȣ:" + thrid);
									bw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
						bankBook.bankSaveBankBook(bbcnt);
						System.out.println("Good Bye~");
						op = false;
						break;
					}
				}
			}
			else {
				System.out.println("���� 3�������� ������ �� �ֽ��ϴ�!!");
			}
			break; //option 'n'�� break;
		}
	}
}
