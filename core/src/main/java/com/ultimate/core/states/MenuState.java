package com.ultimate.core.states;

import com.ultimate.core.gameObjects.PlayCharacter;

/**
 * Created by Gotus on 12.08.2017.
 */
public class MenuState {

    PlayCharacter newCharacter = new PlayCharacter();

    public String setCharacterName(String data) {

        String fields[] = data.split(" ");
        if (fields.length < 2) {

            return "Not enough data to create character";
        }

        if (fields[0].equalsIgnoreCase("") || fields[1].equalsIgnoreCase("")) {

            return "Fields can't be empty";
        }

        newCharacter.setName(fields[0]);

        for (PlayCharacter.Race race: PlayCharacter.Race.values()) {

            if (race.toString().equalsIgnoreCase(fields[1])) {

                newCharacter.setRace(race);
                break;
            }
        }

        return newCharacter.toString();
    }
}
