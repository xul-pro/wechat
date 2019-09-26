package 敏感词库;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Words {
	
	public static void main(String[] args) throws IOException {
		File file = new File("wd.txt");
		/*
		 * 需要进行处理的目标字符串
		 */
		String text="";
		/*
		 * 目标字符串分词后放进的list集合
		 */
		ArrayList<String> target = new ArrayList<String>();
		/**
		 * 需要进行过滤的敏感词集合
		 */
		ArrayList<String> dirty = new ArrayList<String>(); 
		FileToClass01 fileToClass01 = new FileToClass01();
		IKTest ikTest = new IKTest();
		fileToClass01.getDirty(file, dirty);
		ikTest.fenci(text, target);
		/**
		 * 进行选择，把敏感词用*代替
		 */
		for(int i=0;i<target.size();i++) {
			for(int j=0;j<dirty.size();j++) {
				if (target.get(i).equals(dirty.get(j))) {
					target.set(i, "*");
				}
			}
		}
		Iterator<String> iterator = target.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
