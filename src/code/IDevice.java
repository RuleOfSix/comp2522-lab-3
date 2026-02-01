/**
 * Abstract class that can represent any smart device with a particular purpose.
 *
 * @author June Pyle
 * @version 1.0
 */
public abstract class IDevice
{
    private final String purpose;

    public IDevice(final String purpose)
    {
        validatePurpose(purpose);

        this.purpose = purpose;
    }

    /**
     * Prints the details of an IDevice, which includes its purpose, to the console.
     */
    public abstract void printDetails();

    /**
     * Accessor for the IDevice's purpose.
     *
     * @return The String containing the IDevice's purpose
     */
    public final String getPurpose()
    {
        return purpose;
    }

    // Validates a purpose, which must not be null.
    private static void validatePurpose(final String purpose)
    {
        if (purpose == null)
        {
            throw new IllegalArgumentException("invalid purpose");
        }
    }
}
