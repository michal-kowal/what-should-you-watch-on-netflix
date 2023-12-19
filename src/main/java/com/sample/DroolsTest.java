package com.sample;

import javax.swing.JFrame;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
    	JFrame frame = new JFrame();
        KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	try {
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        frame.setLayout(null);
    }
}
