public class Phone extends Product<Phone>{
    private int mah;
    private String colour;

    public Phone(String brand, String description, double unitPrice, double discount, int stock, int memory, double size, int mah, int ram, String colour) {
        super(brand, description, unitPrice, discount, stock, memory, size, ram);
        this.colour = colour;
        this.mah = mah;
    }

    public int getMah() {
        return mah;
    }

    public void setMah(int mah) {
        this.mah = mah;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
