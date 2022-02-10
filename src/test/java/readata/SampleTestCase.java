package readata;

import java.io.IOException;
import java.util.ArrayList;

public class SampleTestCase {

	public static void main(String[] args) throws IOException {
		ReadingExcel r=new ReadingExcel();
ArrayList<String> b = r.getData("Add Profile");
for(int i=0;i<b.size();i++) {
	System.out.println(b.get(i));
}
	}

}
