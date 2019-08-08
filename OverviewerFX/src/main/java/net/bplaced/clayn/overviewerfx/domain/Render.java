/*
 * The MIT License
 *
 * Copyright 2019 Your Organisation.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.bplaced.clayn.overviewerfx.domain;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static net.bplaced.clayn.overviewerfx.domain.Dimension.OVERWORLD;

/**
 *
 * @author Clayn <clayn_osmato@gmx.de>
 */
public class Render implements ConfigurationObject
{

    private final StringProperty world = new SimpleStringProperty(null);
    private final ObjectProperty<Dimension> dimension = new SimpleObjectProperty<>(OVERWORLD);
    private final ObservableList<Poi> pois=FXCollections.observableArrayList();

    public ObservableList<Poi> getPois()
    {
        return pois;
    }

    public Dimension getDimension()
    {
        return dimension.get();
    }

    public void setDimension(Dimension value)
    {
        dimension.set(value);
    }

    public ObjectProperty dimensionProperty()
    {
        return dimension;
    }
    

    public String getWorld()
    {
        return world.get();
    }

    public void setWorld(String value)
    {
        world.set(value);
    }

    public StringProperty worldProperty()
    {
        return world;
    }

    
    @Override
    public int getPriority()
    {
        return 5;
    }

    @Override
    public String toConfigString()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
