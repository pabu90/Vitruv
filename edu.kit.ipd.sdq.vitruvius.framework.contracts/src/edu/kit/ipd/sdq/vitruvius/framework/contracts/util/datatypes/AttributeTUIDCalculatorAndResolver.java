package edu.kit.ipd.sdq.vitruvius.framework.contracts.util.datatypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.EcoreBridge;

/**
 * A {@link HierarchicalTUIDCalculatorAndResolver} that creates the TUID for each {@link EObject} by
 * finding the first attribute from the list that the EObject possesses and returning
 * "{attribute name}={attribute value}".
 *
 * @see DefaultTUIDCalculatorAndResolver
 * @author Dominik Werle
 */
public class AttributeTUIDCalculatorAndResolver extends HierarchicalTUIDCalculatorAndResolver<EObject> {
    private final List<String> attributeNames;

    /**
     * class name is used as prefix for every TUID to determine whether an TUID was created using
     * this class. Copied from {@link DefaultTUIDCalculatorAndResolver}.
     */
    private static final String TUIDIdentifier = AttributeTUIDCalculatorAndResolver.class.getSimpleName();

    public AttributeTUIDCalculatorAndResolver(final String tuidPrefix, final String... attributeNames) {
        super(tuidPrefix);
        this.attributeNames = Arrays.asList(attributeNames);
    }

    public AttributeTUIDCalculatorAndResolver(final String tuidPrefix, final Collection<String> attributeNames) {
        super(tuidPrefix);
        this.attributeNames = new ArrayList<String>(attributeNames);
    }

    @Override
    protected Class<EObject> getRootObjectClass() {
        return EObject.class;
    }

    @Override
    protected boolean hasId(final EObject obj, final String indidivualId) throws IllegalArgumentException {
        return indidivualId.equals(calculateIndividualTUIDDelegator(obj));
    }

    @Override
    protected String calculateIndividualTUIDDelegator(final EObject obj) throws IllegalArgumentException {
        for (String attributeName : this.attributeNames) {
            final String attributeValue = EcoreBridge.getStringValueOfAttribute(obj, attributeName);
            if (null != attributeValue) {
                return attributeName + "=" + attributeValue;
            }
        }

        throw new RuntimeException(
                "None of '" + String.join("', '", this.attributeNames) + "' found for eObject '" + obj + "'");
    }
}