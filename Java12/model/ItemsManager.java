package Java12.model;

import java.util.ArrayList;

import Java12.beans.Item;

public class ItemsManager{
    public ArrayList<Item> search(Item key){
        //商品配列を作る3個
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("P001", "基礎からのJava", 2880));
        items.add(new Item("P002", "HTML&CSS/JavaScriptのきほんのきほん", 2460));
        items.add(new Item("P003", "基礎からのサーブレット/JSP", 1880));

        //結果用配列
        ArrayList<Item> result = new ArrayList<Item>();

        //空文字列条件をnullに整える
        String tmp = key.getCode();
        if(tmp != null && tmp.equals("")){
            key.setCode(null);
        }
        tmp = key.getName();
        if(tmp != null && tmp.equals("")){
            key.setName(null);
        }

        //条件が全くなければnullを返す
        if(key.getCode() == null && key.getName() == null){
            return null;
        }

        //商品コードと商品名のAND検索
        for(int i = 0; i < items.size(); i++){
            if(key.getCode() != null){
                if(items.get(i).getCode().indexOf(key.getCode()) < 0){
                    continue;
                }
            }
            if(key.getName() != null){
                if(items.get(i).getName().indexOf(key.getName()) < 0){
                    continue;
                }
            }
            result.add(items.get(i));
        }
        return result;
    }
}