package model;

import java.util.ArrayList;

import beans.Item;
import dao.ItemDataAccessor;
import exceptions.CannotSearchItemsException;
import exceptions.EmptyItemsConditionException;
import exceptions.NoItemsException;

public class ItemsManager{
    public ArrayList<Item> search(Item key) throws EmptyItemsConditionException, NoItemsException, CannotSearchItemsException{
        //空文字列条件をnullに整える
        String tmp = key.getCode();
        if(tmp != null && tmp.equals("")){
            key.setCode(null);
        }
        tmp = key.getName();
        if(tmp != null && tmp.equals("")){
            key.setName(null);
        }

        //条件が全くなければ例外を投げる
        if(key.getCode() == null && key.getName() == null && key.getPrice() == 0){
            throw new EmptyItemsConditionException("商品の検索条件がひとつも入力されていません");
        }

        //検索実行
        ItemDataAccessor ida = new ItemDataAccessor();
        ArrayList<Item> result = ida.select(key);
        if(result.size() == 0){
            throw new NoItemsException("検索結果はありません");
        }

        return result;
    }
}