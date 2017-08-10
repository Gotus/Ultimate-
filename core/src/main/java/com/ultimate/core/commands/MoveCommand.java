package com.ultimate.core.commands;

import com.ultimate.core.*;


public class MoveCommand extends Command {

    public MoveCommand() {

        this.commandName = "move";
        this.description = "Allows player move in selected direction. Valid options: north, south, west, east";
    }


    @Override
    public void call(CurrentGame currentGame, String... direction) {
        if (direction.length == 1) {

            return;
        }

        boolean moved = false;
/*
        switch (direction[1]) {

            case "north":
                if ((character.getY() > 0) && (character != null)){

                    character.setY(character.getY() - 1);
                    character.setCurrentLocation(world.getMap()[character.getX() + (character.getY()) * world.getLength()]);
                    moved = true;
                }
                break;
            case "south":
                if ((character.getY() < (world.getHeight() - 1)) && (character != null)) {

                    character.setY(character.getY() + 1);
                    character.setCurrentLocation(world.getMap()[character.getX() + (character.getY()) * world.getLength()]);
                    moved = true;
                }
                break;
            case "west":
                if ((character.getX() > 0) && (character != null)) {

                    character.setX(character.getX() - 1);
                    character.setCurrentLocation(world.getMap()[character.getX() + (character.getY()) * world.getLength()]);
                    moved = true;
                }
                break;
            case "east":
                if ((character.getX() < world.getLength() - 1) && (character != null)) {

                    character.setX(character.getX() + 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY()) * world.getLength()]);
                    moved = true;
                }
                break;
        }

        if ((Math.random() < 0.3) && (moved)) {




            character.setCurrentBattle(new Battle());

            Enemy newEnemy = new Enemy("Goblin", 8, 3, 1);
            character.getCurrentBattle().addEnemy(newEnemy);
            newEnemy = new Enemy("Troll", 3, 2, 2);
            character.getCurrentBattle().addEnemy(newEnemy);
            //character.setEnemy(newEnemy);

            final int numOfBattleCommands = 1;
            Command[] battleCommands = new Command[numOfBattleCommands];
            Command attack = new AttackCommand();
            battleCommands[0] = attack;

            CommandHandler battleCommandHandler = new CommandHandler(battleCommands);

            Scanner consoleInput = new Scanner(System.in);

            while (!character.getCurrentBattle().getEnemies().isEmpty()) {

                character.getCurrentBattle().printEnemies();

                String command = consoleInput.nextLine();

                battleCommandHandler.handleCommand(command, character, world);
                character.getCurrentBattle().checkEnemy();

                if (character.getCurrentBattle().getEnemies().isEmpty()) {


                    break;
                }

                for (Enemy e: character.getCurrentBattle().getEnemies()) {

                    e.attack(character);

                }

                if ((character.getHp() <= 0)) {


                    break;
                }

            }
        }*/
    }
}