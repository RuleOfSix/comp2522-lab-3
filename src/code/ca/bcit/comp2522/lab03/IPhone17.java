package ca.bcit.comp2522.lab03;

import java.util.Objects;

/**
 * Represents an IPhone17, which is an IPhone with high-resolution camera, and gigabytes of memory.
 *
 * @author June Pyle
 * @author Min Lee
 * @version 1.0.0
 */
public class IPhone17 extends IPhone
{
    private static final int MIN_MEMORY_GB = 0;

    private boolean highResolutionCamera;
    private int memoryGB;

    /**
     * Constructs a new IPhone17 with the given parameters with valid memory.
     *
     * @param remainingPlanMinutes the number of minutes remaining on phone plan for the IPhone17
     * @param carrier              the name of the IPhone17's carrier
     * @param highResolutionCamera true if the IPhone17 has a camera, false otherwise
     * @param memoryGB             the gigabytes of memory of IPhone17
     */
    public IPhone17(final double remainingPlanMinutes,
                    final String carrier,
                    final boolean highResolutionCamera,
                    final int memoryGB)
    {
        super(remainingPlanMinutes,
              carrier);

        // All possible values of highResolutionCamera are valid
        validateMemoryGB(memoryGB);

        this.highResolutionCamera = highResolutionCamera;
        this.memoryGB = memoryGB;
    }

    /**
     * Prints the IPhone17's details to the console (see toString for specifics).
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Generates a String representation of the IPhone17, containing all of its fields.
     *
     * @return A String with the IPhone17's:
     * - highResolutionCamera
     * - gigabytes of memory
     */
    @Override
    public String toString()
    {
        final StringBuilder toStringBuilder;
        final String superString;

        superString = super.toString();
        toStringBuilder = new StringBuilder(superString);

        toStringBuilder.append("Has high resolution camera: ");
        toStringBuilder.append(this.highResolutionCamera);
        toStringBuilder.append('\n');
        toStringBuilder.append("The gigabytes of memory: ");
        toStringBuilder.append(this.memoryGB);
        toStringBuilder.append('\n');

        return toStringBuilder.toString();
    }

    /**
     * Determines whether this IPhone17 is equal to a given object. IPhone can only be equal to other non-null
     * IPhone17. IPhone 17 are considered equal when objects have the same amount of minutes on their phone plan
     * and the same value for high-resolution camera
     *
     * @param o the reference object with which to compare
     * @return true if o is an IPhone17 with the same amount of minutes remaining, and
     * same value for high-resolution camera,
     * false otherwise.
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (!(o instanceof final IPhone17 other))
        {
            return false;
        }

        if (!super.equals(o))
        {
            return false;
        }

        return this.highResolutionCamera == other.hasHighResolutionCamera();
    }

    /**
     * Returns a hash code value for the IPhone17, based on the remaining plan minutes and
     * values of high resolution camera
     *
     * @return a hash code value for the IPhone17
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.getRemainingPlanMinutes(),
                            highResolutionCamera);
    }

    /**
     * Accessor for memoryGB
     *
     * @return gigabytes of memory of IPhone17
     */
    public final int getMemoryGB()
    {
        return this.memoryGB;
    }

    /**
     * Mutator for memoryGB
     *
     * @param memoryGB gigabytes of memory of IPhone17
     */
    public final void setMemoryGB(final int memoryGB)
    {
        validateMemoryGB(memoryGB);
        this.memoryGB = memoryGB;
    }

    /**
     * Accessor for high-resolution camera
     *
     * @return true if the IPhone17 has a camera, false otherwise.
     */
    public final boolean hasHighResolutionCamera()
    {
        return this.highResolutionCamera;
    }

    /**
     * Mutator for high-resolution camera
     *
     * @param highResolutionCamera true to newly indicate IPhone17 has a camera, false otherwise.
     */
    public final void setHighResolutionCamera(final boolean highResolutionCamera)
    {
        // All possible values of high resolution camera are valid
        this.highResolutionCamera = highResolutionCamera;
    }


    // Validates the gigabytes of memory of IPhone17 , which cannot be less than MIN_MEMORY_GB
    private static void validateMemoryGB(final int memoryGB)
    {
        if (memoryGB < MIN_MEMORY_GB)
        {
            throw new IllegalArgumentException("Invalid memory of IPhone17: " + memoryGB);
        }
    }

}
