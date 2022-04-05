package Java08;

public class ItemsManager{
    public Item[] search(Item key){
        //商品配列を作る3個
        Item[] items = new Item[3];
        items[0] = new Item("P001", "基礎からのJava", 2880);
        items[1] = new Item("P002", "HTML&CSS/JavaScriptのきほんのきほん", 2460);
        items[2] = new Item("P003", "基礎からのサーブレット/JSP", 1880);

        //結果用配列
        Item[] result = new Item[items.length];

        //空文字列条件をnullに整える
        if(key.getCode().equals("")){
            key.setCode(null);
        }
        if(key.getName().equals("")){
            key.setName(null);
        }

        //条件が全くなければnullを返す
        if(key.getCode() == null && key.getName() == null){
            return null;
        }

        //商品コードと商品名のAND検索
        int respos = 0;
        for(int i = 0; i < items.length; i++){
            if(key.getCode() != null){
                if(items[i].getCode().indexOf(key.getCode()) < 0){
                    continue;
                }
            }
            if(key.getName() != null){
                if(items[i].getName().indexOf(key.getName()) < 0){
                    continue;
                }
            }
            result[respos] = items[i];
            respos++;
        }
        return result;
    }
}