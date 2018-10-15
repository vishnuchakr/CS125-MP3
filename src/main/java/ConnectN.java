
/**
 * A class that implements a Connect4-like game.
 * @see <a href="https://cs125.cs.illinois.edu/MP/3/">MP3 Documentation</a>
 */
public class ConnectN {
    //Initialize the instance variables.
    /** Maximum board height is 16. */
    public static final int MAX_HEIGHT = 16;

    /** Maximum board width is 16. */
    public static final int MAX_WIDTH = 16;

    /** Minimum board height is 6. */
    public static final int MIN_HEIGHT = 6;

    /** Minimum board N value is 4. */
    public static final int MIN_N = 4;

    /** Minimum board width is 6. */
    public static final int MIN_WIDTH = 6;

    /** Height of the board. */
    private int height;

    /** Width of the board. */
    private int width;

    /** N-value for the board. */
    private int n;

    /** Determines whether the score should be incremented. */
    private boolean shouldAdd = true;

    /** Counts how many times a constructor has been called. */
    private static int gameCount = 0;

    /** ID of the current game. */
    private int id;

    /** Determines whether there is an existing game. */
    private boolean hasStarted = false;

    /** Determines if setWidth ran. */
    private boolean widthSet;

    /** Determines if setHeight ran. */
    private boolean heightSet;

    /** Instantiates the board. */
    private Player[][] board;

    /** Winning player. */
    private Player winningPlayer;

    //Write Constructors
    /**
     * Create a new ConnectN board with uninitialized width, height, and N value.
     */
    public ConnectN() {
        this.height = 0;
        this.width = 0;
        this.n = 0;
        this.board = null;
        gameCount++;
        //this.id = this.getTotalGames() - 1;
    }

    /**
     * Create a new ConnectN board with given width and height and uninitialized N value.
     * @param setWidth Set the width.
     * @param setHeight Set the height.
     */
    public ConnectN(final int setWidth, final int setHeight) {
        if (setWidth < MIN_WIDTH || setWidth > MAX_WIDTH) {
            this.width = 0;
        } else {
            this.width = setWidth;
        }
        if (setHeight < MIN_HEIGHT || setHeight > MAX_HEIGHT) {
            this.height = 0;
        } else {
            this.height = setHeight;
        }
        this.n = 0;
        widthSet = true;
        heightSet = true;
        board = new Player[this.width][this.height];
        gameCount++;
        id = this.getTotalGames() - 1;
    }

    /**
     * Creates a new ConnectN board with a given width, height, and N value.
     * @param setWidth Set the width.
     * @param setHeight Set the height.
     * @param setN Set the N value.
     */
    public ConnectN(final int setWidth, final int setHeight, final int setN) {
        if (setWidth < MIN_WIDTH || setWidth > MAX_WIDTH) {
            this.width = 0;
        } else {
            this.width = setWidth;
        }
        if (setHeight < MIN_HEIGHT || setHeight > MAX_HEIGHT) {
            this.height = 0;
        } else {
            this.height = setHeight;
        }
        if (this.width != 0 && this.height != 0) {
            if (setN < MIN_N || (setN > Math.max(setWidth, setHeight) - 1)) {
                this.n = 0;
            } else {
                this.n = setN;
            }
        }
        widthSet = true;
        heightSet = true;
        board = new Player[this.width][this.height];
        gameCount++;
        id = this.getTotalGames() - 1;
    }
    //random

    /**
     * Create a new ConnectN board with dimensions and N value copied from another board.
     * @param otherBoard Board to be read by the constructor.
     */
    public ConnectN(final ConnectN otherBoard) {
        this(otherBoard.width, otherBoard.height, otherBoard.n);
        this.board = new Player[this.width][this.height];
        gameCount++;
        id = this.getTotalGames() - 1;
    }

    //Write methods
    /**
     * Return a copy of the board.
     * @return board.
     */
    public Player[][] getBoard() {
        if (width <= 0 || height <= 0) {
            return null;
        }
        if (board == null) {
            return null;
        }
        Player[][] copy = new Player[width][height];

        for (int i = 0; i < width - 1; i++) {
            for (int j = 0; j < height - 1; j++) {
                if (board[i][j] != null) {
                    copy[i][i] = new Player(board[i][j]);
                }
            }
        }
        return copy;
    }

    /**
     * Get the current board height.
     * @return height.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Get the current board's id.
     * @return id.
     */
    public int getID() {
        return this.id;
    }

    /**
     * Get the current board N value.
     * @return n.
     */
    public int getN() {
        return this.n;
    }

    /**
     * Get the current board width.
     * @return width.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Return the winner of the game, or null if the game has not ended.
     * @return winner.
     */
    public Player getWinner() {
        if (board == null) {
            return null;
        }
        if (width == 0 || height == 0) {
            return null;
        }
        return null;
    }

    /**
     * Define the hash code for the ConnectN class.
     * @return Hashcode.
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /** Drop a tile in a particular column.
     * @param player Player that dropped the tile.
     * @param setX Column where the tile is dropped.
     * @return true if call is succesful, false if not.
     */
    public boolean setBoardAt(final Player player, final int setX) {
//        if (!shouldAdd) {
//            return false;
//        }
        if (width == 0 || height == 0 || n == 0 || player == null) {
            return false;
        }
        if (setX < 0 || setX > this.board.length - 1) {
            return false;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (this.board[setX][i] == null) {
                this.board[setX][i] = player;
                //getWinner();
                hasStarted = true;
                return true;
            }
        }
        return false;
    }

