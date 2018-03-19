package com.company.algo;

import java.awt.Point;
import java.util.*;

import com.company.Board;
import com.company.CellState;
import com.company.Game;

public class Megamax implements Algorithm {
    public Megamax() {

    }

    @Override
    public void stepWasMade(Point step) {
        for (TreeNode child : currentNode.children) {
            if (step.equals(child.step)) {
                currentNode = child;
                break;
            }
        }
    }

    @Override
    public void prepare() {
        currentNode = root;
    }

    @Override
    public Point makeStep() {
        if (currentNode.children.isEmpty()) {
            throw new RuntimeException("there is no step to make");
        }
        TreeNode candidate = null;
        for (TreeNode child : currentNode.children) {
            if (child.winning == winningStrategy) {
                candidate = child;
                break;
            }
            if (child.winning == WinState.NONE || candidate == null) {
                candidate = child;
            }
        }
        this.currentNode = candidate;
        return candidate.step;
    }

    private static void initialize() {
        if (!initialized) {
            backtrack(new Board(), root, CellState.O, 0);
            root.winning = WinState.NONE;
            initialized = true;
        }
    }

    private TreeNode currentNode = root;
    private WinState winningStrategy = WinState.WIN;

    private static WinState backtrack(Board board, TreeNode currentNode, CellState turn, int depth) {
        if (currentNode != root && board.isWinningStep(currentNode.step, turn)) {
            return currentNode.winning = WinState.WIN;
        }
        if (depth == Board.SIZE * Board.SIZE) {
            return currentNode.winning = WinState.NONE;
        }
        CellState nextTurn = (turn == CellState.X ? CellState.O : CellState.X);
        WinState currentState = WinState.WIN;

        for (int i = 0; i < Board.SIZE; ++i) {
            for (int j = 0; j < Board.SIZE; ++j) {
                Point p = new Point(i, j);
                if (board.getState(p) == CellState.EMPTY) {
                    board.setState(p, nextTurn);
                    TreeNode newChild = new TreeNode(p);
                    currentNode.children.add(newChild);
                    WinState childState = backtrack(board, newChild, nextTurn, depth + 1);
                    board.setState(p, CellState.EMPTY);
                    switch (childState) {
                        case WIN:
                            currentState = WinState.LOSE;
                            break;
                        case NONE:
                            if (currentState != WinState.LOSE) {
                                currentState = WinState.NONE;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return currentNode.winning = currentState;
    }

    private static boolean initialized = false;
    private static TreeNode root = new TreeNode();

    private static class TreeNode {
        public TreeNode() {
        }

        public TreeNode(Point step) {
            this.step = new Point(step.x, step.y);
        }

        private Point step;
        private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
        private WinState winning = WinState.NONE;
    }

    static {
        initialize();
    }
}

enum WinState {
    WIN, LOSE, NONE
}
