package com.cmd.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.sql.Date;
import java.util.Iterator;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cmd.service.interfaces.IDrawingReleasedInOEService;
import com.googlecode.wickedcharts.highcharts.options.Axis;
import com.googlecode.wickedcharts.highcharts.options.Center;
import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.CssStyle;
import com.googlecode.wickedcharts.highcharts.options.Cursor;
import com.googlecode.wickedcharts.highcharts.options.DataLabels;
import com.googlecode.wickedcharts.highcharts.options.Function;
import com.googlecode.wickedcharts.highcharts.options.GridLineDashStyle;
import com.googlecode.wickedcharts.highcharts.options.HorizontalAlignment;
import com.googlecode.wickedcharts.highcharts.options.Labels;
import com.googlecode.wickedcharts.highcharts.options.Legend;
import com.googlecode.wickedcharts.highcharts.options.LegendLayout;
import com.googlecode.wickedcharts.highcharts.options.Marker;
import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.options.PixelOrPercent;
import com.googlecode.wickedcharts.highcharts.options.PlotLine;
import com.googlecode.wickedcharts.highcharts.options.PlotOptions;
import com.googlecode.wickedcharts.highcharts.options.PlotOptionsChoice;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.StackLabels;
import com.googlecode.wickedcharts.highcharts.options.Stacking;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.Tooltip;
import com.googlecode.wickedcharts.highcharts.options.VerticalAlignment;
import com.googlecode.wickedcharts.highcharts.options.ZoomType;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.color.HighchartsColor;
import com.googlecode.wickedcharts.highcharts.options.color.NullColor;
import com.googlecode.wickedcharts.highcharts.options.color.RadialGradient;
import com.googlecode.wickedcharts.highcharts.options.functions.PercentageFormatter;
import com.googlecode.wickedcharts.highcharts.options.functions.StackTotalFormatter;
import com.googlecode.wickedcharts.highcharts.options.series.Point;
import com.googlecode.wickedcharts.highcharts.options.series.PointSeries;
import com.googlecode.wickedcharts.highcharts.options.series.Series;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.googlecode.wickedcharts.highcharts.theme.DarkBlueTheme;
import com.googlecode.wickedcharts.highcharts.theme.Theme;