    /** Set the board at a specific position.
     * @param player Sets the board for that player.
     * @param setX sets the X position of the board.
     * @param setY sets the Y position of the board.
     * @return True if the move succeeds, false if not.
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
//        if (getWinner() != null) {
//            return false;
//        }
        if (width == 0 || height == 0 || n == 0 || player == null) {
            return false;
        }
        if (setX < 0 || setX > this.width - 1 || setY < 0 || setY > this.height - 1) {
            return false;
        }
        if (board[setX][setY] != null) {
            return false;
        }

        if (setY == 0) {
            board[setX][setY] = player;
            //getWinner();
            hasStarted = true;
            return true;
        } else if (board[setX][setY - 1] == null) {
            return false;
        }
        board[setX][setY] = player;
        //getWinner();
        hasStarted = true;
        return true;
    }

    /**
     * Get the player at a specific board position.
     * @param getX Get X.
     * @param getY Get Y.
     * @return The player at specified position.
     */
    public Player getBoardAt(final int getX, final int getY) {
        if (getX > this.width - 1 || getX < 0 || getY > this.height - 1 || getY < 0) {
            return null;
        }
        if (board[getX][getY] == null) {
            return null;
        }
        return board[getX][getY];
    }


    /**
     * Attempt to set the board height.
     * @param setHeight Sets the height of the board.
     * @return true if method successful, false if not.
     */
    public boolean setHeight(final int setHeight) {
        if (hasStarted) {
            return false;
        }
        if (setHeight > MAX_HEIGHT || setHeight < MIN_HEIGHT) {
            return false;
        }
        this.height = setHeight;
        heightSet = true;
        if (n > Math.max(width, height) - 1) {
            this.n = 0;
        }
        this.board = new Player[width][height];
        return true;
    }

    /**
     * Attempt to set the board width.
     * @param setWidth New width for the board.
     * @return true if setWidth is successful, false if not.
     */
    public boolean setWidth(final int setWidth) {
        if (hasStarted) {
            return false;
        }
        if (setWidth > MAX_WIDTH || setWidth < MIN_WIDTH) {
            return false;
        }
        this.board = new Player[width][height];
        this.width = setWidth;
        if (n > Math.max(width, height) - 1) {
            this.n = 0;
        }
        widthSet = true;
        return true;
    }

    /**
     * Attempt to set the current board N value.
     * @param newN New N value for the board.
     * @return true if setN successful, false if not.
     */
    public boolean setN(final int newN) {
        if (hasStarted) {
            return false;
        }
        if (!widthSet || !heightSet) {
            return false;
        }
        if (newN >= MIN_N) {
            if (newN <= (Math.max(width, height)) - 1) {
                this.n = newN;
                return true;
            }
        }
        return false;
    }

    /**
     * Compare any number of ConnectN boards.
     * @param boards The boards being compared.
     * @return Determines if the boards are the same or not.
     */
    public static boolean compareBoards(final ConnectN... boards) {
        if (boards == null || boards.length == 0) {
            return false;
        }
        for (int i = 0; i < boards.length - 1; i++) {
            if (!(compareBoards(boards[i], boards[i + 1]))) {
                return false;
            }
        }
        return true;
    }

    /**Compare two ConnectN boards.
     * @param firstBoard First board to be compared.
     * @param secondBoard Second board to be compared.
     * @return Determines if the boards are the same or not.
     */
    public static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
        if (firstBoard == null || secondBoard == null) {
            return false;
        }
        if (firstBoard.getWidth() != secondBoard.getWidth()) {
            return false;
        }
        if (firstBoard.getHeight() != secondBoard.getHeight()) {
            return false;
        }
        if (firstBoard.getN() != secondBoard.getN()) {
            return false;
        }
//        if (firstBoard.getN() != secondBoard.getN()) {
//            return false;
//        }
        if (firstBoard.equals(secondBoard)) {
            return true;
        }
        Player[][] board1 = firstBoard.getBoard();
        Player[][] board2 = secondBoard.getBoard();
        if (board1 == null && board2 == null) {
            return true;
        }

        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[0].length; j++) {
//                if (firstBoard.getBoardAt(i, j) == null && secondBoard.getBoardAt(i, j) == null) {
//                    continue;
//                }
//                if (firstBoard.getBoardAt(i, j) == null || secondBoard.getBoardAt(i, j) == null
//                    || !(firstBoard.getBoardAt(i, j).equals(secondBoard.getBoardAt(i, j)))) {
//                    return false;
//                }
                if (board1[i][j] == board2[i][j]) {
                    continue;
                }

                if (!board1[i][j].equals(board2[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**Class method to create a new ConnectN board.
     * @param width Width of the board.
     * @param height Height of the board.
     * @param n N value for the board.
     * @return A new ConnectN board.
     */
    public static ConnectN create(final int width, final int height, final int n) {
        if (width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT
            || n < MIN_N || n > width - 1 || n > height - 1) {
            return null;
        }
        return new ConnectN(width, height, n);
    }

    /**Creates multiple new ConnectN instances.
     * @param number Number of board instances.
     * @param width Width of the boards.
     * @param height Height of the boards.
     * @param n N value for the boards in question.
     * @return The created ConnectN boards.
     */
    public static ConnectN[] createMany(final int number, final int width, final int height, final int n) {
        if (number == 0) {
            return null;
        }
        if (width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT
                || n < MIN_N || n > width - 1 || n > height - 1) {
            return null;
        }
        ConnectN[] list = new ConnectN[number];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ConnectN(width, height, n);
        }
        return list;
    }

    /** Define equality for the ConnectN class.
     * @param obj Determining equality of Object obj.
     * @return Determines if two ConnectN objects are equal.
     */
    public boolean equals(final java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ConnectN other = (ConnectN) obj;
        return id == other.id;
    }

    /**
     * Return the total number of games that have been created.
     * @return gameCount.
     */
    public static int getTotalGames() {
        return gameCount;
    }
}
