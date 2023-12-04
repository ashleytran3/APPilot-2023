
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;
public class DataReader {
  public static ArrayList<City> readData( String fileName ) {
    ArrayList<City> dataList = new ArrayList<City>();
    File dataFile = new File( fileName );

    try( Scanner fileScanner = new Scanner( dataFile )) {
      ArrayList<String> lines = new ArrayList<String>();
      
      while( fileScanner.hasNextLine() ) {
        lines.add( fileScanner.nextLine() );
      }

      for( int index = 1; index < lines.size(); index++ ) {
        String line = lines.get( index );

        String[] data = line.split(",");

        String stateAbbrev = data[0];
        String cityName = data[1];
        int cityPop = Integer.parseInt( data[2] );
        double cityNoHealth = Double.parseDouble( data[3] );
        double cityHighBP = Double.parseDouble( data[4] );
        double cityAsthma = Double.parseDouble( data[5] );
        double citySmoke = Double.parseDouble( data[6] );
        double cityNoExer = Double.parseDouble( data[7] );
        double cityObe = Double.parseDouble( data[8] );
        double citySleep = Double.parseDouble( data[9] );

        City model = new City( stateAbbrev, cityName, cityPop, cityNoHealth, cityHighBP, cityAsthma, citySmoke,
                              cityNoExer, cityObe, citySleep );

        dataList.add( model );
      }
    }
    catch( FileNotFoundException error ) {
      handleError(error);
    }
    return dataList;
  }

  public static void handleError( Exception error ) {
    System.out.println( "The following error was caught:");
    System.out.println( error.getMessage() );
  }
}
