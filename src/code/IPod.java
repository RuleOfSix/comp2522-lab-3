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
    public IPod(final int songsStored, final double maxVolumeDb)
    {
        super(PURPOSE);

        validateSongsStored(songsStored);
        validateMaxVolumeDb(maxVolumeDb);

        this.songsStored = songsStored;
        this.maxVolumeDb = maxVolumeDb;
    }

    /**
     * Prints the following details about this IPod to the console:
     *     - Purpose
     *     - Number of songs stored
     *     - Maximum volume in decibels
     */
    @Override
    public void printDetails() {
        System.out.println("Purpose: " + this.getPurpose());
        System.out.println("Number of songs stored: " + this.songsStored);
        System.out.println("Maximum volume (decibels): " + this.maxVolumeDb);
    }

    public int getSongsStored() {
        return this.songsStored;
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
