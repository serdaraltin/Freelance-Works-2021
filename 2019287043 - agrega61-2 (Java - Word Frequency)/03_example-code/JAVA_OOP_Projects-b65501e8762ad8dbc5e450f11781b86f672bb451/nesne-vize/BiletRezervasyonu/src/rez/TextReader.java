package rez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextReader {

	public List<String> readText(String newFile, String format) throws IOException
	{
		File dir = new File(newFile);
		File[] files = dir.listFiles();
		String sentences="";
		
        for (File file : files) {
            if(file.isFile()) {
                BufferedReader inputStream =new BufferedReader(new InputStreamReader(new FileInputStream(file),format));
                String line;
                try {
                    
                    while ((line = inputStream.readLine()) != null) {
                        sentences+= line;
                    }
                }catch(IOException e) {
                	System.out.println(e);
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
        String word = "";
        List<String> rValue= new ArrayList<String>();
        for (char letter:sentences.toCharArray())
        {
        	if(letter!=',')
        		word+=letter;
        	else
        	{
        		rValue.add(word);
        		word="";
        	}
        }
        return rValue;
	}
}
