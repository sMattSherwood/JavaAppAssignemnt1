package comp208.sherwood;

public class Card {

    int faceID;
    int row;
    int col;

    public void setFaceID(int faceID) {
        this.faceID = faceID;
    }

    public Card(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
