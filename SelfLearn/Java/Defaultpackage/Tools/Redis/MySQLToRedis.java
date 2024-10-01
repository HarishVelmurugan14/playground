package SelfLearn.Java.Defaultpackage.Tools.Redis;

import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLToRedis {
    public static void main(String[] args) {
        String mysqlUrl = "jdbc:mysql://localhost:3306/threads";
        String mysqlUser = "root";
        String mysqlPassword = "";
        String tableName = "record_details";
        String specificKey = "2";
        try {
            Jedis jedis = new Jedis("localhost", 6379);

            long cacheStartTime = System.nanoTime();

            if (!jedis.exists(tableName)) {
                Connection mysqlConn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
                Statement stmt = mysqlConn.createStatement();
                ResultSet allRecords = stmt.executeQuery("SELECT * FROM " + tableName);

                while (allRecords.next()) {
                    String key = allRecords.getString("id");
                    String value = allRecords.getString("Record Name");
                    String value2 = allRecords.getString("execution_status");
                    String value3 = allRecords.getString("JobID");
                    jedis.hset("record_details", key, value + ";" + value2 + ";" + value3);
                }
                mysqlConn.close();
            }
            long cacheEndTime = System.nanoTime();
            long cacheTimeTaken = cacheEndTime - cacheStartTime;
            long dbStartTime = System.nanoTime();

            String fieldValue = jedis.hget(tableName, specificKey);
            if (fieldValue != null) {
                String[] values = fieldValue.split(";");
                if (values.length >= 3) {
                    System.out.println("ID : "+ specificKey);
                    System.out.println("Record Name : " + values[0]);
                    System.out.println("Execution Status : " + values[1]);
                    System.out.println("JobID : " + values[2]);
                } else {
                    System.out.println("Insufficient fields in the record");
                }
            } else {
                System.out.println("Record not found in Redis");
            }

            long dbEndTime = System.nanoTime();
            long dbTimeTaken = dbEndTime - dbStartTime;

            System.out.println("Time taken for serving from cache: " + cacheTimeTaken + " nanoseconds");
            System.out.println("Time taken for serving from database: " + dbTimeTaken + " nanoseconds");

            jedis.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
