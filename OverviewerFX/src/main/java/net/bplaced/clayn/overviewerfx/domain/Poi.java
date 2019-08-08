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
import javafx.geometry.Point3D;

/**
 *
 * @author Clayn <clayn_osmato@gmx.de>
 */
public class Poi implements SubConfigurationObject
{

    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final ObjectProperty<Point3D> location = new SimpleObjectProperty<>();

    public Point3D getLocation()
    {
        return location.get();
    }

    public void setLocation(Point3D value)
    {
        location.set(value);
    }

    public ObjectProperty locationProperty()
    {
        return location;
    }

    public String getDescription()
    {
        return description.get();
    }

    public void setDescription(String value)
    {
        description.set(value);
    }

    public StringProperty descriptionProperty()
    {
        return description;
    }

    public String getName()
    {
        return name.get();
    }

    public void setName(String value)
    {
        name.set(value);
    }

    public StringProperty nameProperty()
    {
        return name;
    }

    public String getId()
    {
        return id.get();
    }

    public void setId(String value)
    {
        id.set(value);
    }

    public StringProperty idProperty()
    {
        return id;
    }

    @Override
    public String toConfigString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("'id' : '").append(getId()).append("',").append("\n");
        builder.append("'name' : '").append(getName()).append("',").append("\n");
        if (getDescription() != null && !getDescription().trim().isEmpty())
        {
            builder.append("'description' : '").append(getDescription()).append("',").append(
                    "\n");
        }
        Point3D loc=getLocation();
        builder.append("'x' : ").append(loc.getX()).append("\n");
        builder.append("'y' : ").append(loc.getY()).append("\n");
        builder.append("'z' : ").append(loc.getZ()).append("\n");
        return builder.toString();
    }

}
