package src;

public enum MovieCode {
    REGULAR("regular"), CHILDRENS("childrens"), NEW("new");
    
    private final String value;
    
    private MovieCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
