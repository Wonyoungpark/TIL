package ex0219.multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientChatGUIExam extends JFrame {
	JTextArea textArea = new JTextArea();
	JScrollPane jsp= new JScrollPane(textArea);
	
	JTextField textField = new JTextField();
	
	Socket sk;
	BufferedReader br;
	PrintWriter pw;
	
    public ClientChatGUIExam() {
    	super("채팅창");
    	
    	Container con = super.getContentPane();
    	con.add(jsp , BorderLayout.CENTER);
    	con.add(textField, BorderLayout.SOUTH);
    	
    	//옵션 설정
    	textArea.setFocusable(false);
    	textArea.setBackground(Color.CYAN);
    	
    	setSize(400, 300);
    	setLocationRelativeTo(null);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	
    	//서버에 접속
    	this.connection();
    	
    	// 서버가 보내주는 데이터를 받아서 textArea에 출력하는 스레드
    	Thread th = new Thread(()->{ //익명 구현 객체
    		try {
	    		String data=null;
	    		while((data = br.readLine())!=null) { //서버가 보낸 메시지
	    			textArea.append(data+"\n"); //서버가 보낸 데이터를 JTextArea 영역에 추가
	    			
	    			//스크롤이 마지막글자가 있는 위치로 이동시키기
	    			textArea.setCaretPosition( textArea.getText().length() );
	    		}
    		}catch (Exception e) {
				e.printStackTrace();
			}
    	});
    	
    	th.setDaemon(true);//메인스레드가 종료되면 함께 종료된다.
    	th.start();
    	
    	
    	//이벤트 등록 ( textField에 엔터...)
		// Thread가 아닌 EventHandler이다.
    	textField.addActionListener((e)->{ //new ActionListener(event)를 람다식으로 작성
    		//textField의 값을 읽어서 서버에게 전송한다. 
    		String inputData = textField.getText();
    		pw.println(inputData);
    		
    		//textField의 값을 지운다.
    		textField.setText("");
    	});
    	
    }//생성자 끝
    
    /**
     * 채팅을 위한 서버에 접속기능
     * */
    public void connection() {
    	 try {
    		sk = new Socket("127.0.0.1" , 8001);
//    		sk = new Socket("192.168.0.22" , 8000);
    		br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
    		pw = new PrintWriter(sk.getOutputStream(), true);
    		
    		//대화명입력 창을 띄운다.
    		String name = JOptionPane.showInputDialog(this, "대화명을 입력해주세요.");
    		
    		//서버에게 대화명을 전송한다.
    		pw.println(name);
    		
    		setTitle("[ " + name +" ] "); //JFrame 창에 대화명 출력
    		 
    	 }catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
	public static void main(String[] args) {
		new ClientChatGUIExam();

	}

}


