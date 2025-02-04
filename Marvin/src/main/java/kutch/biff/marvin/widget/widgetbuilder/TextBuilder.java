/*
 * ##############################################################################
 * #  Copyright (c) 2016 Intel Corporation
 * # 
 * # Licensed under the Apache License, Version 2.0 (the "License");
 * #  you may not use this file except in compliance with the License.
 * #  You may obtain a copy of the License at
 * # 
 * #      http://www.apache.org/licenses/LICENSE-2.0
 * # 
 * #  Unless required by applicable law or agreed to in writing, software
 * #  distributed under the License is distributed on an "AS IS" BASIS,
 * #  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * #  See the License for the specific language governing permissions and
 * #  limitations under the License.
 * ##############################################################################
 * #    File Abstract: 
 * #
 * #
 * ##############################################################################
 */
package kutch.biff.marvin.widget.widgetbuilder;

import java.util.logging.Logger;
import kutch.biff.marvin.logger.MarvinLogger;
import kutch.biff.marvin.utility.FrameworkNode;
import kutch.biff.marvin.widget.BaseWidget;
import kutch.biff.marvin.widget.ListBoxText;
import kutch.biff.marvin.widget.TextWidget;

/**
 *
 * @author Patrick Kutch
 */
public class TextBuilder
{

    private final static Logger LOGGER = Logger.getLogger(MarvinLogger.class.getName());

    public static TextWidget Build(FrameworkNode masterNode, String widgetDefFilename)
    {
        TextWidget _widget = new TextWidget();

        return ReadTextWidgetInfo(_widget, masterNode, widgetDefFilename);
    }

    public static TextWidget ReadTextWidgetInfo(TextWidget _widget, FrameworkNode masterNode, String widgetDefFilename)
    {
        for (FrameworkNode node : masterNode.getChildNodes())
        {
            if (BaseWidget.HandleCommonDefinitionFileConfig(_widget, node))
            {
            }
            else if (node.getNodeName().equalsIgnoreCase("#comment"))
            {
            }
            else if (node.getNodeName().equalsIgnoreCase("ScaleToShape"))
            {
                String str = node.getTextContent();
                if (0 == str.compareToIgnoreCase("True"))
                {
                    _widget.setScaleToFitBounderies(true);
                }
                else if (0 == str.compareToIgnoreCase("False"))
                {
                    _widget.setScaleToFitBounderies(false);
                }
                else
                {
                    LOGGER.severe("Invalid Text Widget Definition File.  ScaleToShape should be True or False, not:" + str);
                    return null;
                }
            }
        }
        return _widget;
    }

    public static ListBoxText ListBoxText_Build(FrameworkNode masterNode, String widgetDefFilename)
    {
        ListBoxText _widget = new ListBoxText();
        for (FrameworkNode node : masterNode.getChildNodes())
        {
            if (BaseWidget.HandleCommonDefinitionFileConfig(_widget, node))
            {
            }
            else if (node.getNodeName().equalsIgnoreCase("#comment"))
            {
            }
        }
        return _widget;
    }

}
