/*
 * Copyright 2011, MyCellar
 *
 * This file is part of MyCellar.
 *
 * MyCellar is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyCellar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MyCellar. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.peralta.mycellar.interfaces.client.web.components.shared.cloud;

import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import fr.peralta.mycellar.interfaces.client.web.components.shared.Action;
import fr.peralta.mycellar.interfaces.client.web.components.shared.ActionLink;
import fr.peralta.mycellar.interfaces.client.web.components.shared.form.ObjectForm;
import fr.peralta.mycellar.interfaces.client.web.renderers.shared.RendererServiceFacade;

/**
 * @author speralta
 * 
 * @param <O>
 */
public abstract class ComplexTagCloud<O> extends SimpleTagCloud<O> {

    private static final long serialVersionUID = 201107191845L;

    private static final String CREATE_FORM_COMPONENT_ID = "createForm";
    private static final String ADD_COMPONENT_ID = "add";

    @SpringBean
    private RendererServiceFacade rendererServiceFacade;

    /**
     * @param id
     * @param label
     * @param objects
     * @param parentToReRender
     */
    public ComplexTagCloud(String id, IModel<?> label, Map<O, Integer> objects,
            Class<? extends Component> parentToReRender) {
        super(id, label, objects, parentToReRender);
        setOutputMarkupId(true);
        add(createHiddenCreateForm());
        add(new ActionLink(ADD_COMPONENT_ID, Action.ADD));
    }

    /**
     * @param object
     * @return
     */
    @Override
    protected String getLabelFor(O object) {
        return rendererServiceFacade.render(object);
    }

    /**
     * @param id
     * @return
     */
    protected abstract Component createComponentForCreation(String id);

    /**
     * @return
     */
    protected abstract O createObject();

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void onEvent(IEvent<?> event) {
        if (event.getPayload() instanceof Action) {
            Action action = (Action) event.getPayload();
            switch (action) {
            case SELECT:
                event.stop();
                setDefaultModelObject(((Tag<?>) event.getSource()).getDefaultModelObject());
                get(ADD_COMPONENT_ID).setVisibilityAllowed(false);
                get(VALUE_COMPONENT_ID).setVisibilityAllowed(true).setDefaultModel(
                        new Model<String>(getLabelFor((O) getDefaultModelObject())));
                get(CLOUD_COMPONENT_ID).setVisibilityAllowed(false);
                send(getParent(), Broadcast.EXACT, Action.SELECT);
                break;
            case ADD:
                get(ADD_COMPONENT_ID).setVisibilityAllowed(false);
                get(CLOUD_COMPONENT_ID).setVisibilityAllowed(false);
                replace(
                        new ObjectForm<O>(CREATE_FORM_COMPONENT_ID, createObject())
                                .replace(createComponentForCreation(ObjectForm.EDIT_PANEL_COMPONENT_ID)))
                        .setVisibilityAllowed(true);
                break;
            case SAVE:
                setDefaultModelObject(get(CREATE_FORM_COMPONENT_ID).getDefaultModelObject());
                get(VALUE_COMPONENT_ID).setVisibilityAllowed(true).setDefaultModel(
                        new Model<String>(getLabelFor((O) getDefaultModelObject())));
                replace(createHiddenCreateForm());
                break;
            default:
                throw new WicketRuntimeException("Action " + action + " not managed.");
            }
        }
    }

    private Component createHiddenCreateForm() {
        return new EmptyPanel(CREATE_FORM_COMPONENT_ID).setVisibilityAllowed(false);
    }
}
