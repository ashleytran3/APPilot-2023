import java.util.ArrayList;

public class Controller {
    public void mostSmokers() {
        ArrayList<City> demoData = DataReader.readData("HealthyCities.csv");
        ArrayList<State> list = new ArrayList<State>();
        
        //create an array list to store the state and # of smokers -> if there = a new state then add a new
        //element, if not add # of smokers to existing element
        for( City place : demoData ) {
          if( list.size() == 0 ) {
            list.add( new State( place.getState(), (int)( place.getPopulation() * place.getSmoker() ) ) );
          }
          for( int i = 0; i < list.size(); i++ ) {
            if( place.getState().equals( list.get(i).getStateName() ) ) {
              list.get(i).setNumSmokers( (int)( place.getPopulation() * place.getSmoker() ) );
            }
            else
              list.add( new State( place.getState(), (int)( place.getPopulation() * place.getSmoker() ) ) );
          }
        }
        //list holds info for total # smokers in a state -> calc average for each state
        //total / # of times the state appears in demoData
        System.out.println( list.size() );
      int[] aveNum = new int[50];
        for( int j = 0; j < list.size(); j++ ) {
            int total = list.get(j).getNumSmokers();
            int count = 0;
            for( City place : demoData ) {
              if( place.getState().equals(list.get(j).getStateName() ) )
                count++;
            }
            total /= count;
            aveNum[j] = total;
        }
        //find greatest num in the array
        int index = 0;
        int max = aveNum[0];
        for( int k = 1; k < aveNum.length; k++ ) {
          if( aveNum[k] > aveNum[k-1] ) {
              index = k;
              max = aveNum[k];
          }
        }
        System.out.println(list.get(index).getStateName() + " has the greatest average number of smokers: " + max + " smokers."); 
      }
      public void overallHealth() {
        ArrayList<City> demoData = DataReader.readData("HealthyCities.csv");
        double smallHealth = 0;
        double bigHealth = 0;
        
        for( City place : demoData ) {
          place.calcHealthScore();
          // a small city is one with a population less than 250,000
          if( place.getPopulation() < 250000 ) 
            smallHealth += place.getHealthScore();
          else
            bigHealth += place.getHealthScore();
        }
        
        if( smallHealth < bigHealth ) 
             System.out.println( "Small cities are healthier than big cities.");
          else if( bigHealth < smallHealth )
             System.out.println( "Big cities are healthier than small cities.");
          else
             System.out.println( "Big and small cities are equally healthy.");
      }
}
