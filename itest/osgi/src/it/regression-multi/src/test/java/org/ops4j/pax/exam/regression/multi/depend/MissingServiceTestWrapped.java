/*
 * Copyright 2013 Harald Wellmann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ops4j.pax.exam.regression.multi.depend;

import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemPackage;
import static org.ops4j.pax.exam.regression.multi.RegressionConfiguration.regressionDefaults;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Info;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;

/**
 * This test is expected to fail with a ServiceLookupException, as no Runnable is registered.
 * <p>
 * For this reason, the test shall not be run directly in the integration test suite.
 * 
 * @author Harald Wellmann
 */
@RunWith(PaxExam.class)
public class MissingServiceTestWrapped {

    @Inject
    private Runnable runnable;

    @Configuration
    public Option[] config() {
        return options(regressionDefaults(), //
            systemPackage("org.ops4j.pax.swissbox.tracker; version="
                + Info.getPaxSwissboxVersion().replace("-SNAPSHOT", "")), 
                junitBundles());
    }

    @Test
    public void bundlesShouldBeResolved() {
        assertTrue(true);
    }
}
