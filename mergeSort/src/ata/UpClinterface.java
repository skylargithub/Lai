/**
* JDBC Stored Procedure ATADB.UPCLINTERFACE
*/

package ata;

import java.sql.*;
import java.io.*;


// Program written to extract rows from the Commercial line(CL) tables to create files for the interface areas each night in batch.

public class UpClinterface
{
    public static void upClinterface (String   env,
                                      int[]    SQLCODE,
                                      String[] SQLMessage) throws SQLException, Exception
    {
      Class.forName("com.ibm.db2.jcc.DB2Driver");
       Connection con = DriverManager.getConnection("jdbc:db2://agencyserver2-it.nwideweb.net:50004/ATADB","atajobu","Wa4Vc3Yp");
       // Connection con = DriverManager.getConnection("jdbc:db2://ss028029atadbpt.nwie.net:50004/ATADB","atajobu","Wa4Vc3Yp");
        
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        boolean bFlag;
        String sqlHeader;
        String sqlDetail;
        String SQLUpdateBatch;
        String tracelog = "";


        SQLUpdateBatch = "UPDATE ATADB.TB0100 SET RECORD_STATUS = 'A', UPDATE_TS = CURRENT TIMESTAMP WHERE VALUE_CODE = 'CLBatch' ";

        sqlHeader = "select entry_dt,file_label from atadb.CLTTRAILER WITH UR ";
       
        sqlDetail = "select a.POLICY_LOCATOR,a.POLICY_PREFIXA,a.POLICY_PREFIXB, "+
                     "a.POLICY_NUM,a.POLICY_DEC,a.REC_ALLIED_AGENCY,a.REC_ALLIED_PDCR,a.TRANS_EFFECTIVE_DT, "+
                        "a.FIN_SERV_PROV,a.SERV_SERV_PROV,a.FIN_TPC, a.SERV_TPC,a.PRINT_FLAG,a.FULL_COMMISSION_DT, "+
                        "a.PROCESSOR_USERID,a.CORRECTION_INDIC,a.FIN_AGENT,a.FIN_PDCR "+
                  "from atadb.CLT_INTERFACE a";

        stmt = con.prepareStatement( sqlHeader );
        bFlag = stmt.execute();
        rs1 = stmt.getResultSet();
        stmt2 = con.prepareStatement( SQLUpdateBatch );
        bFlag = stmt2.execute();
        rs3 = stmt2.getResultSet();


        try {

            while (rs1.next()){
               String outFile = "";
               if (env.trim().equals("DEV")){
                   outFile = "/lhome/atajobu/POLICY_TRANSACTIONS/PolSystemTransferTransactions"+rs1.getString(2).substring(0,1).toUpperCase()+rs1.getString(2).substring(1).toLowerCase()+".txt";
               }else{
                   outFile = "C:/CLT/PolSystemTransferTransactions"+rs1.getString(2).substring(0,1).toUpperCase()+rs1.getString(2).substring(1).toLowerCase()+".txt";
               }
               BufferedWriter out = new BufferedWriter(new FileWriter(outFile));

               for (int i=1;i<=39;i++){
                     out.write(" ");
                     }
               out.write(rs1.getString("entry_dt").substring(5,7));
               out.write(rs1.getString("entry_dt").substring(8,10));
               out.write(rs1.getString("entry_dt").substring(0,4));

                     stmt = con.prepareStatement( sqlDetail );
                     bFlag = stmt.execute();
                     rs2 = stmt.getResultSet();
                     while (rs2.next()){
                       out.write("\r\n"); 
                       out.write(rs2.getString("POLICY_LOCATOR"));
                       out.write(rs2.getString("POLICY_PREFIXA"));
                       out.write(rs2.getString("POLICY_PREFIXB"));
                       out.write(rs2.getString("POLICY_NUM"));
                       out.write(rs2.getString("POLICY_DEC"));
                       out.write(rs2.getString("REC_ALLIED_AGENCY"));
                       out.write(rs2.getString("REC_ALLIED_PDCR"));
                       out.write(rs2.getString("TRANS_EFFECTIVE_DT").substring(0,2));
                       out.write(rs2.getString("TRANS_EFFECTIVE_DT").substring(3,5));
                       out.write(rs2.getString("TRANS_EFFECTIVE_DT").substring(6,10));
                       out.write(rs2.getString("FIN_SERV_PROV"));
                       out.write(rs2.getString("SERV_SERV_PROV"));
                       out.write(rs2.getString("FIN_TPC"));                   
                       out.write(rs2.getString("SERV_TPC"));    
                       out.write(rs2.getString("PRINT_FLAG"));    
                       out.write(rs2.getString("FULL_COMMISSION_DT").substring(0,2));
                       out.write(rs2.getString("FULL_COMMISSION_DT").substring(3,5));
                       out.write(rs2.getString("FULL_COMMISSION_DT").substring(6,10));
                       out.write(rs2.getString("PROCESSOR_USERID"));
                       out.write(rs2.getString("CORRECTION_INDIC"));
                       out.write(rs2.getString("FIN_AGENT"));
                       out.write(rs2.getString("FIN_PDCR"));
                       for (int i=1;i<=50;i++){
                          out.write(" ");
                       }
                     }
                     
               out.write("\r\n");
               out.write("99999999\r\n");
               out.close();


               InputStream inStream = new FileInputStream(outFile);
               File bakFile = new File(outFile +".bak");
          
               OutputStream outStream = new FileOutputStream(bakFile);
               
               byte[] buf = new byte[1024];
               int len;
               while ((len = inStream.read(buf)) > 0) {
                  outStream.write(buf, 0, len);
               }
               inStream.close();
               outStream.close();
         }

        }catch (SQLException e){
             SQLCODE[0] = e.getErrorCode();
             SQLMessage[0] =  "SQLException: " + e;
        }catch (Exception ex){
             SQLCODE[0] = 7000;
             SQLMessage[0] = "Exception: " + ex;
        }

        if (rs1 != null) rs1.close();
        if (rs2 != null) rs2.close();
        if (rs3 != null) rs3.close();
        if (stmt != null) stmt.close();

      }
}

