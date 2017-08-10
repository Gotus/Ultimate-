package com.ultimate.core.commands;

import com.ultimate.core.CurrentGame;


public class AttackCommand  extends Command {

    AttackCommand() {

        commandName = "attack";
        description = "Input this command to attack your enemy";
    }

    @Override
    public void call(CurrentGame currentGame, String ...context) {

        if (context.length < 2) {

            return;
        }

        /*Enemy targetEnemy = character.getCurrentBattle().getEnemy(Integer.parseInt(context[1]) - 1);
        if (targetEnemy == null) {

            return;
        }
        character.attackEnemy(targetEnemy);
        */
    }
}
