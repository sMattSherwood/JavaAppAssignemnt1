package comp208.sherwood;

public class Card {

    int faceID;
    int row;
    int col;
    boolean flipped;

    public void setFaceID(int faceID) {
        this.faceID = faceID;
    }

    public int getFaceID() {
        return faceID;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }
    public Card(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
