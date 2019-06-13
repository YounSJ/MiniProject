package miniProject;

import java.io.*;
import java.net.*;
import java.util.*;

public class Person { //주체는 나	
	public static final String PERSONFIRSTFILE = "F:\\work\\test\\personFirstBankBook.txt";
	public static final String PERSONSECONDFILE = "F:\\work\\test\\personSecondBankBook.txt";
	public static final String PERSONTHRIDFILE = "F:\\work\\test\\personThridBankBook.txt";
	
	public static int callPersonFirstFile() { //파일 불러오기
		//첫번째 통장
		int firstBankBookNum = 0;
		
		File file1 = new File(PERSONFIRSTFILE);
		if(file1.exists()) {
			try {
				BufferedReader firstFile = new BufferedReader(new FileReader(PERSONFIRSTFILE));
				
				String str1 = firstFile.readLine();
				String result1 = str1.substring(5); //계좌번호 불러오기
				firstBankBookNum = Integer.parseInt(result1);
				
				firstFile.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return firstBankBookNum;
	}
	
	public static int callPersonSecondFile() {
		//두번째 통장
		int secondBankBookNum = 0;
		
		File file2 = new File(PERSONSECONDFILE);
		if(file2.exists()) {
			try {
				BufferedReader secondFile = new BufferedReader(new FileReader(PERSONSECONDFILE));
				
				String str2 = secondFile.readLine();
				String result2 = str2.substring(5); //계좌번호 불러오기
				secondBankBookNum = Integer.parseInt(result2);
				
				secondFile.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return secondBankBookNum;
	}
	
	public static int callPersonThridFile() {
		//세번째 통장
		int thridBankBookNum = 0;
		File file3 = new File(PERSONTHRIDFILE);
		if(file3.exists()) {
			try {
				BufferedReader thridFile = new BufferedReader(new FileReader(PERSONTHRIDFILE));
				String str3 = thridFile.readLine();
				String result3 = str3.substring(5); //계좌번호 불러오기
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
		
		System.out.println("통장을 가지고 있습니까?(y/n)");
		char option = sc.nextLine().charAt(0);
		switch(option) {
		case 'y':
			//파일을 불러와야됨
			int bankFirst = bankBook.callBankFirstFile();
			int bankFirstBalance = bankBook.callBankFirstFileBalance();
			int personFirst = callPersonFirstFile();
			int bankSecond = bankBook.callBankSecondFile();
			int bankSecondBalance = bankBook.callBankSecondFileBalance();
			int personSecond = callPersonSecondFile();
			int bankThrid = bankBook.callBankThridFile();
			int bankThridBalance = bankBook.callBankThridFileBalance();
			int personThrid = callPersonThridFile();

			System.out.println("1. 은행에서 업무보기");
			System.out.println("2. ATM 업무보기");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1: //은행에서 업무보기
				System.out.println("통장을 선택하시오.(1~3)");
				int number = Integer.parseInt(sc.nextLine());
				switch(number) {
				case 1:
					if(bankFirst == personFirst) { //첫번째 통장
						System.out.println("잔액:" + bankBook.callBankFirstFileBalance());
						boolean op4 = true;
						while(op4) {
							System.out.println("1. 입금");
							System.out.println("2. 출금");
							System.out.println("3. 끝내기");
							System.out.print("선택:");
							
							int num3 = Integer.parseInt(sc.nextLine());
							switch(num3) {
							case 1:
								//입금
								System.out.println("입금하실 금액은?");
								int money = Integer.parseInt(sc.nextLine());
								if(money % 10 == 0) {
									bankFirstBalance += money;
									bankBook.after(number, bankFirstBalance);
								}
								else {
									System.out.println("1원단위는 입금하실 금액을 입력해주세요");
									money = Integer.parseInt(sc.nextLine());
									bankFirstBalance += money;
									bankBook.after(number, bankFirstBalance);
								}
								break;
							case 2:
								//출금
								System.out.println("출금하실 금액은?");
								money = Integer.parseInt(sc.nextLine());
								if(bankFirstBalance - money >= 0) {
									bankFirstBalance -= money;
									bankBook.after(number, bankFirstBalance);
								}
								else {
									System.out.println("출금하실 금액을 다시 입력해주세요");
									bankFirstBalance -= money;
									bankBook.after(number, bankFirstBalance);
								}
								break;
							case 3:	//끝내기
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
					if(bankSecond == personSecond) { //두번째 통장
						System.out.println("잔액:" + bankBook.callBankSecondFileBalance());
						boolean op4 = true;
						while(op4) {
							System.out.println("1. 입금");
							System.out.println("2. 출금");
							System.out.println("3. 끝내기");
							System.out.print("선택:");
							
							int num3 = Integer.parseInt(sc.nextLine());
							switch(num3) {
							case 1:
								//입금
								System.out.println("입금하실 금액은?");
								int money = Integer.parseInt(sc.nextLine());
								if(money % 10 == 0) {
									bankSecondBalance += money;
									bankBook.after(number, bankSecondBalance);
								}
								else {
									System.out.println("1원단위는 입금하실 금액을 입력해주세요");
									money = Integer.parseInt(sc.nextLine());
									bankSecondBalance += money;
									bankBook.after(number, bankSecondBalance);
								}
								break;
							case 2:
								//출금
								System.out.println("출금하실 금액은?");
								money = Integer.parseInt(sc.nextLine());
								if(bankSecondBalance - money >= 0) {
									bankSecondBalance -= money;
									bankBook.after(number, bankSecondBalance);
								}
								else {
									System.out.println("출금하실 금액을 다시 입력해주세요");
									bankSecondBalance -= money;
									bankBook.after(number, bankSecondBalance);
								}
								break;
							case 3:	//끝내기
								bankBook.afterSaveBankBook(number-1);
								bankBook.afterprint(number);
								System.out.println("끝~");
								op4 = false;
								break;
							}
						}
					}
					break;
				case 3:
					if(bankThrid == personThrid) { //세번째 통장
						System.out.println("잔액:" + bankBook.callBankThridFileBalance());
						boolean op4 = true;
						while(op4) {
							System.out.println("1. 입금");
							System.out.println("2. 출금");
							System.out.println("3. 끝내기");
							System.out.print("선택:");
							
							int num3 = Integer.parseInt(sc.nextLine());
							switch(num3) {
							case 1:
								//입금
								System.out.println("입금하실 금액은?");
								int money = Integer.parseInt(sc.nextLine());
								if(money % 10 == 0) {
									bankThridBalance += money;
									bankBook.after(number, bankThridBalance);
								}
								else {
									System.out.println("1원 단위는 입금하실 금액을 입력해주세요");
									money = Integer.parseInt(sc.nextLine());
									bankThridBalance += money;
									bankBook.after(number, bankThridBalance);
								}
								break;
							case 2:
								//출금
								System.out.println("출금하실 금액은?");
								money = Integer.parseInt(sc.nextLine());
								if(bankThridBalance - money >= 0) {
									bankThridBalance -= money;
									bankBook.after(number, bankThridBalance);
								}
								else {
									System.out.println("출금하실 금액을 다시 입력해주세요");
									bankThridBalance -= money;
									bankBook.after(number, bankThridBalance);
								}
								break;
							case 3:	//끝내기
								bankBook.afterSaveBankBook(number-1);
								bankBook.afterprint(number);
								System.out.println("끝~");
								op4 = false;
								break;
							}
						}
					}
					break;
				}
				break; //은행에서 업무보기 break;
			case 2: //ATM 업무보기
				InetAddress ip = null;
				Socket soc = null;
				
				try {
					ip = InetAddress.getByName("127.0.0.1");
					soc = new Socket(ip, 33333);
					
					System.out.println("통장을 선택하시오.(1~3)");
					int num5 = Integer.parseInt(sc.nextLine());
					switch(num5) {
					case 1:
						PrintWriter pw1 = new PrintWriter(soc.getOutputStream());
						pw1.println(personFirst);
						
						System.out.println("잔액:" + bankBook.callBankFirstFileBalance());
						System.out.println("1. 입금");
						System.out.println("2. 출금");
						System.out.println("3. 끝내기");
						System.out.print("선택:");
						int num6 = Integer.parseInt(sc.nextLine());
						switch(num6) {
						case 1: //입금
							System.out.println("입금하실 금액은?");
							int money = Integer.parseInt(sc.nextLine());
							if(money % 10 == 0) {
								bankFirstBalance += money;
								pw1.println(bankFirstBalance);
								System.out.println(money + "원을 입금하셨습니다.");
								System.out.println("잔액은 " + bankFirstBalance + "원 입니다.");
							}
							else {
								System.out.println("1원단위는 입금하실 금액을 입력해주세요");
								money = Integer.parseInt(sc.nextLine());
								bankFirstBalance += money;
								pw1.println(bankFirstBalance);
								System.out.println(money + "원을 입금하셨습니다.");
								System.out.println("잔액은 " + bankFirstBalance + "원 입니다.");
							}							
							break;
						case 2: //출금
							System.out.println("출금하실 금액은?");
							money = Integer.parseInt(sc.nextLine());
							if(bankFirstBalance - money >= 0) {
								bankFirstBalance -= money;
								pw1.println(bankFirstBalance);
								System.out.println(money + "원을 출금하셨습니다.");
								System.out.println("잔액은 " + bankFirstBalance + "원 입니다.");
							}
							else {
								System.out.println("출금하실 금액을 다시 입력해주세요");
								bankFirstBalance -= money;
								pw1.println(bankFirstBalance);
								System.out.println(money + "원을 출금하셨습니다.");
								System.out.println("잔액은 " + bankFirstBalance + "원 입니다.");
							}
							break;
						case 3: //돌아가기
							System.out.println("끝~");
							break;
						}
						pw1.close();
						break;
					case 2:
						PrintWriter pw2 = new PrintWriter(soc.getOutputStream());
						pw2.println(personSecond);
						
						System.out.println("잔액:" + bankBook.callBankSecondFileBalance());
						System.out.println("1. 입금");
						System.out.println("2. 출금");
						System.out.println("3. 끝내기");
						System.out.print("선택:");
						num6 = Integer.parseInt(sc.nextLine());
						switch(num6) {
						case 1: //입금
							System.out.println("입금하실 금액은?");
							int money = Integer.parseInt(sc.nextLine());
							if(money % 10 == 0) {
								bankSecondBalance += money;
								pw2.println(bankSecondBalance);
								System.out.println(money + "원을 입금하셨습니다.");
								System.out.println("잔액은 " + bankSecondBalance + "원 입니다.");
							}
							else {
								System.out.println("10원 이상 입금하실 금액을 입력해주세요");
								money = Integer.parseInt(sc.nextLine());
								bankSecondBalance += money;
								pw2.println(bankSecondBalance);
								System.out.println(money + "원을 입금하셨습니다.");
								System.out.println("잔액은 " + bankSecondBalance + "원 입니다.");
							}							
							break;
						case 2: //출금
							System.out.println("출금하실 금액은?");
							money = Integer.parseInt(sc.nextLine());
							if(bankSecondBalance - money >= 0) {
								bankSecondBalance -= money;
								pw2.println(bankSecondBalance);
								System.out.println(money + "원을 출금하셨습니다.");
								System.out.println("잔액은 " + bankSecondBalance + "원 입니다.");
							}
							else {
								System.out.println("출금하실 금액을 다시 입력해주세요");
								bankSecondBalance -= money;
								pw2.println(bankSecondBalance);
								System.out.println(money + "원을 출금하셨습니다.");
								System.out.println("잔액은 " + bankSecondBalance + "원 입니다.");
							}
							break;
						case 3: //끝내기
							System.out.println("끝~");
							break;
						}
						pw2.close();
						break;
					case 3:
						PrintWriter pw3 = new PrintWriter(soc.getOutputStream());
						pw3.println(personThrid);
						
						System.out.println("잔액:" + bankBook.callBankThridFileBalance());
						System.out.println("1. 입금");
						System.out.println("2. 출금");
						System.out.println("3. 끝내기");
						System.out.print("선택:");
						num6 = Integer.parseInt(sc.nextLine());
						switch(num6) {
						case 1: //입금
							System.out.println("입금하실 금액은?");
							int money = Integer.parseInt(sc.nextLine());
							if(money % 10 == 0) {
								bankThridBalance += money;
								pw3.println(bankThridBalance);
								System.out.println(money + "원을 입금하셨습니다.");
								System.out.println("잔액은 " + bankThridBalance + "원 입니다.");
							}
							else {
								System.out.println("10원 이상 입금하실 금액을 입력해주세요");
								money = Integer.parseInt(sc.nextLine());
								bankThridBalance += money;
								pw3.println(bankThridBalance);
								System.out.println(money + "원을 입금하셨습니다.");
								System.out.println("잔액은 " + bankThridBalance + "원 입니다.");
							}							
							break;
						case 2: //출금
							System.out.println("출금하실 금액은?");
							money = Integer.parseInt(sc.nextLine());
							if(bankThridBalance - money >= 0) {
								bankThridBalance -= money;
								pw3.println(bankThridBalance);
								System.out.println(money + "원을 출금하셨습니다.");
								System.out.println("잔액은 " + bankThridBalance + "원 입니다.");
							}
							else {
								System.out.println("출금하실 금액을 다시 입력해주세요");
								bankThridBalance -= money;
								pw3.println(bankThridBalance);
								System.out.println(money + "원을 출금하셨습니다.");
								System.out.println("잔액은 " + bankThridBalance + "원 입니다.");
							}
							break;
						case 3: //돌아가기
							System.out.println("끝~");
							break;
						}
						pw3.close();
						break;
					}
				} catch (Exception e) {
					System.out.println("Server가 닫혀있습니다");
				} finally {
					try {
						if(soc != null) soc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break; //ATM 업무보기 break;
			}
			break; //option 'y'의 break;
			
		case 'n':
			System.out.println("몇 개의 통장을 개설하시겠습니까?");
			System.out.println("(단, 통장은 최대 3개까지만 개설할 수 있습니다)");
			System.out.print("개설할 통장의 개수:");
			int bbcnt = Integer.parseInt(sc.nextLine());
			if(1 <= bbcnt && bbcnt <= 3) {
				while(op) {
					System.out.println("----------------");
					System.out.println("1. 은행에서 통장개설하기(N개의 통장을 먼저 다 개설해주세요)");
					System.out.println("2. 통장확인(개설 후 제대로 개설되었는지 꼭 확인하시오)");
					System.out.println("3. 은행에서 업무보기");
					System.out.println("4. 영수증을 가지고 가시겠습니까?");
					System.out.println("5. 은행업무 끝");
					System.out.print("선택:");
					int num = Integer.parseInt(sc.nextLine());
					boolean op1 = true;
					switch(num) {
					case 1:
						//은행에서 통장개설하기
						if(bankBook.getCnt() < bbcnt) {
							System.out.println("이름을 입력해주세요");
							name = sc.nextLine();
							bankBook.setAccountHolder(name);
							System.out.println("통장 비밀번호 4자리를 입력해주세요 (1000~9999사이의 비밀번호만 가능합니다");
							password = Integer.parseInt(sc.nextLine());
							if(1000 <= password && password <= 9999) {
								bankBook.setPassword(password);
								bankBook.newBankBook();
								bankBook.setCnt(++cnt);
							}
							else {
								System.out.println("비밀번호 조건에 일치하지 않습니다.");
							}
							bankBook.saveAccountNum();
							break;
							
						}
						else {
							System.out.println("통장을 더 이상 만들지 못합니다.");
							break;
						}
					case 2:
						//통장확인
						bankBook.bankBookConfig(bbcnt);
						break;
					case 3:
						//은행에서 업무보기
						while(op1) {
							System.out.println("---------");
							System.out.println("1~3 통장선택"); //사람은 통장을 본인이 고르기 때문에 1~3 선택
							System.out.println("4. 뒤로가기");
							System.out.print("선택:");
							
							int num2 = Integer.parseInt(sc.nextLine());
							boolean op2 = true;
							switch(num2) {
							case 1: //1번 계좌
								while(op2) {
									System.out.println("---------");
									System.out.println("1. 입금");
									System.out.println("2. 출금");
									System.out.println("3. 잔액확인(입,출금 후 반드시 잔액확인을 해주세요)");
									System.out.println("4. 돌아가기");
									System.out.print("선택:");
									
									int num3 = Integer.parseInt(sc.nextLine());
									switch(num3) {
									case 1:
										//입금
										System.out.println("입금하실 금액은?");
										int money = Integer.parseInt(sc.nextLine());
										bankBook.deposit(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 2:
										//출금
										System.out.println("출금하실 금액은?");
										money = Integer.parseInt(sc.nextLine());
										bankBook.withdraw(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 3:
										//잔액확인
										bankBook.selectBankBook(num2, num3);
										break;
									case 4:
										//돌아가기
										first = bankBook.getBankBook(num2);
										System.out.println("돌아가기");
										op2 = false;
										break;
									}
								}
								break;
							case 2: //2번 계좌
								while(op2) {
									System.out.println("---------");
									System.out.println("1. 입금");
									System.out.println("2. 출금");
									System.out.println("3. 잔액확인(입,출금 후 반드시 잔액확인을 해주세요)");
									System.out.println("4. 돌아가기");
									System.out.print("선택:");
									
									int num3 = Integer.parseInt(sc.nextLine());
									switch(num3) {
									case 1:
										//입금
										System.out.println("입금하실 금액은?");
										int money = Integer.parseInt(sc.nextLine());
										bankBook.deposit(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 2:
										//출금
										System.out.println("출금하실 금액은?");
										money = Integer.parseInt(sc.nextLine());
										bankBook.withdraw(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 3:
										//잔액확인
										bankBook.selectBankBook(num2, num3);
										break;
									case 4:
										//돌아가기
										second = bankBook.getBankBook(num2);
										System.out.println("돌아가기");
										op2 = false;
										break;
									}
								}
								break;
							case 3: //3번 계좌
								while(op2) {
									System.out.println("---------");
									System.out.println("1. 입금");
									System.out.println("2. 출금");
									System.out.println("3. 잔액확인(입,출금 후 반드시 잔액확인을 해주세요)");
									System.out.println("4. 돌아가기");
									System.out.print("선택:");
									
									int num3 = Integer.parseInt(sc.nextLine());
									switch(num3) {
									case 1:
										//입금
										System.out.println("입금하실 금액은?");
										int money = Integer.parseInt(sc.nextLine());
										bankBook.deposit(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 2:
										//출금
										System.out.println("출금하실 금액은?");
										money = Integer.parseInt(sc.nextLine());
										bankBook.withdraw(num2, money);
										bankBook.selectBankBook(num2, num3);
										break;
									case 3:
										//잔액확인
										bankBook.selectBankBook(num2, num3);
										break;
									case 4:
										//돌아가기
										thrid = bankBook.getBankBook(num2);
										System.out.println("돌아가기");
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
						//영수증을 가지고 가시겠습니까?
						System.out.println("영수증을 가지겠습니까?(y/n)");
						char receipt = sc.nextLine().charAt(0);
						switch(receipt) {
						case 'y':
							System.out.println("어떤 계좌의 영수증을 출력하시겠습니까?");
							int recepitNum = Integer.parseInt(sc.nextLine());
							bankBook.printReceipt(recepitNum);
							break;
						case 'n':
							System.out.println("영수증을 출력하지 않겠습니다");
							break;
						}
						break;
					case 5:
						//은행업무 끝
						for(int i=0; i<bbcnt; i++) {
							if(i == 0) {
								try {
									BufferedWriter bw = new BufferedWriter(new FileWriter(PERSONFIRSTFILE));
									bw.write("계좌번호:" + first);
									bw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							else if(i == 1) {
								try {
									BufferedWriter bw = new BufferedWriter(new FileWriter(PERSONSECONDFILE));
									bw.write("계좌번호:" + second);
									bw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							else if(i == 2) {
								try {
									BufferedWriter bw = new BufferedWriter(new FileWriter(PERSONTHRIDFILE));
									bw.write("계좌번호:" + thrid);
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
				System.out.println("통장 3개까지만 개설할 수 있습니다!!");
			}
			break; //option 'n'의 break;
		}
	}
}
