import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args){

        ArrayList<Game> games = scrapeGames();
        CSV.writeGamesToCSV(games);

        //Game.print(games);

    }

    public static ArrayList<Game> scrapeGames(){
        ArrayList<Game> games = new ArrayList<>();

        try{
            Document doc = Jsoup.connect("https://store.steampowered.com/").get();
            Element topsellers_content = doc.getElementById("tab_topsellers_content");

            Elements gameNames = topsellers_content.getElementsByClass("tab_item_name");
            Elements gameGenres = topsellers_content.getElementsByClass("tab_item_top_tags");
            Elements gamePrices = topsellers_content.getElementsByClass("discount_final_price");

            int i = 0;
            for (Element game : gameNames){
                Game newGame = new Game();
                newGame.setName(game.text());           // Set name of game

                // Extract all genres into an array list
                ArrayList<String> genres = new ArrayList<>();
                for (Element genre : gameGenres){
                    genres.add(genre.getElementsByClass("top_tag").text());
                }
                newGame.setGenres(genres.get(i));              // Set Genres of title

                //Get Price of game
                ArrayList<Float> prices = new ArrayList<>();
                for (Element price : gamePrices){
                    prices.add((Float.parseFloat(price.text().replaceAll("[,]+", ".").replace('€', ' '))));
                }
                newGame.setPrice(prices.get(i));

                //Add all of this game's details to game list
                games.add(newGame);
                i++;
            }
        }
        catch (IOException io ){
            System.out.println(io.getMessage());
        }
        return games;
    }
}
