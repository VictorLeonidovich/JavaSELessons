package main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum RobotTypeTarget {
	BUILDER, DESTROYER, KILLER, DEFENDER, ALL;
	private Log LOG = LogFactory.getLog(RobotTypeTarget.class);
	public RobotTypeUtils getRobotType(RobotTypeTarget simpleRobotType) {
		return convertRobotType(simpleRobotType);
	}

	private RobotTypeUtils convertRobotType(RobotTypeTarget simpleRobotType) {
		for (RobotTypeUtils type : RobotTypeUtils.values()) {
			LOG.debug(type.getRobotTypeTarget() + " --- " + simpleRobotType);
			if (type.getRobotTypeTarget().equals(simpleRobotType)) {
				return type;
			}
		}
		throw new UnsupportedOperationException("from convertRobotType()");
	}

}
