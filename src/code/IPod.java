/**
 * Represents an IPod, which is an IDevice for the purpose of listening to music.
 *
 * @author June Pyle
 * @version 1.0
 */
public class IPod extends IDevice
{
    private static final String PURPOSE = "music";
    private static final int MIN_SONGS_STORED = 0;
    private static final double MIN_MAX_VOLUME_DB = 0.0;

    private int songsStored;
    private double maxVolumeDb;

    /**
     * Constructs a new IPod with the given parameters, if they are valid.
     *
     * @param songsStored the discrete number of songs currently stored on the IPod
     * @param maxVolumeDb the maximum volume of the IPod, in decibels
     */
    public IPod(final int songsStored,
                final double maxVolumeDb)
    {
        super(PURPOSE);

        validateSongsStored(songsStored);
        validateMaxVolumeDb(maxVolumeDb);

        this.songsStored = songsStored;
        this.maxVolumeDb = maxVolumeDb;
    }

    /**
     * Prints the IPod's details to the console (see toString for specifics).
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Generates a String representation of the IPod, containing all of its fields.
     *
     * @return A String with the IPod's:
     * - Purpose
     * - Number of songs stored
     * - Maximum number in decibels
     */
    @Override
    public String toString()
    {
        final StringBuilder toStringBuilder;
        final String superString;

        superString = super.toString();
        toStringBuilder = new StringBuilder(superString);

        toStringBuilder.append("Songs stored: ");
        toStringBuilder.append(songsStored);
        toStringBuilder.append('\n');
        toStringBuilder.append("Maximum volume (decibels): ");
        toStringBuilder.append(maxVolumeDb);
        toStringBuilder.append('\n');

        return toStringBuilder.toString();
    }

    /**
     * Determines whether this IPod is equal to a given object. IPods can only be equal to other non-null
     * IPods. IPods are considered equal if and only if they have the same number of songs stored on them.
     *
     * @param o   the reference object with which to compare
     * @return true if o is an IPod with the same amount of songs stored on it as this one, false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (!(o instanceof final IPod other)) {
            return false;
        }

        return this.songsStored == other.getSongsStored();
    }

    /**
     * Generates a hash code value for the IPod, determined by the number of songs stored on it. Since equality of
     * IPods is based on the number of songs stored on them, this upholds the hashCode() contract.
     *
     * @return a hash code value for the IPod
     */
    @Override
    public int hashCode()
    {
        return this.songsStored;
    }

    /**
     * Accessor for songsStored.
     *
     * @return the number of songs currently stored on the IPod.
     */
    public final int getSongsStored()
    {
        return this.songsStored;
    }

    /**
     * Mutator for songsStored.
     *
     * @param songsStored the new number of songs stored on the IPod.
     */
    public final void setSongsStored(final int songsStored)
    {
        validateSongsStored(songsStored);
        this.songsStored = songsStored;
    }

    /**
     * Accessor for maxVolumeDb.
     *
     * @return the current maximum volume of the IPod, in decibels.
     */
    public final double getMaxVolumeDb()
    {
        return this.maxVolumeDb;
    }

    /**
     * Mutator for maxVolumeDb.
     *
     * @param maxVolumeDb the new maximum volume of the IPod, in decibels.
     */
    public final void setMaxVolumeDb(final double maxVolumeDb)
    {
        validateMaxVolumeDb(maxVolumeDb);
        this.maxVolumeDb = maxVolumeDb;
    }

    // Validates the number of songs stored on the IPod, which cannot be less than MIN_SONGS_STORED
    private static void validateSongsStored(final int songsStored)
    {
        if (songsStored < MIN_SONGS_STORED)
        {
            throw new IllegalArgumentException("Invalid amount of songs stored: " + songsStored);
        }
    }

    // Validates the maximum volume in decibels, which cannot be less than MIN_MAX_VOLUME_DB
    private static void validateMaxVolumeDb(final double maxVolumeDb)
    {
        if (maxVolumeDb < MIN_MAX_VOLUME_DB)
        {
            throw new IllegalArgumentException("Invalid maximum volume in decibels: " + maxVolumeDb);
        }
    }
}
