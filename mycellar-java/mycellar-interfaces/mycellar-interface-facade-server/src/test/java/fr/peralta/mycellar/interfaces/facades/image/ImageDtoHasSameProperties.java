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
package fr.peralta.mycellar.interfaces.facades.image;

import static org.hamcrest.CoreMatchers.*;
import fr.peralta.mycellar.interfaces.facades.PropertiesMatcher;
import fr.peralta.mycellar.interfaces.facades.image.dto.Image;

/**
 * @author speralta
 */
public class ImageDtoHasSameProperties extends PropertiesMatcher<Image> {

    public ImageDtoHasSameProperties(Image image) {
        addProperty("content", is(equalTo(image.getContent())));
        addProperty("contentType", is(equalTo(image.getContentType())));
        addProperty("height", is(equalTo(image.getHeight())));
        addProperty("id", is(equalTo(image.getId())));
        addProperty("name", is(equalTo(image.getName())));
        addProperty("width", is(equalTo(image.getWidth())));
    }
}
