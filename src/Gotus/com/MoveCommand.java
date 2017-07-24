package Gotus.com;

/**
 * Created by Gotus on 24.07.2017.
 */
public class MoveCommand extends Command{

    MoveCommand() {

        this.commandName = "move";
        this.description = "Allows player move in selected direction. Valid options: north, south, west, east";
    }


    @Override
    public void call(PlayCharacter character, World world, String... direction) {
        if (direction.length == 1) {

            return;
        }
        switch (direction[1]) {

            case "north":
                if ((character.getY() > 0) && (character != null)){

                    character.setY(character.getY() - 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY()) * world.getLength()]);
                }
                break;
            case "south":
                if ((character.getY() < world.getHeight()) && (character != null)) {

                    character.setY(character.getY() + 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY()) * world.getLength()]);
                }
                break;
            case "west":
                if ((character.getX() > 0) && (character != null)) {

                    character.setX(character.getX() - 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY()) * world.getLength()]);
                }
                break;
            case "east":
                if ((character.getX() < world.getLength() - 1) && (character != null)) {

                    character.setX(character.getX() + 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY()) * world.getLength()]);
                }
                break;
        }
        System.out.println("Current x: " + character.getX());
        System.out.println("Current y: " + character.getY());
        System.out.println(character.getCurrentLocation());
    }
}