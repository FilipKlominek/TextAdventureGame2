package cz.educanet.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML

    public Button btnUp;
    public Button btnLeft;
    public Button btnRight;
    public Button btnDown;

    public Label title;
    public Label description;

    private Room currentRoom;
    private boolean keyFound;

    public void goingUp(ActionEvent actionEvent) {
        currentRoom = currentRoom.getTop();

        if (currentRoom.getTop() == null) btnUp.setVisible(false);
        else btnUp.setVisible(true);
        if (currentRoom.getLeft() == null) btnLeft.setVisible(false);
        else btnLeft.setVisible(true);
        if (currentRoom.getRight() == null) btnRight.setVisible(false);
        else btnRight.setVisible(true);
        if (currentRoom.getBottom() == null) btnDown.setVisible(false);
        else btnDown.setVisible(true);

        if (currentRoom.isLockRoom() && !keyFound) btnUp.setVisible(false);

        description.setText(currentRoom.getDescription());
        title.setText(currentRoom.getTitle());
        /*
        btnUp.setText(currentRoom.getTop().getTitle());
        btnLeft.setText(currentRoom.getLeft().getTitle());
        btnRight.setText(currentRoom.getRight().getTitle());
        btnDown.setText(currentRoom.getBottom().getTitle());
        */
    }

    public void goingLeft(ActionEvent actionEvent) {
        currentRoom = currentRoom.getLeft();

        if (currentRoom.getTop() == null) btnUp.setVisible(false);
        else btnUp.setVisible(true);
        if (currentRoom.getLeft() == null) btnLeft.setVisible(false);
        else btnLeft.setVisible(true);
        if (currentRoom.getRight() == null) btnRight.setVisible(false);
        else btnRight.setVisible(true);
        if (currentRoom.getBottom() == null) btnDown.setVisible(false);
        else btnDown.setVisible(true);

        description.setText(currentRoom.getDescription());
        title.setText(currentRoom.getTitle());
        /*
        btnUp.setText(currentRoom.getTop().getTitle());
        btnLeft.setText(currentRoom.getLeft().getTitle());
        btnRight.setText(currentRoom.getRight().getTitle());
        btnDown.setText(currentRoom.getBottom().getTitle());
        */
    }

    public void goingRight(ActionEvent actionEvent) {
        currentRoom = currentRoom.getRight();

        if (currentRoom.getTop() == null) btnUp.setVisible(false);
        else btnUp.setVisible(true);
        if (currentRoom.getLeft() == null) btnLeft.setVisible(false);
        else btnLeft.setVisible(true);
        if (currentRoom.getRight() == null) btnRight.setVisible(false);
        else btnRight.setVisible(true);
        if (currentRoom.getBottom() == null) btnDown.setVisible(false);
        else btnDown.setVisible(true);

        description.setText(currentRoom.getDescription());
        title.setText(currentRoom.getTitle());
        /*
        btnUp.setText(currentRoom.getTop().getTitle());
        btnLeft.setText(currentRoom.getLeft().getTitle());
        btnRight.setText(currentRoom.getRight().getTitle());
        btnDown.setText(currentRoom.getBottom().getTitle());
        */
    }

    public void goingDown(ActionEvent actionEvent) {
        currentRoom = currentRoom.getBottom();

        if (currentRoom.getTop() == null) btnUp.setVisible(false);
        else btnUp.setVisible(true);
        if (currentRoom.getLeft() == null) btnLeft.setVisible(false);
        else btnLeft.setVisible(true);
        if (currentRoom.getRight() == null) btnRight.setVisible(false);
        else btnRight.setVisible(true);
        if (currentRoom.getBottom() == null) btnDown.setVisible(false);
        else btnDown.setVisible(true);

        description.setText(currentRoom.getDescription());
        title.setText(currentRoom.getTitle());
        /*
        btnUp.setText(currentRoom.getTop().getTitle());
        btnLeft.setText(currentRoom.getLeft().getTitle());
        btnRight.setText(currentRoom.getRight().getTitle());
        btnDown.setText(currentRoom.getBottom().getTitle());
        */

        if (currentRoom.isKeyRoom()) keyFound = true;
    }

    @FXML
    public void initialize() {
        Room entrance = new Room();

        entrance.setTitle("Entrance");
        entrance.setDescription(
                "Up: Treasure room\n" +
                        "Down: Exit\n" +
                        "Left: The maze\n" +
                        "Right: Don't go there"
        );


        Room treasureRoomEntrance = new Room();
        treasureRoomEntrance.setTitle("Treasure room entrance");
        treasureRoomEntrance.setDescription("The treasure room is locked. \n" +
                "It requires a key");

        Room treasureRoom = new Room();
        treasureRoom.setTitle("Treasure room");
        treasureRoom.setDescription("There is a lot of gold here");

        Room ending2 = new Room();
        ending2.setTitle("The good ending");
        ending2.setDescription("You are rich now, congrats!");


        Room exit = new Room();
        exit.setTitle("Outside");
        exit.setDescription("Down: Exit");

        Room ending1 = new Room();
        ending1.setTitle("The boring ending");
        ending1.setDescription("You went home and gained nothing");


        Room mazeEntrance = new Room();
        mazeEntrance.setTitle("Maze entrance");
        mazeEntrance.setDescription("Left: Enter the maze");

        Room maze0 = new Room();
        maze0.setTitle("");
        maze0.setDescription(
                "1: ^ \n" +
                        "2: v \n" +
                        "3: > \n" +
                        "4: > \n" +
                        "5: < \n" +
                        "6: < \n" +
                        "7: ^ \n" +
                        "8: v");

        Room maze1 = new Room();
        maze1.setTitle("5");

        Room maze2 = new Room();
        maze2.setTitle("7");

        Room maze3 = new Room();
        maze3.setTitle("4");

        Room maze4 = new Room();
        maze4.setTitle("6");

        Room maze5 = new Room();
        maze5.setTitle("2");

        Room mazeEnd = new Room();
        mazeEnd.setTitle("You got through the maze");
        mazeEnd.setDescription("You found key 1");
        mazeEnd.setKeyRoom(true);


        Room room4 = new Room();
        room4.setTitle("???");
        room4.setDescription("Don't continue");

        Room ending3 = new Room();
        ending3.setTitle("The bad ending");
        ending3.setDescription("You fell into a cave and died");


        entrance.setTop(treasureRoomEntrance);
        entrance.setLeft(mazeEntrance);
        entrance.setRight(room4);
        entrance.setBottom(exit);


        treasureRoomEntrance.setBottom(entrance);
        treasureRoomEntrance.setLockRoom(true);
        treasureRoomEntrance.setTop(treasureRoom);

        treasureRoom.setTop(ending2);


        mazeEntrance.setRight(entrance);
        mazeEntrance.setLeft(maze0);

        maze0.setRight(mazeEntrance);
        maze0.setLeft(maze1);

        maze1.setLeft(maze2);
        maze1.setTop(maze0);
        maze1.setBottom(maze0);

        maze2.setTop(maze3);
        maze2.setLeft(maze0);
        maze2.setRight(maze0);

        maze3.setRight(maze4);
        maze3.setTop(maze0);

        maze4.setLeft(maze5);
        maze4.setRight(maze0);
        maze4.setBottom(maze0);

        maze5.setBottom(mazeEnd);
        maze5.setTop(maze0);
        maze5.setLeft(maze0);
        maze5.setRight(maze0);

        mazeEnd.setBottom(mazeEntrance);


        room4.setLeft(entrance);

        exit.setTop(entrance);
        exit.setBottom(ending1);


        room4.setRight(ending3);

        currentRoom = entrance;
        keyFound = false;

        title.setText(currentRoom.getTitle());
        description.setText(currentRoom.getDescription());


    }


}
