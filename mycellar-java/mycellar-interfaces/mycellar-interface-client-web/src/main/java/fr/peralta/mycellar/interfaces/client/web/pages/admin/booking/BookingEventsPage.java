/*
 * Copyright 2011, MyBookingEvent
 *
 * This file is part of MyBookingEvent.
 *
 * MyBookingEvent is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyBookingEvent is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MyBookingEvent. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.peralta.mycellar.interfaces.client.web.pages.admin.booking;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import fr.peralta.mycellar.domain.booking.BookingEvent;
import fr.peralta.mycellar.domain.booking.repository.BookingEventOrder;
import fr.peralta.mycellar.domain.booking.repository.BookingEventOrderEnum;
import fr.peralta.mycellar.domain.shared.exception.BusinessException;
import fr.peralta.mycellar.interfaces.client.web.components.booking.data.BookingEventDataProvider;
import fr.peralta.mycellar.interfaces.client.web.components.shared.data.MultipleSortableDataProvider;
import fr.peralta.mycellar.interfaces.client.web.pages.admin.AbstractEditPage;
import fr.peralta.mycellar.interfaces.client.web.pages.admin.AbstractListPage;
import fr.peralta.mycellar.interfaces.facades.booking.BookingServiceFacade;

/**
 * @author speralta
 */
public class BookingEventsPage extends
        AbstractListPage<BookingEvent, BookingEventOrderEnum, BookingEventOrder> {

    private static final long serialVersionUID = 201203262250L;

    @SpringBean
    private BookingServiceFacade bookingServiceFacade;

    /**
     * @param parameters
     */
    public BookingEventsPage(PageParameters parameters) {
        super(parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected MultipleSortableDataProvider<BookingEvent, BookingEventOrderEnum, BookingEventOrder> getDataProvider() {
        return new BookingEventDataProvider();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<IColumn<BookingEvent, BookingEventOrderEnum>> getColumns() {
        List<IColumn<BookingEvent, BookingEventOrderEnum>> columns = new ArrayList<IColumn<BookingEvent, BookingEventOrderEnum>>();
        columns.add(new PropertyColumn<BookingEvent, BookingEventOrderEnum>(new ResourceModel(
                "name"), BookingEventOrderEnum.NAME, "name"));
        columns.add(new PropertyColumn<BookingEvent, BookingEventOrderEnum>(new ResourceModel(
                "start"), BookingEventOrderEnum.START, "start"));
        columns.add(new PropertyColumn<BookingEvent, BookingEventOrderEnum>(
                new ResourceModel("end"), BookingEventOrderEnum.END, "end"));
        return columns;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected PageParameters getEditPageParameters(BookingEvent object) {
        if (object == null) {
            return BookingEventPage.getPageParametersForCreation();
        } else {
            return BookingEventPage.getPageParameters(object);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<? extends AbstractEditPage<BookingEvent>> getEditPageClass() {
        return BookingEventPage.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deleteObject(BookingEvent object) throws BusinessException {
        bookingServiceFacade.deleteBookingEvent(object);
    }

}
