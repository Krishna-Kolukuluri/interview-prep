package systemdesign.monopoly.src.model.tiles.actionStrategy;

import systemdesign.monopoly.src.model.player.Player;

import java.io.Serializable;

public interface Command extends Serializable {
    void execute(Player player);
}
