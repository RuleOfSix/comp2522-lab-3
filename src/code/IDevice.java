/**
 * Abstract class that can represent any smart device with a particular purpose.
 *
 * @author June Pyle
 * @author Min Lee
 * @version 1.0
 */
public abstract class IDevice
{
    private final String purpose;

    protected IDevice(final String purpose)
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

    /**
     * Creates a String representation of the IDevice.
     *
     * @return a String containing the IDevice's purpose
     */
    @Override
    public String toString()
    {
        return String.format("Purpose: %s\n",
                             purpose);
    }

    /**
     * Determines whether this IDevice is equal to a given object. IDevices can only be equal to other non-null
     * IDevices. IDevices are considered equal if and only if their purposes are the same.
     *
     * @param o the reference object with which to compare
     * @return true if o is an IDevice with an equal purpose to this one, false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (!(o instanceof final IDevice other))
        {
            return false;
        }

        return this.purpose.equals(other.getPurpose());
    }

    /**
     * Generates a hash code value for the IDevice, determined by its purpose. Since equality of IDevices is
     * based on their purpose, this upholds the hashCode() contract.
     *
     * @return a hash code value for the IDevice
     */
    @Override
    public int hashCode()
    {
        return this.purpose.hashCode();
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
