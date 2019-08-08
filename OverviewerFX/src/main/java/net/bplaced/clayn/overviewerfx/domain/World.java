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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Clayn <clayn_osmato@gmx.de>
 */
public class World implements ConfigurationObject
{

    private final StringProperty name = new SimpleStringProperty(null);
    private final StringProperty path = new SimpleStringProperty(null);

    public String getPath()
    {
        return path.get();
    }

    public StringProperty pathProperty()
    {
        return path;
    }

    public World(String name, String path)
    {
        setName(name);
        setPath(path);
    }

    public World()
    {
    }

    public String getName()
    {
        return name.get();
    }

    public StringProperty nameProperty()
    {
        return name;
    }

    @Override
    public String toConfigString()
    {

        Objects.requireNonNull(getName());
        Objects.requireNonNull(getPath());
        return String.format("worlds[\"%s\"] = \"%s\"", getName(), getPath());
    }

    public final void setName(String name)
    {
        Objects.requireNonNull(name);
        if (name.trim().isEmpty())
        {
            throw new IllegalArgumentException("World name must not be emtpy");
        }
        nameProperty().set(name);
    }

    public final void setPath(String path)
    {
        Objects.requireNonNull(path);
        if (path.trim().isEmpty())
        {
            throw new IllegalArgumentException("World path must not be emtpy");
        }
        Path p = Paths.get(path);
        if (!Files.exists(p) || !Files.isDirectory(p))
        {
            throw new IllegalArgumentException(
                    "World path must be an existing directory");
        }
        pathProperty().set(path);
    }

    @Override
    public int getPriority()
    {
        return 9;
    }

}
