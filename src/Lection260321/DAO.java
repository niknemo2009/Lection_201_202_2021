package Lection260321;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface DAO <T> {
    default Connection getConnection() throws SQLException, ClassNotFoundException {
       // Connection result=DriverManager.getConnection("jdbc:sqlite:e://sample.db");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection result= DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=Europe/Kiev",
                "user","user");
        return result;
    }
    T create(T entity);
    boolean update(T entity);
    boolean delete(int id);
    List<T> find(T entity);
    default List<T> findById(int id){
        List<T> result=new ArrayList<>();
        return result;
    }
    List<T> findAll();
}

class DAO_User implements DAO<User>{
    Connection connect;
    @Override
    public User create(User entity) {
        try {
        if(connect==null){

                connect=getConnection();

        }
        String sql="INSERT INTO Users (`login`, `pashash`, `telephon`)  VALUES ( ?,  ?,  ? )";
        PreparedStatement preparedStatement=connect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,entity.login);
        preparedStatement.setString(2,entity.password);
        preparedStatement.setString(3,entity.telephon);

        preparedStatement.execute();
        ResultSet rs=preparedStatement.getGeneratedKeys();
        rs.next();
        int key=rs.getInt(1);
         entity.setId(key);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

            return entity;
    }

    @Override    public boolean update(User entity) {
        //UPDATE Users   SET  login = 'login', password = 'password', tel = 'tel' WHERE id = 'id';
        boolean result=false;
        try {
            if(connect==null){

                connect=getConnection();

            }
            String sql="UPDATE Users   SET  login = ?, pashash = ?, telephon = ? WHERE id = ?";
            PreparedStatement preparedStatement=connect.prepareStatement(sql);
            preparedStatement.setString(1,entity.login);
            preparedStatement.setString(2,entity.password);
            preparedStatement.setString(3,entity.telephon);
            preparedStatement.setInt(4,entity.getId());

            result=preparedStatement.execute();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        //DELETE FROM Users   WHERE id = 'id' ;
        boolean result=false;
        try {
            if(connect==null){

                connect=getConnection();

            }
            String sql="DELETE FROM Users   WHERE id = ?";
            PreparedStatement preparedStatement=connect.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            result=preparedStatement.execute();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return result;

    }

    @Override
    public List<User> findById(int id) {
        List<User> result=new ArrayList<>();
        try {
            if(connect==null){

                connect=getConnection();

            }
            String sql="SELECT *  FROM Users where id="+String.valueOf(id);
            Statement statement=connect.createStatement();



            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int tempId=resultSet.getInt(1);
                String login=resultSet.getString(2);
                String password=resultSet.getString(3);
                String tel=resultSet.getString(4);
                User tempUser=new User(login,password,tel);
                tempUser.setId(tempId);
                result.add(tempUser);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public List<User> findByIdProc(int id) {
        List<User> result=new ArrayList<>();
        try {
            if(connect==null){

                connect=getConnection();

            }
            String sql="call sakila.getUser(?)";
            CallableStatement callStmt=connect.prepareCall(sql);
callStmt.setInt(1,id);


            ResultSet resultSet=callStmt.executeQuery();
            while (resultSet.next()){
                int tempId=resultSet.getInt(1);
                String login=resultSet.getString(2);
                String password=resultSet.getString(3);
                String tel=resultSet.getString(4);
                User tempUser=new User(login,password,tel);
                tempUser.setId(tempId);
                result.add(tempUser);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    @Override
    public List<User> find(User entity) {
        //SELECT *  FROM Users where id=3;
        List<User> result=new ArrayList<>();
        try {
            if(connect==null){

                connect=getConnection();

            }
            String sql="SELECT *  FROM Users where id=?";
            PreparedStatement preparedStatement=connect.prepareStatement(sql);

            preparedStatement.setInt(1,entity.getId());

            ResultSet resultSet=preparedStatement.executeQuery();
while (resultSet.next()){
    int id=resultSet.getInt(1);
    String login=resultSet.getString(2);
    String password=resultSet.getString(3);
    String tel=resultSet.getString(4);
    User tempUser=new User(login,password,tel);
    tempUser.setId(id);
    result.add(tempUser);
}

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        //SELECT *  FROM Users where id=3;
        List<User> result=new ArrayList<>();
        try {
            if(connect==null){

                connect=getConnection();

            }
            String sql="SELECT *  FROM Users ";
            Statement statement=connect.createStatement();



            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String login=resultSet.getString(2);
                String password=resultSet.getString(3);
                String tel=resultSet.getString(4);
                User tempUser=new User(login,password,tel);
                tempUser.setId(id);
                result.add(tempUser);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
       User user=new User("login234rtrtrt","qwqw1234","2224-3334");
//       user.setId(5);
        DAO_User dao=new DAO_User();
        //user.password="56789";
        //dao.update(user);
       // System.out.println(dao.findAll());
        dao.create(user);
        System.out.println(dao.findByIdProc(10));
       // user.login="1111111";

       // dao.delete(7);

//        List<User> list=dao.findAll();
//        System.out.println(list);
//        User temp=list.get(0);
//        List<User> temp2=dao.find(temp);
//        temp2.get(0).login="7777777777";
//        dao.update(temp2.get(0));
//        System.out.println(dao.findAll());
    }
}

