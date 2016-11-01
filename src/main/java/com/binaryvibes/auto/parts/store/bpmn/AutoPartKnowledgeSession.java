package com.binaryvibes.auto.parts.store.bpmn;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Component;

/**
 * File: AutoPartKnowledgeSession.java
 *
 * @author Aamir Muhammad
 */
@Component
public class AutoPartKnowledgeSession {

    public KieSession getStatefulKnowledgeSession() throws Exception {
        KieHelper kieHelper = new KieHelper();
        KieBase kieBase = kieHelper.addResource(
                ResourceFactory.newClassPathResource("META-INF/spring/autoPartStore.bpmn"),
                ResourceType.BPMN2).build();
        return kieBase.newKieSession();
    }
}
