package org.calculator;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUICalculator extends JFrame {
	
	//	전역 변수 선언
	static JLabel operate;
	static JLabel info;
	static int check_pos = 0;
	static int check_range = 0;
	
	public GUICalculator () {
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 종
		
		// 배치 설정
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5,5));
		c.setBackground(Color.BLACK);
		
		ResultPanel RP = new ResultPanel();
		c.add(RP, BorderLayout.EAST);
		
		NumberPanel NP = new NumberPanel();
		c.add(NP, BorderLayout.SOUTH);

		setSize(500, 600);
		setVisible(true);
	}
	
	//	계산 결과
	class ResultPanel extends JPanel {
		public ResultPanel() {
			setLayout(new GridLayout(3,1));	
			setBackground(Color.BLACK);
			info = new JLabel("수식을 입력하세요 ");
			operate = new JLabel(""); 
			
			info.setFont(new Font("맑은 고딕", 0, 20));		
			info.setBackground(Color.BLACK);
			info.setForeground(Color.WHITE);
			info.setHorizontalAlignment(SwingConstants.RIGHT);
			
			operate.setFont(new Font("맑은 고딕", 0, 40));
			operate.setBackground(Color.BLACK);
			operate.setForeground(Color.WHITE);		
			operate.setHorizontalAlignment(SwingConstants.RIGHT);
			
			add(info); add(operate); 			
			operate.addMouseListener(new MyMouse());
		}
	}
	
	// 결과창에서 연산 삭제
	class MyMouse extends MouseAdapter {
		public void mousePressed(MouseEvent e) {	
			if (e.getClickCount() == 2) {
				check_pos = 0;
				operate.setText(""); 
				info.setText("수식을 입력하세요 ");
			}		
		}
	}

	// 입력 버튼
	class NumberPanel extends JPanel {
		public NumberPanel() {
			// 버튼 정의
			JButton[] bt = new JButton[16];
			setBackground(Color.BLACK);
			setLayout(new GridLayout (4,4,5,5));
			
			bt[0] = new JButton("7");
			bt[1] = new JButton("8");
			bt[2] = new JButton("9");
			bt[3] = new JButton("÷");
			
			bt[4] = new JButton("4");
			bt[5] = new JButton("5");
			bt[6] = new JButton("6");
			bt[7] = new JButton("×");
			
			bt[8] = new JButton("1");
			bt[9] = new JButton("2");
			bt[10] = new JButton("3");
			bt[11] = new JButton("-");
			
			bt[12] = new JButton("C");
			bt[13] = new JButton("0");
			bt[14] = new JButton("=");
			bt[15] = new JButton("+");
			
			for (int i = 0; i <= 15; i++) {
				
				// 숫자 입력
				if (i%4 != 3 && i < 11) {
					bt[i].setFont(new Font("맑은 고딕", 0, 30));
					bt[i].setBackground(Color.WHITE);
					bt[i].setForeground(Color.DARK_GRAY);
					add(bt[i]);
					
					bt[i].addActionListener(new ActionListener () {
						public void actionPerformed(ActionEvent e) {
							// 연산식 작성
							if (check_pos == 0) {
								JButton button = (JButton)e.getSource();
								String oldtext = operate.getText();
								String text = button.getText();
								String newtext = oldtext + text;
								
								// 글자 크기 조절
								int n = newtext.length();
								if (n <= 10) operate.setFont(new Font("맑은 고딕", 0, 40));
								else if (n > 10) operate.setFont(new Font("맑은 고딕", 0, 30));	
								
								// 계산식 길이 제한
								if (n <= 25) {
									operate.setText(newtext);
									info.setText("수식을 계산 중입니다 ");
								}
								else if (n > 25) info.setText("입력 가능한 범위를 초과하였습니다 ");
							}
						}
					});
				}
				
				// C, = 입력
				else if (i == 12 || i == 14) {
					bt[i].setFont(new Font("맑은 고딕", 0, 30));
					bt[i].setBackground(Color.WHITE);
					bt[i].setForeground(Color.ORANGE);
					add(bt[i]);
					
					// C 버튼 이벤트
					bt[12].addActionListener(new ActionListener () {
						public void actionPerformed(ActionEvent e) {
							int n = operate.getText().length()-1;
							
							if (n == 0) {
								operate.setText("");
								info.setText("수식을 입력하세요 ");
								check_pos = 0;
							}						
							else if (n > 0 && n <= 10) {
								operate.setFont(new Font("맑은 고딕", 0, 40));
								operate.setText(operate.getText().substring(0, n));
								info.setText("수식을 지우는 중입니다 ");					
							}						
							else {
								operate.setFont(new Font("맑은 고딕", 0, 35));
								operate.setText(operate.getText().substring(0, n));
								info.setText("수식을 지우는 중입니다 ");
							}
						}
					});
					
					// = 버튼 이벤트
					bt[14].addActionListener(new CalcListener());
				}		
				
				// 연산자 입력
				else if (i % 4 == 3){
					bt[i].setFont(new Font("맑은 고딕", 0, 40));
					bt[i].setBackground(new Color (234,150,72));
					bt[i].setForeground(Color.ORANGE);
					add(bt[i]);				
					bt[i].addActionListener(new OPListener());
				}
				
				// 0 입력
				else if (i == 13) {
					bt[i].setFont(new Font("맑은 고딕", 0, 30));
					bt[i].setBackground(Color.WHITE);
					bt[i].setForeground(Color.DARK_GRAY);
					add(bt[i]);
					bt[i].addActionListener(new OPListener());
				}
			}				
		}
	}

	// 0, 연산자 이벤트
	private class OPListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton now = (JButton)e.getSource();
			int len = operate.getText().length();
			Character front = operate.getText().charAt(len-1);
			// 앞 문자열 판별
			if (check_pos == 0 && front != '+' && front != '-' && front != '×' && front != '÷') {
				String oldtext = operate.getText();
				String text = now.getText();
				String newtext = oldtext + text;
				operate.setText(newtext);
				info.setText("수식을 계산 중입니다 ");
			}		
		}
	}

	// = 연산자 이벤트
	public class CalcListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {		
			String now = operate.getText();
			
			double result = Calculator(now);
			operate.setFont(new Font("맑은 고딕", 0, 40));
			
			if (result < 0) {
				info.setText("양수 범위의 계산만 할 수 있습니다 ");
				operate.setText(Double.toString(result));
				check_pos = 1;
			}	
			else if (result >= 10000000) {
				info.setText("10,000,000 미만의 범위만 계산할 수 있습니다 ");
				operate.setText("0.0");
			}
			else operate.setText(Double.toString(result));					
		}
	}
	
	// 계산
	public double Calculator(String input) {	
		int i;
		double answer;
		check_range = 0;
		ArrayList<Double> value = new ArrayList<Double>();
		ArrayList<String> operation = new ArrayList<String>();
		
		operation.add(null);
		String str = new String("");
		for (i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			String s = Character.toString(c);
			
			if(Character.isDigit(c)) {
				str += Character.toString(c);
				if(i == input.length()-1)
					value.add(Double.parseDouble(str));
			}
			else if (s.equals(".")) str += s;
			else {
				value.add(Double.parseDouble(str));
				operation.add(Character.toString(c));
				str = "";
			}
		}
		
		for(i = 0; i < value.size(); i++) {
			if (value.get(i) >= 10000000) {
				check_range = 1;		
				info.setText("10,000,000 미만의 수끼리만 계산할 수 있습니다 ");
				break;
			}
		}
		
		if (check_range == 0) {			
			for(i = 1; i < value.size(); i++) {
				String s = operation.get(i);
				double tmp;
				
				// 곱셈, 나눗셈 먼저 계산
				if (s.equals("×")) {
					tmp = value.get(i-1) * value.get(i);
					operation.remove(i);
					value.remove(i);
					value.remove(i-1);				
					value.add(i-1, tmp);
					i--;
				}	
				else if (s.equals("÷")) {
					tmp = value.get(i-1) / value.get(i);
					operation.remove(i);
					value.remove(i);
					value.remove(i-1);		
					value.add(i-1, tmp);
					i--;
				}
			}
			
			answer = value.get(0);
			for(i = 1; i < value.size(); i++) {
				String s = operation.get(i);
				double n = value.get(i);
				
				if(s.compareTo("+")==0) answer += n;
				else if(s.compareTo("-")==0) answer -= n;
			}
			
			return answer;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		new GUICalculator();
	}
}