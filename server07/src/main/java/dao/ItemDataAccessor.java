package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Item;
import exceptions.CannotSearchItemsException;

public class ItemDataAccessor {
    public ArrayList<Item> select(Item key) throws CannotSearchItemsException {
        ArrayList<Item> result = new ArrayList<Item>();
        
        Context context = null;
        DataSource ds = null;
        try {
            context = new InitialContext();
            ds = (DataSource)context.lookup("java:comp/env/jdbc/goodsorder");
        } catch (NamingException e) {
            throw new CannotSearchItemsException("商品検索ができませんでした");
        }
        try(Connection db = ds.getConnection()){
            PreparedStatement ps = db.prepareStatement("SELECT code, name, price FROM items WHERE  name LIKE ? AND name LIKE ? AND price LIKE ? ORDER BY code");
            setFolder(ps, 1, key.getCode());
            setFolder(ps, 2, key.getName());
            setFolder(ps, 3, "" + key.getPrice());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Item item = new Item(rs.getString("code"), rs.getString("name"), rs.getInt("price"));
                result.add(item);
            }
        }catch(SQLException e){
            throw new CannotSearchItemsException("商品検索ができませんでした");
        }

        return result;
    }

    private void setFolder(PreparedStatement ps, int no, String dat) throws SQLException{
        if(dat != null && !dat.equals("")){
            ps.setString(no, "%" + dat + "%");
        }else{
            ps.setString(no,"%");
        }
    }
}
