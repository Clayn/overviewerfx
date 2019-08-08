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

import java.util.function.Supplier;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Clayn <clayn_osmato@gmx.de>
 */
public class FilterFunction implements ConfigurationObject
{

    private static FilterFunction createStandardFilter(String name,
            final Supplier<String> contentGetter)
    {
        return new FilterFunction(
                name)
        {

            @Override
            public void setContent(String content)
            {
            }

            @Override
            public void setName(String value)
            {

            }

            @Override
            public final String getName()
            {
                return super.getName();
            }

            @Override
            public String getContent()
            {
                return contentGetter.get();
            }

        };
    }
    public static final FilterFunction TOWN_FILTER = createStandardFilter(
            "townFilter",
            new StringBuilder().append("\tif poi['id'] == 'Town':\n").append(
            "\t\treturn poi['name']")::toString);

    private final StringProperty name = new SimpleStringProperty(null);
    private final StringProperty content = new SimpleStringProperty("");

    public String getContent()
    {
        return content.get();
    }

    public void setContent(String value)
    {
        content.set(value);
    }

    public StringProperty contentProperty()
    {
        return content;
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

    public FilterFunction(String name)
    {
        this.name.set(name);
    }

    @Override
    public int getPriority()
    {
        return 10;
    }

    @Override
    public String toConfigString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("def ").append(getName()).append("(poi):").append("\n\t");
        builder.append(getContent());
        return builder.toString();
    }
}
