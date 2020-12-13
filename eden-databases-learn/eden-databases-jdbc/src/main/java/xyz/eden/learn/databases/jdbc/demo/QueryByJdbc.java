//package xyz.eden.learn.databases.jdbc.demo;
//
//import com.alibaba.fastjson.JSONObject;
//import xyz.eden.learn.databases.common.entity.UserEntity;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
///**
// * QueryByJdbc
// *
// * @author gavin
// * @version 1.0
// * @datetime 2020/12/13 18:42
// */
//public class QueryByJdbc {
//
//    private static final String DRIVER_PREFIX = "jdbc.";
//    private static final int DRIVER_PREFIX_LEN = DRIVER_PREFIX.length();
//
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//        String configFilePath = "dp.properties";
//
//        final Properties properties = getDataSourceProperties(getProperties(configFilePath));
//
//        // 1. 设置驱动
//        Class.forName(properties.getProperty("driver"));
//
//        PreparedStatement preparedStatement = null;
//        try (
//                // 2.
//                Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
//        ) {
//
//            String sqlStr = "SELECT * FROM t_user WHERE id = ?";
//            preparedStatement = connection.prepareStatement(sqlStr);
//            preparedStatement.setLong(1, 1);
//            final ResultSet resultSet = preparedStatement.executeQuery();
//
//
//            List<UserEntity> userEntityList = new ArrayList<>(1);
//            UserEntity userEntity;
//            while (resultSet.next()) {
//                userEntity = new UserEntity();
//                userEntity.setId(resultSet.getLong("id"));
//                userEntity.setName(resultSet.getString("name"));
//                userEntity.setEmail(resultSet.getString("email"));
//                userEntity.setCreateDatetime(resultSet.getDate("create_datetime"));
//
//                userEntityList.add(userEntity);
//            }
//
//            System.out.println(JSONObject.toJSONString(userEntityList));
//        } finally {
//            if (preparedStatement != null) {
//                preparedStatement.cancel();
//            }
//        }
//
//
//    }
//
//
//    private static Properties getDataSourceProperties(Properties properties) {
//        Properties dataSourceProperties = new Properties();
//        properties.forEach((k, v) -> {
//            String key = (String) k;
//            String val = (String) v;
//            if (key.startsWith(DRIVER_PREFIX)) {
//                dataSourceProperties.put(key.substring(DRIVER_PREFIX_LEN), val);
//            }
//        });
//
//        return dataSourceProperties;
//    }
//
//    private static Properties getProperties(String configFilePath) throws IOException {
//        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFilePath);
//
//        Properties properties = new Properties();
//        properties.load(inputStream);
//        return properties;
//    }
//}
