package Java06;

class Item {
    String code;    //商品コード
    String name;    //商品名
    int price;      //単価

    Item(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    String getCode() {
        return code;
    }
    void setCode(String code) {
        this.code = code;
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    int getPrice() {
        return price;
    }
    void setPrice(int price) {
        this.price = price;
    }
}
