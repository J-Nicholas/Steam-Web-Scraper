import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Game {
    private String name;
    private String genres;
    private float price;

    @Override
    public String toString() {
        return getName() + "," + "€"+getPrice() + "," + getGenres();
    }

    public static void print(@NotNull ArrayList<Game> games){
        int i = 1;
        for(Game game : games){
            System.out.println(i + "\t" + game);
            i++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenres() {
        return "\"" + genres + "\"";
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
