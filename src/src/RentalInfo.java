package src;

import java.util.HashMap;

public class RentalInfo {

  public static String statement(Customer customer) {
    HashMap<String, Movie> movies = new HashMap();
    movies.put("F001", new Movie("You've Got Mail", MovieCode.REGULAR));
    movies.put("F002", new Movie("Matrix", MovieCode.REGULAR));
    movies.put("F003", new Movie("Cars", MovieCode.CHILDRENS));
    movies.put("F004", new Movie("Fast & Furious X", MovieCode.NEW));

    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";
    
    for (MovieRental r : customer.getRentals()) {
      double thisAmount = 0;
      
      thisAmount += movies.get(r.getMovieId()).getCost(r.getDays());

      //add frequent bonus points
      frequentEnterPoints++;
      
      // add bonus for a two day new release rental
      if (movies.get(r.getMovieId()).getCode().equals(MovieCode.NEW) && r.getDays() > 2) 
          frequentEnterPoints++;

      //print figures for this rental
      result += "\t" + movies.get(r.getMovieId()).getTitle() + "\t" + thisAmount + "\n";
      totalAmount = totalAmount + thisAmount;
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentEnterPoints + " frequent points\n";

    return result;
  }
}
