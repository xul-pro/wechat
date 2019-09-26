package 敏感词库;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKTest {
	
	public void fenci(String text,ArrayList<String> list) throws IOException {
	 	StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re,true);
        String string;
        Lexeme lex = null;
        while((lex=ik.next())!=null){
        	list.add(lex.getLexemeText());
        }
	}
}
