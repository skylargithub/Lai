package ata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Uppcinterface.uppcinterface("IT", new int[5] , new String[5]);
public class Uppcinterface
{
  public static void uppcinterface(String env, int[] SQLCODE, String[] SQLMessage)
    throws SQLException, Exception
  {
	  
	  Class.forName("com.ibm.db2.jcc.DB2Driver");
    Connection con = DriverManager.getConnection("jdbc:db2://agencyserver2-it.nwideweb.net:50004/ATADB","atajobu","Wa4Vc3Yp");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    PreparedStatement stmt1 = null;
    PreparedStatement stmt2 = null;
    PreparedStatement stmt3 = null;
    PreparedStatement stmt4 = null;
    PreparedStatement stmt5 = null;
    PreparedStatement stmt6 = null;

    ResultSet rs2 = null;
    ResultSet rs3 = null;

    ResultSet rs5 = null;
    ResultSet rs6 = null;

    String SQLUpdateBatch_PCAuto = "UPDATE ATADB.TB0100 SET RECORD_STATUS = 'A', UPDATE_TS = CURRENT TIMESTAMP WHERE VALUE_CODE = 'PCAutoBatch' ";
    String SQLUpdateBatch_PCFire = "UPDATE ATADB.TB0100 SET RECORD_STATUS = 'A', UPDATE_TS = CURRENT TIMESTAMP WHERE VALUE_CODE = 'PCFireBatch' ";    
    
    String sqlDetail_PCAuto = "select a.RECORD_ID,a.POLICY_LOCATOR,a.TRANSFER_REQUEST_ID,a.POLICY_RO,a.POLICY_STATE_NUM, a.POLICY_PREFIX,a.POLICY_NUM,a.REC_PDCR_NUM,a.TRANS_EFFECTIVE_DT, a.SERV_SERV_PROV,a.SERV_TPC,a.FULL_COMMISSION_YR_INC,a.REASON_PCOMM_CODE, A.PURCHASE_PERCENT_FLAG,a.PROCESSOR_USERID,a.CORRECTION_INDIC,a.INSERT_TS,a.POLICY_TYPE from atadb.PC_INTERFACE a WHERE a.POLICY_LOCATOR = 'PolicyCenter' AND a.POLICY_TYPE='Auto' WITH UR";

    String sqlDetail_PCFire = "select a.RECORD_ID,a.POLICY_LOCATOR,a.TRANSFER_REQUEST_ID,a.POLICY_RO,a.POLICY_STATE_NUM, a.POLICY_PREFIX,a.POLICY_NUM,a.REC_PDCR_NUM,a.TRANS_EFFECTIVE_DT, a.SERV_SERV_PROV,a.SERV_TPC,a.FULL_COMMISSION_YR_INC,a.REASON_PCOMM_CODE, A.PURCHASE_PERCENT_FLAG,a.PROCESSOR_USERID,a.CORRECTION_INDIC,a.INSERT_TS,a.POLICY_TYPE from atadb.PC_INTERFACE a WHERE a.POLICY_LOCATOR = 'PolicyCenter' AND a.POLICY_TYPE='Fire' WITH UR";

    stmt2 = con.prepareStatement(SQLUpdateBatch_PCAuto);
    boolean bFlag = stmt2.execute();
    rs2 = stmt2.getResultSet();
    String PCAutoOutputFile = null;
    try
    {
      if (env.trim().equals("DEV"))
        PCAutoOutputFile = "/home/atajobu/POLICY_TRANSACTIONS/PolSystemTransferTransactionsPCAuto.txt";
      else {
        PCAutoOutputFile = "C:/CLT/PolSystemTransferTransactionsPCAuto.txt";
      }
      BufferedWriter out = new BufferedWriter(new FileWriter(PCAutoOutputFile, false));

      out.write("H");
      for (int i = 2; i <= 62; i++) {
        out.write(" ");
      }
      out.write(sdf.format(new Date()));
      stmt3 = con.prepareStatement(sqlDetail_PCAuto);
      bFlag = stmt3.execute();
      rs3 = stmt3.getResultSet();
      String transferRequestId = "";
      String transferEffDate = "";
      while (rs3.next()) {
        transferRequestId = "";
        transferEffDate = "";
        out.write("\r\n");
        out.write(rs3.getString("RECORD_ID"));
        out.write(rs3.getString("POLICY_LOCATOR"));
        transferRequestId = rs3.getString("TRANSFER_REQUEST_ID");
        if (transferRequestId.length() != 0) {
          while (20 - transferRequestId.length() != 0) {
            transferRequestId = " " + transferRequestId;
          }
        }
        out.write(transferRequestId);
        out.write(rs3.getString("POLICY_RO"));
        out.write(rs3.getString("POLICY_STATE_NUM"));
        out.write(rs3.getString("POLICY_PREFIX"));
        out.write(rs3.getString("POLICY_NUM"));
        out.write(rs3.getString("REC_PDCR_NUM"));

        transferEffDate = rs3.getString("TRANS_EFFECTIVE_DT");
        String[] splitDate = transferEffDate.split("\\/");
        out.write(splitDate[2] + "-" + splitDate[0] + "-" + splitDate[1]);

        out.write(rs3.getString("SERV_SERV_PROV"));
        out.write(rs3.getString("SERV_TPC"));
        out.write(rs3.getString("FULL_COMMISSION_YR_INC"));
        out.write(rs3.getString("REASON_PCOMM_CODE"));
        out.write(rs3.getString("PURCHASE_PERCENT_FLAG"));
        out.write(rs3.getString("PROCESSOR_USERID"));
        out.write(rs3.getString("CORRECTION_INDIC"));
        for (int i = 1; i <= 50; i++) {
          out.write(" ");
        }
      }

      out.write("\r\n");
      out.write("T");
      for (int i = 2; i <= 62; i++) {
        out.write(" ");
      }
      out.write("9999999999\r\n");
      out.close();

      InputStream inStream = new FileInputStream(PCAutoOutputFile);
      File bakFile = new File(PCAutoOutputFile + ".bak");

      OutputStream outStream = new FileOutputStream(bakFile);

      byte[] buf = new byte[1024];
      int len;
      while ((len = inStream.read(buf)) > 0) {
        outStream.write(buf, 0, len);
      }
      inStream.close();
      outStream.close();

      stmt5 = con.prepareStatement(SQLUpdateBatch_PCFire);
      bFlag = stmt5.execute();
      rs5 = stmt5.getResultSet();
      String PCFireOutputFile = null;

      if (env.trim().equals("DEV"))
        PCFireOutputFile = "/home/atajobu/POLICY_TRANSACTIONS/PolSystemTransferTransactionsPCFire.txt";
      else {
        PCFireOutputFile = "C:/CLT/PolSystemTransferTransactionsPCFire.txt";
      }
      BufferedWriter out1 = new BufferedWriter(new FileWriter(PCFireOutputFile, false));

      out1.write("H");
      for (int i = 2; i <= 62; i++) {
        out1.write(" ");
      }
      out1.write(sdf.format(new Date()));
      stmt6 = con.prepareStatement(sqlDetail_PCFire);
      bFlag = stmt6.execute();
      rs6 = stmt6.getResultSet();
      while (rs6.next()) {
        transferRequestId = "";
        transferEffDate = "";
        out1.write("\r\n");
        out1.write(rs6.getString("RECORD_ID"));
        out1.write(rs6.getString("POLICY_LOCATOR"));
        transferRequestId = rs6.getString("TRANSFER_REQUEST_ID");
        if (transferRequestId.length() != 0) {
          while (20 - transferRequestId.length() != 0) {
            transferRequestId = " " + transferRequestId;
          }
        }
        out1.write(transferRequestId);
        out1.write(rs6.getString("POLICY_RO"));
        out1.write(rs6.getString("POLICY_STATE_NUM"));
        out1.write(rs6.getString("POLICY_PREFIX"));
        out1.write(rs6.getString("POLICY_NUM"));
        out1.write(rs6.getString("REC_PDCR_NUM"));

        transferEffDate = rs6.getString("TRANS_EFFECTIVE_DT");
        String[] splitDate = transferEffDate.split("\\/");
        out1.write(splitDate[2] + "-" + splitDate[0] + "-" + splitDate[1]);

        out1.write(rs6.getString("SERV_SERV_PROV"));
        out1.write(rs6.getString("SERV_TPC"));
        out1.write(rs6.getString("FULL_COMMISSION_YR_INC"));
        out1.write(rs6.getString("REASON_PCOMM_CODE"));
        out1.write(rs6.getString("PURCHASE_PERCENT_FLAG"));
        out1.write(rs6.getString("PROCESSOR_USERID"));
        out1.write(rs6.getString("CORRECTION_INDIC"));
        for (int i = 1; i <= 50; i++) {
          out1.write(" ");
        }
      }

      out1.write("\r\n");
      out1.write("T");
      for (int i = 2; i <= 62; i++) {
        out1.write(" ");
      }
      out1.write("9999999999\r\n");
      out1.close();

      InputStream inStream1 = new FileInputStream(PCFireOutputFile);
      File bakFile1 = new File(PCFireOutputFile + ".bak");

      OutputStream outStream1 = new FileOutputStream(bakFile1);

      byte[] buf1 = new byte[1024];
      int len1;
      while ((len1 = inStream1.read(buf1)) > 0) {
        outStream1.write(buf1, 0, len1);
      }
      inStream1.close();
      outStream1.close();
    }
    catch (SQLException e)
    {
      SQLCODE[0] = e.getErrorCode();
      SQLMessage[0] = ("SQLException: " + e);
    }
    catch (Exception ex) {
      SQLCODE[0] = 7000;
      SQLMessage[0] = ("Exception: " + ex);
    } 

    if (rs2 != null) rs2.close();
    if (rs3 != null) rs3.close();

    if (rs5 != null) rs5.close();
    if (rs6 != null) rs6.close();
    if (stmt1 != null) stmt1.close();
    if (stmt2 != null) stmt2.close();
    if (stmt3 != null) stmt3.close();
    if (stmt4 != null) stmt4.close();
    if (stmt5 != null) stmt5.close();
    if (stmt6 != null) stmt6.close();
  }
}