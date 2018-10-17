package main;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum RobotTypeTarget {
	
	BUILDER(Arrays.asList(RobotTypeUtils.BUILDER)),
	DESTROYER(Arrays.asList(RobotTypeUtils.DESTROYER)),
	KILLER(Arrays.asList(RobotTypeUtils.KILLER)),
	DEFENDER(Arrays.asList(RobotTypeUtils.DEFENDER)),
	ALL(Arrays.asList(RobotTypeUtils.values()));
	
	private Log LOG = LogFactory.getLog(RobotTypeTarget.class);
	private List<RobotTypeUtils> robotTypes;
	private RobotTypeTarget(List<RobotTypeUtils> robotTypes) {
		this.robotTypes = robotTypes;
	}

	public List<RobotTypeUtils> getRobotType() {
		return robotTypes;
	}




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
