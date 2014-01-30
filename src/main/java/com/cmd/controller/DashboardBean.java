package com.cmd.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cmd.model.Aircraft;
import com.cmd.model.CurveRelease;
import com.cmd.model.CurveReleaseSerie;
import com.cmd.model.DrawingReleasedInOE;
import com.cmd.service.interfaces.IAircraftService;
import com.cmd.service.interfaces.ICurveReleaseService;
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
	
	@Inject
	IAircraftService aircraftService;
	
	@Inject
	ICurveReleaseService curveReleaseService;
	
	private Options options = new Options();
	private Theme theme = new Theme();
	private Options relesedOEs = new Options();
	private Options delayedEOs = new Options();
	private Options changeDocumentType = new Options();
	private Options releasedDrawing = new Options();
	private Options releaseCurveDrawing = new Options();
	private Options numberEOs = new Options();
	private Options managementDispositionPCRs = new Options();
	private List<DrawingReleasedInOE> listPlannedDwgWeek = new ArrayList<DrawingReleasedInOE>();
	private List<Aircraft> listAircraft = new ArrayList<Aircraft>();
	private String codProjectSelected = new String();
	private String codModelSelected = new String();
	private String dbtSelected = new String();
	private Integer periodSelected = 1;
	private Date minDate;
	private Date maxDate;
	

	public DashboardBean() {
		
	}
	
	@PostConstruct
	public void init(){		
		selectRelesedOEs(true);
		selectReleaseCurveDrawing(true);
	}
	
	
	public void requestInformation(){
		selectRelesedOEs(true);
		selectReleaseCurveDrawing(true);
	}
	
	public List<String> listCodProject(){
		/*
		 * Carrega a lista do Banco de dados
		 */
		List<Aircraft> daoAircraft = aircraftService.selectProgram();
		List<String> list = new ArrayList<String>();
		for(Aircraft aircraft : daoAircraft){
			list.add(aircraft.getCodProgram());
		}
	     return list;
	}
	
	public List<String> listCodModel(){
		/*
		 * Carrega a lista do Banco de dados
		 */
		List<Aircraft> daoAircraft = aircraftService.selectModel(getCodProjectSelected());
		List<String> list = new ArrayList<String>();
		for(Aircraft aircraft : daoAircraft){
			list.add(aircraft.getCodModel());
		}
	     return list;
	}
	
	public List<String> listDbt(){
		/*
		 * Carrega a lista do Banco de dados
		 */
		List<Aircraft> daoAircraft = aircraftService.selectDbt(getCodProjectSelected());
		List<String> list = new ArrayList<String>();
		for(Aircraft aircraft : daoAircraft){
			list.add(aircraft.getDesignBuiltTeam().getDscDbt());
		}
	     return list;
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

	public void selectRelesedOEs(boolean bool) {
		List<DrawingReleasedInOE> listPlanned = new ArrayList<DrawingReleasedInOE>();
		List<DrawingReleasedInOE> listReleased = new ArrayList<DrawingReleasedInOE>();
		
		List<String> cateListPlanned = new ArrayList<String>();
		List<Number> qtyPnListPlanned = new ArrayList<Number>();
		
		List<Number> qtyPnListPlannedAccum = new ArrayList<Number>();
		List<Number> qtyPnListReleased = new ArrayList<Number>();
		List<Number> qtyPnListReleasedAccum = new ArrayList<Number>();
		
		if(bool){
			
			Date teste = this.maxDate;
			listPlanned = drawingReleasedInOEService.selectPlannedDwgWeek(codProjectSelected, getMinDate(), teste);
			listReleased = drawingReleasedInOEService.selectReleasedDwgWeek(codProjectSelected, getMinDate(), getMaxDate());
			
			
			for(DrawingReleasedInOE drawingReleasedInOE : listPlanned){
				cateListPlanned.add(drawingReleasedInOE.getCategory());				
				qtyPnListPlanned.add(drawingReleasedInOE.getQtyPn());
			}			
			
			for(DrawingReleasedInOE drawingReleasedInOE : listPlanned){
				qtyPnListPlannedAccum.add(drawingReleasedInOE.getQtyPnAccum());
			}			
			
			for(DrawingReleasedInOE drawingReleasedInOE : listReleased){
				qtyPnListReleased.add(drawingReleasedInOE.getQtyPn());
			}			
			
			for(DrawingReleasedInOE drawingReleasedInOE : listReleased){
				qtyPnListReleasedAccum.add(drawingReleasedInOE.getQtyPnAccum());
			}
		}
	
			theme = new DarkBlueTheme();
			Options options = new Options();
			ChartOptions chartOptions = new ChartOptions();
			chartOptions.setZoomType(ZoomType.XY);
			options.setChartOptions(chartOptions);
			options.setTitle(new Title(codProjectSelected));
			options.setSubtitle(new Title("EO's Release by Week of 2013"));
	
			Axis xAxis = new Axis();
			xAxis.setCategories(cateListPlanned);
	
			Axis yAxis = new Axis();
			yAxis.setTitle(new Title("Qty PNs"));
	
			options.setyAxis(yAxis);
			options.setxAxis(xAxis);
	
			options.setTooltip(new Tooltip());
	
			options.setLabels(new Labels().setStyle(new CssStyle()));
	
			Series<Number> series1 = new SimpleSeries();
			series1.setType(SeriesType.COLUMN);
			series1.setName("Planned");
			series1.setData(qtyPnListPlanned);
			options.addSeries(series1);
	
			Series<Number> series2 = new SimpleSeries();
			series2.setType(SeriesType.COLUMN);
			series2.setName("Released");
			series2.setData(qtyPnListReleased);
			options.addSeries(series2);
	
			Marker series3Marker = new Marker();
			series3Marker.setLineWidth(2);
			series3Marker.setLineColor(new HexColor("#8BBC21"));
			series3Marker.setFillColor(new HexColor("#ffffff"));
	
			Series<Number> series3 = new SimpleSeries();
			series3.setType(SeriesType.SPLINE);
			series3.setName("Accumulated Planned");
			series3.setData(qtyPnListPlannedAccum);
			series3.setMarker(series3Marker);
			options.addSeries(series3);
	
			Marker series4Marker = new Marker();
			series4Marker.setLineWidth(2);
			series4Marker.setLineColor(new HexColor("#990000"));
			series4Marker.setFillColor(new HexColor("#ffffff"));
	
			Series<Number> series4 = new SimpleSeries();
			series4.setType(SeriesType.SPLINE);
			series4.setName("Accumulated Released");
			series4.setData(qtyPnListReleasedAccum);
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

	public void selectReleaseCurveDrawing(boolean bool) {
		
		List<CurveReleaseSerie> listReleased = new ArrayList<CurveReleaseSerie>();
		List<CurveReleaseSerie> listPlan = new ArrayList<CurveReleaseSerie>();
		List<CurveReleaseSerie> listDane = new ArrayList<CurveReleaseSerie>();
		
		List<String> cateListLib = new ArrayList<String>();
		List<Number> qtyPnListReleased = new ArrayList<Number>();
		List<Number> qtyPnListPlan = new ArrayList<Number>();
		List<Number> qtyPnListDane = new ArrayList<Number>();
		
		if(bool){
			listReleased = curveReleaseService.selectCurveReleaseLibMonthly(codProjectSelected, getMinDate(), getMaxDate());
			listPlan = curveReleaseService.selectCurveReleasePlanMonthly(codProjectSelected, getMinDate(), getMaxDate());
			listDane = curveReleaseService.selectCurveReleaseDaneMonthly(codProjectSelected, getMinDate(), getMaxDate());
			
			for(CurveReleaseSerie curveReleaseSerie : listReleased){
				cateListLib.add(curveReleaseSerie.getCategory());
				qtyPnListReleased.add(curveReleaseSerie.getQtyPn());
			}
			
			for(CurveReleaseSerie curveReleaseSerie : listPlan){
				qtyPnListPlan.add(curveReleaseSerie.getQtyPn());
			}
			
			for(CurveReleaseSerie curveReleaseSerie : listDane){
				qtyPnListDane.add(curveReleaseSerie.getQtyPn());
			}
		}
		
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();

		chartOptions.setType(SeriesType.LINE);
		chartOptions.setMarginRight(130);
		chartOptions.setMarginBottom(25);
		chartOptions.setZoomType(ZoomType.XY);
		options.setChartOptions(chartOptions);

		Title title = new Title(codProjectSelected);
		title.setX(-20);
		options.setTitle(title);

		Title subTitle = new Title("Release Curve Drawings - 2013");
		subTitle.setX(-20);
		options.setSubtitle(subTitle);

		Axis xAxis = new Axis();
		xAxis.setCategories(cateListLib);
		
		
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
		series1.setData(qtyPnListPlan);
		options.addSeries(series1);

		Series<Number> series2 = new SimpleSeries();
		series2.setName("Released");
		series2.setData(qtyPnListReleased);
		options.addSeries(series2);

		Series<Number> series3 = new SimpleSeries();
		series3.setName("DANE");
		series3.setData(qtyPnListDane);
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

	public List<DrawingReleasedInOE> getListPlannedDwgWeek() {
		return listPlannedDwgWeek;
	}

	public void setListPlannedDwgWeek(List<DrawingReleasedInOE> listPlannedDwgWeek) {
		this.listPlannedDwgWeek = listPlannedDwgWeek;
	}

	public List<Aircraft> getListAircraft() {
		return listAircraft;
	}

	public void setListAircraft(List<Aircraft> listAircraft) {
		this.listAircraft = listAircraft;
	}

	public String getCodProjectSelected() {
		return codProjectSelected;
	}

	public void setCodProjectSelected(String codProjectSelected) {
		this.codProjectSelected = codProjectSelected;
	}

	public String getCodModelSelected() {
		return codModelSelected;
	}

	public void setCodModelSelected(String codModelSelected) {
		this.codModelSelected = codModelSelected;
	}

	public String getDbtSelected() {
		return dbtSelected;
	}

	public void setDbtSelected(String dbtSelected) {
		this.dbtSelected = dbtSelected;
	}

	public Integer getPeriodSelected() {
		return periodSelected;
	}

	public void setPeriodSelected(Integer periodSelected) {
		this.periodSelected = periodSelected;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

}
