package cz.educanet.gui;

public class Room {

    private String description;
    private String title;
    private boolean keyRoom;


    private boolean lockRoom;

    private Room top;
    private Room left;
    private Room right;
    private Room bottom;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isKeyRoom() {
        return keyRoom;
    }

    public void setKeyRoom(boolean keyRoom) {
        this.keyRoom = keyRoom;
    }

    public boolean isLockRoom() {
        return lockRoom;
    }

    public void setLockRoom(boolean lockRoom) {
        this.lockRoom = lockRoom;
    }


    public Room getTop() {
        return top;
    }

    public void setTop(Room top) {
        this.top = top;
    }

    public Room getLeft() {
        return left;
    }

    public void setLeft(Room left) {
        this.left = left;
    }

    public Room getRight() {
        return right;
    }

    public void setRight(Room right) {
        this.right = right;
    }

    public Room getBottom() {
        return bottom;
    }

    public void setBottom(Room bottom) {
        this.bottom = bottom;
    }
}