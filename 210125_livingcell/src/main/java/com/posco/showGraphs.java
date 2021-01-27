package com.posco;

import java.io.IOException;

import com.appnexus.grafana.client.GrafanaClient;
import com.appnexus.grafana.client.models.Dashboard;
import com.appnexus.grafana.client.models.GrafanaDashboard;
import com.appnexus.grafana.configuration.GrafanaConfiguration;
import com.appnexus.grafana.exceptions.GrafanaException;


public class showGraphs {

	public static void main(String[] args) {
		//Setup the client
		GrafanaConfiguration grafanaConfiguration =
		        new GrafanaConfiguration()
		        	.host("https://poscographone.grafana.net")
		        	.apiKey("eyJrIjoiMzVhMDVkZGRlOGQ1ZjM0ZmJkMzA0YWU3MTEyYzJkMTIzNDZhMGU3OCIsIm4iOiJpbml0aWFsS2V5IiwiaWQiOjQ1ODQ4MX0=");
		GrafanaClient grafanaClient = new GrafanaClient(grafanaConfiguration);

		//Setup the dashboard
		String DASHBOARD_NAME = "Dashboard1";

		Dashboard dashboard = new Dashboard()
		      .title(DASHBOARD_NAME)
		      .version(0);

		GrafanaDashboard grafanaDashboard = new GrafanaDashboard().dashboard(dashboard);

		//Make API calls
		try {
			grafanaClient.createDashboard(grafanaDashboard);
		} catch (GrafanaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			grafanaClient.getDashboard(DASHBOARD_NAME);
		} catch (GrafanaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			grafanaClient.deleteDashboard(DASHBOARD_NAME);
		} catch (GrafanaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
