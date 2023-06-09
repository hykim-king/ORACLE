// mbti.java
package com.pcwk.ehr.elcaro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ani {
    private DB_conn dbConn;

    public ani(DB_conn dbConn) {
        this.dbConn = dbConn;
    }

    public void retrieveAccountByANI(String userId) {
        try {
            // ACCOUNT_TB에서 MBTI 값을 가져오는 쿼리
            String accountQuery = "SELECT * FROM ACCOUNT_TB WHERE ID = ?";
            PreparedStatement accountStmt = dbConn.getConnection().prepareStatement(accountQuery);
            accountStmt.setString(1, userId);
            ResultSet accountRs = accountStmt.executeQuery();

            // MBTI_TB에서 MBTI 값을 비교하여 결과를 가져오는 쿼리
            String aniQuery = "SELECT ANI_NAME, IMG_SRC FROM ANI_TB WHERE ANI = ?";
            PreparedStatement aniStmt = dbConn.getConnection().prepareStatement(aniQuery);

            while (accountRs.next()) {
                int code = accountRs.getInt("ANI");

                // mbtiCode를 매개변수로 설정하여 MBTI_TB에서 결과를 가져옴
                aniStmt.setInt(1, code);
                ResultSet aniRs = aniStmt.executeQuery();

                if (aniRs.next()) {
                    String aniname = aniRs.getString("ANI_NAME");
                    String imgSrc = aniRs.getString("IMG_SRC");

                    // 결과 출력
                    System.out.println("ANI Code: " + code);
                    System.out.println("ANI Name: " + aniname);
                    System.out.println("IMG Source: " + imgSrc);
                    System.out.println("------------------------");
                }

                aniRs.close();
            }

            accountRs.close();
            accountStmt.close();
            aniStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
