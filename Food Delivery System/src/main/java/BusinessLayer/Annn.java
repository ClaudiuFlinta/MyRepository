package BusinessLayer;

public interface Annn {

    /**
     * Sets the id.
     *
     * @param  id id of the client
     * @throws IllegalArgumentException if id < 0
     */
    static void checkClientId(int id) {
        // Enforce specified precondition in public method
        if (id < 0)
            throw new IllegalArgumentException("Illegal id: " + id);

    }

}
