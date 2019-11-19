package jdbc.com.jdbc;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        Connection connection= null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {

            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库连接
            connection= DriverManager.
            getConnection("jdbc:mysql://localhost:3306/xxx?charsetEncoding=utf-8","root","820820");

            //定义sql语句表示占位符
            String sql="select * from user where id = ? ";

            //获取预处理statement
            preparedStatement=connection.prepareStatement(sql);

            //向数据库发出sql执行查询，查询出结果集
            resultSet =preparedStatement.executeQuery();

            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("name"));
            }
        }catch (Exception e){
                e.printStackTrace();
        }

        finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
