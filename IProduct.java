public interface IProduct {
    public int getId();
    public String getBrand();
    public void setBrand(String name);
    public double getUnitPrice();
    public void setUnitPrice(double unitPrice);
    public double getDiscount();
    void setDiscount(double discount);
}
