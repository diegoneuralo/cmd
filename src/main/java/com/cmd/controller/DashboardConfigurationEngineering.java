package com.cmd.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.googlecode.wickedcharts.highcharts.options.Axis;
import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.Events;
import com.googlecode.wickedcharts.highcharts.options.Function;
import com.googlecode.wickedcharts.highcharts.options.HorizontalAlignment;
import com.googlecode.wickedcharts.highcharts.options.Legend;
import com.googlecode.wickedcharts.highcharts.options.LegendLayout;
import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.options.PlotOptions;
import com.googlecode.wickedcharts.highcharts.options.PlotOptionsChoice;
import com.googlecode.wickedcharts.highcharts.options.PointOptions;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.Tooltip;
import com.googlecode.wickedcharts.highcharts.options.VerticalAlignment;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.functions.RemovePointFunction;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.googlecode.wickedcharts.highcharts.theme.DarkBlueTheme;
import com.googlecode.wickedcharts.highcharts.theme.Theme;

@Named
@ViewScoped
public class DashboardConfigurationEngineering implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Options options = new Options();
	private Theme theme = new Theme();
	private Options statusOfAudits = new Options();
	private Options itemsWithoutComponent = new Options();
	private Options psa = new Options();
	private Options gfeNotFound = new Options();
	private Options improvementsProjects = new Options();
	
	public DashboardConfigurationEngineering(){
		
	}
	
	@PostConstruct
	public void init(){
		selectStatusOfAudits();
		selectItemsWithoutComponent();
		selectPsa();
		selectGfeNotFound();
		selectImprovementProjects();
	}
	
	public void selectStatusOfAudits() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions.setType(SeriesType.COLUMN));
 
		options.setTitle(new Title("Status of Audits - A1M"));
 
		options.setSubtitle(new Title("Status Of Audits - 2013"));
 
		options.setxAxis(new Axis()
        .setCategories("Items without Component", "PSA", "GFE Not Found", "Items G without R", "Items R without RD", "SAP released and not released VPM", "VPM released and not released SAP"));
 
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
        .setSeries(new PlotOptions()
        .setPointPadding(0.2f)
        .setBorderWidth(0)
            .setPoint(new PointOptions()
                .setEvents(new Events()
                    .setClick(new Function("if(this.category == 'Items without Component'){dlg1.show()};" +
                    		"if(this.category == 'PSA'){dlg2.show()};" +
                    		"if(this.category == 'GFE Not Found'){dlg3.show()}; if(this.category == 'Items G without R'){dlg4.show()};if(this.category == 'Items R without RD'){dlg5.show()};if(this.category == 'SAP released and not released VPM'){dlg6.show()};if(this.category == 'VPM released and not released SAP'){dlg7.show()}"))))));

 
		options.addSeries(new SimpleSeries()
        .setName("New")
        .setData(
            49.9,
            71.5,
            106.4,
            129.2,
            144.0,
            129.2,
            144.0));
 
		options.addSeries(new SimpleSeries()
        .setName("Late")
        .setData(
            83.6,
            78.8,
            98.5,
            93.4,
            106.0,
            93.4,
            106.0));
		
		options.addSeries(new SimpleSeries()
        .setName("Answered")
        .setData(
            49.9,
            71.5,
            106.4,
            129.2,
            144.0,
            129.2,
            144.0));		
		
		setStatusOfAudits(options);
	}
	
	public void selectItemsWithoutComponent() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions.setType(SeriesType.COLUMN));
 
		options.setTitle(new Title("History of Audits Visibilities - A1M"));
 
		options.setSubtitle(new Title("Items without Component - 2013"));
 
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
        .setSeries(new PlotOptions()
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
        .setName("Late")
        .setData(
            83.6,
            78.8,
            98.5,
            93.4,
            106.0));
		
		options.addSeries(new SimpleSeries()
        .setName("Answered")
        .setData(
            49.9,
            71.5,
            106.4,
            129.2,
            144.0));		
		
		setItemsWithoutComponent(options);
	}
	
	public void selectPsa() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions.setType(SeriesType.COLUMN));
 
		options.setTitle(new Title("History of Audits Visibilities - A1M"));
 
		options.setSubtitle(new Title("PSA - 2013"));
 
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
        .setSeries(new PlotOptions()
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
        .setName("Late")
        .setData(
            83.6,
            78.8,
            98.5,
            93.4,
            106.0));
		
		options.addSeries(new SimpleSeries()
        .setName("Answered")
        .setData(
            49.9,
            71.5,
            106.4,
            129.2,
            144.0));		
		
		setPsa(options);
	}
	
	public void selectGfeNotFound() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions.setType(SeriesType.COLUMN));
 
		options.setTitle(new Title("History of Audits Visibilities - A1M"));
 
		options.setSubtitle(new Title("GFE Not Found - 2013"));
 
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
        .setSeries(new PlotOptions()
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
        .setName("Late")
        .setData(
            83.6,
            78.8,
            98.5,
            93.4,
            106.0));
		
		options.addSeries(new SimpleSeries()
        .setName("Answered")
        .setData(
            49.9,
            71.5,
            106.4,
            129.2,
            144.0));		
		
		setGfeNotFound(options);
	}
	
	public void selectImprovementProjects() {
		theme = new DarkBlueTheme();
		Options options = new Options();
		ChartOptions chartOptions = new ChartOptions();
		options.setChartOptions(chartOptions.setType(SeriesType.COLUMN));
 
		options.setTitle(new Title("Improvement Projects"));
 
		options.setSubtitle(new Title("Improvement Projects - 2013"));
 
		options.setxAxis(new Axis()
        .setCategories("Congelamento da EPRO", "Gestão da EPRO", "Configuração Série Curta", "Gestão de Configuração de Fornecedores", "Confiabilidade EPRO AMX"));
 
		options.setyAxis(new Axis()
        .setMin(0)
        .setTitle(new Title("% Percentual")));
 
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
            .setFunction(" return ''+ this.x +': '+ this.y +' %';")));
		
		options.setPlotOptions(new PlotOptionsChoice()
        .setSeries(new PlotOptions()
        .setPointPadding(0.2f)
        .setBorderWidth(0)));

 
		options.addSeries(new SimpleSeries()
        .setName("Planning")
        .setData(
            49.9,
            71.5,
            106.4,
            129.2,
            144.0));
 
		options.addSeries(new SimpleSeries()
        .setName("Real")
        .setData(
            83.6,
            78.8,
            98.5,
            93.4,
            106.0));
		
		setImprovementsProjects(options);
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

	public Options getStatusOfAudits() {
		return statusOfAudits;
	}

	public void setStatusOfAudits(Options statusOfAudits) {
		this.statusOfAudits = statusOfAudits;
	}

	public Options getItemsWithoutComponent() {
		return itemsWithoutComponent;
	}

	public void setItemsWithoutComponent(Options itemsWithoutComponent) {
		this.itemsWithoutComponent = itemsWithoutComponent;
	}

	public Options getPsa() {
		return psa;
	}

	public void setPsa(Options psa) {
		this.psa = psa;
	}

	public Options getGfeNotFound() {
		return gfeNotFound;
	}

	public void setGfeNotFound(Options gfeNotFound) {
		this.gfeNotFound = gfeNotFound;
	}

	public Options getImprovementsProjects() {
		return improvementsProjects;
	}

	public void setImprovementsProjects(Options improvementsProjects) {
		this.improvementsProjects = improvementsProjects;
	}

}
