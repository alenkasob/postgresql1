import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

/**
 * Created by Krasitka on 18.03.2018.
 */
public class Checks {
    private String ID   ;
    private String  HD_ID   ;
   /* CHECK_DATE                       TIMESTAMP,
    CHECK_NUM                        EAN13  EAN13 = VARCHAR(13) ,
    CHECK_CLIENT_ID                  ID  ID = VARCHAR(32) ,
    CHECK_CLIENT_CODE_NAME           NAME_LONG  NAME_LONG = VARCHAR(120) ,
    CHECK_SUBDIVISION_ID             ID ID = VARCHAR(32) ,
    CHECK_SUBDIVISION_NAME           NAME  NAME = VARCHAR(64) ,
    CHECK_AGENT_ID                   ID  ID = VARCHAR(32) ,
    CHECK_AGENT_CODE_NAME            NAME_LONG  NAME_LONG = VARCHAR(120) ,
    CHECK_PAYER_ORG_ID               ID  ID = VARCHAR(32) ,
    CHECK_PAYER_ORG_CODE_NAME        NAME_LONG  NAME_LONG = VARCHAR(120) */

   private String GOODS_ID ;

   /* GOODS_NAME                       NAME_LARGE /* NAME_LARGE = VARCHAR(240)
    GOODS_GRP_NAME                   NAME_LONG /* NAME_LONG = VARCHAR(120) ,
    GOODS_ORDER                      IS_ /* IS_ = INTEGER ,
    UNIT_ID                          ID /* ID = VARCHAR(32) ,
    MATERIAL_ID                      ID /* ID = VARCHAR(32) ,
    BARCODE_GEN_ID                   BIGINT,
    BULB_NUM_ID                      ID /* ID = VARCHAR(32) ,
    BLANK_ID                         ID /* ID = VARCHAR(32) ,
    BULB_NUM_CODE                    EAN13 /* EAN13 = VARCHAR(13) ,
    IS_EAN8                          IS_ DEFAULT 0 /* IS_ = INTEGER ,
    IS_REMARKED_DATE_TIME            TIMESTAMP,
    REMARKED_EMPLOYEE_ID             ID /* ID = VARCHAR(32) ,
    REMARKER_EMPLOYEE_CODE_NAME      NAME_LONG /* NAME_LONG = VARCHAR(120) */

    public Checks(String ID, String HD_ID, String GOODS_ID, int CNT) {
        this.ID = ID;
        this.HD_ID = HD_ID;
        this.GOODS_ID = GOODS_ID;
        this.CNT = CNT;
    }

    public Checks() {

    }

    public String getID() {

        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHD_ID() {
        return HD_ID;
    }

    public void setHD_ID(String HD_ID) {
        this.HD_ID = HD_ID;
    }

    public String getGOODS_ID() {
        return GOODS_ID;
    }

    public void setGOODS_ID(String GOODS_ID) {
        this.GOODS_ID = GOODS_ID;
    }

    public int getCNT() {
        return CNT;
    }

    public void setCNT(int CNT) {
        this.CNT = CNT;
    }

    private int CNT    ;                       /*  CNT DEFAULT 1 NOT NULL /* CNT = NUMERIC(18,6) ,
    PRICE_BASE                       PRICE DEFAULT 0 /* PRICE = NUMERIC(18,2) ,
    PRICE                            PRICE DEFAULT 0 /* PRICE = NUMERIC(18,2) ,
    SUM_BASE                         PRICE DEFAULT 0 /* PRICE = NUMERIC(18,2) ,
    SUM_                             PRICE DEFAULT 0 /* PRICE = NUMERIC(18,2) ,
    SUBDIVISION_EXEC_ID              ID /* ID = VARCHAR(32) ,
    SUBDIVISION_EXEC_NAME            NAME /* NAME = VARCHAR(64) ,
    ORG_EXEC_ID                      ID /* ID = VARCHAR(32) ,
    ORG_EXEC_CODE_NAME               NAME_LONG /* NAME_LONG = VARCHAR(120) ,
    PLAN_DATE_DONE                   DATE,
    DATE_DONE                        TIMESTAMP,
    DATE_DONE_PREV                   TIMESTAMP,
    DONE_EMPLOYEE_ID                 ID /* ID = VARCHAR(32) ,
    DONE_EMPLOYEE_CODE_NAME          NAME_LONG /* NAME_LONG = VARCHAR(120) ,
    CHECK_EMPLOYEE_ID                ID /* ID = VARCHAR(32) ,
    CHECK_EMPLOYEE_CODE_NAME         NAME_LONG /* NAME_LONG = VARCHAR(120) ,
    IS_URGENT                        IS_ DEFAULT 0 /* IS_ = INTEGER ,
    COMPLEX_ID                       ID /* ID = VARCHAR(32) ,
    IS_COMPLEX                       IS_ /* IS_ = INTEGER ,
    MANIPULATION_ID                  ID /* ID = VARCHAR(32) ,
    MANIPULATION_DATE_TIME           TIMESTAMP,
    MANIPULATION_EMPLOYEE_ID         ID /* ID = VARCHAR(32) ,
    MANIPULATION_EMPLOYEE_CODE_NAME  NAME_LONG /* NAME_LONG = VARCHAR(120) ,
    IS_MANIPULATION                  IS_ /* IS_ = INTEGER ,
    IS_REFUSE                        IS_ DEFAULT 0 /* IS_ = INTEGER ,
    REFUSE_PRINT_TIME                TIMESTAMP,
    DESCR                            BLOB_TEXT /* BLOB_TEXT = BLOB SUB_TYPE 1 SEGMENT SIZE 80 ,
    DESCR_PREVIEW                    NAME /* NAME = VARCHAR(64) ,
    NEW_BULB_CODE                    EAN13 /* EAN13 = VARCHAR(13) ,
    DATE_SEND                        TIMESTAMP,
    SUM_OUT                          PRICE /* PRICE = NUMERIC(18,2) ,
    IMPORT_LAB_ID                    ID /* ID = VARCHAR(32) ,
    DIC_NO_OPPORT_TO_RES_ID          ID /* ID = VARCHAR(32) ,
    DIC_NO_OPPORT_TO_RES_NAME        NAME_MIDDLE /* NAME_MIDDLE = VARCHAR(24) ,*/

   // private long DATE_ADD ;                       TIMESTAMP DEFAULT current_timestamp NOT NULL,
    /*RESULT_TEXT_PREVIEW              NAME /* NAME = VARCHAR(64),
    LAB_PROCESS_ID                   ID /* ID = VARCHAR(32) ,
    ML_PART                          NAME /* NAME = VARCHAR(64) ,
    ML_ORIG_EXEC_SUBD                ID /* ID = VARCHAR(32) ,
    ML_STATUS                        IS_ /* IS_ = INTEGER */

    public static void selectChecks(String url, String name, String password) throws SQLException {

        String SQL = "Select first 100 (d.*) from jor_checks_dt d";
        try (
                Connection conn = getConnection(url, name, password);
                Statement statement = conn.createStatement();) {
            int count = 0;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    //statement.setInt(0,contacts.getId());

                    System.out.print("ID = " + rs.getString("id") + "  ");
                    System.out.print("HD_ID = " + rs.getString("hd_id") + "  ");
                    System.out.print("goods_id = " + rs.getString("goods_id") + "  ");
                    System.out.print("Cnt = " + rs.getString("cnt") + "  ");

                    System.out.println();
                    // statement.getResultSet().next();


                    count++;
                    // execute every 100 rows or less
                   /* if (count % 100 == 0 || count == list.size()) {
                        statement.executeBatch();
                    }*/
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
