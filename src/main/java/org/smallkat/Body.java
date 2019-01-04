package org.smallkat;

import us.ihmc.simulationconstructionset.FloatingJoint;
import us.ihmc.simulationconstructionset.Link;

public interface Body {
    FloatingJoint getMainBodyJoint();
    Link getLink();


}
