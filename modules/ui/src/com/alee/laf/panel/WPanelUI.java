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

package com.alee.laf.panel;

import com.alee.laf.WebUI;
import com.alee.utils.LafUtils;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.plaf.PanelUI;
import java.awt.*;

/**
 * Pluggable look and feel interface for {@link JPanel} component.
 *
 * @param <C> component type
 * @author Mikle Garin
 */

public abstract class WPanelUI<C extends JPanel> extends PanelUI implements WebUI<C>
{
    /**
     * Runtime variables.
     */
    protected C panel;

    @Override
    public void installUI ( final JComponent c )
    {
        // Saving panel reference
        panel = ( C ) c;

        // Installing default component settings
        installDefaults ();

        // Installing default component listeners
        installListeners ();
    }

    @Override
    public void uninstallUI ( final JComponent c )
    {
        // Uninstalling default component listeners
        uninstallListeners ();

        // Uninstalling default component settings
        uninstallDefaults ();

        // Removing panel reference
        panel = null;
    }

    @Override
    public String getPropertyPrefix ()
    {
        return "Panel.";
    }

    /**
     * Installs default component settings.
     */
    protected void installDefaults ()
    {
        LafUtils.installDefaults ( panel, getPropertyPrefix () );
    }

    /**
     * Uninstalls default component settings.
     */
    protected void uninstallDefaults ()
    {
        LafUtils.uninstallDefaults ( panel );
    }

    /**
     * Installs default component listeners.
     */
    protected void installListeners ()
    {
        // Do nothing by default
    }

    /**
     * Uninstalls default component listeners.
     */
    protected void uninstallListeners ()
    {
        // Do nothing by default
    }

    @Override
    public int getBaseline ( final JComponent c, final int width, final int height )
    {
        super.getBaseline ( c, width, height );
        final Border border = c.getBorder ();
        if ( border instanceof AbstractBorder )
        {
            return ( ( AbstractBorder ) border ).getBaseline ( c, width, height );
        }
        return -1;
    }

    @Override
    public Component.BaselineResizeBehavior getBaselineResizeBehavior ( final JComponent c )
    {
        super.getBaselineResizeBehavior ( c );
        final Border border = c.getBorder ();
        if ( border instanceof AbstractBorder )
        {
            return ( ( AbstractBorder ) border ).getBaselineResizeBehavior ( c );
        }
        return Component.BaselineResizeBehavior.OTHER;
    }
}