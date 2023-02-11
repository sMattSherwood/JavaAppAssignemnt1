package comp208.sherwood;

public class Card {

    int faceID; // cardID
    int row; //row
    int col; // column

    public void setFaceID(int faceID) {
        this.faceID = faceID;
    }

    public int getFaceID() {
        return faceID;
    }

    public Card(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
