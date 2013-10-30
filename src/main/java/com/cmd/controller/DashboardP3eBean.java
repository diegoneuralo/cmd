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
public class DashboardP3eBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	IDrawingReleasedInOEService drawingReleasedInOEService;
	
	private Options options = new Options();
	private Theme theme = new Theme();
	private Options procedureMfa = new Options();
	private Options procedureEpro = new Options();

	public DashboardP3eBean() {
		selectProcedureMfa();
	}

	public void selectProcedureMfa() {	

		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();

		chartOptions.setType(SeriesType.LINE);
		chartOptions.setMarginRight(130);
		chartOptions.setMarginBottom(25);
		options.setChartOptions(chartOptions);

		Title title = new Title("Control Tower");
		title.setX(-20);
		options.setTitle(title);

		Title subTitle = new Title("Control Tower - 2013");
		subTitle.setX(-20);
		options.setSubtitle(subTitle);

		Axis xAxis = new Axis();
		xAxis.setCategories(Arrays
				.asList(new String[] { "MFA Procedure",
						"MFA EPRO", "MFA Delivery Doc", "MFA SAE", "Delivery" }));
		
		
		options.setxAxis(xAxis);

		PlotLine plotLines = new PlotLine();
		plotLines.setValue(0f);
		plotLines.setWidth(1);
		plotLines.setColor(new HexColor("#999999"));

		Axis yAxis = new Axis();
		yAxis.setTitle(new Title("Indicator"));
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
		series1.setName("Gold");
		series1.setData(Arrays.asList(new Number[] { 7.0, 6.9, 9.5, 14.5, 18.2 }));
		options.addSeries(series1);

		Series<Number> series2 = new SimpleSeries();
		series2.setName("Silver");
		series2.setData(Arrays.asList(new Number[] { -0.2, 0.8, 5.7, 11.3,
				17.0 }));
		options.addSeries(series2);

		Series<Number> series3 = new SimpleSeries();
		series3.setName("Bronze");
		series3.setData(Arrays.asList(new Number[] { -0.9, 0.6, 3.5, 8.4, 13.5 }));
		options.addSeries(series3);
		
		Series<Number> series4 = new SimpleSeries();
		series4.setName("Annual Target");
		series4.setData(Arrays.asList(new Number[] { -0.9, 0.6, 3.5, 8.4, 13.5 }));
		options.addSeries(series4);
		
		Series<Number> series5 = new SimpleSeries();
		series5.setName("Average 12M");
		series5.setData(Arrays.asList(new Number[] { -0.9, 0.6, 3.5, 8.4, 13.5 }));
		options.addSeries(series5);
		
		Series<Number> series6 = new SimpleSeries();
		series6.setName("Value");
		series6.setData(Arrays.asList(new Number[] { -0.9, 0.6, 3.5, 8.4, 13.5 }));
		options.addSeries(series6);
		
		setProcedureMfa(options);
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

	public Options getProcedureMfa() {
		return procedureMfa;
	}

	public void setProcedureMfa(Options procedureMfa) {
		this.procedureMfa = procedureMfa;
	}

	public Options getProcedureEpro() {
		return procedureEpro;
	}

	public void setProcedureEpro(Options procedureEpro) {
		this.procedureEpro = procedureEpro;
	}

}
