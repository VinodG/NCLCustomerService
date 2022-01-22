package com.anychart.core.stock.scrollerseries;

import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.JsObject;
import com.anychart.core.stock.scrollerseries.OHLC;

import java.util.Locale;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import android.text.TextUtils;

// class
/**
 * Candlestick Series Class.<br/>
{docs:Stock_Charts/Series/Japanese_Candlestick}Learn more about Candlestick series{docs}
 */
public class Candlestick extends OHLC {

    protected Candlestick() {

    }

    public static Candlestick instantiate() {
        return new Candlestick("new anychart.core.stock.scrollerSeries.candlestick()");
    }

    

    public Candlestick(String jsChart) {
        jsBase = "candlestick" + ++variableIndex;
        APIlib.getInstance().addJSLine(jsBase + " = " + jsChart + ";");
    }

    public String getJsBase() {
        return jsBase;
    }

    
    /**
     * Getter for the allowPointSettings flag.
     */
    public void allowPointSettings() {
        APIlib.getInstance().addJSLine(jsBase + ".allowPointSettings();");
    }
    /**
     * Setter for the allowPointSettings flag.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick allowPointSettings(Boolean enabled) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".allowPointSettings(%s);", enabled));

        return this;
    }
    /**
     * Getter for element bottom bound settings.
     */
    public void bottom() {
        APIlib.getInstance().addJSLine(jsBase + ".bottom();");
    }
    /**
     * Setter for element bottom bound settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bottom(Number bottom) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bottom(%s);", bottom));

        return this;
    }
    /**
     * Setter for element bottom bound settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bottom(String bottom) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bottom(%s);", wrapQuotes(bottom)));

        return this;
    }
    /**
     * Getter for element bounds settings.
     */
    public com.anychart.core.utils.Bounds bounds() {
        return new com.anychart.core.utils.Bounds(jsBase + ".bounds()");
    }
    /**
     * Setter for bounds of the element using one parameter.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(com.anychart.utils.RectObj bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s);", (bounds != null) ? bounds.getJsBase() : null));

        return this;
    }
    /**
     * Setter for bounds of the element using one parameter.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(com.anychart.math.Rect bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s);", (bounds != null) ? bounds.getJsBase() : null));

        return this;
    }
    /**
     * Setter for bounds of the element using one parameter.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(com.anychart.core.utils.Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s);", (bounds != null) ? bounds.getJsBase() : null));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(Number x, Number y, Number width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", x, y, width, height));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(Number x, Number y, Number width, String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", x, y, width, wrapQuotes(height)));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(Number x, Number y, String width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", x, y, wrapQuotes(width), height));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(Number x, Number y, String width, String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", x, y, wrapQuotes(width), wrapQuotes(height)));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(Number x, String y, Number width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", x, wrapQuotes(y), width, height));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(Number x, String y, Number width, String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", x, wrapQuotes(y), width, wrapQuotes(height)));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(Number x, String y, String width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", x, wrapQuotes(y), wrapQuotes(width), height));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(Number x, String y, String width, String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", x, wrapQuotes(y), wrapQuotes(width), wrapQuotes(height)));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(String x, Number y, Number width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(x), y, width, height));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(String x, Number y, Number width, String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(x), y, width, wrapQuotes(height)));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(String x, Number y, String width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(x), y, wrapQuotes(width), height));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(String x, Number y, String width, String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(x), y, wrapQuotes(width), wrapQuotes(height)));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(String x, String y, Number width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(x), wrapQuotes(y), width, height));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(String x, String y, Number width, String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(x), wrapQuotes(y), width, wrapQuotes(height)));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(String x, String y, String width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(x), wrapQuotes(y), wrapQuotes(width), height));

        return this;
    }
    /**
     * Setter for element bounds settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick bounds(String x, String y, String width, String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(x), wrapQuotes(y), wrapQuotes(width), wrapQuotes(height)));

        return this;
    }
    /**
     * Getter for the color scale.
     */
    public com.anychart.scales.LinearColor colorScale() {
        return new com.anychart.scales.LinearColor(jsBase + ".colorScale()");
    }
    /**
     * Setter for the color scale.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick colorScale(com.anychart.scales.LinearColor settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".colorScale(%s);", (settings != null) ? settings.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the color scale.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick colorScale(com.anychart.scales.OrdinalColor settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".colorScale(%s);", (settings != null) ? settings.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the color scale.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick colorScale(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".colorScale(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Setter for the color scale.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick colorScale(com.anychart.enums.ScaleTypes settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".colorScale(%s);", (settings != null) ? settings.getJsBase() : null));

        return this;
    }
    /**
     * 
     */
    public com.anychart.data.TableMapping data(List<DataEntry> data) {
        return new com.anychart.data.TableMapping(String.format(Locale.US, jsBase + ".data(%s)", arrayToString(data)));
    }
    /**
     * Getter for the element state (enabled or disabled).
     */
    public void enabled() {
        APIlib.getInstance().addJSLine(jsBase + ".enabled();");
    }
    /**
     * Setter for the element enabled state.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick enabled(Boolean enabled) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".enabled(%s);", enabled));

        return this;
    }
    /**
     * Getter for the falling series fill color.
     */
    public void fallingFill() {
        APIlib.getInstance().addJSLine(jsBase + ".fallingFill();");
    }
    /**
     * Setter for the falling fill settings using an object, an array or a string.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(com.anychart.graphics.vector.Fill color) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s);", (color != null) ? color.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the falling fill settings using an object, an array or a string.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(com.anychart.graphics.vector.GradientKey color) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s);", (color != null) ? color.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the falling fill settings using an object, an array or a string.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(String[] color) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s);", arrayToStringWrapQuotes(color)));

        return this;
    }
    /**
     * Falling fill color with opacity.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(String color, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s);", wrapQuotes(color), opacity));

        return this;
    }
    /**
     * Linear gradient falling fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(com.anychart.graphics.vector.GradientKey keys, Number angle, Boolean mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s, %s, %s);", (keys != null) ? keys.getJsBase() : null, angle, mode, opacity));

        return this;
    }
    /**
     * Linear gradient falling fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(com.anychart.graphics.vector.GradientKey keys, Number angle, com.anychart.graphics.vector.Rect mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s, %s, %s);", (keys != null) ? keys.getJsBase() : null, angle, (mode != null) ? mode.getJsBase() : null, opacity));

        return this;
    }
    /**
     * Linear gradient falling fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(com.anychart.graphics.vector.GradientKey keys, Number angle, String mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s, %s, %s);", (keys != null) ? keys.getJsBase() : null, angle, wrapQuotes(mode), opacity));

        return this;
    }
    /**
     * Linear gradient falling fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(String[] keys, Number angle, Boolean mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(keys), angle, mode, opacity));

        return this;
    }
    /**
     * Linear gradient falling fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(String[] keys, Number angle, com.anychart.graphics.vector.Rect mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(keys), angle, (mode != null) ? mode.getJsBase() : null, opacity));

        return this;
    }
    /**
     * Linear gradient falling fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(String[] keys, Number angle, String mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(keys), angle, wrapQuotes(mode), opacity));

        return this;
    }
    /**
     * Radial gradient falling fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(com.anychart.graphics.vector.GradientKey keys, Number cx, Number cy, com.anychart.graphics.math.Rect mode, Number opacity, Number fx, Number fy) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s, %s, %s, %s, %s, %s);", (keys != null) ? keys.getJsBase() : null, cx, cy, (mode != null) ? mode.getJsBase() : null, opacity, fx, fy));

        return this;
    }
    /**
     * Radial gradient falling fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingFill(String[] keys, Number cx, Number cy, com.anychart.graphics.math.Rect mode, Number opacity, Number fx, Number fy) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(keys), cx, cy, (mode != null) ? mode.getJsBase() : null, opacity, fx, fy));

        return this;
    }
    /**
     * Getter for falling hatch fill settings.
     */
    public com.anychart.graphics.vector.PatternFill fallingHatchFill() {
        return new com.anychart.graphics.vector.PatternFill(jsBase + ".fallingHatchFill()");
    }
    /**
     * Setter for falling hatch fill settings.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingHatchFill(com.anychart.graphics.vector.hatchfill.HatchFillType type, String color, Number thickness, Number size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingHatchFill(%s, %s, %s, %s);", (type != null) ? type.getJsBase() : null, wrapQuotes(color), thickness, size));

        return this;
    }
    /**
     * Setter for falling hatch fill settings.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingHatchFill(String type, String color, Number thickness, Number size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingHatchFill(%s, %s, %s, %s);", wrapQuotes(type), wrapQuotes(color), thickness, size));

        return this;
    }
    /**
     * Setter for falling hatch fill settings using function.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingHatchFill(String fallingHatchFillFunction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingHatchFill(%s);", wrapQuotes(fallingHatchFillFunction)));

        return this;
    }
    /**
     * Setter for falling hatch fill settings using pattern fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingHatchFill(com.anychart.graphics.vector.PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingHatchFill(%s);", (patternFill != null) ? patternFill.getJsBase() : null));

        return this;
    }
    /**
     * Setter for falling hatch fill settings using an instance.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingHatchFill(com.anychart.graphics.vector.HatchFill settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingHatchFill(%s);", (settings != null) ? settings.getJsBase() : null));

        return this;
    }
    /**
     * Setter for falling hatch fill using boolean.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingHatchFill(Boolean enabled) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingHatchFill(%s);", enabled));

        return this;
    }
    /**
     * Getter for falling stroke settings.
     */
    public void fallingStroke() {
        APIlib.getInstance().addJSLine(jsBase + ".fallingStroke();");
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(com.anychart.graphics.vector.Stroke value, Number thickness, String dashpattern, String lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(com.anychart.graphics.vector.Stroke value, Number thickness, String dashpattern, String lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(com.anychart.graphics.vector.Stroke value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(com.anychart.graphics.vector.Stroke value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(com.anychart.graphics.vector.ColoredFill value, Number thickness, String dashpattern, String lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(com.anychart.graphics.vector.ColoredFill value, Number thickness, String dashpattern, String lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(com.anychart.graphics.vector.ColoredFill value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(com.anychart.graphics.vector.ColoredFill value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(String value, Number thickness, String dashpattern, String lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", wrapQuotes(value), thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(String value, Number thickness, String dashpattern, String lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", wrapQuotes(value), thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(String value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", wrapQuotes(value), thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for falling stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(String value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s, %s, %s, %s, %s);", wrapQuotes(value), thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for falling stroke using an object.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick fallingStroke(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fallingStroke(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Returns pixel bounds of the element due to parent bounds and self bounds settings.
     */
    public com.anychart.math.Rect getPixelBounds() {
        return new com.anychart.math.Rect(jsBase + ".getPixelBounds()");
    }
    /**
     * Getter for element height settings.
     */
    public void height() {
        APIlib.getInstance().addJSLine(jsBase + ".height();");
    }
    /**
     * Setter for element height setting.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick height(Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".height(%s);", height));

        return this;
    }
    /**
     * Setter for element height setting.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick height(String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".height(%s);", wrapQuotes(height)));

        return this;
    }
    /**
     * Getter for chart labels.
     */
    public com.anychart.core.ui.LabelsFactory labels() {
        return new com.anychart.core.ui.LabelsFactory(jsBase + ".labels()");
    }
    /**
     * Setter for chart labels.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick labels(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".labels(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Setter for chart labels.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick labels(Boolean settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".labels(%s);", settings));

        return this;
    }
    /**
     * Getter for element left bound settings.
     */
    public void left() {
        APIlib.getInstance().addJSLine(jsBase + ".left();");
    }
    /**
     * Setter for element left bound settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick left(Number left) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".left(%s);", left));

        return this;
    }
    /**
     * Setter for element left bound settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick left(String left) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".left(%s);", wrapQuotes(left)));

        return this;
    }
    /**
     * Getter for the maximum height.
     */
    public void maxHeight() {
        APIlib.getInstance().addJSLine(jsBase + ".maxHeight();");
    }
    /**
     * Setter for the maximum height.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick maxHeight(Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".maxHeight(%s);", height));

        return this;
    }
    /**
     * Setter for the maximum height.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick maxHeight(String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".maxHeight(%s);", wrapQuotes(height)));

        return this;
    }
    /**
     * Getter for maximum labels.
     */
    public com.anychart.core.ui.LabelsFactory maxLabels() {
        return new com.anychart.core.ui.LabelsFactory(jsBase + ".maxLabels()");
    }
    /**
     * Setter for maximum labels.
     */
    public com.anychart.core.stock.series.Base maxLabels(String settings) {
        return new com.anychart.core.stock.series.Base(String.format(Locale.US, jsBase + ".maxLabels(%s)", wrapQuotes(settings)));
    }
    /**
     * Setter for maximum labels.
     */
    public com.anychart.core.stock.series.Base maxLabels(Boolean settings) {
        return new com.anychart.core.stock.series.Base(String.format(Locale.US, jsBase + ".maxLabels(%s)", settings));
    }
    /**
     * Getter for the maximum point width.
     */
    public void maxPointWidth() {
        APIlib.getInstance().addJSLine(jsBase + ".maxPointWidth();");
    }
    /**
     * Setter for the maximum point width.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick maxPointWidth(Number width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".maxPointWidth(%s);", width));

        return this;
    }
    /**
     * Setter for the maximum point width.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick maxPointWidth(String width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".maxPointWidth(%s);", wrapQuotes(width)));

        return this;
    }
    /**
     * Getter for the maximum width.
     */
    public void maxWidth() {
        APIlib.getInstance().addJSLine(jsBase + ".maxWidth();");
    }
    /**
     * Setter for the maximum width.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick maxWidth(Number width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".maxWidth(%s);", width));

        return this;
    }
    /**
     * Setter for the maximum width.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick maxWidth(String width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".maxWidth(%s);", wrapQuotes(width)));

        return this;
    }
    /**
     * Getter for the minimum height.
     */
    public void minHeight() {
        APIlib.getInstance().addJSLine(jsBase + ".minHeight();");
    }
    /**
     * Setter for the minimum height.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick minHeight(Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minHeight(%s);", height));

        return this;
    }
    /**
     * Setter for the minimum height.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick minHeight(String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minHeight(%s);", wrapQuotes(height)));

        return this;
    }
    /**
     * Getter for minimum labels.
     */
    public com.anychart.core.ui.LabelsFactory minLabels() {
        return new com.anychart.core.ui.LabelsFactory(jsBase + ".minLabels()");
    }
    /**
     * Setter for minimum labels.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick minLabels(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minLabels(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Setter for minimum labels.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick minLabels(Boolean settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minLabels(%s);", settings));

        return this;
    }
    /**
     * Getter for the minimum point length.
     */
    public void minPointLength() {
        APIlib.getInstance().addJSLine(jsBase + ".minPointLength();");
    }
    /**
     * Setter for the minimum point length.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick minPointLength(Number length) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minPointLength(%s);", length));

        return this;
    }
    /**
     * Setter for the minimum point length.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick minPointLength(String length) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minPointLength(%s);", wrapQuotes(length)));

        return this;
    }
    /**
     * Getter for the minimum width.
     */
    public void minWidth() {
        APIlib.getInstance().addJSLine(jsBase + ".minWidth();");
    }
    /**
     * Setter for the minimum width.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick minWidth(Number width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minWidth(%s);", width));

        return this;
    }
    /**
     * Setter for the minimum width.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick minWidth(String width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minWidth(%s);", wrapQuotes(width)));

        return this;
    }
    /**
     * Getter for normal state settings.
     */
    public com.anychart.core.StateSettings normal() {
        return new com.anychart.core.StateSettings(jsBase + ".normal()");
    }
    /**
     * Setter for normal state settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick normal(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".normal(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Getter for point width settings.
     */
    public void pointWidth() {
        APIlib.getInstance().addJSLine(jsBase + ".pointWidth();");
    }
    /**
     * Setter for the point width settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick pointWidth(Number width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".pointWidth(%s);", width));

        return this;
    }
    /**
     * Setter for the point width settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick pointWidth(String width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".pointWidth(%s);", wrapQuotes(width)));

        return this;
    }
    /**
     * Prints all elements on related stage.
     */
    public void print(com.anychart.graphics.vector.PaperSize paperSizeOrOptions, Boolean landscape) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".print(%s, %s);", (paperSizeOrOptions != null) ? paperSizeOrOptions.getJsBase() : null, landscape));
    }
    /**
     * Prints all elements on related stage.
     */
    public void print(String paperSizeOrOptions, Boolean landscape) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".print(%s, %s);", wrapQuotes(paperSizeOrOptions), landscape));
    }
    /**
     * Removes all listeners from an object. You can also optionally remove listeners of some particular type.
     */
    public void removeAllListeners(String type) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".removeAllListeners(%s);", wrapQuotes(type)));
    }
    /**
     * Getter for the series rendering.
     */
    public com.anychart.core.series.RenderingSettings rendering() {
        return new com.anychart.core.series.RenderingSettings(jsBase + ".rendering()");
    }
    /**
     * Setter for the series rendering settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick rendering(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".rendering(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Getter for element right bound settings.
     */
    public void right() {
        APIlib.getInstance().addJSLine(jsBase + ".right();");
    }
    /**
     * Setter for element right bound setting.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick right(Number right) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".right(%s);", right));

        return this;
    }
    /**
     * Setter for element right bound setting.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick right(String right) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".right(%s);", wrapQuotes(right)));

        return this;
    }
    /**
     * Getter for the series rising fill color.
     */
    public void risingFill() {
        APIlib.getInstance().addJSLine(jsBase + ".risingFill();");
    }
    /**
     * Setter for the rising fill settings using an object, an array or a string.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(com.anychart.graphics.vector.Fill color) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s);", (color != null) ? color.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the rising fill settings using an object, an array or a string.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(com.anychart.graphics.vector.GradientKey color) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s);", (color != null) ? color.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the rising fill settings using an object, an array or a string.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(String[] color) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s);", arrayToStringWrapQuotes(color)));

        return this;
    }
    /**
     * Rising fill color with opacity.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(String color, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s);", wrapQuotes(color), opacity));

        return this;
    }
    /**
     * Linear gradient rising fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(com.anychart.graphics.vector.GradientKey keys, Number angle, Boolean mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s, %s, %s);", (keys != null) ? keys.getJsBase() : null, angle, mode, opacity));

        return this;
    }
    /**
     * Linear gradient rising fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(com.anychart.graphics.vector.GradientKey keys, Number angle, com.anychart.graphics.vector.Rect mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s, %s, %s);", (keys != null) ? keys.getJsBase() : null, angle, (mode != null) ? mode.getJsBase() : null, opacity));

        return this;
    }
    /**
     * Linear gradient rising fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(com.anychart.graphics.vector.GradientKey keys, Number angle, String mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s, %s, %s);", (keys != null) ? keys.getJsBase() : null, angle, wrapQuotes(mode), opacity));

        return this;
    }
    /**
     * Linear gradient rising fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(String[] keys, Number angle, Boolean mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(keys), angle, mode, opacity));

        return this;
    }
    /**
     * Linear gradient rising fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(String[] keys, Number angle, com.anychart.graphics.vector.Rect mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(keys), angle, (mode != null) ? mode.getJsBase() : null, opacity));

        return this;
    }
    /**
     * Linear gradient rising fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(String[] keys, Number angle, String mode, Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(keys), angle, wrapQuotes(mode), opacity));

        return this;
    }
    /**
     * Radial gradient rising fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(com.anychart.graphics.vector.GradientKey keys, Number cx, Number cy, com.anychart.graphics.math.Rect mode, Number opacity, Number fx, Number fy) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s, %s, %s, %s, %s, %s);", (keys != null) ? keys.getJsBase() : null, cx, cy, (mode != null) ? mode.getJsBase() : null, opacity, fx, fy));

        return this;
    }
    /**
     * Radial gradient rising fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingFill(String[] keys, Number cx, Number cy, com.anychart.graphics.math.Rect mode, Number opacity, Number fx, Number fy) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(keys), cx, cy, (mode != null) ? mode.getJsBase() : null, opacity, fx, fy));

        return this;
    }
    /**
     * Getter for rising hatch fill settings.
     */
    public com.anychart.graphics.vector.PatternFill risingHatchFill() {
        return new com.anychart.graphics.vector.PatternFill(jsBase + ".risingHatchFill()");
    }
    /**
     * Setter for rising hatch fill settings.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingHatchFill(com.anychart.graphics.vector.hatchfill.HatchFillType type, String color, Number thickness, Number size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingHatchFill(%s, %s, %s, %s);", (type != null) ? type.getJsBase() : null, wrapQuotes(color), thickness, size));

        return this;
    }
    /**
     * Setter for rising hatch fill settings.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingHatchFill(String type, String color, Number thickness, Number size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingHatchFill(%s, %s, %s, %s);", wrapQuotes(type), wrapQuotes(color), thickness, size));

        return this;
    }
    /**
     * Setter for rising hatch fill settings using function.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingHatchFill(String risingHatchFillFunction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingHatchFill(%s);", wrapQuotes(risingHatchFillFunction)));

        return this;
    }
    /**
     * Setter for rising hatch fill settings using pattern fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingHatchFill(com.anychart.graphics.vector.PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingHatchFill(%s);", (patternFill != null) ? patternFill.getJsBase() : null));

        return this;
    }
    /**
     * Setter for hatch fill settings using an instance.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingHatchFill(com.anychart.graphics.vector.HatchFill settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingHatchFill(%s);", (settings != null) ? settings.getJsBase() : null));

        return this;
    }
    /**
     * Setter for rising hatch fill using boolean.
{docs:Graphics/Hatch_Fill_Settings}Learn more about hatch fill settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingHatchFill(Boolean enabled) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingHatchFill(%s);", enabled));

        return this;
    }
    /**
     * Getter for rising stroke settings.
     */
    public void risingStroke() {
        APIlib.getInstance().addJSLine(jsBase + ".risingStroke();");
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(com.anychart.graphics.vector.Stroke value, Number thickness, String dashpattern, String lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(com.anychart.graphics.vector.Stroke value, Number thickness, String dashpattern, String lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(com.anychart.graphics.vector.Stroke value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(com.anychart.graphics.vector.Stroke value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(com.anychart.graphics.vector.ColoredFill value, Number thickness, String dashpattern, String lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(com.anychart.graphics.vector.ColoredFill value, Number thickness, String dashpattern, String lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(com.anychart.graphics.vector.ColoredFill value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(com.anychart.graphics.vector.ColoredFill value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", (value != null) ? value.getJsBase() : null, thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(String value, Number thickness, String dashpattern, String lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", wrapQuotes(value), thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(String value, Number thickness, String dashpattern, String lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", wrapQuotes(value), thickness, wrapQuotes(dashpattern), wrapQuotes(lineJoin), (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(String value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, String lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", wrapQuotes(value), thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, wrapQuotes(lineCap)));

        return this;
    }
    /**
     * Setter for rising stroke settings.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(String value, Number thickness, String dashpattern, com.anychart.graphics.vector.StrokeLineJoin lineJoin, com.anychart.graphics.vector.StrokeLineCap lineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s, %s, %s, %s, %s);", wrapQuotes(value), thickness, wrapQuotes(dashpattern), (lineJoin != null) ? lineJoin.getJsBase() : null, (lineCap != null) ? lineCap.getJsBase() : null));

        return this;
    }
    /**
     * Setter for rising stroke using an object.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick risingStroke(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".risingStroke(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Getter for selected state settings.
     */
    public com.anychart.core.StateSettings selected() {
        return new com.anychart.core.StateSettings(jsBase + ".selected()");
    }
    /**
     * Setter for selected state settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick selected(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".selected(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Getter for switching of the series type.
     */
    public void seriesType() {
        APIlib.getInstance().addJSLine(jsBase + ".seriesType();");
    }
    /**
     * Setter for switching of the series type.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick seriesType(String type) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".seriesType(%s);", wrapQuotes(type)));

        return this;
    }
    /**
     * Getter for element top bound settings.
     */
    public void top() {
        APIlib.getInstance().addJSLine(jsBase + ".top();");
    }
    /**
     * Setter for element top bound settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick top(Number top) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".top(%s);", top));

        return this;
    }
    /**
     * Setter for element top bound settings.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick top(String top) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".top(%s);", wrapQuotes(top)));

        return this;
    }
    public void setOnClickListener(com.anychart.chart.common.listener.ListenersInterface.OnClickListener listener) {
        StringBuilder js = new StringBuilder();

        js.append(jsBase).append(".listen('pointClick', function(e) {");

        if (listener.getFields() != null) {
            js.append("var result = ");
            for (String field : listener.getFields()) {
                js.append(String.format(Locale.US, "'%1$s' + ':' + e.point.get('%1$s') + ',' +", field));
            }
            js.setLength(js.length() - 8);
            js.append(";");

            js.append("android.onClick(result);");
        } else {
            js.append("android.onClick(null);");
        }
        js.append("});");

        com.anychart.chart.common.listener.ListenersInterface.getInstance().setOnClickListener(listener);

        APIlib.getInstance().addJSLine(js.toString());
    }

    public void setOnClickListener(com.anychart.chart.common.listener.ListenersInterface.OnClickListener listener, String type, String ePath) {
        StringBuilder js = new StringBuilder();

        js.append(jsBase).append(String.format(Locale.US, ".listen('%1$s', function(e) {", type));

        if (listener.getFields() != null) {
            ePath = (ePath != null) ? ePath + "." : "";
            js.append("var result = ");
            for (String field : listener.getFields()) {
                js.append(String.format(Locale.US, "'%1$s' + ':' + e.%2$s%1$s + ',' +", field, ePath));
            }
            js.setLength(js.length() - 8);
            js.append(";");

            js.append("android.onClick(result);");
        } else {
            js.append("android.onClick(null);");
        }
        js.append("});");

        com.anychart.chart.common.listener.ListenersInterface.getInstance().setOnClickListener(listener);

        APIlib.getInstance().addJSLine(js.toString());
    }
    /**
     * Removes an event listener which was added with listen() by the key returned by listen() or listenOnce().
     */
    public void unlistenByKey(String key) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".unlistenByKey(%s);", wrapQuotes(key)));
    }
    /**
     * Getter for element width settings.
     */
    public void width() {
        APIlib.getInstance().addJSLine(jsBase + ".width();");
    }
    /**
     * Setter for element width setting.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick width(Number width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".width(%s);", width));

        return this;
    }
    /**
     * Setter for element width setting.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick width(String width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".width(%s);", wrapQuotes(width)));

        return this;
    }
    /**
     * Getter for the Y-scale.
     */
    public com.anychart.scales.ScatterBase yScale() {
        return new com.anychart.scales.ScatterBase(jsBase + ".yScale()");
    }
    /**
     * Setter for the Y-scale.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick yScale(com.anychart.scales.ScatterBase settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".yScale(%s);", (settings != null) ? settings.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the Y-scale.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick yScale(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".yScale(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Setter for the Y-scale.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick yScale(com.anychart.enums.ScaleTypes settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".yScale(%s);", (settings != null) ? settings.getJsBase() : null));

        return this;
    }
    /**
     * Getter for the Z-index of the element.
     */
    public void zIndex() {
        APIlib.getInstance().addJSLine(jsBase + ".zIndex();");
    }
    /**
     * Setter for the Z-index of the element.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick zIndex(Number zIndex) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".zIndex(%s);", zIndex));

        return this;
    }
    /**
     * Returns series index.
     */
    public void getIndex() {
        APIlib.getInstance().addJSLine(jsBase + ".getIndex();");
    }
    /**
     * Getter for the container.
     */
    public com.anychart.graphics.vector.Layer container() {
        return new com.anychart.graphics.vector.Layer(jsBase + ".container()");
    }
    /**
     * Setter for the container.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick container(com.anychart.graphics.vector.Layer element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".container(%s);", (element != null) ? element.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the container.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick container(com.anychart.graphics.vector.Stage element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".container(%s);", (element != null) ? element.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the container.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick container(String element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".container(%s);", wrapQuotes(element)));

        return this;
    }
    /**
     * Getter for the parent bounds.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.math.Rect parentBounds() {
        return new com.anychart.math.Rect(jsBase + ".parentBounds()");
    }
    /**
     * Setter for the parent bounds using single value.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick parentBounds(com.anychart.math.Rect bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".parentBounds(%s);", (bounds != null) ? bounds.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the parent bounds using single value.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick parentBounds(String bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".parentBounds(%s);", wrapQuotes(bounds)));

        return this;
    }
    /**
     * Setter for the parent bounds using single value.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick parentBounds(Number bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".parentBounds(%s);", bounds));

        return this;
    }
    /**
     * Setter for the parent bounds using several values.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.core.stock.scrollerseries.Candlestick parentBounds(Number left, Number top, Number width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".parentBounds(%s, %s, %s, %s);", left, top, width, height));

        return this;
    }
    /**
     * 
     */
    public com.anychart.data.TableMapping data(com.anychart.data.View data) {
        return new com.anychart.data.TableMapping(String.format(Locale.US, jsBase + ".data(%s)", (data != null) ? data.getJsBase() : null));
    }
    /**
     * 
     */
    public com.anychart.data.TableMapping data(List<DataEntry> data, com.anychart.enums.TreeFillingMethod fillMethod) {
        return new com.anychart.data.TableMapping(String.format(Locale.US, jsBase + ".data(%s, %s)", arrayToString(data), (fillMethod != null) ? fillMethod.getJsBase() : null));
    }
    /**
     * 
     */
    public com.anychart.data.TableMapping data(List<DataEntry> data, String fillMethod) {
        return new com.anychart.data.TableMapping(String.format(Locale.US, jsBase + ".data(%s, %s)", arrayToString(data), wrapQuotes(fillMethod)));
    }
    /**
     * 
     */
    public Object yScale(Class scaleClass) {
        Object instance = null;
        try {
            instance = scaleClass.getDeclaredConstructor(String.class).newInstance(jsBase + ".yScale()");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
        return instance;
    }

}