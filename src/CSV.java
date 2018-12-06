import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSV {

    public static void writeGamesToCSV(ArrayList<Game> games)  {

        try{
            StringBuilder sb = new StringBuilder();
            sb.append("Rank, Title, Price, Genres,\n");
            int i = 1;
            for(Game game : games){
                sb.append(i + "," + game + "\n");
                i++;
            }
            PrintWriter writer = new PrintWriter("test.csv");

            writer.write(sb.toString());
            writer.close();
        }
        catch (IOException io){
            System.out.println(io.getMessage());
        }

    }
}
