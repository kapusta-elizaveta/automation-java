package executionEngine;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class DriverScript {

    public static Properties OR;
    public static ActionKeywords actionKeywords;
    public static String sActionKeyword;
    public static String sPageObject;
    public static Method method[];

    public static int iTestStep;
    public static int iTestLastStep;
    public static String sTestCaseID;
    public static String sRunMode;

    public DriverScript() throws NoSuchMethodException, SecurityException{
        actionKeywords = new ActionKeywords();
        method = actionKeywords.getClass().getMethods();
    }

    public static void main(String[] args) throws Exception {
        ExcelUtils.setExcelFile(Constants.Path_TestData);

        String Path_OR = Constants.Path_OR;
        FileInputStream fs = new FileInputStream(Path_OR);
        OR= new Properties(System.getProperties());
        OR.load(fs);

        DriverScript startEngine = new DriverScript();
        startEngine.execute_TestCase();
    }

    private void execute_TestCase() throws Exception {
        //This will return the total number of test cases mentioned in the Test cases sheet
        int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
        //This loop will execute number of times equal to Total number of test cases
        for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++){
            //This is to get the Test case name from the Test Cases sheet
            sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
            //This is to get the value of the Run Mode column for the current test case
            sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
            //This is the condition statement on RunMode value
            if (sRunMode.equals("Yes")){
                //Only if the value of Run Mode is 'Yes', this part of code will execute
                iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
                iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
                //This loop will execute number of times equal to Total number of test steps
                for (;iTestStep<=iTestLastStep;iTestStep++){
                    sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);
                    sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
                    execute_Actions();
                }
            }
        }
    }

    private static void execute_Actions() throws Exception {

        for(int i=0;i<method.length;i++){
            if(method[i].getName().equals(sActionKeyword)){
                method[i].invoke(actionKeywords,sPageObject);
                break;
            }
        }
    }
}
