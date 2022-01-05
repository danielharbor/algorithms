package com.phonescreens;

import java.io.*;
import java.util.*;

/*
The 2-player game of Drawdown is played with a board made up of N groups of stones.
At the start of each game a board and a list of k moves are provided. Each move is a list of N integers, which represent the number of stones the move adds/removes from the board at each index. All moves result in a net reduction of stones on the board.
Moves can be re-used, but a move can no longer be performed if doing so would reduce the number of stones in any group below 0. After no more moves can be completed, player 1 wins if there are more stones at index 0 than at index N - 1. Otherwise, player 2 wins.

Example: Let's say the game begins with a board of [6, 4, 2, 4] and these are the available moves provided:
1. [-2, -2, 1, 0]
2. [-4, -4, 0 ,0]
3. [0, 0, -2, -2]

Player One: 3, Player Two: 2

move 1, move 1, move 3, move 3
Initial board: [6, 4, 2, 4]
Player 1 decides to perform move 1. New board: [4, 2, 3, 4]
Player 2 can perform move 1 or move 3. They decide to perform move 1.  New board: [2, 0, 4, 4]
Player 1 has to perform move 3 (which is the only move available).  New board: [2, 0, 2, 2]
Player 2 has to perform move 3. New board: [2, 0, 0, 0]
The game is now over and player 1 is the winner.

[3,...0.., 1] => player 1
[1,...0.., 3] => player 2
[3,...0.., 3] => player 2
 */

class Square2019Phone2 {
  public static void main(String[] args) {
    int[] nums = {6, 4, 2, 4};
    int[][] moves = {{0, 0, 0, -1}, {-1, -4, 0 ,0}, {0, 0, -2, -2}};
    int[] winnerCount = new int[2];

    System.out.println(Arrays.toString(nums));
    getCombinationOfMoves(nums, nums, moves, winnerCount);
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(winnerCount));
  }

  static void getCombinationOfMoves(int[] state, int[] prevState, int[][] moves, int[] winnerCount) {
    if (state.length == 0) {  // we've reached end of a particular set of moves
      int winner = getWinner(prevState);
      winnerCount[winner-1]++;
      return;
    }

    for (int i = 0; i < moves.length; i++) {
      int[] nextState = getNextState(state, moves[i]);
      getCombinationOfMoves(nextState, state, moves, winnerCount);
    }
  }

  // return an int representing the winning player's number (1 or 2)
  static int getWinner(int[] nums) {
    return nums[0] > nums[nums.length-1] ? 1 : 2;
  }

  // get next state of board based on given move
  static int[] getNextState(int[] nums, int[] move) {
    int[] nextState = new int[nums.length];
    boolean res = false;
    for (int i = 0; i < nums.length; i++) {
      nextState[i] = nums[i] + move[i];
      if (nextState[i] >= 0 && nextState[i] != nums[i]) {
        res = true;
      }
    }

    if (res) {
      for (int i = 0; i < nums.length; i++) {
        nums[i] = nextState[i] >= 0 ? nextState[i] : nums[i];
      }
      return nums;
    } else {
      return new int[0]; // empty array to signify that there's not a possible move
    }
  }
}
