package systemdesign.monopoly.src.model.tiles.actionStrategy;

import systemdesign.monopoly.src.model.tiles.GameAction;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractActionFactory {
    public abstract ArrayList<GameAction> getActionList(String className);
}
