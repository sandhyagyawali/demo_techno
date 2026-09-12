
package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterManager implements ITestListener {

    public ExtentSparkReporter sparkReporter; //UI of the report
    public ExtentReports extent; //populate common info on the report (eg : testername , operatingsystemname , testername , environment report...)
    public ExtentTest test; //creating test case entries in the report and update status of the test method

    private String repName;


    @Override  //@Override is a Java annotation. It tells the compiler that this method is overriding (replacing) a method from a parent class or interface.
    public void onStart(ITestContext testContext) {
        // specify location of the report
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName="Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

        sparkReporter.config().setDocumentTitle("Automation Report"); // Tile of report
        sparkReporter.config().setReportName("Functional Testing"); // Name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Passing General information
        extent.setSystemInfo("Computer name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Sandhya");
        extent.setSystemInfo("os","Windows11");
        extent.setSystemInfo("Browser name","Chrome");

    }


    @Override
    public void onTestSuccess(ITestResult result){
        //create a new entry in the report
        test = extent.createTest(result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());//to display group reports
        test.log(Status.PASS,result.getName()+ " get successfully executed.");
    }

    @Override
    public void onTestFailure(ITestResult result){
        test = extent.createTest(result.getTestClass().getName() + " -- " +result.getMethod().getMethodName()); //Create test entry in report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL,result.getName() + "got failed."); //Log failure status
        test.log(Status.INFO,result.getThrowable().getMessage()); //Log Error Messgae

    }

    @Override
    public void onTestSkipped(ITestResult result){
        test = extent.createTest(result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName()+ "got skipped");
        test.log(Status.INFO,result.getThrowable().getMessage());
    }


    @Override
    public void onFinish(ITestContext testContext) {

        // Flush report
        extent.flush();

        // Get correct report file path directly from sparkReporter
        String reportPath = sparkReporter.getFile().getAbsolutePath();

        System.out.println("Report Path: " + reportPath);

        File reportFile = new File(reportPath);

        System.out.println(reportFile.getAbsolutePath());
        System.out.println(reportFile.exists());
        try {
            if (reportFile.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(reportFile.getCanonicalFile().toURI());
            }
        } catch (Exception e) {
            System.out.println("Could not open report in browser: " + e.getMessage());
        }
    }
}
