package Com.flipcart.ExtendReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//Extent report 5.x...//version

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static Com.flipcart.Base.BaseTest.driver;


public class ExtentReportManager implements ITestListener {
    ExtentSparkReporter extentSparkReporter;
    protected static ExtentReports extentReports;
    protected ExtentTest extentTest;


//    String repName;

    public void onStart(ITestContext testContext) {
//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
//        repName = "Test-Report-" + timeStamp + ".html";
//
//        sparkReporter = new ExtentSparkReporter("C:\\Users\\user\\IdeaProjects\\E-Commerce\\src\\main\\java\\Reports" + repName);// specify location of the report

//        sparkReporter.config().setDocumentTitle("Flipkart Automation Report"); // Title of report
//        sparkReporter.config().setReportName("Flipkart Website Testing"); // name of the report
//        sparkReporter.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Application", "Flipkart");
//        extent.setSystemInfo("Module", "Login");
//        extent.setSystemInfo("Sub Module", "-");
//        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//        extent.setSystemInfo("User Name", System.getProperty("user.name"));
//        extent.setSystemInfo("Environemnt", "QA");

        // Initialize Extent Reports
        extentSparkReporter = new ExtentSparkReporter("./ExtentReportDemo.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        // Set System Information
        extentReports.setSystemInfo("Application", "Flipkart");
        extentReports.setSystemInfo("Module", "Homepage");
        extentReports.setSystemInfo("Sub Module", "-");
        extentReports.setSystemInfo("Os", "Windows10");
        extentReports.setSystemInfo("User", "Admin");
        extentReports.setSystemInfo("Browser", "Chrome");

        // Configure Report Settings
        extentSparkReporter.config().setDocumentTitle("Extent Report Demo");
        extentSparkReporter.config().setReportName("Test_Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MM dd, yyyy, hh:mm a (zzzz)");

    }

    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, "Test Passed");


    }
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }

    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, "Test Failed");
        extentTest.log(Status.FAIL, result.getThrowable().getMessage());

        try {
            String imgPath = captureScreen(result.getName());
            extentTest.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.SKIP, "Test Skipped");
        extentTest.log(Status.SKIP, result.getThrowable().getMessage());
    }
    public void startTest(String testName, String author, String category) {
        // Create a new test in the Extent Report
        extentTest = extentReports.createTest(testName)
                .assignAuthor(author)
                .assignCategory(category)
                .assignDevice("Chrome");
    }

//    public String getScreenshotAsBase64(String name) {
//        String imagePath ="";
//        try {
//            // Capture screenshot
//            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//            // Convert the screenshot to Base64
//            FileInputStream fileInputStream = new FileInputStream(screenshotFile);
//            byte[] bytes = IOUtils.toByteArray(fileInputStream);
//            imagePath = Base64.getEncoder().encodeToString(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return  imagePath;
//    }
}