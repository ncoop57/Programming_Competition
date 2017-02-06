package Miscellaneous;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by natha on 2/5/2017.
 */
public class Sudoku
{

    final int DIMENSION = 9;
    final int NCELLS = DIMENSION * DIMENSION;
    private boolean finished = false;

    private class Point
    {

        int x;
        int y;

        public Point(int x, int y)
        {

            this.x = x;
            this.y = y;

        }

    }

    private class Board
    {

        int matrix[][] = new int[DIMENSION][DIMENSION];
        int freecount;
        Point move[] = new Point[NCELLS];

    }

    public static void main(String[] args)
    {

        Sudoku sudoku = new Sudoku();

        sudoku.run();


    }

    private void run()
    {

        Scanner sc = new Scanner(System.in);

        Board board = new Board();
        board.freecount = NCELLS;
        for (int i = 0; i < DIMENSION; i++)
        {
            String[] row = sc.nextLine().split(" ");

            for (int j = 0; j < row.length; j++)
            {
                board.matrix[i][j] = Integer.parseInt(row[j]);
                if (board.matrix[i][j] != 0)
                    board.freecount--;
            }
        }

        backtracking(new int[NCELLS], 0, board);

    }

    private void next_square(Point newPoint, Board board)
    {

        // Naive Selection for next square
        for (int i = 0; i < board.matrix.length; i++)
            for (int j = 0; j < board.matrix[i].length; j++)
                if (board.matrix[i][j] == 0)
                {
                    newPoint.x = j;
                    newPoint.y = i;
                    return;
                }

        newPoint.x = -1;
        newPoint.y = -1;

    }

    @SuppressWarnings("Duplicates")
    private void possible_values(Point newPoint, Board board, boolean[] possible)
    {

        // Naive generation of possible values

        // Removing possibilities on the same row
        for (int i = 0; i < board.matrix.length; i++)
            if (board.matrix[newPoint.y][i] != 0)
                possible[board.matrix[newPoint.y][i] - 1] = false;

        // Removing possibilities on the same column
        for (int j = 0; j < board.matrix.length; j++)
            if (board.matrix[j][newPoint.x] != 0)
                possible[board.matrix[j][newPoint.x] - 1] = false;

        // Removing possibilities in the same sector
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (newPoint.x < 3) // The new square is in the first 3 columns of the board
                {
                    if (newPoint.y < 3) // The new square is in the first 3 x 3 square
                    {

                        if (board.matrix[i][j] != 0)
                            possible[board.matrix[i][j] - 1] = false;

                    } else if (newPoint.y < 6) // The new square is in the second 3 x 3 square
                    {
                        if (board.matrix[3 + i][j] != 0)
                            possible[board.matrix[3 + i][j] - 1] = false;
                    } else // The new square is in the third 3 x 3 square
                    {
                        if (board.matrix[6 + i][j] != 0)
                            possible[board.matrix[6 + i][j] - 1] = false;
                    }
                } else if (newPoint.x < 6)
                {
                    if (newPoint.y < 3) // The new square is in the fourth 3 x 3 square
                    {

                        if (board.matrix[i][3 + j] != 0)
                            possible[board.matrix[i][3 + j] - 1] = false;

                    } else if (newPoint.y < 6) // The new square is in the fifth 3 x 3 square
                    {
                        if (board.matrix[3 + i][3 + j] != 0)
                            possible[board.matrix[3 + i][3 + j] - 1] = false;
                    } else // The new square is in the sixth 3 x 3 square
                    {
                        if (board.matrix[6 + i][3 + j] != 0)
                            possible[board.matrix[6 + i][3 + j] - 1] = false;
                    }
                } else
                {
                    if (newPoint.y < 3) // The new square is in the seventh 3 x 3 square
                    {

                        if (board.matrix[i][6 + j] != 0)
                            possible[board.matrix[i][6 + j] - 1] = false;

                    } else if (newPoint.y < 6) // The new square is in the eighth 3 x 3 square
                    {
                        if (board.matrix[3 + i][6 + j] != 0)
                            possible[board.matrix[3 + i][6 + j] - 1] = false;
                    } else // The new square is in the nineth 3 x 3 square
                    {
                        if (board.matrix[6 + i][6 + j] != 0)
                            possible[board.matrix[6 + i][6 + j] - 1] = false;
                    }
                }
            }
        }

    }


    private void backtracking(int[] a, int k, Board board)
    {

        int[] c = new int[DIMENSION];
        int nc = 0;

        if (is_a_solution(a, k, board))
        {

            process_solution(a, k, board);

        }
        else
        {

            k++;
            nc = construct_candidates(a, k, board, c, nc);
            for (int i = 0; i < nc; i++)
            {

                a[k - 1] = c[i];
                make_move(a, k, board);
                backtracking(a, k, board);
                unmake_move(a, k, board);

                if (finished) return;

            }

        }

    }

    private void process_solution(int[] a, int k, Board board)
    {

        // Print Board
        for (int i = 0; i < board.matrix.length; i++)
        {

            for (int j = 0; j < board.matrix[i].length; j++)
                System.out.printf("%d ", board.matrix[i][j]);

            System.out.println();

        }

        finished = true;

    }

    private boolean is_a_solution(int[] a, int k, Board board)
    {

        return (board.freecount == 0);

    }

    private void make_move(int[] a, int k, Board board)
    {

        fill_square(board.move[k - 1].x, board.move[k - 1].y, a[k - 1], board);
        board.freecount--;

    }

    private void fill_square(int x, int y, int i, Board board)
    {

        board.matrix[y][x] = i;

    }

    private void unmake_move(int[] a, int k, Board board)
    {

        free_square(board.move[k - 1].x, board.move[k - 1].y, board);
        board.freecount++;

    }

    private void free_square(int x, int y, Board board)
    {

        board.matrix[y][x] = 0;

    }

    private int construct_candidates(int[] a, int k, Board board, int[] c, int nc)
    {

        Point newPoint = new Point(0, 0);
        boolean[] possible = new boolean[DIMENSION];
        Arrays.fill(possible, true);

        next_square(newPoint, board);

        board.move[k - 1] = new Point(newPoint.x, newPoint.y);

        if (newPoint.x < 0 && newPoint.y < 0) return -1;

        possible_values(newPoint, board, possible);
        for (int i = 0; i < DIMENSION; i++)
            if (possible[i])
            {
                c[nc] = i + 1;
                nc++;

            }

        return nc;

    }

}
