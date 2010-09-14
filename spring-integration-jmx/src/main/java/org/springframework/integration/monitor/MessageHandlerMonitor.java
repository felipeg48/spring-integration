/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.monitor;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.support.MetricType;

/**
 * @author Dave Syer
 *
 * @since 2.0
 */
public interface MessageHandlerMonitor {

	/**
	 * @return the number of successful handler calls
	 */
	@ManagedMetric(metricType = MetricType.COUNTER, displayName = "Handler Execution Count", description = "rate=1h")
	int getHandleCount();

	/**
	 * @return the number of failed handler calls
	 */
	@ManagedMetric(metricType = MetricType.COUNTER, displayName = "Handler Error Count", description = "rate=1h")
	int getErrorCount();

	/**
	 * @return the maximum handler duration (milliseconds)
	 */
	@ManagedMetric(metricType = MetricType.GAUGE, displayName = "Handler Mean Duration")
	double getMeanDuration();

	/**
	 * @return the minimum handler duration (milliseconds)
	 */
	@ManagedMetric(metricType = MetricType.GAUGE, displayName = "Handler Min Duration")
	double getMinDuration();

	/**
	 * @return the standard deviation handler duration (milliseconds)
	 */
	@ManagedMetric(metricType = MetricType.GAUGE, displayName = "Handler Max Duration")
	double getMaxDuration();

	@ManagedMetric(metricType = MetricType.GAUGE, displayName = "Handler Standard Deviation Duration")
	double getStandardDeviationDuration();
	
	/**
	 * @return summary statistics about the handler duration (milliseconds)
	 */
	Statistics getDuration();

	String getName();

	String getSource();

}