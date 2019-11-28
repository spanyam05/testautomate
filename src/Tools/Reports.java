package Tools;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.TestCaseConfiguration;

public class Reports extends TestCaseConfiguration {
	
	String Loc = "C:\\Users\\ykamisetty\\Desktop\\New folder\\Project\\Reports\\"+getDate()+".html";
	//System.out.println(Loc);
	
	public ExtentReports addTestStep(){	
	ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(Loc);
	//System.out.println(Loc);
	
	
	ExtentReports extentreports = new ExtentReports();
	extentreports.attachReporter(htmlreporter);
	return extentreports;
	}
	
	
	public static String getDate(){
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String date = dateFormat.format(new Date());
		return date;
	}
	
	public String getScreenShot() throws Exception{
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String screenshotname = "C:\\Users\\ykamisetty\\Desktop\\New folder\\Project\\Screenshots\\"+getDate()+".png";
		FileHandler.copy(src, new File(screenshotname));
		
		return screenshotname;
		
	}
	
	public void addPassStep(String testCaseName,String testDescription,String actualResults) throws Exception, Exception{
		ExtentReports extentreports = addTestStep();
		ExtentTest test = extentreports.createTest(testCaseName, testDescription);
		test.pass(actualResults, MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot()).build());
		extentreports.flush();	
	}
	
	public void addFailStep(String testCaseName,String testDescription,String actualResults) throws Exception, Exception{
		ExtentReports extentreports = addTestStep();
		ExtentTest test = extentreports.createTest(testCaseName, testDescription);
		test.fail(actualResults, MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot()).build());
		extentreports.flush();	
	}
	
	public static void main(String[] args) throws Exception{
		//Reports r = new Reports();
		
	}
	
	public void mailGeneration(final String sendfrom, String sendto, String Subject, final String Password) throws Exception{
		
		Properties prop = System.getProperties();
		
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "25");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "25");
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
		
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sendfrom, Password);
			}
		});
		
		try{
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sendfrom));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendto));
			message.setSubject(Subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Test");
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source = new FileDataSource(Loc);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(Loc);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart2);
			message.setContent(multipart);
			Transport.send(message);
			Thread.sleep(6000);
			System.out.println("EmailSent");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		/*Session session = Session.getDefaultInstance(prop);
		MimeMessage msg = new MimeMessage(session);
		InternetAddress fromAddress = new InternetAddress(sendfrom);
		InternetAddress toAddress = new InternetAddress(sendto);
		msg.setFrom(fromAddress);
		msg.addRecipient(Message.RecipientType.TO, toAddress);
		msg.setSubject(Subject);
		BodyPart msgBody = new MimeBodyPart();
		msgBody.setText("This is test report through mail");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(msgBody);
		msgBody = new MimeBodyPart();
		DataSource source = new FileDataSource(Loc);
		DataHandler dataHandler = new DataHandler(source);
		msgBody.setDataHandler(dataHandler);
		msgBody.setFileName(Loc);
		multipart.addBodyPart(msgBody);
		msg.setContent(multipart);
		Transport transport = session.getTransport("smtp");
		transport.connect("pop.gmail.com",995, sendfrom, Password);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
		System.out.println("Mail Sent");*/
		
		
	}

	
	
	
}
