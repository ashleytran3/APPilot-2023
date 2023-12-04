public class State {
    private String stateName;
  private int numSmokers;
  public State( String n, int s ) {
    stateName = n;
    numSmokers = s;
  }
  public String getStateName() {
    return stateName;
  }
  public int getNumSmokers() {
    return numSmokers;
  }
  public void setNumSmokers( int num ) {
    numSmokers += num;
  }
}
