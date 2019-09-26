package 敏感词库;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileToClass01 {
	
	public void  getDirty(File file, ArrayList<String> list) throws IOException {
		BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf8"));
		 String string;
		while ((string=bufferedReader.readLine())!=null) {
			list.add(string);

		}
	}

	


}
