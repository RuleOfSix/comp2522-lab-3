package ca.bcit.comp2522.lab03;

/**
 * Represents an IPhone, which is an IDevice for the purpose of talking.
 *
 * @author June Pyle
 * @author Min Lee
 * @version 1.0.0
 */
public class IPhone extends IDevice
{
    private static final String PURPOSE = "talking";
    private static final double MIN_REMAINING_PLAN_MINUTES = 0.0;

    private double remainingPlanMinutes;
    private String carrier;

    /**
     * Constructs a new IPhone with the given parameters, if they are valid.
     *
     * @param remainingPlanMinutes number of minutes remaining on phone plan
     * @param carrier              the name of carrier
     */
    public IPhone(final double remainingPlanMinutes,
                  final String carrier)
    {
        super(PURPOSE);

        validateRemainingPlanMinutes(remainingPlanMinutes);
        validateCarrier(carrier);

        this.remainingPlanMinutes = remainingPlanMinutes;
        this.carrier = carrier;
    }


    /**
     * Prints the IPhone's details to the console (see toString for specifics).
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Generates a String representation of the IPhone, containing all of its fields.
     *
     * @return A String with the IPhone's:
     *         - Purpose
     *         - carrier
     *         - minutes remaining on phone plan
     */
    @Override
    public String toString()
    {
        final StringBuilder toStringBuilder;
        final String superString;

        superString = super.toString();
        toStringBuilder = new StringBuilder(superString);

        toStringBuilder.append("Carrier: ");
        toStringBuilder.append(this.carrier);
        toStringBuilder.append('\n');
        toStringBuilder.append("The number of minutes remaining on phone plan: ");
        toStringBuilder.append(this.remainingPlanMinutes);
        toStringBuilder.append('\n');

        return toStringBuilder.toString();
    }

    /**
     * Determines whether this IPhone is equal to a given object. IPhone can only be equal to other non-null
     * IPhone. IPhones which have the same amount of minutes remaining as each other are considered equal.
     *
     * @param o the reference object with which to compare
     * @return true if o is an IPhone with the same amount of minutes remaining, false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (!(o instanceof final IPhone other))
        {
            return false;
        }

        /*
         * We're boxing the remainingPlanMinutes value in order to use Double.equals(), which respects the
         * .equals() contract by being a true equivalence relation (it has the reflexive, transitive, symmetric,
         * and substitution properties).
         */
        final Double remainingPlanMinutes = this.remainingPlanMinutes;

        return remainingPlanMinutes.equals(other.getRemainingPlanMinutes());
    }

    /**
     * Returns a hash code value for the IPhone, based on the remaining plan minutes
     *
     * @return a hash code value for the IPhone
     */
    @Override
    public int hashCode()
    {
        return Double.hashCode(remainingPlanMinutes);
    }

    /**
     * Accessor for remainingPlanMinutes
     *
     * @return IPhone's the number of minutes remaining on phone plan.
     */
    public final double getRemainingPlanMinutes()
    {
        return this.remainingPlanMinutes;
    }


    /**
     * Mutator for remainingPlanMinutes
     *
     * @param remainingPlanMinutes IPhone's the number of minutes remaining on phone plan.
     */
    public final void setRemainingPlanMinutes(final double remainingPlanMinutes)
    {
        validateRemainingPlanMinutes(remainingPlanMinutes);
        this.remainingPlanMinutes = remainingPlanMinutes;
    }

    /**
     * Getter for carrier
     *
     * @return IPhone's carrier name.
     */
    public final String getCarrier()
    {
        return this.carrier;
    }


    /**
     * Setter for carrier
     *
     * @param carrier IPhone's carrier name
     */
    public final void setCarrier(final String carrier)
    {
        validateCarrier(carrier);
        this.carrier = carrier;
    }


    // Validates remaining minutes on plan , which cannot be less than MIN_REAMINING_PLAN_MINUTES.
    private static void validateRemainingPlanMinutes(final double remainingPlanMinutes)
    {
        if (remainingPlanMinutes < MIN_REMAINING_PLAN_MINUTES)
        {
            throw new IllegalArgumentException(
                "Invalid number of minutes remaining on phone plan: " +
                remainingPlanMinutes);
        }
    }

    // Validate the carrier of IPhone, which cannot be null or blank.
    private static void validateCarrier(final String carrier)
    {
        if (carrier == null ||
            carrier.isBlank())
        {
            throw new IllegalArgumentException("Invalid carrier");
        }
    }

}
