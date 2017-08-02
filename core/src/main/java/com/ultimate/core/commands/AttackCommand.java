package com.ultimate.core.commands;

import com.ultimate.core.gameObjects.Enemy;
import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;


public class AttackCommand  extends Command {

    AttackCommand() {

        commandName = "attack";
        description = "Input this command to attack your enemy";
    }

    @Override
    public void call(PlayCharacter character, World world, String ...context) {

        if (context.length < 2) {

            return;
        }

        /*Enemy targetEnemy = character.getCurrentBattle().getEnemy(Integer.parseInt(context[1]) - 1);
        if (targetEnemy == null) {

            System.out.println("Ineffective");
            return;
        }
        character.attackEnemy(targetEnemy);
        System.out.println(targetEnemy.getName() + "'s hp: " + targetEnemy.getHp());
        */
    }
}
