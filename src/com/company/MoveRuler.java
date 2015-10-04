package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by �������� ������ on 04.10.2015.
 */
public class MoveRuler {
    public static List<Move> getAvailableMoves(State state) throws Exception {
        Coordinates zeroCoord = state.getZeroCoordinates();
        List<Move> moveList = new ArrayList<Move>();

        // ���� ����� �� ������� ����� �� �������� ����������� ������
        if (zeroCoord.getI() > 0) {
            moveList.add(Move.LEFT_ROTATE);
        }

        // ���� ����� �� ������� ������ �� �������� ������������ �������
        if (zeroCoord.getI() < 2) {
            moveList.add(Move.RIGHT_ROTATE);
        }

        // ���� ����� �� ������� ������ �� �������� ����������� ����
        if (zeroCoord.getJ() < 2) {
            moveList.add(Move.DOWN_ROTATE);
        }

        // ���� ����� �� ������� ������� �� �������� ����������� �����
        if (zeroCoord.getJ() > 0) {
            moveList.add(Move.UP_ROTATE);
        }

        return moveList;
    }
}
