package jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindBillType {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //1.加载驱动程序
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@192.168.3.122:1521:orcl";
            String user = "CWCS06";
            String password = "1";
            //2.获得数据库链接
            conn = DriverManager.getConnection(url, user, password);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            st = conn.createStatement();

            // 查出所有表名
//        String allTableNameSQL = "select TABLE_NAME from USER_TABLES order by TABLE_NAME";
//        ArrayList<String> allTableNameList = new ArrayList<String>();
//        ResultSet rs = st.executeQuery(allTableNameSQL);
//
//        //4.处理数据库的返回结果(使用ResultSet类)
//        while (rs.next()) {
//            allTableNameList.add(rs.getString("table_name"));
//        }
//        System.out.println(allTableNameList);

            // 查出所有表名和其对应的主键列名
            String tableNameAndPKNameSQL = "select table_name, column_name from USER_CONS_COLUMNS" +
                    " where CONSTRAINT_NAME in (select CONSTRAINT_NAME from USER_CONSTRAINTS" +
                    " where CONSTRAINT_TYPE = 'P' and TABLE_NAME in (select TABLE_NAME from dba_tables))";
            HashMap<String, String> tableNameAndPKNameMap = new HashMap<String, String>();
            rs = st.executeQuery(tableNameAndPKNameSQL);
            while (rs.next()) {
                tableNameAndPKNameMap.put(rs.getString("table_name"), rs.getString("column_name"));
            }
            System.out.println(tableNameAndPKNameMap);
            Set<Map.Entry<String, String>> entries = tableNameAndPKNameMap.entrySet();
            int i = 0;
            for (Map.Entry<String, String> entry : entries) {
                i++;
                String tableName = entry.getKey();
                String tablePK = entry.getValue();
                String targetTableNameSQL = "select " + tablePK + " from " + tableName + " where " + tablePK + " = '1001A31000000003N77E'";
                System.out.println(String.format("%04d", i) + "\t" + targetTableNameSQL);
                try {
                    rs = st.executeQuery(targetTableNameSQL);
                } catch (SQLException e) {
                    e.printStackTrace();
                    continue;
                }
                if (rs.next()) {
                    System.out.println(tableName);
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
