package ca.bcit.comp2522.lab03;

/**
 * Represents an IPad, which is an IDevice for the purpose of learning.
 *
 * @author June Pyle
 * @author Min Lee
 *
 * @version 1.0.0
 */
public class IPad extends IDevice
{
    private static final String PURPOSE = "learning";
    private boolean tabletCase;


    private String operatingSystemVersion;


    /**
     * Constructs a new IPad with the given parameters, if they are valid.
     *
     * @param tabletCase             true if the IPad currently has a case, false otherwise
     * @param operatingSystemVersion the current OS version of the IPad
     */
    public IPad(final boolean tabletCase,
                final String operatingSystemVersion)
    {
        super(PURPOSE);

        // all possible values of tabletCase are valid
        validateOperatingSystemVersion(operatingSystemVersion);

        this.tabletCase = tabletCase;
        this.operatingSystemVersion = operatingSystemVersion;
    }

    /**
     * Prints the IPad's details to the console (see toString for specifics).
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Generates a String representation of the IPad, containing all of its fields.
     *
     * @return A String with the IPad's:
     * - Purpose
     * - Whether it has a case
     * - Operating system version
     */
    @Override
    public String toString()
    {
        final StringBuilder toStringBuilder;
        final String superString;

        superString = super.toString();
        toStringBuilder = new StringBuilder(superString);

        toStringBuilder.append("Has case: ");
        toStringBuilder.append(this.tabletCase);
        toStringBuilder.append('\n');
        toStringBuilder.append("Operating system version: ");
        toStringBuilder.append(this.operatingSystemVersion);
        toStringBuilder.append('\n');

        return toStringBuilder.toString();
    }

    /**
     * Determines whether this IPad is equal to a given object. IPads can only be equal to other non-null
     * IPads. IPads are considered equal if and only if they have the same operating system version.
     *
     * @param o the reference object with which to compare
     * @return true if o is an IPad with the same operating system version as one, false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (!(o instanceof final IPad other))
        {
            return false;
        }

        return this.operatingSystemVersion.equals(other.getOperatingSystemVersion());
    }

    /**
     * Generates a hash code value for the IPad, determined by its operating system version. Since equality of
     * IPads is based on operating system version, this upholds the hashCode() contract.
     *
     * @return a hash code value for the IPad
     */
    @Override
    public int hashCode()
    {
        return this.operatingSystemVersion.hashCode();
    }

    /**
     * Accessor for tabletCase.
     *
     * @return true if the IPad currently has a case, false otherwise.
     */
    public final boolean hasCase()
    {
        return this.tabletCase;
    }

    /**
     * Mutator for tabletCase.
     *
     * @param tabletCase true to give the IPad a case, false to remove any case from the IPad
     */
    public final void setTabletCase(final boolean tabletCase)
    {
        // all possible values of tabletCase are valid
        this.tabletCase = tabletCase;
    }

    /**
     * Accessor for operatingSystemVersion.
     *
     * @return the IPad's operating system version
     */
    public final String getOperatingSystemVersion()
    {
        return this.operatingSystemVersion;
    }

    /**
     * Mutator for operatingSystemVersion.
     *
     * @param operatingSystemVersion the IPad's new operating system version.
     */
    public final void setOperatingSystemVersion(final String operatingSystemVersion)
    {
        validateOperatingSystemVersion(operatingSystemVersion);
        this.operatingSystemVersion = operatingSystemVersion;
    }

    /*
     * Validates the operating system version of the IPad. A String is a valid operating system version if
     * it is not null and not blank (that is, it must have non-whitespace characters).
     */
    private static void validateOperatingSystemVersion(final String operatingSystemVersion)
    {
        if (operatingSystemVersion == null ||
            operatingSystemVersion.isBlank())
        {
            throw new IllegalArgumentException("Invalid operating system version");
        }
    }
}
