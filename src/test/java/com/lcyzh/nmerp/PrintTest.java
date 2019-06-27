package com.lcyzh.nmerp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JFileChooser;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/25  9:33 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/25    create
 */
public class PrintTest {


    public static void main(String[] args) {
        new PrintTest().print();
    }

    public void print(){
        //创建选择文件弹出框
		/*JFileChooser fileChooser=new JFileChooser();
		//对话框打开时默认盘符
		fileChooser.setCurrentDirectory(new File("e:/"));
		int state=fileChooser.showOpenDialog(null);
		if (state==fileChooser.APPROVE_OPTION) {*/
        //获取选择的文件
//        File file=new File("/Users/lijinku/Documents/picture/1561429066541971.png");
        File file=new File("/Users/lijinku/Documents/123.xlsx");
        //File file=fileChooser.getSelectedFile();
        //构建打印请求属性集
        HashPrintRequestAttributeSet pras=new HashPrintRequestAttributeSet();
        //设置打印格式，AUTOSENSE为任意格式
        DocFlavor flavor=DocFlavor.INPUT_STREAM.AUTOSENSE;
        //查找所有的可用的打印服务
        PrintService printService[]=PrintServiceLookup.lookupPrintServices(flavor, pras);
        //定位默认的打印服务
        PrintService defaultService=PrintServiceLookup.lookupDefaultPrintService();
        //显示默认的打印狂
        PrintService service=ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
        if (service!=null) {
            try {
                DocPrintJob job=service.createPrintJob();//构建打印zuoye
                FileInputStream fis=new FileInputStream(file);//构造待打印文件流
                DocAttributeSet das=new HashDocAttributeSet();
                Doc doc=new SimpleDoc(fis, flavor, das);
                job.print(doc, pras);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}