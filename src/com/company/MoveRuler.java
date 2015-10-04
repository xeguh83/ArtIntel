package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by например јндрей on 04.10.2015.
 */
public class MoveRuler {
    public static List<Move> getAvailableMoves(State state) throws Exception {
        Coordinates zeroCoord = state.getZeroCoordinates();
        List<Move> moveList = new ArrayList<Move>();

        // ≈сли точка не крайн€€ лева€ то доступны перемещени€ налево
        if (zeroCoord.getI() > 0) {
            moveList.add(Move.LEFT_ROTATE);
        }

        // ≈сли точка не крайн€€ права€ то доступны перемещаени€ направо
        if (zeroCoord.getI() < 2) {
            moveList.add(Move.RIGHT_ROTATE);
        }

        // ≈сли точка не крайн€€ нижн€€ то доступны перемещени€ вниз
        if (zeroCoord.getJ() < 2) {
            moveList.add(Move.DOWN_ROTATE);
        }

        // ≈сли точка не крайн€€ верхн€€ то доступны перемещени€ вверх
        if (zeroCoord.getJ() > 0) {
            moveList.add(Move.UP_ROTATE);
        }

        return moveList;
    }
}
