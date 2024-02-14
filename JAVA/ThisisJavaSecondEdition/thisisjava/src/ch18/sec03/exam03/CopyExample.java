package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) {
		String originalFileName="/Temp/Test.jpg";
		String targetFileName="Temp/Test2.jpg";
		InputStream is=null;
		OutputStream os=null;
		try {
			is = new FileInputStream(originalFileName);
			os = new FileOutputStream(targetFileName);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {

				if(is!=null) is.close();
				if(os!=null) os.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