@Named
@ViewScoped
public class DashboardBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	IDrawingReleasedInOEService drawingReleasedInOEService;
	
	private Options options = new Options();
	private Theme theme = new Theme();
	private Options relesedOEs = new Options();
	private Options delayedEOs = new Options();
	private Options changeDocumentType = new Options();
	private Options releasedDrawing = new Options();
	private Options releaseCurveDrawing = new Options();
	private Options numberEOs = new Options();
	private Options managementDispositionPCRs = new Options();

	public DashboardBean() {
		selectRelesedOEs();
		selectDelayedEOs();
		selectChangeDocumentType();
		selectReleasedDrawing();
		selectReleaseCurveDrawing();
		selectNumberEOs();
		selectManagementDispositionPCRs();
		/*drawingReleasedInOEService.selectPlannedDwgWeek("A1M", Date.valueOf("2013-10-01"), Date.valueOf("2013-11-01"));*/
	}

	public void selectDelayedEOs() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions);
		options.setTitle(new Title("A1M"));
		options.setSubtitle(new Title("Delayed EO's - 2013"));
		
		Axis xAxis = new Axis();
		xAxis.setCategories(Arrays.asList(new String[] { "Jan/13", "Feb/13",
				"Mar/13", "Apr/13", "May/13" }));

		Axis yAxis = new Axis();
		yAxis.setTitle(new Title("Qty PNs"));

		options.setyAxis(yAxis);
		options.setxAxis(xAxis);

		options.setTooltip(new Tooltip());

		options.setLabels(new Labels().setStyle(new CssStyle()));

		Series<Number> series1 = new SimpleSeries();
		series1.setType(SeriesType.COLUMN);
		series1.setName("Delayed");
		series1.setData(Arrays.asList(new Number[] { 3, 2, 1, 3, 4 }));
		options.addSeries(series1);

		Marker series2Marker = new Marker();
		series2Marker.setLineWidth(2);
		series2Marker.setLineColor(new HexColor("#0D233A"));
		series2Marker.setFillColor(new HexColor("#ffffff"));

		Series<Number> series2 = new SimpleSeries();
		series2.setType(SeriesType.SPLINE);
		series2.setName("Accumulated Delayed");
		series2.setData(Arrays.asList(new Number[] { 4, 3, 3, 9, 0 }));
		series2.setMarker(series2Marker);
		options.addSeries(series2);

		setDelayedEOs(options);
	}

	public void selectRelesedOEs() {	
		
		/*drawingReleasedInOEService.selectPlannedDwgWeek("A1M", Date.valueOf("2013-10-01"), Date.valueOf("2013-11-01"));*/

		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions);
		options.setTitle(new Title("A1M"));
		options.setSubtitle(new Title("Released EO's - 2013"));

		Axis xAxis = new Axis();
		xAxis.setCategories(Arrays.asList(new String[] { "Jan/13", "Feb/13",
				"Mar/13", "Apr/13", "May/13" }));

		Axis yAxis = new Axis();
		yAxis.setTitle(new Title("Qty PNs"));

		options.setyAxis(yAxis);
		options.setxAxis(xAxis);

		options.setTooltip(new Tooltip());

		options.setLabels(new Labels().setStyle(new CssStyle()));

		Series<Number> series1 = new SimpleSeries();
		series1.setType(SeriesType.COLUMN);
		series1.setName("Planned");
		series1.setData(Arrays.asList(new Number[] { 3, 2, 1, 3, 4 }));
		options.addSeries(series1);

		Series<Number> series2 = new SimpleSeries();
		series2.setType(SeriesType.COLUMN);
		series2.setName("Released");
		series2.setData(Arrays.asList(new Number[] { 2, 3, 5, 7, 6 }));
		options.addSeries(series2);

		Marker series3Marker = new Marker();
		series3Marker.setLineWidth(2);
		series3Marker.setLineColor(new HexColor("#8BBC21"));
		series3Marker.setFillColor(new HexColor("#ffffff"));

		Series<Number> series3 = new SimpleSeries();
		series3.setType(SeriesType.SPLINE);
		series3.setName("Accumulated Planned");
		series3.setData(Arrays.asList(new Number[] { 4, 3, 3, 9, 0 }));
		series3.setMarker(series3Marker);
		options.addSeries(series3);

		Marker series4Marker = new Marker();
		series4Marker.setLineWidth(2);
		series4Marker.setLineColor(new HexColor("#990000"));
		series4Marker.setFillColor(new HexColor("#ffffff"));

		Series<Number> series4 = new SimpleSeries();
		series4.setType(SeriesType.SPLINE);
		series4.setName("Accumulated Released");
		series4.setData(Arrays.asList(new Number[] { 3, 2.67, 3, 6.33, 3.33 }));
		series4.setMarker(series4Marker);
		options.addSeries(series4);

		setRelesedOEs(options);
	}

	public void selectChangeDocumentType() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions);
		options.setTitle(new Title("A1M"));
		options.setSubtitle(new Title("Change by Document Type - 2013"));

		Axis xAxis = new Axis();
		xAxis.setCategories(Arrays.asList(new String[] { "Jan/13", "Feb/13",
				"Mar/13", "Apr/13", "May/13" }));

		Axis yAxis = new Axis();
		yAxis.setTitle(new Title("Qty PNs"));

		options.setyAxis(yAxis);
		options.setxAxis(xAxis);

		options.setTooltip(new Tooltip());

		options.setLabels(new Labels().setStyle(new CssStyle()));

		Series<Number> series1 = new SimpleSeries();
		series1.setType(SeriesType.COLUMN);
		series1.setName("BRS");
		series1.setData(Arrays.asList(new Number[] { 3, 2, 1, 3, 4 }));
		options.addSeries(series1);

		Series<Number> series2 = new SimpleSeries();
		series2.setType(SeriesType.COLUMN);
		series2.setName("AMD");
		series2.setData(Arrays.asList(new Number[] { 2, 3, 5, 7, 6 }));
		options.addSeries(series2);

		Series<Number> series3 = new SimpleSeries();
		series3.setType(SeriesType.COLUMN);
		series3.setName("OE");
		series3.setData(Arrays.asList(new Number[] { 2, 3, 5, 7, 6 }));
		options.addSeries(series3);
		setChangeDocumentType(options);
	}

	public void selectReleasedDrawing() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();

		options.setChartOptions(chartOptions.setType(SeriesType.COLUMN));

		options.setTitle(new Title("A1M"));
		options.setSubtitle(new Title("Drawings Released - 2013"));

		options.setxAxis(new Axis().setCategories(new String[] { "Jan/13",
				"Feb/13", "Mar/13", "Apr/13", "May/13" }));

		options.setyAxis(new Axis()
				.setMin(0)
				.setTitle(new Title("Qty PNs"))
				.setStackLabels(
						new StackLabels().setEnabled(Boolean.TRUE).setStyle(
								new CssStyle().setProperty("font-weight",
										"bold").setProperty("color", "gray"))));

		options.setTooltip(new Tooltip()
				.setFormatter(new StackTotalFormatter()));

		options.setPlotOptions(new PlotOptionsChoice()
				.setColumn(new PlotOptions().setStacking(Stacking.NORMAL)
						.setDataLabels(
								new DataLabels().setEnabled(Boolean.TRUE)
										.setColor(new HexColor("#FFFFFF")))));

		options.addSeries(new SimpleSeries().setName("Affect Lead Time")
				.setData(5, 3, 4, 7, 2));

		options.addSeries(new SimpleSeries().setName("Not Affect Lead Time")
				.setData(2, 2, 3, 2, 1));

		Marker series3Marker = new Marker();
		series3Marker.setLineWidth(2);
		series3Marker.setLineColor(new HexColor("#8BBC21"));
		series3Marker.setFillColor(new HexColor("#ffffff"));

		Series<Number> series3 = new SimpleSeries();
		series3.setType(SeriesType.SPLINE);
		series3.setName("% Affect in Month");
		series3.setData(Arrays.asList(new Number[] { 4, 3, 3, 9, 0 }));
		series3.setMarker(series3Marker);
		options.addSeries(series3);
		setReleasedDrawing(options);
	}

	public void selectReleaseCurveDrawing() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();

		chartOptions.setType(SeriesType.LINE);
		chartOptions.setMarginRight(130);
		chartOptions.setMarginBottom(25);
		options.setChartOptions(chartOptions);

		Title title = new Title("A1M");
		title.setX(-20);
		options.setTitle(title);

		Title subTitle = new Title("Release Curve Drawings - 2013");
		subTitle.setX(-20);
		options.setSubtitle(subTitle);

		Axis xAxis = new Axis();
		xAxis.setCategories(Arrays
				.asList(new String[] { "Jan/13",
						"Feb/13", "Mar/13", "Apr/13", "May/13" }));
		
		
		options.setxAxis(xAxis);

		PlotLine plotLines = new PlotLine();
		plotLines.setValue(0f);
		plotLines.setWidth(1);
		plotLines.setColor(new HexColor("#999999"));

		Axis yAxis = new Axis();
		yAxis.setTitle(new Title("Qty PNs"));
		yAxis.setPlotLines(Collections.singletonList(plotLines));
		options.setyAxis(yAxis);

		Legend legend = new Legend();
		legend.setLayout(LegendLayout.VERTICAL);
		legend.setAlign(HorizontalAlignment.RIGHT);
		legend.setVerticalAlign(VerticalAlignment.TOP);
		legend.setX(-10);
		legend.setY(100);
		legend.setBorderWidth(0);
		options.setLegend(legend);

		Series<Number> series1 = new SimpleSeries();
		series1.setName("Planned");
		series1.setData(Arrays.asList(new Number[] { 7.0, 6.9, 9.5, 14.5, 18.2 }));
		options.addSeries(series1);

		Series<Number> series2 = new SimpleSeries();
		series2.setName("Released");
		series2.setData(Arrays.asList(new Number[] { -0.2, 0.8, 5.7, 11.3,
				17.0 }));
		options.addSeries(series2);

		Series<Number> series3 = new SimpleSeries();
		series3.setName("DANE");
		series3.setData(Arrays.asList(new Number[] { -0.9, 0.6, 3.5, 8.4, 13.5 }));
		options.addSeries(series3);
		
		setReleaseCurveDrawing(options);
	}
	
	public void selectNumberEOs() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions.setType(SeriesType.COLUMN));
 
		options.setTitle(new Title("A1M"));
 
		options.setSubtitle(new Title("Number of new and revised EO's - 2013"));
 
		options.setxAxis(new Axis()
        .setCategories("Jan/13", "Feb/13", "Mar/13", "Apr/13", "May/13"));
 
		options.setyAxis(new Axis()
        .setMin(0)
        .setTitle(new Title("Qty")));
 
		options.setLegend(new Legend()
        .setLayout(LegendLayout.VERTICAL)
        .setBackgroundColor(new HexColor("#FFFFFF"))
        .setAlign(HorizontalAlignment.LEFT)
        .setVerticalAlign(VerticalAlignment.TOP)
        .setX(100)
        .setY(70)
        .setFloating(Boolean.TRUE)
        .setShadow(Boolean.TRUE));
 
		options.setTooltip(new Tooltip()
        .setFormatter(new Function()
            .setFunction(" return ''+ this.x +': '+ this.y +' Qty';")));
 
		options.setPlotOptions(new PlotOptionsChoice()
        .setColumn(new PlotOptions()
            .setPointPadding(0.2f)
            .setBorderWidth(0)));
 
		options.addSeries(new SimpleSeries()
        .setName("New")
        .setData(
            49.9,
            71.5,
            106.4,
            129.2,
            144.0));
 
		options.addSeries(new SimpleSeries()
        .setName("Revised")
        .setData(
            83.6,
            78.8,
            98.5,
            93.4,
            106.0));
		
		
		setNumberEOs(options);
	}
	
	public void selectManagementDispositionPCRs() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();

		options.setChartOptions(chartOptions.setType(SeriesType.COLUMN));

		options.setTitle(new Title("A1M"));
		options.setSubtitle(new Title("Management Disposition PCRs - 2013"));

		options.setxAxis(new Axis().setCategories(new String[] { "Jan/13",
				"Feb/13", "Mar/13", "Apr/13", "May/13" }));

		options.setyAxis(new Axis()
				.setMin(0)
				.setTitle(new Title("Qty PCR's"))
				.setStackLabels(
						new StackLabels().setEnabled(Boolean.TRUE).setStyle(
								new CssStyle().setProperty("font-weight",
										"bold").setProperty("color", "gray"))));

		options.setTooltip(new Tooltip()
				.setFormatter(new StackTotalFormatter()));

		options.setPlotOptions(new PlotOptionsChoice()
				.setColumn(new PlotOptions().setStacking(Stacking.NORMAL)
						.setDataLabels(
								new DataLabels().setEnabled(Boolean.TRUE)
										.setColor(new HexColor("#FFFFFF")))));

		options.addSeries(new SimpleSeries().setName("Issue (CCB)")
				.setData(5, 3, 4, 7, 2));

		options.addSeries(new SimpleSeries().setName("Technical Analysis (DIP)")
				.setData(2, 2, 3, 2, 1));
		
		options.addSeries(new SimpleSeries().setName("Approval (Program)")
				.setData(2, 2, 3, 2, 1));
		
		options.addSeries(new SimpleSeries().setName("Execution (DIP)")
				.setData(2, 2, 3, 2, 1));

		Marker series3Marker = new Marker();
		series3Marker.setLineWidth(2);
		series3Marker.setLineColor(new HexColor("#8BBC21"));
		series3Marker.setFillColor(new HexColor("#ffffff"));

		Series<Number> series3 = new SimpleSeries();
		series3.setType(SeriesType.SPLINE);
		series3.setName("Qty Total PCR's");
		series3.setData(Arrays.asList(new Number[] { 4, 3, 3, 9, 0 }));
		series3.setMarker(series3Marker);
		options.addSeries(series3);
		setManagementDispositionPCRs(options);
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Options getRelesedOEs() {
		return relesedOEs;
	}

	public void setRelesedOEs(Options relesedOEs) {
		this.relesedOEs = relesedOEs;
	}

	public Options getDelayedEOs() {
		return delayedEOs;
	}

	public void setDelayedEOs(Options delayedEOs) {
		this.delayedEOs = delayedEOs;
	}

	public Options getChangeDocumentType() {
		return changeDocumentType;
	}

	public void setChangeDocumentType(Options changeDocumentType) {
		this.changeDocumentType = changeDocumentType;
	}

	public Options getReleasedDrawing() {
		return releasedDrawing;
	}

	public void setReleasedDrawing(Options releasedDrawing) {
		this.releasedDrawing = releasedDrawing;
	}

	public Options getReleaseCurveDrawing() {
		return releaseCurveDrawing;
	}

	public void setReleaseCurveDrawing(Options releaseCurveDrawing) {
		this.releaseCurveDrawing = releaseCurveDrawing;
	}

	public Options getNumberEOs() {
		return numberEOs;
	}

	public void setNumberEOs(Options numberEOs) {
		this.numberEOs = numberEOs;
	}

	public Options getManagementDispositionPCRs() {
		return managementDispositionPCRs;
	}

	public void setManagementDispositionPCRs(Options managementDispositionPCRs) {
		this.managementDispositionPCRs = managementDispositionPCRs;
	}

}
