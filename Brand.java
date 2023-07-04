public class Brand implements Comparable<Brand>{
    private  String name;

    private static int nextId;
    private final int id;


    public Brand(String name) { // constructor her cagrıldıgında id degeri artacak sekılde ayarlandı.
        this.id = nextId;
        nextId++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Brand o) { // Alfabeye gore siralamasini sagliyor
        return this.getName().compareTo(o.getName());
    }
}
