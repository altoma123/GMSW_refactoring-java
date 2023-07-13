package src;

public class Movie {
    private String title;
    private MovieCode code;

    public Movie(String title, MovieCode code) {

        this.title = title;
        this.code = code;
    }
    
    public double getCost(int rentedDays) {
        double cost = 0;
        
        switch(code) {
            case NEW:
                cost = rentedDays * 3;
                break;
            case REGULAR:
                cost = 2;
                if (rentedDays > 2) {
                    cost += ((rentedDays - 2) * 1.5);
                }
                break;
            case CHILDRENS:
                cost = 1.5;
                if (rentedDays > 3) {
                    cost += ((rentedDays - 3) * 1.5);
                }
                break;
        }
        return cost;
    }
    

    public String getTitle() {
        return title;
    }

    public MovieCode getCode() {
        return code;
    }
}
