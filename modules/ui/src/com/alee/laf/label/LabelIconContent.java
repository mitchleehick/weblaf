/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.label;

import com.alee.painter.decoration.IDecoration;
import com.alee.painter.decoration.content.AbstractIconContent;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.swing.*;

/**
 * Label icon content implementation.
 *
 * @param <E> component type
 * @param <D> decoration type
 * @param <I> content type
 * @author Alexandr Zernov
 */

@XStreamAlias ( "LabelIcon" )
public class LabelIconContent<E extends JLabel, D extends IDecoration<E, D>, I extends LabelIconContent<E, D, I>>
        extends AbstractIconContent<E, D, I>
{
    @Override
    protected Icon getIcon ( final E c, final D d )
    {
        return c.isEnabled () ? c.getIcon () : c.getDisabledIcon ();
    }
}