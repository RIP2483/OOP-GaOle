import java.util.ArrayList;
import java.util.List;

public class MoveParser {
    public static List<Move> parseMoveData(String filePath) {
        List<String[]> data = CSVReader.readCSV(filePath);
        List<Move> moveList = new ArrayList<>();

        for (String[] row : data) {
            String moveName = row[0];
            int damage = Integer.parseInt(row[1]);
            moveList.add(new Move(moveName, damage));
        }
        return moveList;
    }
}
