public class Library {
    private String name;
    private Catalogue catalogue;

    public Library(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
