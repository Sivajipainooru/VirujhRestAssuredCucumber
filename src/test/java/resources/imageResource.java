package resources;

import Pojo.imageImage;
import Pojo.textImage;
import Pojo.widgetImage;
import Pojo.windowImage;

public class imageResource {
	public void imagePlace()
	{
		widgetImage w=new widgetImage();
		w.setDebug("on");
		windowImage wi=new windowImage();
		wi.setTitle("Sample Konfabulator Widget");
		wi.setName("main_window");
		wi.setWidth(500);
		wi.setHeight(500);
		imageImage i=new imageImage();
		i.setSrc("Images/Sun.png");
		i.setName("sun1");
		i.sethOffset(250);
		i.setvOffset(250);
		i.setAlignment("center");
		textImage t=new textImage();
		t.setData("Click Here");
		t.setSize(36);
		t.setStyle("bold");
		t.setName("text1");
		t.sethOffset(250);
		t.setvOffset(100);
		t.setAlignment("center");
		t.setOnMouseUp("sun1.opacity = (sun1.opacity / 100) * 90;");
		
	}

}
