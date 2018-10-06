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

    /** Counts how many times a constructor has been called. */
    private static int gameCount = 0;

    /** ID of the current game. */
    private int id;

    /** Determines whether there is an existing game. */
    private static boolean ongoingGame = false;

    //Write Constructors
    /**
     * Create a new ConnectN board with uninitialized width, height, and N value.
     */
    public ConnectN() {
        this.height = 0;
        this.width = 0;
        this.n = 0;
        gameCount++;
        this.id = gameCount - 1;
    }

    /**
     * Create a new ConnectN board with given width and height and uninitialized N value.
     * @param setWidth Set the width.
     * @param setHeight Set the height.
     */
    public ConnectN(final int setWidth, final int setHeight) {
        if (setWidth >= MIN_WIDTH && setWidth <= MAX_WIDTH) {
            this.width = setWidth;
        } else {
            this.width = 0;
        }
        if (setHeight >= MIN_HEIGHT && setHeight <= MAX_HEIGHT) {
            this.height = setHeight;
        } else {
            this.height = 0;
        }
        this.n = 0;
        gameCount++;
        this.id = gameCount - 1;
    }

    /**
     * Creates a new ConnectN board with a given width, height, and N value.
     * @param setWidth Set the width.
     * @param setHeight Set the height.
     * @param setN Set the N value.
     */
    public ConnectN(final int setWidth, final int setHeight, final int setN) {
        if (setWidth >= MIN_WIDTH && setWidth <= MAX_WIDTH) {
            this.width = setWidth;
        } else {
            this.width = 0;
        }
        if (setHeight >= MIN_HEIGHT && setHeight <= MAX_HEIGHT) {
            this.height = setHeight;
        } else {
            this.height = 0;
        }
        if (setN >= MIN_N && (setN <= this.height - 1 && setN <= this.width - 1)) {
            n = setN;
        } else {
            n = 0;
        }

        gameCount++;
        this.id = gameCount - 1;
    }

    /**
     * Create a new ConnectN board with dimensions and N value copied from another board.
     * @param otherBoard Board to be read by the constructor.
     */
    public ConnectN(final ConnectN otherBoard) {
        this.width = otherBoard.getWidth();
        this.height = otherBoard.getHeight();
        this.n = otherBoard.getN();
        this.id = otherBoard.getID();
        gameCount++;
    }

    //Write methods
    /**
     * Return a copy of the board.
     * @return board.
     */
    public Player[][] getBoard() {
        if (width > 0 && height > 0) {
            return new Player[0][0];
        }
        return null;
    }

    /**
     * Get the player at a specific board position.
     * @param getX Get X.
     * @param getY Get Y.
     * @return The player at specified position.
     */
    public Player getBoardAt(final int getX, final int getY) {
        return new Player("bob");
    }

    /**
     * Get the current board height.
     * @return height.
     */
    public int getHeight() {
        return height;
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
        return n;
    }

    /**
     * Get the current board width.
     * @return width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Return the winner of the game, or null if the game has not ended.
     * @return winner.
     */
    public Player getWinner() {
        return new Player("Bob");
    }

    /**
     * Define the hash code for the ConnectN class.
     * @return Hashcode.
     */
    public int hashCode() {
        return 0;
    }

    /** Drop a tile in a particular column.
     * @param player Player that dropped the tile.
     * @param x Column where the tile is dropped.
     * @return true if call is succesful, false if not.
     */
    public boolean setBoardAt(final Player player, final int x) {

        ongoingGame = true;
        return true;
    }

    /** Set the board at a specific position.
     * @param player Sets the board for that player.
     * @param setX sets the X position of the board.
     * @param setY sets the Y position of the board.
     * @return True if the move succeeds, false if not.
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        return true;
    }

    /**
     * Attempt to set the board height.
     * @param setHeight Sets the height of the board.
     * @return true if method succesful, false if not.
     */
    public boolean setHeight(final int setHeight) {
        return true;
    }

    /**
     * Attempt to set the current board N value.
     * @param newN New N value for the board.
     * @return true if setN succesful, false if not.
     */
    public boolean setN(final int newN) {
        return true;
    }

    /**
     * Attempt to set the board width.
     * @param setWidth New width for the board.
     * @return true if setWidth is succesful, false if not.
     */
    public boolean setWidth(final int setWidth) {
        return true;
    }

    /**
     * Compare any number of ConnectN boards.
     * @param boards The boards being compared.
     * @return Determines if the boards are the same or not.
     */
    public static boolean compareBoards(final ConnectN... boards) {
        return true;
    }

    /**Compare two ConnectN boards.
     * @param firstBoard First board to be compared.
     * @param secondBoard Second board to be compared.
     * @return Determines if the boards are the same or not.
     */
    public static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
        return true;
    }

    /**Class method to create a new ConnectN board.
     * @param width Width of the board.
     * @param height Height of the board.
     * @param n N value for the board.
     * @return A new ConnectN board.
     */
    public static ConnectN create(final int width, final int height, final int n) {
        return new ConnectN();
    }

    /**Creates multiple new ConnectN instances.
     * @param number Number of board instances.
     * @param width Width of the boards.
     * @param height Height of the boards.
     * @param n N value for the boards in question.
     * @return The created ConnectN boards.
     */
    public static ConnectN[] createMany(final int number, final int width, final int height, final int n) {
        return new ConnectN[0];
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
