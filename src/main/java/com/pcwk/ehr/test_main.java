// test_main.java
package com.pcwk.ehr.elcaro;

public class test_main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "ELCARO";
        String password = "pcwk";

        DB_conn dbConn = new DB_conn(jdbcUrl, username, password);
        dbConn.connect();

        String userId = "ccjj1002";  // 사용자의 ID를 넣을 부분

        mbti mbtiObj = new mbti(dbConn);
        mbtiObj.retrieveAccountByMBTI(userId);

        ani aniObj = new ani(dbConn);
        aniObj.retrieveAccountByANI(userId);

        dbConn.close();
    }
}
