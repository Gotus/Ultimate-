package Gotus.com;

/**
 * Created by Gotus on 26.07.2017.
 */
public class AttackCommand  extends Command{

    AttackCommand() {

        commandName = "attack";
        description = "Input this command to attack your enemy";
    }

    @Override
    public void call(PlayCharacter character, World world, String ...context) {

        Enemy targetEnemy = character.getEnemy();
        character.attackEnemy(targetEnemy);
        System.out.println(targetEnemy.getName() + "'s hp: " + targetEnemy.getHp());
    }
}
