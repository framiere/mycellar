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
package fr.peralta.mycellar.interfaces.client.web.components.wine.edit;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;

import fr.peralta.mycellar.domain.wine.WineColorEnum;
import fr.peralta.mycellar.domain.wine.WineTypeEnum;
import fr.peralta.mycellar.interfaces.client.web.components.shared.feedback.FormComponentFeedbackBorder;

/**
 * @author speralta
 */
public class WineEditPanel extends Panel {

    private static final long serialVersionUID = 201109081819L;

    /**
     * @param id
     */
    public WineEditPanel(String id) {
        super(id);
        add(new TextField<WineTypeEnum>("type").setEnabled(false));
        add(new TextField<WineColorEnum>("color").setEnabled(false));
        add(new TextField<String>("producer.name").setEnabled(false));
        add(new TextField<String>("appellation.name").setEnabled(false));
        add(new FormComponentFeedbackBorder("vintage").add(new TextField<Integer>("vintage")));
        add(new FormComponentFeedbackBorder("name").add(new TextField<String>("name")));
        add(new FormComponentFeedbackBorder("ranking").add(new TextField<String>("ranking")));
    }

}
