package code.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String note;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, int price, String note, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.note = note;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
