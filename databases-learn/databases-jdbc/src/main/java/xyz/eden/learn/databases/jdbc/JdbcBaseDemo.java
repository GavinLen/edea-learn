package xyz.eden.learn.databases.jdbc;

import com.alibaba.fastjson.JSONObject;
import xyz.eden.learn.databases.common.entity.UserEntity;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/14 15:03
 */
public class JdbcBaseDemo {
    private static final String DRIVER_PREFIX = "jdbc.";
    private static final int DRIVER_PREFIX_LEN = DRIVER_PREFIX.length();

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        // 0. 读取配置文件
        String configFilePath = "dp.properties";
        final Properties properties = getDataSourceProperties(getProperties(configFilePath));

        // 1. 设置驱动
        Class.forName(properties.getProperty("driver"));

        PreparedStatement preparedStatement = null;
        String sqlStr = null;
        // 2. 获取连接
        try (Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"))) {

            // 3. 声明
            sqlStr = "SELECT * FROM t_user WHERE id = ?";
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setLong(1, 1);

            // 4. 执行 SQL
            final ResultSet resultSet = preparedStatement.executeQuery();

            // 5. 解析结果集
            List<UserEntity> userEntityList = new ArrayList<>(1);
            UserEntity userEntity;
            while (resultSet.next()) {
                userEntity = new UserEntity();
                userEntity.setId(resultSet.getLong("id"));
                userEntity.setName(resultSet.getString("name"));
                userEntity.setEmail(resultSet.getString("email"));
                userEntity.setCreateDatetime(resultSet.getDate("create_datetime"));

                userEntityList.add(userEntity);
            }
            System.out.println(JSONObject.toJSONString(userEntityList));

            sqlStr = "INSERT INTO t_user(name, email, create_datetime) VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, "李四");
            preparedStatement.setString(2, "lisi@123.com");
            preparedStatement.setDate(3, new Date(System.currentTimeMillis()));

            final int addResult = preparedStatement.executeUpdate();
            System.out.println("Add Result:" + addResult);

            /**
             * 返回自增 id
             */
            sqlStr = "INSERT INTO t_user(name, email, create_datetime) VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "李四");
            preparedStatement.setString(2, "lisi@123.com");
            preparedStatement.setDate(3, new Date(System.currentTimeMillis()));

            final int id = preparedStatement.executeUpdate();
            System.out.println("Add Id:" + id);

            /**
             * 批量操作
             */
            sqlStr = "INSERT INTO t_user(name, email, create_datetime) VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlStr);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1, "test_" + i);
                preparedStatement.setString(2, "lisi" + i + "@123.com");
                preparedStatement.setDate(3, new Date(System.currentTimeMillis()));

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    private static Properties getDataSourceProperties(Properties properties) {
        Properties dataSourceProperties = new Properties();
        properties.forEach((k, v) -> {
            String key = (String) k;
            String val = (String) v;
            if (key.startsWith(DRIVER_PREFIX)) {
                dataSourceProperties.put(key.substring(DRIVER_PREFIX_LEN), val);
            }
        });

        return dataSourceProperties;
    }

    private static Properties getProperties(String configFilePath) throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFilePath);

        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }


    private class UserOperation {


        public UserEntity getUserById(Long id) {
            String sqlStr = "SELECT * FROM t_user WHERE id = ?";
            return null;
        }

        public int add(Connection connection, UserEntity userEntity) throws SQLException {
            String sqlStr = "INSERT INTO t_user(name, email, create_datetime) VALUES(?, ?, ?)";
            final PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, userEntity.getName());
            preparedStatement.setString(2, userEntity.getEmail());
            preparedStatement.setDate(3, new Date(System.currentTimeMillis()));

            final int addResult = preparedStatement.executeUpdate();
            return addResult;
        }
    }
}
