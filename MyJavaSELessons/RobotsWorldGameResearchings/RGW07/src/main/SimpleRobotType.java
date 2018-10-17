package main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum SimpleRobotType {
	BUILDER, DESTROYER, KILLER, DEFENDER, ALL;
	private Log LOG = LogFactory.getLog(SimpleRobotType.class);
	public RobotType getRobotType(SimpleRobotType simpleRobotType) {
		return convertRobotType(simpleRobotType);
	}

	private RobotType convertRobotType(SimpleRobotType simpleRobotType) {
		for (RobotType type : RobotType.values()) {
			LOG.debug(type.getSimpleRobotType() + " --- " + simpleRobotType);
			if (type.getSimpleRobotType().equals(simpleRobotType)) {
				return type;
			}
		}
		throw new UnsupportedOperationException("from convertRobotType()");
	}

}
