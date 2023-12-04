public class City {
    private String state;
   private String name;
   private int population;
   private double noHealth;
   private double highBP;
   private double asthma;
   private double smoker;
   private double noExercise;
   private double obese;
   private double sleepDeprived;
   private double healthScore;
   public City( String st, String place, int pop, double health, double bP, double asth, double smoke, double exer, double ob, double sleep ) {
      state = st;
      name = place;
      population = pop;
      noHealth = health;
      highBP = bP;
      asthma = asth;
      smoker = smoke;
      noExercise = exer;
      obese = ob;
      sleepDeprived = sleep;
   }
   public String getState() {
      return state;
   }
  public String getName() {
      return name;
  }
   public int getPopulation() {
      return population;
   }
   public double getNoHealth() {
      return noHealth;
   }
   public double getHighBP() {
      return highBP;
   }
   public double getAsthma() {
      return asthma;
   }
   public double getSmoker() {
      return smoker;
   }
   public double getNoExercise() {
      return noExercise;
   }
   public double getObese() {
      return obese;
   }
   public double getSleepDeprived() {
      return sleepDeprived;
   }
   public double getHealthScore() {
      return healthScore;
   }
   public void calcHealthScore() {
      double score = 0;
      score += noHealth + highBP + asthma + smoker + noExercise + obese + sleepDeprived;
      score = (score / 700) * 100;
      score = (int)( (score+ 0.05) * 10 ) / 10.0;
      healthScore = score;
   }
  public String toString() {
    String description = getName() + ", " + getState() + " has a population of " + getPopulation() +". " + getNoHealth() + "% don't have health insurance, " + getHighBP() + "% have high blood pressure, " + getAsthma() + "% have asthma, " + getSmoker() + "% smoke, " + getNoExercise() + "% don't exercise, " + getObese() + "% are obese, and " + getSleepDeprived() + "% are sleep deprived.";
    return description;
  }
}
