// mbti.java
package com.pcwk.ehr.elcaro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mbti {
    private DB_conn dbConn;

    public mbti(DB_conn dbConn) {
        this.dbConn = dbConn;
    }

    public void retrieveAccountByMBTI(String userId) {
        try {
            // ACCOUNT_TB에서 MBTI 값을 가져오는 쿼리
            String accountQuery = "SELECT * FROM ACCOUNT_TB WHERE ID = ?";
            PreparedStatement accountStmt = dbConn.getConnection().prepareStatement(accountQuery);
            accountStmt.setString(1, userId);
            ResultSet accountRs = accountStmt.executeQuery();

            // MBTI_TB에서 MBTI 값을 비교하여 결과를 가져오는 쿼리
            String mbtiQuery = "SELECT MBTI_TYPE, IMG_SRC FROM MBTI_TB WHERE MBTI = ?";
            PreparedStatement mbtiStmt = dbConn.getConnection().prepareStatement(mbtiQuery);

            while (accountRs.next()) {
                int code = accountRs.getInt("MBTI");

                // mbtiCode를 매개변수로 설정하여 MBTI_TB에서 결과를 가져옴
                mbtiStmt.setInt(1, code);
                ResultSet mbtiRs = mbtiStmt.executeQuery();

                if (mbtiRs.next()) {
                    String mbtiType = mbtiRs.getString("MBTI_TYPE");
                    String imgSrc = mbtiRs.getString("IMG_SRC");

                    // 결과 출력
                    System.out.println("MBTI Code: " + code);
                    System.out.println("MBTI Type: " + mbtiType);
                    System.out.println("IMG Source: " + imgSrc);
                    System.out.println("------------------------");
                }

                mbtiRs.close();
            }

            accountRs.close();
            accountStmt.close();
            mbtiStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
