package UtilityLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;

public class screenshot extends BaseClass{
		
public static String Screenshot(String FolderName) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	SimpleDateFormat s=new SimpleDateFormat("ddMMyyyy_HHmmss");
	String date=s.format(new Date());
	String ActualDate=new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
			File dest=new File(System.getProperty("user.dir")+"\\FolderName\\"+ActualDate+".png");
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return date;

}
}
